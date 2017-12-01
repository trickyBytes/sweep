package sweep.products.impl;

import sweep.IPrice;
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
    public Beans(IPrice price) {
        super(price, "Beans");
    }
}
