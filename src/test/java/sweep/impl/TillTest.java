package sweep.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import sweep.IBasket;
import sweep.ISaving;
import sweep.ITill;
import sweep.impl.Basket;
import sweep.impl.Till;
import sweep.offers.IOffer;
import sweep.products.IProduct;
import sweep.products.impl.Beans;
import sweep.products.impl.Coke;

/**
 * CheckoutTests.
 *
 * @author trickyBytes
 */
public class TillTest {
    IBasket basket;
    ITill till;
    IProduct coke;
    IProduct beans;
    
    IOffer twoForOneOnCoke;
    
    @Before
    public void setUp(){
        coke = new Coke(70);
        beans = new Beans(50);
    }
        
    @Test
    public void testCalculationOfOneItem() throws Exception {
        ITill till = new Till();
        IBasket basket = new Basket();
        
        basket = new Basket();
        basket.addProduce(coke);
        
        assertEquals(70, till.calculateTotal(basket));
    }
    
    
    @Test
    public void canCountTheAmountOfProductInBasket() throws Exception {
        IBasket basket = new Basket();
        basket.addProduce(coke);
        
        assertEquals(1, basket.amountOfProduct(coke.getId()));
        
        basket.addProduce(coke);
        basket.addProduce(coke);
        assertEquals(3, basket.amountOfProduct(coke.getId()));
        
        basket.addProduce(beans);
        Map<IProduct, Long> amountOfProducts = basket.ammountOfProducts();
        assertEquals(3, (long) amountOfProducts.get(coke));
    }
    
    @Test
    public void applyBulkOffer() throws Exception {
        ISaving saving = mock(ISaving.class);
        when(saving.getAmmount()).thenReturn(-40);
                
        IOffer offer = mock(IOffer.class);
        when(offer.getSaving(coke, 2)).thenReturn(saving);
        
        
        till = new Till();
        till.addOffer(offer);
        
        basket = new Basket();
        basket.addProduce(coke);
        basket.addProduce(coke);
        basket.addProduce(beans);
        
        assertEquals("Subtotal", 190, ((Till)till).calculateSubTotal(basket));
        assertEquals("Savings", -40, ((Till)till).calcualteSavings(basket, Arrays.asList(offer)));
        assertEquals("Total Price", 150, till.calculateTotal(basket));
    }
}
