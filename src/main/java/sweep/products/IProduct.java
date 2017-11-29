package sweep.products;

import java.util.UUID;

import sweep.IPrice;

/**
 * IProduct.
 *
 * @author trickyBytes
 */
public interface IProduct {

    /**
     * TODO.
     * 
     * @return
     */
    IPrice getPrice();

    /**
     * TODO.
     * 
     * @return
     */
    UUID getId();
}
