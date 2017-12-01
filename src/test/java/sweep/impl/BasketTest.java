package sweep.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.UUID;

import org.junit.Test;

import sweep.Basket;
import sweep.products.IProduct;

/**
 * BasketTest.
 *
 * @author trickyBytes
 */
public class BasketTest {

    private IProduct coke;
    
    
    @Test
    public void canAddNOfProductsToBasket() throws Exception {
        coke = mock(IProduct.class);
        when(coke.getId()).thenReturn(UUID.randomUUID());
        
        Basket basket = new SupermarketBasket();
        basket.addProduce(coke, 3);
        
        assertEquals(3,basket.amountOfProduct(coke.getId()));
    }
}
