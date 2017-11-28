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

    /**
     * @param productId
     * @param bulkPrice 
     * @param numberOfItems 
     */
    public BulkPriceOffer(UUID productId, int numberOfItems, int bulkPrice) {
        this.bulkPrice = bulkPrice;
        this.productId = productId;
    }

    /**
     * @param product
     * @return
     * @see sweep.offers.IOffer#getSaving(sweep.IProduct)
     */
    @Override
    public ISaving getSaving(IProduct product) {
        ISaving saving = new Saving(0);
        
        if(product.getId().equals(productId)){
            saving = new Saving(bulkPrice);
        }
        
        return saving;
    }

}
