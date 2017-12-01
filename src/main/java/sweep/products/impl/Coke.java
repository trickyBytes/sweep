package sweep.products.impl;

import sweep.IPrice;
import sweep.products.Product;

/**
 * Coke.
 *
 * @author trickyBytes
 */
public class Coke extends AbsProduct implements Product {

    /**
     * @param price
     * @param name
     */
    public Coke(IPrice price) {
        super(price, "Coke");
    }
   
}
