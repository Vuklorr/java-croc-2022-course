package ru.croc.task18.test;

import org.testng.annotations.Test;
import ru.croc.task18.dao.OrderDAO;
import ru.croc.task18.dao.ProductDAO;
import ru.croc.task18.entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class DAOTest {
    private final ProductDAO productDAO = new ProductDAO();
    @Test
    private void findProduct() throws SQLException, ClassNotFoundException {
        Product product = productDAO.findProduct("Т5");
        assertEquals(product.article(), "Т5");
        assertEquals(product.name(), "Видеокарта");
        assertEquals(product.cost(), 15000);
    }

    @Test
    private void findNullProduct() throws SQLException, ClassNotFoundException {
        Product product = productDAO.findProduct("ТTTTTT");
        assertNull(product);
    }

    @Test
    private void createProduct() throws SQLException, ClassNotFoundException {
        productDAO.createProduct(new Product("Т6","Наушники", 500));
        Product product = productDAO.findProduct("Т6");
        assertNotNull(product);
    }

    @Test
    private void updateProduct() throws SQLException, ClassNotFoundException {
        Product product = new Product("Т6","НаушникиPro", 5000);
        productDAO.updateProduct(product);
        assertEquals(product.article(), "Т6");
        assertEquals(product.name(), "НаушникиPro");
        assertEquals(product.cost(), 5000);
    }

    @Test
    private void createOrder() throws SQLException, ClassNotFoundException {
        List<Product> productList = new ArrayList<>();
        OrderDAO orderDAO = new OrderDAO();

        Product product1 = new Product("Т6","НаушникиPro", 5000);
        Product product2 = new Product("Т6","НаушникиPro", 5000);
        productList.add(product1);
        productList.add(product2);
        orderDAO.createOrder("petya", productList);
    }

    @Test
    private void deleteProduct() throws SQLException, ClassNotFoundException {
        Product product = new Product("Т6","НаушникиPro", 5000);
        productDAO.deleteProduct(product.article());
        assertNull(productDAO.findProduct(product.article()));
    }
}
