package sweep;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import sweep.products.IProduct;

/**
 * A container holding {@link IProduct} to be processed
 * @author trickyBytes
 */
public interface Basket {
    /**
     * Adds one unit of product
     * @param product
     */
    void addProduce(IProduct product);

    void addProduce(IProduct product, int numberOfUnits);
    
    /**
     * Returns a list a simple list of all items in the basket.
     */
    List<IProduct> getItems();

    /**
     * Returns a sum of the specific products in the basket, i.e 200grams of Rice, 2 cans of beans
     * 
     * @param id {@link UUID} reference for the product
     * @return {@link Long} sum of the amount of product within the basket
     */
    long amountOfProduct(UUID id);

    /**
     * Creates a dictionary of all products and the amounts (see {@link #ammountOfProducts()} in basket. 
     * @return {@link Map} of Product to Amount 
     */
    Map<IProduct, Long> ammountOfProducts();
}
