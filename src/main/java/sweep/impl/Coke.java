package sweep.impl;

import java.util.UUID;

import sweep.IProduct;

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
     * @see sweep.IProduct#getPrice()
     */
    @Override
    public int getPrice() {
        return price;
    }

    /**
     * @return
     * @see sweep.IProduct#getId()
     */
    @Override
    public UUID getId() {
        return id;
    }
}
