class MAIN {
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

        Player[] players = { Lidor, Yair, Zinger, Yaniv, Kenner, Noam, uri, ido, Itzik, David, Dolev, Yoni };
        algo algo= new algo(players);


    }
}
