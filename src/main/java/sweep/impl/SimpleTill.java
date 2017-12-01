package sweep.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sweep.Basket;
import sweep.ISaving;
import sweep.Till;
import sweep.offers.Offer;
import sweep.products.Product;

/**
 * {@link Till} implementation does nothing more than sum the price of products, apply offers and return a total.
 * More complicated implementations might do things like inventory handling.
 *
 * @author trickyBytes
 */
public class SimpleTill implements Till {
    List<Offer> offers = new ArrayList<>();

    protected BigDecimal calculateSubTotal(Basket basket) {
        BigDecimal subtotal = BigDecimal.ZERO;
        
        for(Product item : basket.getItems()){
            subtotal = subtotal.add(item.getPrice().get());
        }
        
        return subtotal;
    }

    protected BigDecimal calculate(Basket basket, List<Offer> offers) {
        Map<Product, Long> amountOfProducts = basket.ammountOfProducts();
        List<ISaving> savings = new ArrayList<>();

        for (Map.Entry<Product, Long> entry : amountOfProducts.entrySet()) {
            for (Offer offer : offers) {
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
     * @see sweep.Till#calculateTotal(sweep.Basket)
     */
    @Override
    public BigDecimal calculateTotal(Basket basket) {
        final BigDecimal subtotal = calculateSubTotal(basket);
        final BigDecimal savings = calculate(basket, offers);

        return subtotal.add(savings);
    }

    /**
     * @param offer
     * @see sweep.Till#addOffer(sweep.offers.Offer)
     */
    @Override
    public void addOffer(Offer offer) {
        if(offer == null){
            throw new IllegalArgumentException("Offer cannot be null");
        }
        this.offers.add(offer);
    }
}
