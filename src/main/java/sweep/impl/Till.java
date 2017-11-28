package sweep.impl;

import java.util.ArrayList;
import java.util.List;

import sweep.IBasket;
import sweep.ITill;
import sweep.offers.IOffer;

/**
 * Till.
 *
 * @author trickyBytes
 */
public class Till implements ITill {
    List<IOffer> offers = new ArrayList<IOffer>();
    
    
    private int calculateSubTotal(IBasket basket){
        return basket.getItems()
                .stream()
                .mapToInt(item -> item.getPrice()).sum();
    }
    
    
    /**
     * @param basket
     * @return
     * @see sweep.ITill#calculateTotal(sweep.IBasket)
     */
    @Override
    public int calculateTotal(IBasket basket) {
        final int subtotal = calculateSubTotal(basket);
        
        
        return subtotal;
    }


    /**
     * @param offer
     * @see sweep.ITill#addOffer(sweep.offers.IOffer)
     */
    @Override
    public void addOffer(IOffer offer) {
        this.offers.add(offer);
    }
}
