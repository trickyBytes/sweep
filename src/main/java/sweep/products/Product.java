package sweep.products;

import java.util.UUID;

import sweep.Price;

/**
 * Represents a unique item in the Shop, a Shop would have many of these. Uniquenss is defined by the the ID of the
 * product.
 * 
 * @author trickyBytes
 */
public interface Product {

    /**
     * @return The {@link Price} of the product
     */
    Price getPrice();

    /**
     * @return The unique {@link UUID} of the {@link Product}
     */
    UUID getId();

    /**
     * @return A human readable name for the product as a {@link String}
     */
    String getName();
}
