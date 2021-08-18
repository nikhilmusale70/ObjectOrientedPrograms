public class Problem3 {
    public static void main(String[] args) {
        StockMarket sm = new StockMarket();
    }
}

class StockMarket{
    int numberOfCompanies = 2;

    String[] compSymbol = {"INF", "REL"};
    int[] numberOfShares = {20, 30};
    double[] priceOfStock = {15.0, 25.0};

    StockMarket(){
        valueOfEachStock();
        valueOfAllStocks();
    }

    public void valueOfEachStock(){
        for (int i=0; i<compSymbol.length; i++){
            System.out.println("Value for single "+compSymbol[i]+ " stock is "+priceOfStock[i]);
        }
    }

    public void valueOfAllStocks(){
        for (int i=0; i<compSymbol.length; i++){
            System.out.println("Value for whole "+compSymbol[i]+ " is "+(numberOfShares[i]*priceOfStock[i]));
        }
    }

}