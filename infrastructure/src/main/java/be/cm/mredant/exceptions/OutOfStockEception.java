package be.cm.mredant.exceptions;

public class OutOfStockEception extends OrderException {

    public OutOfStockEception(Integer stock, String itemName) {
        super(String.format("%s has insufficient stock : %s", itemName, stock));
    }

}
