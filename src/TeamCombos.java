/*
class MAIN {
    public static void main(String[] args) {
        /*
        Player Lidor = new Player("lidor Adani", 78, 82, 77, 83, 69, 87, 74, 86);
        Player Yair = new Player("Yair Levi", 77, 83, 84, 88, 81, 89, 83, 80);
        Player Zinger = new Player("Itay Zinger", 77, 80, 71, 78, 62, 93, 70, 60);
        Player Yaniv = new Player("Yaniv Adani", 94, 92, 89, 85, 78, 91, 70, 81);
        Player Kenner = new Player("Oz Kenner", 86, 85, 94, 88, 81, 95, 88, 84);
        Player Noam = new Player("Noam Toren", 76, 76, 80, 76, 69, 81, 79, 82);
        Player uri = new Player("uriel hendri", 96, 94, 98, 86, 82, 91, 90, 76);
        Player ido = new Player("Ido Gavriel", 63, 70, 76, 72, 60, 71, 73, 68);
        Player Itzik = new Player("Itzik Lev", 80, 74, 61, 66, 60, 64, 70, 63);
        Player David = new Player("David Volk", 68, 74, 77, 72, 64, 79, 69, 67);
        Player Dolev = new Player("Dolev levy", 63, 70, 77, 72, 62, 73, 85, 66);
        Player Yoni = new Player("Yoni Tal", 82, 77, 80, 79, 94, 79, 88, 95);

        Player[] players = { Lidor, Yair, Zinger, Yaniv, Kenner, Noam, uri, ido, Itzik, David, Dolev, Yoni };
        algo algo= new algo(players);


    }
    */

import java.util.*;


class Combination {
    HashMap<String, Point> AllCombs = new HashMap<String, Point>(); // Hashmap to store every possible combination of teams
    HashMap<String, Player> NameToPlayer = new HashMap<String, Player>(); // Hashmap to store { player name : player object }
    HashMap<String,Double> ranks= new HashMap<String,Double>();
    List<Player> PlayersLst; // All the players playing today stored as list
    List<Double> StatsAvg = new ArrayList<>();
    static int counter = 1;

    public Combination(List<Player> p) {
        this.PlayersLst = p;
        for (int i = 0; i < p.size(); i++) {
            this.NameToPlayer.put(p.get(i).getName(), p.get(i));
        }
        double sum = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < p.size(); j++) {
                sum = sum + p.get(j).getStats()[i];
            }
            this.StatsAvg.add(sum / p.size());
            sum = 0;
        }
        System.out.println(this.StatsAvg);
    }

    public void secondGroupFinder(List<Player> arr2, List<Player> data2, int start,
                                  int end, int index, int r, String first) {
        if (index == r) {
            String second = "";
            for (int j = 0; j < r; j++) {
                second = second + " " + data2.get(j).getName();
            }
            this.AllCombs.put(first + "," + second, new Point(0, 0));
            counter++;
            return;
        }
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data2.add(index, arr2.get(i));
            secondGroupFinder(arr2, data2, i + 1, end, index + 1, r, first);
        }
    }

    public void printCombination(int n, int r) {
        List<Player> data = new ArrayList<>();
        combinationUtil(this.PlayersLst, data, 0, n - 1, 0, r);
        this.delete_dups();
    }

    public void combinationUtil(List<Player> arr, List<Player> data, int start,
                                int end, int index, int r) {
        String first = "";
        if (index == r) {
            for (int j = 0; j < r; j++) {
                first = first + " " + data.get(j).getName();
            }
            List<Player> tempList = new ArrayList<>(arr);
            List<Player> tempData = new ArrayList<>();
            tempList.removeAll(data);
            if (data.size() > 5) {
                data.remove(data.size() - 1);
            }
            secondGroupFinder(tempList, tempData, 0, tempList.size() - 1, 0, 5, first);

            return;
        }
        for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
            data.add(index, arr.get(i));
            if (data.size() > 5) {
                data.remove(data.size() - 1);
            }
            combinationUtil(arr, data, i + 1, end, index + 1, r);
        }
    }


    public void delete_dups() {
        counter = 1;
        HashMap<String, Point> dup = (HashMap<String, Point>) this.AllCombs.clone();
        for (String key : this.AllCombs.keySet()) {
            String[] splited = key.split(",");
            String reverse = splited[1] + "," + splited[0];
            if (dup.containsKey(key)) {
                dup.remove(reverse);
            }
        }
        this.AllCombs = dup;
        //System.out.println(this.AllCombs);
    }

    public void rank_combos() {
        for (String key : this.AllCombs.keySet()) {
            String[] teams = key.split(",");
            String[] team1 = teams[0].split(" ");
            String[] team2 = teams[1].split(" ");
            this.AllCombs.put(key,new Point(rank_team(team1),rank_team(team2)));
        }
        sort_combs();
    }

    public double rank_team(String[] team) {
        double sum = 0;
        List<Double> teamAVG= new ArrayList<>();
        for (int k = 0; k < 8; k++) {
            for (int i = 1; i < team.length; i += 2) {
                String name = team[i] + " " + team[i + 1];
                Player p = this.NameToPlayer.get(name);
                //System.out.println(p.getName());
                sum=sum+p.getStats()[k];
            }
            teamAVG.add(sum/5);
            sum=0;
        }
        for (int i=0;i<teamAVG.size();i++){
            sum=sum+(Math.abs(teamAVG.get(i)-this.StatsAvg.get(i)));
        }
        return sum;
    }

    public void sort_combs(){
        for (String key : this.AllCombs.keySet()) {
            this.ranks.put(key,this.AllCombs.get(key).distance());
        }
        double minVal= Double.MAX_VALUE;
        String bestMatch="";
        for (String key : this.ranks.keySet()) {
            if(this.ranks.get(key)<minVal){
                minVal=this.ranks.get(key);
                bestMatch=key;
            }
        }
        System.out.println(bestMatch+" is the best match with distance of "+minVal);

    }


    public static void main(String[] args) {
        Player Lidor = new Player("lidor Adani", 78, 82, 77, 83, 69, 87, 74, 86);
        Player Yair = new Player("Yair Levi", 77, 83, 84, 88, 81, 89, 83, 80);
        Player Zinger = new Player("Itay Zinger", 77, 80, 71, 78, 62, 93, 70, 60);
        Player Yaniv = new Player("Yaniv Adani", 94, 92, 89, 85, 78, 91, 70, 81);
        Player Kenner = new Player("Oz Kenner", 86, 85, 94, 88, 81, 95, 88, 84);
        Player Noam = new Player("Noam Toren", 76, 76, 80, 76, 69, 81, 79, 82);
        Player uri = new Player("uriel hendri", 96, 94, 98, 86, 82, 91, 90, 76);
        Player ido = new Player("Ido Gavriel", 63, 70, 76, 72, 60, 71, 73, 68);
        Player Itzik = new Player("Itzik Lev", 80, 74, 61, 66, 60, 64, 70, 63);
        Player David = new Player("David Volk", 68, 74, 77, 72, 64, 79, 69, 67);
        Player Dolev = new Player("Dolev levy", 63, 70, 77, 72, 62, 73, 85, 66);
        Player Yoni = new Player("Yoni Tal", 82, 77, 80, 79, 94, 79, 88, 95);
        Player[] p = {Lidor, Yair, Zinger, Yaniv, Kenner, Noam, uri, ido, Itzik, David, Dolev, Yoni};
        ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(p));
        Combination c = new Combination(players);
        int n = players.size();
        c.printCombination(n, 5);
        c.rank_combos();
    }
}

