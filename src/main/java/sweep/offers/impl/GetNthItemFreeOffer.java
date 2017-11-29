package sweep.offers.impl;

import java.util.UUID;

import sweep.offers.IOffer;
import sweep.products.IProduct;

/**
 * GetNthItemFreeOffer.
 *
 * @author trickyBytes
 */
public class GetNthItemFreeOffer extends Offer implements IOffer {
    private final int amountOfProductAtFullPrice;
    
    /**
     * @param productId
     * @param amountOfProductAtFullPrice
     */
    public GetNthItemFreeOffer(UUID productId, int amountOfProductAtFullPrice) {
        super(productId);
        this.amountOfProductAtFullPrice = amountOfProductAtFullPrice;
    }

    /**
     * @param amountOfProduct
     * @return
     * @see sweep.offers.impl.Offer#getMultiplesOfOffer(int)
     */
    @Override
    protected int getMultiplesOfOffer(int amountOfProduct) {
        return  amountOfProduct / (this.amountOfProductAtFullPrice + 1);
    }


    /**
     * @return
     * @see sweep.offers.impl.Offer#getOfferDiscount()
     */
    @Override
    protected int getOfferDiscount(IProduct product) {
        return product.getPrice();
    }

    /**
     * @return
     * @see sweep.offers.impl.Offer#getOfferAmount()
     */
    @Override
    protected int getOfferAmount() {
        return amountOfProductAtFullPrice;
    }
}
