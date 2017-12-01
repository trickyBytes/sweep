package sweep.impl;

import java.math.BigDecimal;

import sweep.Saving;

/**
 * Simple implementation of a saving.
 * @author trickyBytes
 */
public class SimpleSaving implements Saving {
    private final BigDecimal amount;
    
    
    /**
     * @param bulkPrice
     */
    public SimpleSaving(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    /**
     * @return
     * @see sweep.Saving#getAmmount()
     */
    @Override
    public BigDecimal getAmmount() {
        return amount;
    }

}
