import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static java.nio.file.Files.newBufferedReader;

//===========================================================================
public class FleetManagement {
    //-----------------------------------------------------------------------
    public static final Scanner keyboard = new Scanner(System.in);
    public static final int MAX_BOAT_LENGTH = 100;
    public static final double MAX_PURCHASE_PRICE = 1000000;

    enum type {POWER, SAILING}

    ;
    ArrayList<Boat> fleet = new ArrayList<>();

    //-----------------------------------------------------------------------
    public static void main(String[] args) {
/*
        ArrayList<Boat> fleet;
        fleet = initFromCSVFile("C:\\Users\\Ailis\\Desktop\\CSC120_LAB\\FleetData.csv");
        Boat boat = new Boat();
*/
        ArrayList<Boat> fleet;
        String path = "C:\\Users\\Ailis\\Desktop\\CSC120_LAB\\FleetData.csv";
        fleet = initFromCSVFile(path);

        menu(fleet);

/*
        if(args.length > 0){
            initFromCSVFile();
        }
        else{
            initFromObjectFile();
        }
*/


        writeFleetToObjectFile();

    }

    //-----------------------------------------------------------------------
    private static ArrayList<Boat> initFromCSVFile(String fileName) {
        ArrayList<Boat> fleet = new ArrayList<>();

        Boat newBoat = new Boat();

        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = "";
            while ((line = br.readLine()) != null) ;
            {
                String[] attributes = line.split(",");
                newBoat = createBoat(attributes);
                fleet.add(newBoat);

            }

        } catch(IOException e) {
         e.printStackTrace();
        }


/*
        String line = null;
        try{
            BufferedReader br = newBufferedReader(new FileReader(fileName));

            while((line = br.readLine()) != null){
            String[] values = line.split(",");
            System.out.println(line);
            }

            } catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }

*/

        return fleet;

        }



    //-----------------------------------------------------------------------
    private static void initFromObjectFile(){

   }
    //-----------------------------------------------------------------------
    private static void writeFleetToObjectFile(){

    }
    //-----------------------------------------------------------------------
    private static void menu(ArrayList<Boat>fleet) {

        char menuSelection;
        int index;
        int index2 = 0;
        Boat myBoat = new Boat();
        String boatName;
        double newExpense;


        System.out.println("Welcome to the Fleet Management System");
        System.out.println("---------------------------------------");

        System.out.print("(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it : ");
        menuSelection = Character.toUpperCase(keyboard.next().charAt(0));

        do {
            switch (menuSelection) {
                case 'P':
                    System.out.println(" ");
                    System.out.println("Fleet report:");
                    for (index = 0; index < fleet.size(); index++) {
                        System.out.println(fleet.get(index));
                    }
                    System.out.println("Total                           : ");
                    break;
                case 'A':
                    System.out.println(" ");
                    addBoat(fleet);
                    break;
                case 'R':
                    System.out.println(" ");
                    removeBoat(fleet);
                    break;
                case 'E':
                    System.out.println(" ");
                    System.out.println("Which boat do you want to spend on? : ");
                    boatName = keyboard.nextLine();
                    //--make sure that boat exists and is found in array
                    System.out.println("How much do you want to spend");
                    newExpense = keyboard.nextDouble();
                    myBoat.getExpenses(newExpense);
                    break;
                case 'X':
                    System.out.println(" ");
                    System.out.println("Exiting the Fleet Management System");
            }
        } while(menuSelection != 'X');
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
    //-----------------------------------------------------------------------
    public static Boat addBoat(ArrayList<Boat>fleet){

        type newType;
        String newName;
        int newManufacturer;
        String newMakeAndModel;
        int newLength;
        double newPurchasePrice;

        System.out.println("Please enter the new boat CSV data : ");
        String str = keyboard.nextLine();
        String[] res = str.split("[,]");

        newType = type.valueOf(res[0]);
        newName = res[1];
        newManufacturer = Integer.parseInt(res[2]);
        newMakeAndModel = res[3];
        newLength = Integer.parseInt(res[4]);
        newPurchasePrice = Double.parseDouble(res[5]);

        return new Boat (newType,newName,newManufacturer,newMakeAndModel,newLength,newPurchasePrice);
    }
    //-----------------------------------------------------------------------
    public static void removeBoat(ArrayList<Boat>fleet){

        String boatName;

        System.out.print("Which boat would you like to remove? : ");
        boatName = keyboard.nextLine();

        if(!fleet.contains(boatName)){
               System.out.println("Cannot find boat " + boatName);
        }
        else{
            int index = 0;
            do{
                if (!(fleet.get(index).getName().equals(boatName))){
                    index++;
                }
            }while (!(fleet.get(index).getName().equals(boatName)));
            fleet.remove(index);
        }
    }
    //-----------------------------------------------------------------------
}
//===========================================================================
