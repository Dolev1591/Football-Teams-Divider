public class Player {

    private String Name;
    private int[] Stats= new int[8];


    public Player(String name, int stamina, int pace, int shooting, int passing, int defense, int dribbling, int strength,
                  int GoalKeeping) {
        this.Name=name;
        this.Stats[0]=stamina;
        this.Stats[1]=pace;
        this.Stats[2]=shooting;
        this.Stats[3]=passing;
        this.Stats[4]=defense;
        this.Stats[5]=dribbling;
        this.Stats[6]=strength;
        this.Stats[7]=GoalKeeping;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setStats(int[] stats) {
        Stats = stats;
    }

    public String getName() {
        return Name;
    }

    public int[] getStats() {
        return Stats;
    }
}