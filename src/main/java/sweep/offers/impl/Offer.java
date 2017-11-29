package sweep.offers.impl;

import java.util.UUID;

import sweep.IProduct;
import sweep.ISaving;
import sweep.offers.IOffer;

/**
 * Offer.
 *
 * @author trickyBytes
 */
public abstract class Offer implements IOffer {
    private final UUID productId;
    
    public Offer(UUID productId) {
        this.productId = productId;
    }

    /**
     * @param product
     * @param amount
     * @return
     * @see sweep.offers.IOffer#getSaving(sweep.IProduct, int)
     */
    @Override
    abstract public ISaving getSaving(IProduct product, int amount);

    /**
     * @return
     * @see sweep.offers.IOffer#getProductId()
     */
    @Override
    public UUID getProductId() {
        return productId;
    }
}
