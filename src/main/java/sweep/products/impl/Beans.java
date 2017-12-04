package sweep.products.impl;

import sweep.Price;
import sweep.products.Product;

/**
 * Beans.
 *
 * @author trickyBytes
 */
public class Beans extends AbsProduct implements Product {

    /**
     * @param price
     */
    public Beans(Price price) {
        super(price, "Beans");
    }
}
