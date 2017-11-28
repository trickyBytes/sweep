package sweep;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * IBasket.
 *
 * @author trickyBytes
 */
public interface IBasket {

    /**
     * TODO.
     * 
     * @param product
     */
    void addProduce(IProduct product);

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
