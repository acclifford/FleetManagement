public class Boat {
    //-----------------------------------------------------------------------
    public enum type{POWER,SAILING};

    FleetManagement.type theType;
    public String name;
    public int manufacturer;
    public String makeAndModel;
    public int length;
    public double purchasePrice;
    public double expenses;

    public Boat(){
        theType = null;
        name = null;
        manufacturer = 0;
        makeAndModel = null;
        length = 0;
        purchasePrice = 0;
        expenses = 0;
    }
    //-----------------------------------------------------------------------
    public Boat(FleetManagement.type theType, String name, int manufacturer, String makeAndModel, int length, double purchasePrice) {
        this.theType = theType;
        this.name = name;
        this.manufacturer = manufacturer;
        this.makeAndModel = makeAndModel;
        this.length = length;
        this.purchasePrice = purchasePrice;
        expenses = 0;
    }

    //-----------------------------------------------------------------------
    public String toString() {

    }

    //-----------------------------------------------------------------------
    public enum getType() {

    }
    //-----------------------------------------------------------------------
    public enum setType(){

    }
    //-----------------------------------------------------------------------
    public String getName() {

    }
    //-----------------------------------------------------------------------
    public String setName(){

    }
    //-----------------------------------------------------------------------
    public int getManufacturer() {

    }

    //-----------------------------------------------------------------------
    public int setManufacturer(){

    }

    //-----------------------------------------------------------------------
    public String getMakeAndModel() {

    }
    //-----------------------------------------------------------------------
    public String setMakeAndModel{

    }
    //-----------------------------------------------------------------------
    public int getLength() {

    }
    //-----------------------------------------------------------------------
    public int setLength(){

    }

    //-----------------------------------------------------------------------
    public double getPurchasePrice() {

    }
    //-----------------------------------------------------------------------
    public double setPurchasePrice(){

    }
    //-----------------------------------------------------------------------
    public String getExpenses(double newExpense) {

        double subtractFromPurchasePrice = purchasePrice;

        if(newExpense < purchasePrice){
            expenses = newExpense;
            subtractFromPurchasePrice -= expenses;
            return ("Expense authorized, $" + newExpense + " spend.");
        }
        else{
            return ("Expense not permitted, only $" + subtractFromPurchasePrice + "left to spend.");
        }

    }
    //-----------------------------------------------------------------------
}
