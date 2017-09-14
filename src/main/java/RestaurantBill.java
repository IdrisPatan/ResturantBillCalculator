
import java.util.List;

class RestaurantBill {
    private List<Item> listOfItems;
    private double baseTotal;
    private double tax;
    private double tip;
    private double grandTotal;

    RestaurantBill(List<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public RestaurantBill total() {
        for(Item item : listOfItems){
            baseTotal += item.getPrice()*item.getQuantity();
        }
        baseTotal = MathHelpers.getFormattedValue(baseTotal);
        return this;
    }

    public RestaurantBill tax(double taxRate) {
        tax +=  MathHelpers.getFormattedValue(baseTotal * taxRate);
        return this;
    }

    public RestaurantBill tip(double tipRate) {
        tip += MathHelpers.getFormattedValue(baseTotal * tipRate);
        return this;
    }

    public double calculate (){
        grandTotal = MathHelpers.getFormattedValue(baseTotal + tip + tax);
        return grandTotal;
    }



    public List<Item> getListOfItems(){
        return listOfItems;
    }

    public double getBaseTotal(){
        return baseTotal;
    }

    public double getTax() {
        return tax;
    }

    public double getTip() {
        return tip;
    }

    public double getGrandTotal() {
        return grandTotal;
    }
}
