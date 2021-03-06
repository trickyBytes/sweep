package sweep.products.impl;

import java.util.UUID;

import sweep.Price;
import sweep.products.Product;

/**
 * Product.
 *
 * @author trickyBytes
 */
public abstract class AbsProduct implements Product {
    private final Price price;
    private final UUID id;
    private final String name;

    public AbsProduct(final Price price, final String name) {
        this.price = price;
        this.name = name;
        this.id = UUID.randomUUID();
    }

    /**
     * @return
     * @see sweep.products.Product#getPrice()
     */
    @Override
    public Price getPrice() {
        return price;
    }

    /**
     * @return
     * @see sweep.products.Product#getId()
     */
    @Override
    public UUID getId() {
        return id;
    }

    /**
     * @return
     * @see sweep.products.Product#getName()
     */
    @Override
    public String getName() {
        return name;
    }
}
