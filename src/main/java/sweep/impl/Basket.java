package sweep.impl;

import java.util.ArrayList;
import java.util.List;

import sweep.IBasket;
import sweep.IProduct;

/**
 * Basket.
 *
 * @author trickyBytes
 */
public class Basket implements IBasket {
    List<IProduct> products = new ArrayList<>();
    
    /**
     * @param product
     * @see sweep.IBasket#addProduce(sweep.IProduct)
     */
    @Override
    public void addProduce(IProduct product) {
        this.products.add(product);
    }

    /**
     * @return
     * @see sweep.IBasket#getItems()
     */
    @Override
    public List<IProduct> getItems() {
        return products;
    }
}
