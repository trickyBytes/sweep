package sweep.products.impl;

import java.util.UUID;

import sweep.IPrice;
import sweep.products.IProduct;

/**
 * Product.
 *
 * @author trickyBytes
 */
public abstract class Product implements IProduct {
    private final IPrice price;
    private final UUID id;
    private final String name;
    
    /**
     * 
     */
    public Product(final IPrice price, final String name) {
        this.price = price;
        this.name = name;
        this.id = UUID.randomUUID();
    }
    
    /**
     * @return
     * @see sweep.products.IProduct#getPrice()
     */
    @Override
    public IPrice getPrice() {
        return price;
    }

    /**
     * @return
     * @see sweep.products.IProduct#getId()
     */
    @Override
    public UUID getId() {
        return id;
    }

    /**
     * @return
     * @see sweep.products.IProduct#getName()
     */
    @Override
    public String getName() {
        return name;
    }
}
