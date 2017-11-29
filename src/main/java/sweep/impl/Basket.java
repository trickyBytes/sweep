package sweep.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import sweep.IBasket;
import sweep.products.IProduct;

/**
 * Basket.
 *
 * @author trickyBytes
 */
public class Basket implements IBasket {
    List<IProduct> products = new ArrayList<>();
    
    /**
     * @param product
     * @see sweep.IBasket#addProduce(sweep.products.IProduct)
     */
    @Override
    public void addProduce(IProduct product) {
        this.products.add(product);
    }

    /**
     * @return
     * @see sweep.IBasket#getItems()
     */
    @Override
    public List<IProduct> getItems() {
        return products;
    }

    /**
     * @param id
     * @return
     * @see sweep.IBasket#amountOfProduct(java.util.UUID)
     */
    @Override
    public long amountOfProduct(UUID id) {
       return products.stream().filter(i -> i.getId().equals(id)).count();
    }

    /**
     * @return
     * @see sweep.IBasket#ammountOfProducts()
     */
    @Override
    public Map<IProduct, Long> ammountOfProducts() {
        return products.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
