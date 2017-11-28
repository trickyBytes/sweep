package sweep;

import java.util.List;

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
}
