package sweep.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import sweep.Price;

/**
 * PriceTest.
 *
 * @author trickyBytes
 */
public class PriceTest {

    
    @Test
    public void testCanReturnThePriceOfOneUnitIfNoAmountSpecified() throws Exception {
        Price price = new StorePrice(BigDecimal.valueOf(50), 1, MeasurementUnit.ITEMS);
        assertEquals(BigDecimal.valueOf(50), price.getCost());
    }
    
    @Test
    public void canReturnUnitPriceForOneItem() throws Exception {
        Price price = new StorePrice(BigDecimal.valueOf(50), 1, MeasurementUnit.ITEMS);
        assertEquals(BigDecimal.valueOf(50), price.getCost(BigDecimal.ONE));
    }
    
    @Test
    public void canCalculatePriceForMoreThanOneItem() throws Exception {
        Price price = new StorePrice(BigDecimal.valueOf(50), 1, MeasurementUnit.ITEMS);
        assertEquals(BigDecimal.valueOf(100), price.getCost(BigDecimal.valueOf(2)));
    }
}
