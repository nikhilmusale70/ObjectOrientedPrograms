public class Problem8 {
    public static void main(String[] args) {

        DecksOfCards dc=new DecksOfCards();

    }
}

class DecksOfCards{

    public String suit[] = new String[4];
    public String rank[] = new String[13];
    public String[] card = new String[suit.length * rank.length];
    public int cardNumber=0;

    public int numberOfPlayers;
    public int numberOfCardsEachPlayerGets;
    public String[][] player;


    public DecksOfCards(){
        this.numberOfPlayers=4;
        this.numberOfCardsEachPlayerGets=9;
        intitalizingDeck();
        shuffleCards();
        //printDeck();
        giveCards();
        printDetailsOfPlayer();
    }

    public void intitalizingDeck(){

        suit[0]="Hearts";
        suit[1]="Diamond";
        suit[2]="spade";
        suit[3]="club";

        rank[0]="ace";
        for (int a=1; a<10; a++ ){
            rank[a] =String.valueOf(a+1);
        }
        rank[10]="Joker";
        rank[11]="Queen";
        rank[12]="King";

        for (int i=0;i<suit.length;i++){
            for (int j=0;j<rank.length;j++){
                card[cardNumber] = rank[j] + " of " + suit[i];
                cardNumber++;
            }
        }
    }

    public void shuffleCards(){
        String swap;
        for (int i=0 ; i<card.length ; i++){
            int random = (int) (Math.random() * (i));

            swap = card[i];
            card[i]=card[random];
            card[random]=swap;

        }
    }

    public void printDeck(){
        cardNumber=0;
        for (int i=0; i< suit.length; i++){
            for (int j=0; j< rank.length; j++){
                System.out.println("Card number "+ (cardNumber+1) + " contains " + card[cardNumber]);
                cardNumber++;
            }
        }
    }

    public void giveCards(){

        player = new String[numberOfPlayers][numberOfCardsEachPlayerGets];
        for (int i=0; i<numberOfPlayers; i++){

            int gotCard=0;
            int z=0;
            for (int j=z; j<numberOfCardsEachPlayerGets; j++){
                if(gotCard<=8) {
                    player[i][j] =card[j];
                    z++;

                }
            }
        }

    }

    public void printDetailsOfPlayer() {
        for (int i=0; i<numberOfPlayers; i++){
            System.out.println("\n");

            for (int j=0; j<numberOfCardsEachPlayerGets; j++) {
                System.out.println("Player " + (i+1) + " gets " + player[i][j]);
            }
        }
    }

}
