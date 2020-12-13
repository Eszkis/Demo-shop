package com.codecool.shop.dao;

import com.codecool.shop.config.DBconfig;
import com.codecool.shop.dao.implementation.ProductCategoryDaoJdbc;
import com.codecool.shop.dao.implementation.ProductDaoJdbc;
import com.codecool.shop.dao.implementation.SupplierDaoJdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.sql.DataSource;

import com.codecool.shop.dao.implementation.UserDaoJdbc;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import com.codecool.shop.model.User;
import org.postgresql.ds.PGSimpleDataSource;


public class ShopDatabaseManager {

    private ProductCategoryDaoJdbc productCategoryDao;
    private ProductDaoJdbc productDao;
    private SupplierDaoJdbc supplierDao;
    private UserDaoJdbc userDao;
    private static ShopDatabaseManager instance;


    public static ShopDatabaseManager getInstance() throws SQLException {
        if (instance == null) {
            instance = new ShopDatabaseManager();
            instance.setup();
        }
        return instance;
    }

    private ShopDatabaseManager() {
    }

    public void setup() throws SQLException {
        DataSource dataSource = connect();
        productCategoryDao = new ProductCategoryDaoJdbc(dataSource);
        supplierDao = new SupplierDaoJdbc(dataSource);
        productDao = new ProductDaoJdbc(dataSource, productCategoryDao, supplierDao);
        userDao = new UserDaoJdbc(dataSource);
    }

    private DataSource connect() throws SQLException {
        DBconfig dBconfig = new DBconfig();
        HashMap<String, String> dbProperties = dBconfig.getDBProperties();
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        String dbName = dbProperties.get("db.name");
        String user = dbProperties.get("db.user");
        String password = dbProperties.get("db.password");

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        System.out.println("Trying to connect");
        dataSource.getConnection().close();
        System.out.println("Connection ok.");

        return dataSource;
    }

    public ArrayList<Product> getAllProduct() {
        return productDao.getAll();
    }

    public ArrayList<Supplier> getAllSupplier() {
        return supplierDao.getAll();
    }

    public ArrayList<ProductCategory> getAllProductCategory() {
        return productCategoryDao.getAll();
    }

    public Product getProduct(int id) {
        return productDao.find(id);
    }

    public Supplier getSupplier(int id) {
        return supplierDao.find(id);
    }

    public int getSupplierName(String name) {
        return supplierDao.findId(name);
    }

    public ProductCategory getProductCategory(int id) {
        return productCategoryDao.find(id);
    }

    public int getProductCategoryByName(String name) {
        return productCategoryDao.findId(name);
    }

    public ArrayList<Product> getProductBy(Supplier supplier) {
        return productDao.getBy(supplier);
    }

    public ArrayList<Product> getProductBy(ProductCategory productCategory) {
        return productDao.getBy(productCategory);
    }

    public ArrayList<Product> getProductBy(Supplier supplier, ProductCategory productCategory) {
        return productDao.getBy(productCategory, supplier);
    }

    public User getUserByName(String username) {
        return userDao.find(username);
    }

    public void addUser(User user) {
        userDao.add(user);
    }


}