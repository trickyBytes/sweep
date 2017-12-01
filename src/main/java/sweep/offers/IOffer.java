package sweep.offers;

import java.util.UUID;

import sweep.ISaving;
import sweep.products.Product;

/**
 * IOfferI.
 *
 * @author trickyBytes
 */
public interface IOffer {

    ISaving getSaving(Product product, int amount);

    UUID getProductId();
}