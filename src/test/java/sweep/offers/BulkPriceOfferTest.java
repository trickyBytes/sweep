package sweep.offers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import sweep.Saving;
import sweep.impl.StorePrice;
import sweep.offers.impl.BulkPriceOffer;
import sweep.products.Product;
import sweep.products.impl.Beans;
import sweep.products.impl.Coke;

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
        coke = new Coke(new StorePrice(70));
        beans = new Beans(new StorePrice(50));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testCannotHaveZeroAmountForBulkOffer(){
        new BulkPriceOffer(coke.getId(), 0, BigDecimal.ZERO);
    }

    @Test
    public void testSavingShouldBeTotalCostOfItemsMinusBulkPrice() throws Exception {
        Offer offer = new BulkPriceOffer(coke.getId(), 2, new BigDecimal(100));

        Saving saving = offer.getSaving(coke, 2);
        assertNotNull(saving);
        assertTrue("Amount of saving", new BigDecimal(-40).equals(saving.getAmmount()));
    }

    @Test
    public void testSavingNotAppliedIfNumberOfProductsIsLowerThanBulkAmount() throws Exception {
        Offer offer = new BulkPriceOffer(coke.getId(), 2, new BigDecimal(100));
        int amount = 1;

        Saving saving = offer.getSaving(coke, amount);
        assertNotNull(saving);
        assertTrue("Amount of saving", BigDecimal.ZERO.equals(saving.getAmmount()));
    }
    
    @Test
    public void testSavingIsCorrectIfAmountOfItemsIsBulkPlusOne() throws Exception {
        Offer offer = new BulkPriceOffer(coke.getId(), 2, new BigDecimal(100));
        
        int amount = 3;
        Saving saving = offer.getSaving(coke, amount);
        assertNotNull(saving);
        assertTrue("Amount of saving", new BigDecimal(-40).equals(saving.getAmmount()));
    }
    
    @Test
    public void testSavingIsAppliedToMultiplesOfBulkAmounts() throws Exception {
        Offer offer = new BulkPriceOffer(coke.getId(), 2, new BigDecimal(100));
        
        int amount = 4;
        Saving saving = offer.getSaving(coke, amount);
        assertNotNull(saving);
        assertTrue("Amount of saving", new BigDecimal(-80).equals(saving.getAmmount()));
        
        amount = 5;
        saving = offer.getSaving(coke, amount);
        assertNotNull(saving);
        assertTrue("Amount of saving",  new BigDecimal(-80).equals(saving.getAmmount()));
    }
    
    @Test
    public void oddNumberForBulkAmount() throws Exception {
        Offer offer = new BulkPriceOffer(beans.getId(), 3, new BigDecimal(100));
        
        int amount = 3;
        Saving saving = offer.getSaving(beans, amount);
        assertNotNull(saving);
        assertTrue("Amount of saving", new BigDecimal(-50).equals(saving.getAmmount()));
    }

    @Test
    public void testSavingOnlyAppliedToSelectedProductOnly() throws Exception {
        Offer offer = new BulkPriceOffer(coke.getId(), 2, new BigDecimal(100));

        Saving saving = offer.getSaving(beans, 3);
        assertNotNull(saving);
        assertTrue("Amount of saving", BigDecimal.ZERO.equals(saving.getAmmount()));
    }
}
