package sweep;

import sweep.offers.IOffer;

/**
 * ITill.
 *
 * @author trickyBytes
 */
public interface ITill {

    /**
     * TODO.
     * 
     * @param basket
     * @return
     */
    int calculateTotal(IBasket basket);

    /**
     * TODO.
     * 
     * @param offer
     */
    void addOffer(IOffer offer);
}
