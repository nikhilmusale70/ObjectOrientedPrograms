import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {

        StockMarket stockObj = new StockMarket();
        Portfolio pf = new Portfolio();
        int flag = 0;
        Scanner sc =new Scanner(System.in);


        while(flag == 0){
            System.out.println("\nEnter your choice \n1. See Market\n2. See your Portfolio\n3. Buy\n4. Sell \n5. Exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    pf.seeMarket();
                    break;
                case 2:
                    pf.seePortfolio();
                    break;
                case 3:
                    pf.buy();
                    break;
                case 4:
                    pf.sell();
                    break;
                case 5:
                    flag=1;
                    break;
                default:
                    System.out.println("Enter valid number");
                    break;
            }
        }
    }
}

class StockMarket{
    Scanner sc = new Scanner(System.in);
    String compSymbol;
    int numberOfShares;
    double priceOfStock;
    public int remainingStock = numberOfShares;
    public StockMarket[] sm;

    StockMarket(String symb, int numberOfShares, double priceOfStock){
        this.compSymbol = symb;
        this.numberOfShares = numberOfShares;
        this.priceOfStock = priceOfStock;
        this.remainingStock=numberOfShares;
    }

    StockMarket(){
        sm = new StockMarket[2];
        sm[0] = new StockMarket("INF" , 20 , 50.0);
        sm[1] = new StockMarket("REL" , 30 , 40.0);

    }

}

class Portfolio{
    int shareBought;
    int sellShare;
    int stockSymbol;
    StockMarket obj = new StockMarket();
    Scanner sc = new Scanner(System.in);
    Portfolio[] pf = new Portfolio[2];

    public Portfolio(){
        pf[0]=new Portfolio(0);
        pf[1]=new Portfolio(0);
    }
    public Portfolio(int shareBought){
        this.shareBought=shareBought;
    }

    public void buy(){

        System.out.println("Which company's stock you want to buy ");
        for (int i=0; i<obj.sm.length; i++){
            System.out.println("For buying "+ obj.sm[i].compSymbol + " at "+ obj.sm[i].priceOfStock + " press "+(i+1));
        }
        System.out.println("");
        int option = sc.nextInt();

        System.out.println("How many shares you want to buy :- ");
        int buyShare = sc.nextInt();

        if (option==1){
            obj.sm[option-1].remainingStock -= buyShare;
            pf[option-1] = new Portfolio(buyShare + pf[option-1].shareBought);
        }
        if(option==2){
            obj.sm[option-1].remainingStock -= buyShare;
            pf[option-1] = new Portfolio(buyShare + pf[option-1].shareBought);
        }
    }

    public void sell(){
        System.out.println("Which company's stock you want to sell ");
        for (int i=0; i<obj.sm.length; i++){
            System.out.println("For selling "+ obj.sm[i].compSymbol + " at "+ obj.sm[i].priceOfStock + " press "+(i+1));
        }
        int option = sc.nextInt();

        System.out.println("How many shares you want to sell :- ");
        int sellShare = sc.nextInt();

        if (option==1){
            obj.sm[option-1].remainingStock += sellShare;
            pf[option-1] = new Portfolio(pf[option-1].shareBought - sellShare);
        }
        if(option==2){
            obj.sm[option-1].remainingStock += sellShare;
            pf[option-1] = new Portfolio(pf[option-1].shareBought - sellShare);
        }

    }

    public void seePortfolio(){
        for (int i=0; i< pf.length; i++){
            System.out.println("For "+ obj.sm[i].compSymbol + " i have "+ pf[i].shareBought + " Shares");
        }
    }

    public void seeMarket(){
        System.out.println("\n");
        for (int i=0; i< obj.sm.length ; i++){
            System.out.println("Value for single "+ obj.sm[i].compSymbol+ " stock is "+ obj.sm[i].priceOfStock +
                    " Total Stocks:- " + obj.sm[i].numberOfShares +" Remaing Stocks :- "+ (obj.sm[i].remainingStock - pf[i].shareBought));
        }
    }
}