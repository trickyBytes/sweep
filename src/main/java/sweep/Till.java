package sweep;

import java.math.BigDecimal;

import sweep.offers.IOffer;
import sweep.products.IProduct;

/**
 * Mimics that a real till within a shop, takes a Basket of items, calculates a total price by using the price of
 * products and any offers to be applied to them.
 * 
 * @author trickyBytes
 */
public interface Till {

    /**
     * Calculates the total Cost for {@link IProduct} in a {@link Basket}
     * 
     * @param basket {@link Basket} to calculate the price for
     * @return {@link BigDecimal} the cost of the {@link IProduct} in the {@link Basket}
     */
    BigDecimal calculateTotal(Basket basket);

    /**
     * Add an {@link IOffer} that the till should apply when doing {@link #calculateTotal(Basket)}
     * 
     * @param offer
     */
    void addOffer(IOffer offer);
}
