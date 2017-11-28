package sweep.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import sweep.IBasket;
import sweep.IProduct;
import sweep.ISaving;
import sweep.ITill;
import sweep.offers.IOffer;

/**
 * Till.
 *
 * @author trickyBytes
 */
public class Till implements ITill {
    List<IOffer> offers = new ArrayList<IOffer>();

    protected int calculateSubTotal(IBasket basket) {
        return basket.getItems()
                .stream()
                .mapToInt(item -> item.getPrice()).sum();
    }

    protected int calcualteSavings(IBasket basket, List<IOffer> offers) {
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
        
        return (int) savings.stream().collect(Collectors.summarizingInt(ISaving::getAmmount)).getSum();
    }

    /**
     * @param basket
     * @return
     * @see sweep.ITill#calculateTotal(sweep.IBasket)
     */
    @Override
    public int calculateTotal(IBasket basket) {
        final int subtotal = calculateSubTotal(basket);
        final int savings = calcualteSavings(basket, offers);

        return subtotal + savings;
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
