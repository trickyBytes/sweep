package sweep.offers;

import java.util.UUID;

import sweep.ISaving;
import sweep.products.Product;

/**
 * An offer is something used to calculate the ISaving for X number of a given {@link Product}
 * @author trickyBytes
 */
public interface Offer {

    /**
     * Returns the saving for a given {@link Product} and amount
     * @param product {@link Product} to calculate the saving for
     * @param amount {@link ISaving} saving that could be applied
     * @return {@link ISaving}
     */
    ISaving getSaving(Product product, int amount);

    /**
     * Returns the unique {@link UUID} of the {@link Product} that this offer applies to
     * @return {@link UUID} of the {@link Product}
     */
    UUID getProductId();
}