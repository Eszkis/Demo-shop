package com.codecool.shop.dao.implementation;

import static org.junit.jupiter.api.Assertions.*;

import com.codecool.shop.dao.ShopDatabaseManager;
import com.codecool.shop.model.Supplier;
import java.sql.SQLException;
import java.util.ArrayList;


class SupplierDaoJdbcTest {

    private ShopDatabaseManager shopDatabaseManager = ShopDatabaseManager.getInstance();

    SupplierDaoJdbcTest() throws SQLException {
    }


    @org.junit.jupiter.api.Test
    void addToDatabase() {
    }

    @org.junit.jupiter.api.Test
    void findById() {
        int id = 1;
        var expectedSupplier = new Supplier("marci", 1);

        var result = shopDatabaseManager.getSupplier(id);

        assertEquals(expectedSupplier.getName(), result.getName());
        assertEquals(expectedSupplier.getId(), result.getId());
        assertEquals(expectedSupplier.getDescription(), result.getDescription());
        assertTrue(expectedSupplier.equals(result));
    }


    @org.junit.jupiter.api.Test
    void removeFromDatabase() {
    }


    @org.junit.jupiter.api.Test
    void getAllSupplier() {
        ArrayList<Supplier> supplierList = new ArrayList<>();

        supplierList.add(new Supplier("All supplier", 5));
        supplierList.add(new Supplier("omar", 4));
        supplierList.add(new Supplier("dominik", 3));
        supplierList.add(new Supplier("eszkis", 2));
        supplierList.add(new Supplier("marci", 1));

        ArrayList<Supplier> result = shopDatabaseManager.getAllSupplier();
        assertEquals(supplierList.size(), result.size());
        for (int i = 0; i < supplierList.size(); i++) {
            assertEquals(supplierList.get(i), result.get(i));
        }
    }

    @org.junit.jupiter.api.Test
    void findIdByName() {
        var name = "marci";

        var result = shopDatabaseManager.getSupplierName(name);

        assertEquals(1, result);
    }
}