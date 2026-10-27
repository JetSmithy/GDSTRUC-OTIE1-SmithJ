
public class Main {
    public static void main(String[] args){
        Player pikachu = new Player(25, "Pikachu", 10);
        Player celebi = new Player(251, "Celebi", 10);
        Player hitmonchan = new Player(107, "Hitmonchan", 10);
        Player mankey = new Player(56, "Mankey", 10);
        Player starmie = new Player(121, "Starmie", 10);
        Player togepi = new Player(175, "Togepi", 10);

        SimpleHashtable hashtable = new SimpleHashtable();
        hashtable.put(pikachu.getName(), pikachu);
        hashtable.put(celebi.getName(), celebi);
        hashtable.put(hitmonchan.getName(), hitmonchan);
        hashtable.put(mankey.getName(), mankey);
        hashtable.put(starmie.getName(), starmie);
        hashtable.put(togepi.getName(), togepi);

        System.out.println("\n");

        hashtable.printHashtable();
    }
}
