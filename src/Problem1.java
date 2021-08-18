import java.util.Scanner;

public class Problem1 {
    public static int numberOfItems;

    public static void main(String[] args) {

        System.out.println("Enter number of items you want to add in inventory");
        Scanner sc =new Scanner(System.in);
        numberOfItems = sc.nextInt();

        String item[] = new String[numberOfItems];
        int[] priceForItemPerKg = new int[numberOfItems];
        int[] weightForItemInKg = new int[numberOfItems];

        for (int j=0; j<numberOfItems; j++){
            sc.nextLine();
            System.out.println("Enter name for item1 :- ");
            item[j]=sc.nextLine();

            System.out.println("Enter price per kg for "+item[j]+ " :-");
            priceForItemPerKg[j]= sc.nextInt();

            System.out.println("Enter weight in kg for "+item[j]+ " :-");
            weightForItemInKg[j]= sc.nextInt();
        }

        Inventory[] inv = new Inventory[numberOfItems];
        for (int j=0 ; j<numberOfItems; j++){
            inv[j]= new Inventory(item[j], priceForItemPerKg[j], weightForItemInKg[j]);
        }

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
                priceOfItemPerKg +"\nWeight of "+item+ " in inventory in kg is "+ weightForItemInKg +
                "\nValue of "+item+ " inventory is "+ (weightForItemInKg*priceOfItemPerKg);
    }
}

