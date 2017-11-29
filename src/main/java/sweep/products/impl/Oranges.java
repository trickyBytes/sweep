package sweep.products.impl;

import sweep.IPrice;
import sweep.products.IProduct;

/**
 * Oranges.
 *
 * @author trickyBytes
 */
public class Oranges extends Product implements IProduct {

    public Oranges(final IPrice price) {
        super(price, "Oranges");
    }
}
