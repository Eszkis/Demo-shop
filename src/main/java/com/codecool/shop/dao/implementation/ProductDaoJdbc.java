package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class ProductDaoJdbc implements ProductDao {

    private DataSource dataSource;
    private ProductCategoryDaoJdbc productCategoryJdbc;
    private SupplierDaoJdbc supplierDaoJdbc;

    public ProductDaoJdbc(DataSource dataSource, ProductCategoryDaoJdbc productCategoryDaoJdbc, SupplierDaoJdbc supplierDaoJdbc) {
        this.dataSource = dataSource;
        this.productCategoryJdbc = productCategoryDaoJdbc;
        this.supplierDaoJdbc = supplierDaoJdbc;
    }

    @Override
    public void add(Product product) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO product (name, picture_name, default_price, default_currency, description, product_category, supplier) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setString(2, product.getPictureName());
            statement.setFloat(3, product.getDefaultPrice());
            statement.setString(4, product.getDefaultCurrency().toString());
            statement.setString(5, product.getDescription());
            statement.setString(6, product.getProductCategory().toString());
            statement.setString(7, product.getSupplier().toString());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product find(int id) {
        Product product;

        try (Connection conn = dataSource.getConnection()) {

            String sql = "SELECT * FROM product WHERE id =?";
            PreparedStatement statement = conn
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            ProductCategory productCategory = productCategoryJdbc.find(resultSet.getInt("product_category"));
            Supplier supplier = supplierDaoJdbc.find(resultSet.getInt("supplier"));
            product = new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("picture_name"),
                    resultSet.getFloat("default_price"), resultSet.getString("default_currency"),
                    resultSet.getString("description"), productCategory, supplier);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }


    @Override
    public void remove(int id) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "DELETE FROM product WHERE id = ?";
            PreparedStatement statement = conn
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Product> getAll() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM product ORDER BY id";
            PreparedStatement statement = conn
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                ProductCategory productCategory = productCategoryJdbc.find(resultSet.getInt("product_category"));
                Supplier supplier = supplierDaoJdbc.find(resultSet.getInt("supplier"));
                products.add((new Product(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("picture_name"),
                        resultSet.getFloat("default_price"),
                        resultSet.getString("default_currency"),
                        resultSet.getString("description"),
                        productCategory,
                        supplier)));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Product> getBy(Supplier supplier) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM product WHERE supplier = ? ORDER BY id";
            PreparedStatement statement = conn
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, supplier.getId());
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                ProductCategory productCategory = productCategoryJdbc.find(resultSet.getInt("product_category"));
                products.add((new Product(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("picture_name"),
                        resultSet.getFloat("default_price"),
                        resultSet.getString("default_currency"),
                        resultSet.getString("description"),
                        productCategory,
                        supplier)));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Product> getBy(ProductCategory productCategory) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM product WHERE product_category = ? ORDER BY id";
            PreparedStatement statement = conn
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, productCategory.getId());
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                Supplier supplier = supplierDaoJdbc.find(resultSet.getInt("supplier"));
                products.add((new Product(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("picture_name"),
                        resultSet.getFloat("default_price"),
                        resultSet.getString("default_currency"),
                        resultSet.getString("description"),
                        productCategory,
                        supplier)));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Product> getBy(ProductCategory productCategory, Supplier supplier) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM product WHERE product_category = ? AND supplier = ? ORDER BY id";
            PreparedStatement statement = conn
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, productCategory.getId());
            statement.setInt(2, supplier.getId());
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                products.add((new Product(resultSet.getInt("id"),resultSet.getString("name"),
                        resultSet.getString("picture_name"),
                        resultSet.getFloat("default_price"),
                        resultSet.getString("default_currency"),
                        resultSet.getString("description"),
                        productCategory,
                        supplier)));
            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
