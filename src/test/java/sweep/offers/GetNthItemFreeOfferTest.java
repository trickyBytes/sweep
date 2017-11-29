package sweep.offers;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import sweep.IProduct;
import sweep.offers.impl.GetNthItemFreeOffer;

/**
 * GetNthItemFreeOfferTest.
 *
 * @author trickyBytes
 */
public class GetNthItemFreeOfferTest {
    
    
    private IProduct beans;
    
    
    @Before
    public void setUp(){
        beans = mock(IProduct.class);
        when(beans.getId()).thenReturn(UUID.randomUUID());
        when(beans.getPrice()).thenReturn(50);
    }
    
    @Test
    public void canDescribeHowManyProductsNeedToBePurchased() throws Exception {
        final int numItemsAtFullPrice = 2;
        
        IOffer offer = new GetNthItemFreeOffer(beans.getId(), numItemsAtFullPrice);
        assertNotNull(offer.getSaving(beans, 1));
        assertEquals(0, offer.getSaving(beans, 1));
    }
}
