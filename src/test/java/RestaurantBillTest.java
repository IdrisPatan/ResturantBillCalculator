import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RestaurantBillTest {
    @Test
    public void total() throws Exception {

        Item item1 = new Item("Sandwhich", 5, 1 );
        Item item2 = new Item("Soup", 4, 2 );
        List<Item> items = Arrays.asList(item1, item2);

        RestaurantBill restaurantBill = new RestaurantBill(items);

        assertThat(restaurantBill.total().getBaseTotal(), is(13.0));
    }

    @Test
    public void tax() throws Exception {
        Item item1 = new Item("Sandwhich", 5, 1 );
        Item item2 = new Item("Soup", 4, 2 );
        List<Item> items = Arrays.asList(item1, item2);

        RestaurantBill restaurantBill = new RestaurantBill(items);

        assertThat(restaurantBill.total().tax(.08).getTax(), is(1.04));

    }

    @Test
    public void tip() throws Exception {
        Item item1 = new Item("Sandwhich", 5, 1 );
        Item item2 = new Item("Soup", 4, 2 );
        List<Item> items = Arrays.asList(item1, item2);

        RestaurantBill restaurantBill = new RestaurantBill(items);

        assertThat(restaurantBill.total().tip(.15).getTip(), is(1.95));
    }

    @Test
    public void calculate () throws Exception {
        Item item1 = new Item("Sandwhich", 5, 1 );
        Item item2 = new Item("Soup", 4, 2 );
        List<Item> items = Arrays.asList(item1, item2);

        RestaurantBill restaurantBill = new RestaurantBill(items);
        double grandTotal = restaurantBill
                .total()
                .tax(0.08)
                .tip(0.15)
                .calculate();

        assertThat(grandTotal, is(15.99));
    }

    @Test
    public void allValuesAreCorrect(){
        Item item1 = new Item("Sandwhich", 5, 1 );
        Item item2 = new Item("Soup", 4, 2 );
        List<Item> items = Arrays.asList(item1, item2);

        RestaurantBill restaurantBill = new RestaurantBill(items);
        double grandTotal = restaurantBill
                .total()
                .tax(0.08)
                .tip(0.15)
                .calculate();

        assertThat(restaurantBill.getBaseTotal(), is(13.0));
        assertThat(restaurantBill.getTip(), is(1.95));
        assertThat(restaurantBill.getTax(), is(1.04));
        assertThat(restaurantBill.getGrandTotal(), is(15.99));
    }
}