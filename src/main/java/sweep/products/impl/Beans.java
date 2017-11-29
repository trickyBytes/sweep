package sweep.products.impl;

import sweep.IPrice;
import sweep.products.IProduct;

/**
 * Beans.
 *
 * @author trickyBytes
 */
public class Beans extends Coke implements IProduct {

    /**
     * @param price
     */
    public Beans(IPrice price) {
        super(price);
    }

}
