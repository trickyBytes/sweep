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
     * @return
     */
    ISaving getSaving(IProduct product);

}