package sweep;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import sweep.products.IProduct;

/**
 * IBasket.
 *
 * @author trickyBytes
 */
public interface IBasket {

    /**
     * Adds one unit of product
     * 
     * @param product
     */
    void addProduce(IProduct product);

    void addProduce(IProduct product, int numberOfUnits);
    
    
    /**
     * TODO.
     * 
     */
    List<IProduct> getItems();

    /**
     * TODO.
     * 
     * @param id
     * @return
     */
    long amountOfProduct(UUID id);

    /**
     * TODO.
     * 
     * @return
     */
    Map<IProduct, Long> ammountOfProducts();
}
