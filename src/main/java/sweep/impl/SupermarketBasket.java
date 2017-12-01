package sweep.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import sweep.Basket;
import sweep.products.IProduct;

/**
 * Basket.
 *
 * @author trickyBytes
 */
public class SupermarketBasket implements Basket {
    List<IProduct> products = new ArrayList<>();
    
    /**
     * @param product
     * @see sweep.Basket#addProduce(sweep.products.IProduct)
     */
    @Override
    public void addProduce(IProduct product) {
        this.products.add(product);
    }

    /**
     * @return
     * @see sweep.Basket#getItems()
     */
    @Override
    public List<IProduct> getItems() {
        return products;
    }

    /**
     * @param id
     * @return
     * @see sweep.Basket#amountOfProduct(java.util.UUID)
     */
    @Override
    public long amountOfProduct(UUID id) {
       return products.stream().filter(i -> i.getId().equals(id)).count();
    }

    /**
     * @return
     * @see sweep.Basket#ammountOfProducts()
     */
    @Override
    public Map<IProduct, Long> ammountOfProducts() {
        return products.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * @param product
     * @param numberOfUnits
     * @see sweep.Basket#addProduce(sweep.products.IProduct, int)
     */
    @Override
    public void addProduce(IProduct product, int numberOfUnits) {
        for(int ct = 1; ct <= numberOfUnits; ct++){
            products.add(product);
        }
    }
}
