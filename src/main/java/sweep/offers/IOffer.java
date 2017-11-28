package sweep.offers;

import sweep.IProduct;
import sweep.ISaving;

/**
 * IOfferI.
 *
 * @author trickyBytes
 */
public interface IOffer {

    /**
     * TODO.
     * 
     * @param product
     * @param amount 
     * @return
     */
    ISaving getSaving(IProduct product, int amount);

}