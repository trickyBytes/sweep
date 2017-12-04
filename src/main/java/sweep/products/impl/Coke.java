package sweep.products.impl;

import sweep.Price;
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
    public Coke(Price price) {
        super(price, "Coke");
    }
   
}
