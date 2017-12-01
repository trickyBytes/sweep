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
import sweep.offers.impl.BulkPriceOffer;
import sweep.products.Product;

/**
 * TwoForOneOfferTest.
 *
 * @author trickyBytes
 */
public class BulkPriceOfferTest {

    private Product coke;
    private Product beans;

    @Before
    public void setUp() {
        coke = mock(Product.class);
        when(coke.getId()).thenReturn(UUID.randomUUID());
        when(coke.getPrice()).thenReturn(new Price(70));

        beans = mock(Product.class);
        when(beans.getId()).thenReturn(UUID.randomUUID());
        when(beans.getPrice()).thenReturn(new Price(50));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testCannotHaveZeroAmountForBulkOffer(){
        new BulkPriceOffer(coke.getId(), 0, BigDecimal.ZERO);
    }

    @Test
    public void testSavingShouldBeTotalCostOfItemsMinusBulkPrice() throws Exception {
        IOffer offer = new BulkPriceOffer(coke.getId(), 2, new BigDecimal(100));

        ISaving saving = offer.getSaving(coke, 2);
        assertNotNull(saving);
        assertTrue("Amount of saving", new BigDecimal(-40).equals(saving.getAmmount()));
    }

    @Test
    public void testSavingNotAppliedIfNumberOfProductsIsLowerThanBulkAmount() throws Exception {
        IOffer offer = new BulkPriceOffer(coke.getId(), 2, new BigDecimal(100));
        int amount = 1;

        ISaving saving = offer.getSaving(coke, amount);
        assertNotNull(saving);
        assertTrue("Amount of saving", BigDecimal.ZERO.equals(saving.getAmmount()));
    }
    
    @Test
    public void testSavingIsCorrectIfAmountOfItemsIsBulkPlusOne() throws Exception {
        IOffer offer = new BulkPriceOffer(coke.getId(), 2, new BigDecimal(100));
        
        int amount = 3;
        ISaving saving = offer.getSaving(coke, amount);
        assertNotNull(saving);
        assertTrue("Amount of saving", new BigDecimal(-40).equals(saving.getAmmount()));
    }
    
    @Test
    public void testSavingIsAppliedToMultiplesOfBulkAmounts() throws Exception {
        IOffer offer = new BulkPriceOffer(coke.getId(), 2, new BigDecimal(100));
        
        int amount = 4;
        ISaving saving = offer.getSaving(coke, amount);
        assertNotNull(saving);
        assertTrue("Amount of saving", new BigDecimal(-80).equals(saving.getAmmount()));
        
        amount = 5;
        saving = offer.getSaving(coke, amount);
        assertNotNull(saving);
        assertTrue("Amount of saving",  new BigDecimal(-80).equals(saving.getAmmount()));
    }
    
    @Test
    public void oddNumberForBulkAmount() throws Exception {
        IOffer offer = new BulkPriceOffer(beans.getId(), 3, new BigDecimal(100));
        
        int amount = 3;
        ISaving saving = offer.getSaving(beans, amount);
        assertNotNull(saving);
        assertTrue("Amount of saving", new BigDecimal(-50).equals(saving.getAmmount()));
    }

    @Test
    public void testSavingOnlyAppliedToSelectedProductOnly() throws Exception {
        IOffer offer = new BulkPriceOffer(coke.getId(), 2, new BigDecimal(100));

        ISaving saving = offer.getSaving(beans, 3);
        assertNotNull(saving);
        assertTrue("Amount of saving", BigDecimal.ZERO.equals(saving.getAmmount()));
    }
}
