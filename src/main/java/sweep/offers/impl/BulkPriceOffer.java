package sweep.offers.impl;

import java.util.UUID;

import sweep.IProduct;
import sweep.ISaving;
import sweep.impl.Saving;
import sweep.offers.IOffer;

/**
 * TwoForOneOffer.
 *
 * @author trickyBytes
 */
public class BulkPriceOffer implements IOffer {

    private final int bulkPrice;
    private final UUID productId;
    private final int amount;

    /**
     * @param productId
     * @param bulkPrice
     * @param amount
     */
    public BulkPriceOffer(UUID productId, int amount, int bulkPrice) {
        if (amount <= 0){
            throw new IllegalArgumentException("amount should be greater than zero");
        }
                
        this.bulkPrice = bulkPrice;
        this.productId = productId;
        this.amount = amount;
    }

    /**
     * @param product
     * @return
     * @see sweep.offers.IOffer#getSaving(sweep.IProduct)
     */
    @Override
    public ISaving getSaving(IProduct product, int amount) {
        ISaving saving = new Saving(0);

        if (product.getId().equals(productId) && amount >= this.amount) {
            final int multiples = amount / this.amount;
            final int subTotal = (multiples * this.amount) * product.getPrice();
            saving = new Saving((bulkPrice * multiples) - subTotal);
        }

        return saving;
    }

    /**
     * @return
     * @see sweep.offers.IOffer#getProductId()
     */
    @Override
    public UUID getProductId() {
        return productId;
    }
}
