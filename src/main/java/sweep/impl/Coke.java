package sweep.impl;

import sweep.IProduct;

/**
 * Coke.
 *
 * @author trickyBytes
 */
public class Coke implements IProduct {
    private int price;

    /**
     * @param i
     */
    public Coke(int price) {
        this.price = price;
    }

    /**
     * @return
     * @see sweep.IProduct#getPrice()
     */
    @Override
    public int getPrice() {
        return price;
    }
}
