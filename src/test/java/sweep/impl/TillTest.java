package sweep.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import sweep.IBasket;
import sweep.ISaving;
import sweep.ITill;
import sweep.offers.IOffer;
import sweep.offers.impl.BulkPriceOffer;
import sweep.offers.impl.GetNthItemFreeOffer;
import sweep.products.IProduct;
import sweep.products.impl.Beans;
import sweep.products.impl.Coke;
import sweep.products.impl.Oranges;

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
    IProduct oranges;
    
    IOffer twoForOneOnCoke;
    
    @Before
    public void setUp(){
        coke = new Coke(new Price(70));
        beans = new Beans(new Price(50));
        oranges = new Oranges(new Price(0.199));//price per gram
    }
        
    @Test
    public void testCalculationOfOneItem() throws Exception {
        ITill till = new Till();
        IBasket basket = new Basket();
        
        basket = new Basket();
        basket.addProduce(coke);
        
        assertEquals(new BigDecimal(70), till.calculateTotal(basket));
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
        when(saving.getAmmount()).thenReturn(new BigDecimal(-40));
                
        IOffer offer = mock(IOffer.class);
        when(offer.getSaving(coke, 2)).thenReturn(saving);
        
        
        till = new Till();
        till.addOffer(offer);
        
        basket = new Basket();
        basket.addProduce(coke, 2);
        basket.addProduce(beans);
        
        assertTrue("Subtotal", new BigDecimal(190).equals(((Till)till).calculateSubTotal(basket)));
        assertTrue("Savings", new BigDecimal(-40).equals(((Till)till).calculate(basket, Arrays.asList(offer))));
        assertTrue("Total Price", new BigDecimal(150).equals(till.calculateTotal(basket)));
    }
    
    @Test
    public void fullTillIntegrationTest() throws Exception {
        IOffer beansOffer = new GetNthItemFreeOffer(beans.getId(), 2);
        IOffer cokeOffer = new BulkPriceOffer(coke.getId(), 2, new BigDecimal(100));
        
        till = new Till();
        till.addOffer(beansOffer);
        till.addOffer(cokeOffer);

        basket = new Basket();
        basket.addProduce(coke, 2);
        basket.addProduce(beans, 3);
        basket.addProduce(oranges, 200);
        
        System.out.println(((Till)till).calculateSubTotal(basket).toString());
        assertEquals("Subtotal", new BigDecimal(330).doubleValue(), ((Till)till).calculateSubTotal(basket).doubleValue(), 0.2d);
        assertEquals("Savings", new BigDecimal(-90).doubleValue(), ((Till)till).calculate(basket, Arrays.asList(beansOffer, cokeOffer)).doubleValue(), 0.2d);
        assertEquals("Total Proce", new BigDecimal(240).doubleValue(), till.calculateTotal(basket).doubleValue(), 0.2d);
    }
}
