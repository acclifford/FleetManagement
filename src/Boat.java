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
    public String getName() {

    }

    //-----------------------------------------------------------------------
    public long getManufacturer() {

    }

    //-----------------------------------------------------------------------
    public String getMakeAndModel() {

    }

    //-----------------------------------------------------------------------
    public int getLength() {

    }

    //-----------------------------------------------------------------------
    public double getPurchasePrice() {

    }

    //-----------------------------------------------------------------------
    public double getExpenses(newExpenses) {

        if()
    }
    //-----------------------------------------------------------------------
}
