package sweep.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import sweep.Basket;
import sweep.products.Product;
import sweep.products.impl.Coke;

/**
 * BasketTest.
 *
 * @author trickyBytes
 */
public class BasketTest {

    private Product coke = new Coke(new StorePrice(70));
    
    
    @Test
    public void canAddNOfProductsToBasket() throws Exception {
        Basket basket = new SupermarketBasket();
        basket.addProduce(coke, 3);
        
        assertEquals(3,basket.amountOfProduct(coke.getId()));
    }
}
