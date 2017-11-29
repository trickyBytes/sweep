package sweep.products.impl;

import java.util.UUID;

import sweep.products.IProduct;

/**
 * Coke.
 *
 * @author trickyBytes
 */
public class Coke implements IProduct {
    private int price;
    private final UUID id = UUID.randomUUID();
    
    /**
     * @param i
     */
    public Coke(int price) {
        this.price = price;
    }

    /**
     * @return
     * @see sweep.products.IProduct#getPrice()
     */
    @Override
    public int getPrice() {
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
