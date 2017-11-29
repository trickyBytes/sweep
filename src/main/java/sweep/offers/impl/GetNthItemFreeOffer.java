package sweep.offers.impl;

import java.util.UUID;

import sweep.IProduct;
import sweep.ISaving;
import sweep.offers.IOffer;

/**
 * GetNthItemFreeOffer.
 *
 * @author trickyBytes
 */
public class GetNthItemFreeOffer extends Offer implements IOffer {

    /**
     * @param productId
     * @param numItemsAtFullPrice
     */
    public GetNthItemFreeOffer(UUID productId, int numItemsAtFullPrice) {
        super(productId);
    }

    /**
     * @param product
     * @param amount
     * @return
     * @see sweep.offers.IOffer#getSaving(sweep.IProduct, int)
     */
    @Override
    public ISaving getSaving(IProduct product, int amount) {
        return null;
    }

    /**
     * @return
     * @see sweep.offers.IOffer#getProductId()
     */
    @Override
    public UUID getProductId() {
        return null;
    }
}
