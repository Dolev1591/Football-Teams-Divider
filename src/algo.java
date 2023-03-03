import java.util.Arrays;

public class algo {
    private Player[] players;
    private double[] overAllAvg= new double[8];
    private int optionsNum;

    public algo(Player[] players) {
        this.players = players;
        setAvg(this.players);
        setOptionsNum();

    }

    public void setAvg(Player[] players) {
        double currentSum = 0;
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < players.length; i++) {
                currentSum += players[i].getStats()[j];
            }
            this.overAllAvg[j] = (currentSum / players.length);
            currentSum=0;
        }
        System.out.println(Arrays.toString(this.overAllAvg));
    }

    private int factorial(int n){
        if(n==1){return 1;}
        return n*(factorial(n-1));
    }
    public void setOptionsNum(){
        int n= this.players.length;
        int k= 5;
        int a= (factorial(n)/(factorial(k)*factorial(n-k)));
        int b= factorial(n-k)/(factorial(k)*factorial(n-k-k));
        int c= factorial(k)*factorial(k);
        this.optionsNum=((a*b)/c);
        System.out.println(a*b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(this.optionsNum);
    }
}


// 12 choose 5 (for first group) * 7 choose 5 (for second group)