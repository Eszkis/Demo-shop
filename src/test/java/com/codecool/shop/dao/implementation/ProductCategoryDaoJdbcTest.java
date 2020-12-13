package com.codecool.shop.dao.implementation;

import static org.junit.jupiter.api.Assertions.*;

import com.codecool.shop.dao.ShopDatabaseManager;
import com.codecool.shop.model.ProductCategory;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class ProductCategoryDaoJdbcTest {

    private ShopDatabaseManager shopDatabaseManager = ShopDatabaseManager.getInstance();

    ProductCategoryDaoJdbcTest() throws SQLException {
    }


    @Test
    void add() {
    }

    @Test
    void findById() {
        int id = 1;

        var expectedProductCategory = new ProductCategory("Progbasics", "Python", 1);
        var result = shopDatabaseManager.getProductCategory(id);

        assertEquals(expectedProductCategory, result);
    }

    @Test
    void remove() {
    }

    @Test
    void getAll() {
        ArrayList<ProductCategory> productCategories = new ArrayList<>();

        productCategories.add(new ProductCategory("All category", "All category", 4));
        productCategories.add(new ProductCategory("OOP", "Java", 3));
        productCategories.add(new ProductCategory("WEB", "Javascript&SQL", 2));
        productCategories.add(new ProductCategory("Progbasics", "Python", 1));

        ArrayList<ProductCategory> result = shopDatabaseManager.getAllProductCategory();

        assertEquals(productCategories.size(), result.size());
        for (int i = 0; i < productCategories.size(); i++) {
            assertEquals(productCategories.get(i), result.get(i));
        }
    }

    @Test
    void findIdByName() {
        String name = "OOP";

        var result = shopDatabaseManager.getProductCategoryByName(name);

        assertEquals(3, result);
    }
}