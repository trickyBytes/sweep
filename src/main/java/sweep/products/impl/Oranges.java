package sweep.products.impl;

import sweep.Price;
import sweep.products.Product;

/**
 * Oranges.
 *
 * @author trickyBytes
 */
public class Oranges extends AbsProduct implements Product {

    public Oranges(final Price price) {
        super(price, "Oranges");
    }
}
