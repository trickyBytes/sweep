package sweep.offers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.UUID;

import org.junit.Test;

import sweep.IProduct;
import sweep.ISaving;
import sweep.offers.impl.BulkPriceOffer;

/**
 * TwoForOneOfferTest.
 *
 * @author trickyBytes
 */
public class BulkPriceOfferTest {

    @Test
    public void testSavingApplied() throws Exception {
        final UUID id = UUID.randomUUID();
        IProduct coke = mock(IProduct.class);
        when(coke.getId()).thenReturn(id);

        IOffer offer = new BulkPriceOffer(coke.getId(), 2, 100);
                
        ISaving saving = offer.getSaving(coke);
        assertNotNull(saving);
        assertEquals("Amount of saving", 100, saving.getAmmount());
    }
    
    @Test
    public void testSavingOnlyAppliedToSelectedProductOnly() throws Exception {
        IProduct coke = mock(IProduct.class);
        when(coke.getId()).thenReturn(UUID.randomUUID());

        IProduct beans= mock(IProduct.class);
        when(beans.getId()).thenReturn(UUID.randomUUID());

        IOffer offer = new BulkPriceOffer(coke.getId(), 2, 100);
        
        ISaving saving = offer.getSaving(beans);
        assertNotNull(saving);
        assertEquals("Amount of saving", 0, saving.getAmmount());
    }
}
