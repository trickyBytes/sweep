package sweep.offers;

import java.util.UUID;

import sweep.ISaving;
import sweep.products.IProduct;

/**
 * IOfferI.
 *
 * @author trickyBytes
 */
public interface IOffer {

    ISaving getSaving(IProduct product, int amount);

    UUID getProductId();
}