package sweep;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sweep.impl.Basket;
import sweep.impl.Coke;
import sweep.impl.Till;

/**
 * CheckoutTests.
 *
 * @author trickyBytes
 */
public class TillTests {
    IBasket basket;
    ITill till;
    IProduct coke;
    
    @Before
    public void setUp(){
        coke = new Coke(70);
    }
        
    @Test
    public void testCalculationOfOneItem() throws Exception {
        ITill till = new Till();
        IBasket basket = new Basket();
        
        basket = new Basket();
        basket.addProduce(coke);
        
        assertEquals(70, till.calculateTotal(basket));
    }
}
