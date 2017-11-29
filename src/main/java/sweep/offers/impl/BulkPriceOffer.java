package sweep.offers.impl;

import java.util.UUID;

import sweep.ISaving;
import sweep.impl.Saving;
import sweep.offers.IOffer;
import sweep.products.IProduct;

/**
 * TwoForOneOffer.
 *
 * @author trickyBytes
 */
public class BulkPriceOffer extends Offer implements IOffer{

    private final int bulkPrice;
    private final int amount;

    /**
     * @param productId
     * @param bulkPrice
     * @param amount
     */
    public BulkPriceOffer(UUID productId, int amount, int bulkPrice) {
        super(productId);
        
        if (amount <= 0){
            throw new IllegalArgumentException("amount should be greater than zero");
        }
                
        this.bulkPrice = bulkPrice;
        this.amount = amount;
    }

    /**
     * @param amountOfProduct
     * @return
     * @see sweep.offers.impl.Offer#getMultiplesOfOffer(int)
     */
    @Override
    protected int getMultiplesOfOffer(int amountOfProduct) {
        return amountOfProduct / this.amount;
    }

    /**
     * @param product
     * @return
     * @see sweep.offers.impl.Offer#getOfferDiscount(sweep.products.IProduct)
     */
    @Override
    protected int getOfferDiscount(IProduct product) {
        return bulkPrice;
    }

    /**
     * @return
     * @see sweep.offers.impl.Offer#getOfferAmount()
     */
    @Override
    protected int getOfferAmount() {
        return this.amount;
    }
}
