package sweep.impl;

import java.math.BigDecimal;

import sweep.ISaving;

/**
 * Saving.
 *
 * @author trickyBytes
 */
public class Saving implements ISaving {
    private final BigDecimal saving;
    
    
    /**
     * @param bulkPrice
     */
    public Saving(BigDecimal bigDecimal) {
        this.saving = bigDecimal;
    }

    /**
     * @return
     * @see sweep.ISaving#getAmmount()
     */
    @Override
    public BigDecimal getAmmount() {
        return saving;
    }

}
