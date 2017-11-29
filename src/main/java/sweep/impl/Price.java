package sweep.impl;

import java.math.BigDecimal;

import sweep.IPrice;

/**
 * Price.
 *
 * @author trickyBytes
 */
public class Price implements IPrice {
    private final BigDecimal price;
    
    public Price(int price) {
        this.price = new BigDecimal(price);
    }
    
    /**
     * @return
     * @see sweep.IPrice#get()
     */
    @Override
    public BigDecimal get() {
        return price;
    }

}
