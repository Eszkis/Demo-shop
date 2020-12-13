package com.codecool.shop.dao.implementation;

import static org.junit.jupiter.api.Assertions.*;

import com.codecool.shop.dao.ShopDatabaseManager;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class ProductDaoJdbcTest {

    private ShopDatabaseManager shopDatabaseManager = ShopDatabaseManager.getInstance();

    ProductDaoJdbcTest() throws SQLException {
    }


    @Test
    void add() {
    }

    @Test
    void findById() {
        int id = 1;

        var expectedProduct = new Product(1, "Prog-1Week-Mentorbot",
                "Prog-1Week-Mentorbot-Marci.png", 24.9f, "USD",
                "Quality demo from quality supplier.", new ProductCategory("Progbasics", "Python"),
                new Supplier("marci", 1));

        var result = shopDatabaseManager.getProduct(id);

        assertEquals(expectedProduct, result);

    }

    @Test
    void remove() {
    }

    @Test
    void getAll() {
        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(1, "Prog-1Week-Mentorbot",
                "Prog-1Week-Mentorbot-Marci.png", 24.9f, "USD",
                "Quality demo from quality supplier.", new ProductCategory("Progbasics", "Python"),
                new Supplier("marci", 1)));
        products.add(
                new Product(2, "Prog-2Week-Hangman", "Prog-2Week-Hangman-Eszkis.png", 24.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("Progbasics", "Python"),
                        new Supplier("marci", 1)));
        products.add(
                new Product(3, "Prog-2Week-Hangman", "Prog-2Week-Hangman-Marci.png", 24.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("Progbasics", "Python"),
                        new Supplier("marci", 1)));
        products.add(
                new Product(4, "Prog-3Week-TicTacToe", "Prog-3Week-TicTacToe-Eszkis.png", 24.9f,
                        "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("Progbasics", "Python"),
                        new Supplier("eszkis", 2)));
        products.add(
                new Product(5, "Prog-4Week-Battleship", "Prog-4Week-Battleship-Omar.png", 24.9f,
                        "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("Progbasics", "Python"),
                        new Supplier("omar", 4)));
        products.add(new Product(6, "Prog-5Week-ERP", "Prog-5Week-ERP-Eszkis.png", 24.9f, "USD",
                "Quality demo from quality supplier.", new ProductCategory("Progbasics", "Python"),
                new Supplier("eszkis", 2)));
        products.add(new Product(7, "Prog-5Week-SecureERP", "Prog-5Week-SecureERP-Marci.png", 24.9f,
                "USD",
                "Quality demo from quality supplier.", new ProductCategory("Progbasics", "Python"),
                new Supplier("marci", 1)));
        products.add(new Product(8, "Prog-6Week-RogueLikeGame", "Prog-6Week-RogueLikeGame-Omar.png",
                24.9f, "USD",
                "Quality demo from quality supplier.", new ProductCategory("Progbasics", "Python"),
                new Supplier("omar", 4)));
        products.add(
                new Product(9, "Prog-6Week-RougeLikeGame", "Prog-6Week-RougeLikeGame-Eszkis.png",
                        24.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("Progbasics", "Python"),
                        new Supplier("eszkis", 2)));
        products.add(
                new Product(10, "WEB-1Week-AskMate1", "WEB-1Week-AskMate1-Eszkis.png", 39.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("WEB", "Javascript&SQL"),
                        new Supplier("eszkis", 2)));
        products.add(
                new Product(11, "WEB-1Week-AskMate", "WEB-1Week-AskMate-Dominik.jpg", 39.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("WEB", "Javascript&SQL"),
                        new Supplier("dominik", 3)));
        products.add(new Product(12, "WEB-1Week-AskMate", "B-1Week-AskMate-Omar.png", 39.9f, "USD",
                "Quality demo from quality supplier.", new ProductCategory("WEB", "Javascript&SQL"),
                new Supplier("omar", 4)));
        products.add(
                new Product(13, "WEB-2Week-AskMate2", "WEB-2Week-AskMate2-Eszkis.png", 39.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("WEB", "Javascript&SQL"),
                        new Supplier("eszkis", 2)));
        products.add(
                new Product(14, "WEB-2Week-AskMate2", "WEB-2Week-AskMate2-Omar.png", 39.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("WEB", "Javascript&SQL"),
                        new Supplier("omar", 4)));
        products.add(
                new Product(15, "WEB-3Week-AskMate3", "WEB-3Week-AskMate3-Eszkis.png", 39.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("WEB", "Javascript&SQL"),
                        new Supplier("eszkis", 2)));
        products.add(
                new Product(16, "WEB-3Week-AskMate3", "WEB-3Week-AskMate3-Omar.png", 39.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("WEB", "Javascript&SQL"),
                        new Supplier("omar", 4)));
        products.add(new Product(17, "WEB-4Week-FreeStyleJavascript",
                "WEB-4Week-FreeStyleJavascript-Eszkis.png", 39.9f,
                "USD", "Quality demo from quality supplier.",
                new ProductCategory("WEB", "Javascript&SQL"),
                new Supplier("eszkis", 2)));
        products.add(new Product(18, "WEB-4Week-FreestyleJavaScript",
                "WEB-4Week-FreestyleJavaScript-Marci.png", 39.9f, "USD",
                "Quality demo from quality supplier.", new ProductCategory("WEB", "Javascript&SQL"),
                new Supplier("marci", 1)));
        products.add(
                new Product(19, "WEB-5Week-ProMan", "WEB-5Week-ProMan-Dominik.jpg", 39.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("WEB", "Javascript&SQL"),
                        new Supplier("dominik", 3)));
        products.add(
                new Product(20, "WEB-5Week-ProMan", "WEB-5Week-ProMan-Eszkis.png", 39.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("WEB", "Javascript&SQL"),
                        new Supplier("eszkis", 2)));
        products.add(new Product(21, "WEB-5Week-ProMan", "WEB-5Week-ProMan-Marci.png", 39.9f, "USD",
                "Quality demo from quality supplier.", new ProductCategory("WEB", "Javascript&SQL"),
                new Supplier("marci", 1)));
        products.add(
                new Product(22, "WEB-6Week-ProMan2", "WEB-6Week-BroMan2-Omar.png", 39.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("WEB", "Javascript&SQL"),
                        new Supplier("omar", 4)));
        products.add(
                new Product(23, "WEB-6Week-ProMan2", "WEB-6Week-ProMan2-Eszkis.png", 39.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("WEB", "Javascript&SQL"),
                        new Supplier("eszkis", 2)));
        products.add(
                new Product(24, "WEB-6Week-ProMan", "WEB-6Week-ProMan-Dominik.jpg", 39.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("WEB", "Javascript&SQL"),
                        new Supplier("dominiki", 3)));
        products.add(
                new Product(25, "WEB-7week-PetProject", "WEB-7week-PetProject-Eszkis.png", 39.9f,
                        "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("WEB", "Javascript&SQL"),
                        new Supplier("eszkis", 2)));
        products.add(
                new Product(26, "OOP-1Week-FiveInARow", "OOP-1Week-FiveInARow-Dominik.jpg", 49.9f,
                        "USD",
                        "Quality demo from quality supplier.", new ProductCategory("OOP", "Java"),
                        new Supplier("omar", 4)));
        products.add(
                new Product(27, "OOP-1Week-FiveInARow", "OOP-1Week-FiveInARow-Eszkis.png", 49.9f,
                        "USD",
                        "Quality demo from quality supplier.", new ProductCategory("OOP", "Java"),
                        new Supplier("eszkis", 2)));
        products.add(
                new Product(28, "OOP-1Week-FiveInRow", "OOP-1Week-FiveInRow-Omar.png", 49.9f, "USD",
                        "Quality demo from quality supplier.", new ProductCategory("OOP", "Java"),
                        new Supplier("omar", 4)));
        products.add(new Product(29, "OOP-2Week-ProcessWatch", "OOP-2Week-ProcessWatch-Dominik.jpg",
                49.9f, "USD",
                "Quality demo from quality supplier.", new ProductCategory("OOP", "Java"),
                new Supplier("dominik", 3)));
        products.add(
                new Product(30, "OOP-2Week-ProcessWatch", "OOP-2Week-ProcessWatch-Marci.png", 49.9f,
                        "USD",
                        "Quality demo from quality supplier.", new ProductCategory("OOP", "Java"),
                        new Supplier("marci", 1)));
        products.add(
                new Product(31, "OOP-3Week-DungeonCrawl", "OOP-3Week-DungeonCrawl-Eszkis.png",
                        49.9f,
                        "USD", "Quality demo from quality supplier.",
                        new ProductCategory("OOP", "Java"),
                        new Supplier("eszkis", 2)));
        products.add(new Product(32, "OOP-4Week-DungeonCrawl", "OOP-4Week-DungeonCrawl-Dominik.jpg",
                49.9f, "USD",
                "Quality demo from quality supplier.", new ProductCategory("OOP", "Java"),
                new Supplier("dominik", 3)));
        products.add(new Product(33, "OOP-5Week-CodecoolShop", "OOP-5Week-CodecoolShop-Dominik.png",
                69.9f, "USD",
                "Definitely not our current presentation", new ProductCategory("OOP", "Java"),
                new Supplier("dominik", 3)));

        ArrayList<Product> result = shopDatabaseManager.getAllProduct();

        assertEquals(products.size(), result.size());
        for (int i = 0; i < products.size(); i++) {
            assertEquals(products.get(i), result.get(i));
        }
    }

    @Test
    void getBySupplier() {
        ArrayList<Product> marciProducts = new ArrayList<>();

        marciProducts.add(new Product(1, "Prog-1Week-Mentorbot",
                "Prog-1Week-Mentorbot-Marci.png", 24.9f, "USD",
                "Quality demo from quality supplier.", new ProductCategory("Progbasics", "Python"),
                new Supplier("marci", 1)));
        marciProducts.add(
                new Product(3, "Prog-2Week-Hangman", "Prog-2Week-Hangman-Marci.png", 24.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("Progbasics", "Python"),
                        new Supplier("marci", 1)));

        marciProducts
                .add(new Product(7, "Prog-5Week-SecureERP", "Prog-5Week-SecureERP-Marci.png", 24.9f,
                        "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("Progbasics", "Python"),
                        new Supplier("marci", 1)));

        marciProducts.add(new Product(18, "WEB-4Week-FreestyleJavaScript",
                "WEB-4Week-FreestyleJavaScript-Marci.png", 39.9f, "USD",
                "Quality demo from quality supplier.", new ProductCategory("WEB", "Javascript&SQL"),
                new Supplier("marci", 1)));

        marciProducts
                .add(new Product(21, "WEB-5Week-ProMan", "WEB-5Week-ProMan-Marci.png", 39.9f, "USD",
                        "Quality demo from quality supplier.",
                        new ProductCategory("WEB", "Javascript&SQL"),
                        new Supplier("marci", 1)));

        marciProducts.add(
                new Product(30, "OOP-2Week-ProcessWatch", "OOP-2Week-ProcessWatch-Marci.png", 49.9f,
                        "USD",
                        "Quality demo from quality supplier.", new ProductCategory("OOP", "Java"),
                        new Supplier("marci", 1)));

        Supplier supplier = new Supplier("marci", 1);
        ArrayList<Product> result = shopDatabaseManager.getProductBy(supplier);

        assertEquals(marciProducts.size(), result.size());
        for (int i = 0; i < marciProducts.size(); i++) {
            assertEquals(marciProducts.get(i), result.get(i));
        }

    }

    @Test
    void testGetBy() {
    }

    @Test
    void testGetBy1() {
    }
}