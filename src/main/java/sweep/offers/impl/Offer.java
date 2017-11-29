package sweep.offers.impl;

import java.math.BigDecimal;
import java.util.UUID;

import sweep.ISaving;
import sweep.impl.Saving;
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
    public ISaving getSaving(IProduct product, int amountOfProduct) {
        ISaving saving = new Saving(BigDecimal.ZERO);
        
        if (product.getId().equals(getProductId()) && amountOfProduct >=  getOfferAmount()) {
            final int multiples = getMultiplesOfOffer(amountOfProduct);
            final BigDecimal subTotal = new BigDecimal(multiples * getOfferAmount()).multiply(product.getPrice().get());
            
            saving = new Saving(
                    getOfferDiscount(product)
                    .multiply(new BigDecimal(multiples))
                    .subtract(subTotal));
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
    
    abstract protected int getMultiplesOfOffer(int amountOfProduct);
    abstract protected BigDecimal getOfferDiscount(IProduct product);
    abstract protected int getOfferAmount();
}
