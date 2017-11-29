package sweep.offers.impl;

import java.util.UUID;

import sweep.ISaving;
import sweep.impl.Saving;
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
     * @param product
     * @param amountOfProduct
     * @return
     * @see sweep.offers.IOffer#getSaving(sweep.products.IProduct, int)
     */
    @Override
    public ISaving getSaving(IProduct product, int amountOfProduct) {
        ISaving saving = new Saving(0);
        
        if (product.getId().equals(getProductId()) && amountOfProduct >= this.amountOfProductAtFullPrice) {
            final int multiples = amountOfProduct / (this.amountOfProductAtFullPrice + 1);
            final int subTotal = (multiples * this.amountOfProductAtFullPrice) * product.getPrice();
            
            saving = new Saving((product.getPrice() * multiples) - subTotal);
        }
                
        return saving;
    }
}
