import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void removedProductExists() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Молоко", 150);
        Product product2 = new Product(2, "Яйца", 120);
        Product product3 = new Product(3, "Сыр", 200);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void removedProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Молоко", 150);
        Product product2 = new Product(2, "Яйца", 120);
        Product product3 = new Product(3, "Сыр", 200);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(5)
        );

    }

}