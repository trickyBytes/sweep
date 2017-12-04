package sweep.impl;

import java.math.BigDecimal;

import sweep.Price;

/**
 * Price.
 *
 * @author trickyBytes
 */
public class StorePrice implements Price {
    private final BigDecimal money;
    private final MeasurementUnit forPrice;
    
    public StorePrice(int price) {
        this.money = new BigDecimal(price);
        forPrice = MeasurementUnit.ITEMS;
    }
    
    public StorePrice(double price) {
        this.money = BigDecimal.valueOf(price);
        forPrice = MeasurementUnit.ITEMS;
    }
    
    public StorePrice(BigDecimal money, int amount, MeasurementUnit forPrice){
        this.money = money.divide(new BigDecimal(amount));
        this.forPrice = forPrice;
    }
    
    /**
     * @return
     * @see sweep.Price#getCost(BigDecimal)
     */
    @Override
    public BigDecimal getCost(BigDecimal amount) {
        if(amount == null){
            amount = BigDecimal.ONE;
        }
        
        return money.multiply(amount);
    }

    /**
     * @return
     * @see sweep.Price#getCost()
     */
    @Override
    public BigDecimal getCost() {
        return this.money;
    }

    /**
     * @return
     * @see sweep.Price#getMeasurementUnit()
     */
    @Override
    public MeasurementUnit getMeasurementUnit() {
        return forPrice;
    }
}
