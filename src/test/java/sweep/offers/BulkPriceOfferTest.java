package sweep.offers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.UUID;

import org.junit.Before;
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

    private IProduct coke;
    private IProduct beans;

    @Before
    public void setUp() {
        coke = mock(IProduct.class);
        when(coke.getId()).thenReturn(UUID.randomUUID());
        when(coke.getPrice()).thenReturn(70);

        beans = mock(IProduct.class);
        when(beans.getId()).thenReturn(UUID.randomUUID());
        when(beans.getPrice()).thenReturn(50);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testCannotHaveZeroAmountForBulkOffer(){
        new BulkPriceOffer(coke.getId(), 0, 0);
    }

    @Test
    public void testSavingShouldBeTotalCostOfItemsMinusBulkPrice() throws Exception {
        IOffer offer = new BulkPriceOffer(coke.getId(), 2, 100);

        ISaving saving = offer.getSaving(coke, 2);
        assertNotNull(saving);
        assertEquals("Amount of saving", -40, saving.getAmmount());
    }

    @Test
    public void testSavingNotAppliedIfNumberOfProductsIsLowerThanBulkAmount() throws Exception {
        IOffer offer = new BulkPriceOffer(coke.getId(), 2, 100);
        int amount = 1;

        ISaving saving = offer.getSaving(coke, amount);
        assertNotNull(saving);
        assertEquals("Amount of saving", 0, saving.getAmmount());
    }
    
    @Test
    public void testSavingIsCorrectIfAmountOfItemsIsBulkPlusOne() throws Exception {
        IOffer offer = new BulkPriceOffer(coke.getId(), 2, 100);
        
        int amount = 3;
        ISaving saving = offer.getSaving(coke, amount);
        assertNotNull(saving);
        assertEquals("Amount of saving", -40, saving.getAmmount());
    }
    
    @Test
    public void testSavingIsAppliedToMultiplesOfBulkAmounts() throws Exception {
        IOffer offer = new BulkPriceOffer(coke.getId(), 2, 100);
        
        int amount = 4;
        ISaving saving = offer.getSaving(coke, amount);
        assertNotNull(saving);
        assertEquals("Amount of saving", -80, saving.getAmmount());
        
        amount = 5;
        saving = offer.getSaving(coke, amount);
        assertNotNull(saving);
        assertEquals("Amount of saving", -80, saving.getAmmount());
    }
    
    @Test
    public void oddNumberForBulkAmount() throws Exception {
        IOffer offer = new BulkPriceOffer(beans.getId(), 3, 100);
        
        int amount = 3;
        ISaving saving = offer.getSaving(beans, amount);
        assertNotNull(saving);
        assertEquals("Amount of saving", -50, saving.getAmmount());
    }

    @Test
    public void testSavingOnlyAppliedToSelectedProductOnly() throws Exception {
        IOffer offer = new BulkPriceOffer(coke.getId(), 2, 100);

        ISaving saving = offer.getSaving(beans, 3);
        assertNotNull(saving);
        assertEquals("Amount of saving", 0, saving.getAmmount());
    }
}
