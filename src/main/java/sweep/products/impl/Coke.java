package sweep.products.impl;

import java.util.UUID;

import sweep.IPrice;
import sweep.products.IProduct;

/**
 * Coke.
 *
 * @author trickyBytes
 */
public class Coke implements IProduct {
    private IPrice price;
    private final UUID id = UUID.randomUUID();
    
    /**
     * @param i
     */
    public Coke(IPrice price) {
        this.price = price;
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
}
