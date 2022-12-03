import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
//===========================================================================
public class FleetManagement {
    //-----------------------------------------------------------------------
    public static final Scanner keyboard = new Scanner(System.in);
    public static final int MAX_BOAT_LENGTH = 100;
    public static final double MAX_PURCHASE_PRICE = 1000000;
    enum type{POWER,SAILING};
    //-----------------------------------------------------------------------
    public static void main(String[] args){

        ArrayList<Boat> fleet = initFromCSVFile("C:\\Users\\Ailis\\Desktop\\CSC120_Lab\\FleetData.csv");

        for(Boat b : fleet){
            System.out.println(b);
        }
/*
        if(args.length > 0){
            initFromCSVFile();
        }
        else{
            initFromObjectFile();
        }
*/
        menu();

        writeFleetToObjectFile();
    }
    //-----------------------------------------------------------------------
    private static ArrayList<Boat> initFromCSVFile(String fileName){
        ArrayList<Boat> fleet = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();
            while (line != null); {
                String [] attributes = line.split(",");
                Boat myBoat = createBoat(attributes);
                fleet.add(myBoat);
                line = br.readLine();
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        return fleet;

        }

    //-----------------------------------------------------------------------
    private static void initFromObjectFile(){

   }
    //-----------------------------------------------------------------------
    private static void writeFleetToObjectFile(){

    }
    //-----------------------------------------------------------------------
    private static void menu() {

        char menuSelection;
        int index;
        int index2 = 0;

        String boatName;
        double newExpense;


        System.out.println("Welcome to the Fleet Management System");
        System.out.println("---------------------------------------");

        System.out.print("(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it : ");
        menuSelection = Character.toUpperCase(keyboard.next().charAt(0));

        switch (menuSelection) {
            case 'P':
                for(index = 0; index < fleet.size(); index++){
                    System.out.println(fleet[index]);
                }
                break;
            case 'A':
                fleet.add(myBoat);
                break;
            case 'R':
                System.out.print("Which boat would you like to remove? : ");
                boatName = keyboard.nextLine();
                //--write in if else statement later
                //--come back to this one
                break;
            case 'E':
                System.out.println("Which boat do you want to spend on? : ");
                boatName = keyboard.nextLine();
                //--make sure that boat exists and is found in array
                System.out.println("How much do you want to spend");
                newExpense = keyboard.nextDouble();





        }
    }
    //-----------------------------------------------------------------------
    public static Boat createBoat(String[] attributes){

        type theType;

        theType = type.valueOf(attributes[0]);

        String name = attributes[1];

        int manufacturer = Integer.parseInt(attributes[2]);

        String makeAndModel = attributes[3];

        int length = Integer.parseInt(attributes[4]);

        double purchasePrice = Double.parseDouble(attributes[5]);

        return new Boat (theType,name,manufacturer,makeAndModel,length,purchasePrice);
    }
}
//===========================================================================
