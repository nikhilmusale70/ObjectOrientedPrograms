public class Problem1 {
    public static void main(String[] args) {
        String item1 = "Rice";
        int priceForItem1PerKg=20;
        double weightForItem1InKg=100;

        String item2 = "Pulses";
        int priceForItem2PerKg=30;
        double weightForItem2InKg=150;

        String item3 = "Wheats";
        int priceForItem3PerKg=50;
        double weightForItem3InKg=80;

        Inventory[] inv = new Inventory[3];
        inv[0]= new Inventory(item1,priceForItem1PerKg,weightForItem1InKg);
        inv[1]= new Inventory(item2,priceForItem2PerKg,weightForItem2InKg);
        inv[2]= new Inventory(item3,priceForItem3PerKg,weightForItem3InKg);

        for (int i=0;i< inv.length;i++) {
            System.out.println("\n"+inv[i]);
        }
    }


}

class Inventory {

    public String item;
    public int priceOfItemPerKg;
    public double weightForItemInKg;

    public Inventory(String item, int priceOfItemPerKg, double weightForItemInKg) {

        this.item=item;
        this.priceOfItemPerKg=priceOfItemPerKg;
        this.weightForItemInKg=weightForItemInKg;

    }

    @Override
    public String toString() {
        return item+" Inventory" +" \nPrice of "+ item +" per KG is "+
                priceOfItemPerKg +"\nWeight of "+item+ " in inventory is "+ weightForItemInKg +
                "\nValue of "+item+ " inventory is "+ (weightForItemInKg*priceOfItemPerKg);
    }
}

