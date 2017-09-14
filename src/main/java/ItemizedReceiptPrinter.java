public final class ItemizedReceiptPrinter implements BillMethod {

    @Override
    public void bill(RestaurantBill bill) {
        String output = "";

        for (Item item : bill.getListOfItems()) {
            output += item.getName() + "(" + item.getQuantity() + ") $" + item.getPrice() * item.getQuantity() + "\n";
        }

        output += "--------------------\n";
        output += "baseTotal:        " + "$" + bill.getBaseTotal() + "\n";
        output += "--------------------\n";
        output += "tax:          " + "$" + bill.getTax() + "\n";
        output += "--------------------\n";
        output += "tip:          " + "$" + bill.getTip() + "\n";
        output += "--------------------\n";
        output += "grand total:          " + "$" + bill.getGrandTotal() + "\n";

        System.out.println(output);
    }
}
