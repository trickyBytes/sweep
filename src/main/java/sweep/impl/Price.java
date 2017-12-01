package sweep.impl;

import java.math.BigDecimal;

import sweep.IPrice;

/**
 * Price.
 *
 * @author trickyBytes
 */
public class Price implements IPrice {
    private final BigDecimal total;
    
    public Price(int price) {
        this.total = new BigDecimal(price);
    }
    
    public Price(double price) {
        this.total = BigDecimal.valueOf(price);
    }
    
    /**
     * @return
     * @see sweep.IPrice#get()
     */
    @Override
    public BigDecimal get() {
        return total;
    }

}
