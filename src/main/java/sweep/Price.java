package sweep;

import java.math.BigDecimal;

import sweep.impl.MeasurementUnit;

/**
 * Represents a price for a given amount of a given unit.
 * @author trickyBytes
 */
public interface Price {
    /**
     * @return The cost of one {@link MeasurementUnit}
     */
    BigDecimal getCost();
    
    
    /**
     * Returns the cost for an amount
     * 
     * @param amount
     * @return
     */
    BigDecimal getCost(BigDecimal amount);
    
    /**
     * @return The units the price is calculated in
     */
    MeasurementUnit getMeasurementUnit();
}
