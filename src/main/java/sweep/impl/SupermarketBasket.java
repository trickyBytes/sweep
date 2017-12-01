package sweep.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import sweep.Basket;
import sweep.products.Product;

/**
 * Basket.
 *
 * @author trickyBytes
 */
public class SupermarketBasket implements Basket {
    List<Product> products = new ArrayList<>();
    
    /**
     * @param product
     * @see sweep.Basket#addProduce(sweep.products.Product)
     */
    @Override
    public void addProduce(Product product) {
        this.products.add(product);
    }

    /**
     * @return
     * @see sweep.Basket#getItems()
     */
    @Override
    public List<Product> getItems() {
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
    public Map<Product, Long> ammountOfProducts() {
        return products.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * @param product
     * @param numberOfUnits
     * @see sweep.Basket#addProduce(sweep.products.Product, int)
     */
    @Override
    public void addProduce(Product product, int numberOfUnits) {
        for(int ct = 1; ct <= numberOfUnits; ct++){
            products.add(product);
        }
    }
}
