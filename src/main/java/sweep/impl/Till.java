package sweep.impl;

import sweep.IBasket;
import sweep.ITill;

/**
 * Till.
 *
 * @author trickyBytes
 */
public class Till implements ITill {

    /**
     * @param basket
     * @return
     * @see sweep.ITill#calculateTotal(sweep.IBasket)
     */
    @Override
    public int calculateTotal(IBasket basket) {
        return basket.getItems()
                .stream()
                .mapToInt(item -> item.getPrice()).sum();
    }
}
