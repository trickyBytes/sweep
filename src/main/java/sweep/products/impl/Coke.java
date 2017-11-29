package sweep.products.impl;

import sweep.IPrice;
import sweep.products.IProduct;

/**
 * Coke.
 *
 * @author trickyBytes
 */
public class Coke extends Product implements IProduct {

    /**
     * @param price
     * @param name
     */
    public Coke(IPrice price) {
        super(price, "Coke");
    }
   
}
