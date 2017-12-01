package sweep.offers.impl;

import java.math.BigDecimal;
import java.util.UUID;

import sweep.offers.Offer;
import sweep.products.Product;

/**
 * GetNthItemFreeOffer.
 *
 * @author trickyBytes
 */
public class GetNthItemFreeOffer extends AbsOffer implements Offer {
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
     * @see sweep.offers.impl.AbsOffer#getMultiplesOfOffer(int)
     */
    @Override
    protected int getMultiplesOfOffer(int amountOfProduct) {
        return  amountOfProduct / (this.amountOfProductAtFullPrice + 1);
    }


    /**
     * @return
     * @see sweep.offers.impl.AbsOffer#getOfferDiscount()
     */
    @Override
    protected BigDecimal getOfferDiscount(Product product) {
        return product.getPrice().get();
    }

    /**
     * @return
     * @see sweep.offers.impl.AbsOffer#getOfferAmount()
     */
    @Override
    protected int getOfferAmount() {
        return amountOfProductAtFullPrice;
    }
}
