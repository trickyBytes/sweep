package sweep.impl;

import sweep.ISaving;

/**
 * Saving.
 *
 * @author trickyBytes
 */
public class Saving implements ISaving {
    private final int saving;
    
    
    /**
     * @param bulkPrice
     */
    public Saving(int saving) {
        this.saving = saving;
    }

    /**
     * @return
     * @see sweep.ISaving#getAmmount()
     */
    @Override
    public int getAmmount() {
        return saving;
    }

}
