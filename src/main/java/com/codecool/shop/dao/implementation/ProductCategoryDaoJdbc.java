package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class ProductCategoryDaoJdbc implements ProductCategoryDao {

    private DataSource dataSource;

    public ProductCategoryDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(ProductCategory category) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO product_category (id, department, name) VALUES (?, ?, ?)";
            PreparedStatement statement = conn
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, String.valueOf(category.getId()));
            statement.setString(2, category.getDepartment());
            statement.setString(3, category.getName());
            statement.execute();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ProductCategory find(int id) {
        ProductCategory productCategory;

        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM product_category WHERE id=?";
            PreparedStatement statement = conn
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            productCategory = new ProductCategory(resultSet.getString("name"),
                    resultSet.getString("department"), resultSet.getInt("id"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productCategory;
    }

    @Override
    public void remove(int id) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "DELETE FROM product_category WHERE id = ?";
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
    public ArrayList<ProductCategory> getAll() {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM product_category ORDER BY id DESC";
            PreparedStatement statement = conn
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<ProductCategory> productCategories = new ArrayList<>();
            while (resultSet.next()) {
                productCategories.add(new ProductCategory(resultSet.getString("name"),
                        resultSet.getString("department"), resultSet.getInt("id")));
            }
            return productCategories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int findId(String name) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM product_category WHERE name =?";
            PreparedStatement statement = conn
                    .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
