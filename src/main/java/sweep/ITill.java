package sweep;

import java.math.BigDecimal;

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
    BigDecimal calculateTotal(IBasket basket);

    /**
     * TODO.
     * 
     * @param offer
     */
    void addOffer(IOffer offer);
}
