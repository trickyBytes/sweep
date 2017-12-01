package sweep.offers;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import sweep.ISaving;
import sweep.impl.Price;
import sweep.offers.impl.GetNthItemFreeOffer;
import sweep.products.Product;

/**
 * GetNthItemFreeOfferTest.
 *
 * @author trickyBytes
 */
public class GetNthItemFreeOfferTest {
    
    private Product beans;
    private IOffer offer;
    private final int numItemsAtFullPrice = 2;
    
    @Before
    public void setUp(){
        beans = mock(Product.class);
        when(beans.getId()).thenReturn(UUID.randomUUID());
        when(beans.getPrice()).thenReturn(new Price(50));
        
        offer = new GetNthItemFreeOffer(beans.getId(), numItemsAtFullPrice);
    }
    
    @Test
    public void testCanDescribeHowManyProductsNeedToBePurchased() throws Exception {
        assertNotNull(offer.getSaving(beans, 1));
        assertTrue(BigDecimal.ZERO.equals(offer.getSaving(beans, 1).getAmmount()));
    }
    
    @Test
    public void testSavingShouldBeTheCostOfItem() throws Exception {
        ISaving saving = offer.getSaving(beans, 3);
        assertNotNull(saving);
        assertTrue(new BigDecimal(-50).equals(saving.getAmmount()));
    }
    
    @Test 
    public void testOfferIsntAppliedUntilNumberOfItemsReached() throws Exception {
        ISaving saving = offer.getSaving(beans, 2);
        assertNotNull(saving);
        assertTrue(BigDecimal.ZERO.equals(saving.getAmmount()));
    }
    
    @Test
    public void testSavingIsAppliedToMultiplesOfOffer() throws Exception {
        ISaving saving = offer.getSaving(beans, 6);
        assertNotNull(saving);
        assertTrue(new BigDecimal(-100).equals(saving.getAmmount()));
        
        saving = offer.getSaving(beans, 9);
        assertNotNull(saving);
        assertTrue(new BigDecimal(-150).equals(saving.getAmmount()));
    }
}
