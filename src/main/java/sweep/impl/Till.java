package sweep.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sweep.Basket;
import sweep.ISaving;
import sweep.ITill;
import sweep.offers.IOffer;
import sweep.products.IProduct;

/**
 * Till.
 *
 * @author trickyBytes
 */
public class Till implements ITill {
    List<IOffer> offers = new ArrayList<IOffer>();

    protected BigDecimal calculateSubTotal(Basket basket) {
        BigDecimal subtotal = BigDecimal.ZERO;
        
        for(IProduct item : basket.getItems()){
            subtotal = subtotal.add(item.getPrice().get());
        }
        
        return subtotal;
    }

    protected BigDecimal calculate(Basket basket, List<IOffer> offers) {
        Map<IProduct, Long> amountOfProducts = basket.ammountOfProducts();
        List<ISaving> savings = new ArrayList<>();

        for (Map.Entry<IProduct, Long> entry : amountOfProducts.entrySet()) {
            for (IOffer offer : offers) {
                final ISaving saving = offer.getSaving(entry.getKey(), entry.getValue().intValue());
                
                //TODO: Why does the above return a null?
                if (saving != null){
                    savings.add(saving);
                }
            }
        }
        
        
        BigDecimal savingAmnt = BigDecimal.ZERO;
        for(ISaving saving : savings){
            savingAmnt = savingAmnt.add(saving.getAmmount());
        }
        
        return savingAmnt;
    }

    /**
     * @param basket
     * @return
     * @see sweep.ITill#calculateTotal(sweep.Basket)
     */
    @Override
    public BigDecimal calculateTotal(Basket basket) {
        final BigDecimal subtotal = calculateSubTotal(basket);
        final BigDecimal savings = calculate(basket, offers);

        return subtotal.add(savings);
    }

    /**
     * @param offer
     * @see sweep.ITill#addOffer(sweep.offers.IOffer)
     */
    @Override
    public void addOffer(IOffer offer) {
        if(offer == null){
            throw new IllegalArgumentException("Offer cannot be null");
        }
        this.offers.add(offer);
    }
}
