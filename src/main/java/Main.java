
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){

        Item item1 = new Item("Sandwhich", 5, 1 );
        Item item2 = new Item("Soup", 4, 2 );
        List<Item> items = Arrays.asList(item1, item2);

        RestaurantBill restaurantBill = new RestaurantBill(items);

        double total = restaurantBill
                .total()
                .tax(.08)
                .tip(.15)
                .calculate();

        ItemizedReceiptPrinter receiptPrinter = new ItemizedReceiptPrinter();

        receiptPrinter.bill(restaurantBill);


    }


}
