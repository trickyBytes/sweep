package sweep.offers;

import java.util.UUID;

import sweep.IProduct;
import sweep.ISaving;

/**
 * IOfferI.
 *
 * @author trickyBytes
 */
public interface IOffer {

    ISaving getSaving(IProduct product, int amount);

    UUID getProductId();
}