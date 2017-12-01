package sweep.offers.impl;

import java.math.BigDecimal;
import java.util.UUID;

import sweep.ISaving;
import sweep.impl.Saving;
import sweep.offers.Offer;
import sweep.products.Product;

/**
 * Implements methods that are common to all offers
 *
 * @author trickyBytes
 */
public abstract class AbsOffer implements Offer {
    private final UUID productId;
    
    public AbsOffer(UUID productId) {
        this.productId = productId;
    }

    /**
     * @param product
     * @param amount
     * @return
     * @see sweep.offers.Offer#getSaving(sweep.products.Product, int)
     */
    @Override
    public ISaving getSaving(Product product, int amountOfProduct) {
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
     * @see sweep.offers.Offer#getProductId()
     */
    @Override
    public UUID getProductId() {
        return productId;
    }
    
    protected abstract int getMultiplesOfOffer(int amountOfProduct);
    protected abstract BigDecimal getOfferDiscount(Product product);
    protected abstract int getOfferAmount();
}
