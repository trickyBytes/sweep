package sweep.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.Test;

import sweep.Basket;
import sweep.products.Product;

/**
 * BasketTest.
 *
 * @author trickyBytes
 */
public class BasketTest {

    private Product coke;
    
    
    @Test
    public void canAddNOfProductsToBasket() throws Exception {
        coke = mock(Product.class);
        when(coke.getId()).thenReturn(UUID.randomUUID());
        
        Basket basket = new SupermarketBasket();
        basket.addProduce(coke, 3);
        
        assertEquals(3,basket.amountOfProduct(coke.getId()));
    }
}
