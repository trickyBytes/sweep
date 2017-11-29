package sweep.offers.impl;

import java.util.UUID;

import sweep.ISaving;
import sweep.offers.IOffer;
import sweep.products.IProduct;

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
     * @see sweep.offers.IOffer#getSaving(sweep.products.IProduct, int)
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
