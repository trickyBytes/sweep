package sweep.impl;

import java.math.BigDecimal;

import sweep.ISaving;

/**
 * Saving.
 *
 * @author trickyBytes
 */
public class Saving implements ISaving {
    private final BigDecimal amount;
    
    
    /**
     * @param bulkPrice
     */
    public Saving(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    /**
     * @return
     * @see sweep.ISaving#getAmmount()
     */
    @Override
    public BigDecimal getAmmount() {
        return amount;
    }

}
