package sweep.products.impl;

import sweep.IPrice;
import sweep.products.Product;

/**
 * Oranges.
 *
 * @author trickyBytes
 */
public class Oranges extends AbsProduct implements Product {

    public Oranges(final IPrice price) {
        super(price, "Oranges");
    }
}
