package sweep.offers;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import sweep.IProduct;
import sweep.ISaving;
import sweep.offers.impl.GetNthItemFreeOffer;

/**
 * GetNthItemFreeOfferTest.
 *
 * @author trickyBytes
 */
public class GetNthItemFreeOfferTest {
    
    private IProduct beans;
    private IOffer offer;
    private final int numItemsAtFullPrice = 2;
    
    @Before
    public void setUp(){
        beans = mock(IProduct.class);
        when(beans.getId()).thenReturn(UUID.randomUUID());
        when(beans.getPrice()).thenReturn(50);
        
        offer = new GetNthItemFreeOffer(beans.getId(), numItemsAtFullPrice);
    }
    
    @Test
    public void testCanDescribeHowManyProductsNeedToBePurchased() throws Exception {
        assertNotNull(offer.getSaving(beans, 1));
        assertEquals(0, offer.getSaving(beans, 1).getAmmount());
    }
    
    @Test
    public void testSavingShouldBeTheCostOfItem() throws Exception {
        ISaving saving = offer.getSaving(beans, 3);
        assertNotNull(saving);
        assertEquals(-50, saving.getAmmount());
    }
    
    @Test 
    public void testOfferIsntAppliedUntilNumberOfItemsReached() throws Exception {
        ISaving saving = offer.getSaving(beans, 2);
        assertNotNull(saving);
        assertEquals(0, saving.getAmmount());
    }
    
    @Test
    public void testSavingIsAppliedToMultiplesOfOffer() throws Exception {
        ISaving saving = offer.getSaving(beans, 6);
        assertNotNull(saving);
        assertEquals(-100, saving.getAmmount());
        
        saving = offer.getSaving(beans, 9);
        assertNotNull(saving);
        assertEquals(-150, saving.getAmmount());
    }
}
