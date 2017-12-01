package sweep;

import java.math.BigDecimal;

/**
 * Represents a saving as an amount and <in the future> and description of the saving
 *
 * @author trickyBytes
 */
public interface Saving {

    /**
     * @return the amount of saving as a {@link BigDecimal}
     */
    BigDecimal getAmmount();

}
