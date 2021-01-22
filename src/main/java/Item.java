public class Item {
    private String itemName;
    private double itemPrice;
    private String itemCode;

    public Item(String itemName, double itemPrice, String itemCode) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public String getItemCode() {
        return itemCode;
    }

}
