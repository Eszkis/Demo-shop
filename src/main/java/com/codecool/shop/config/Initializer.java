package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoJdbc;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();



        //setting up a new supplier
        Supplier allSupplier = new Supplier ("All Suplier", "Get all supplier");
        supplierDataStore.add(allSupplier);
        Supplier eszkis = new Supplier("Eszkis", "WEB brofessor");
        supplierDataStore.add(eszkis);
        Supplier marci = new Supplier("Marci", "OOP brofessor");
        supplierDataStore.add(marci);
        Supplier omar = new Supplier("Omar", "Progbasics brofessor");
        supplierDataStore.add(omar);
        Supplier dominik = new Supplier("Dominik", "Multifunctionals brofessor");
        supplierDataStore.add(dominik);

        //setting up a new product category
        ProductCategory allCategory = new ProductCategory("All category", "Every department");
        productCategoryDataStore.add(allCategory);
        ProductCategory progbasics = new ProductCategory("Progbasics", "Python");
        productCategoryDataStore.add(progbasics);
        ProductCategory web = new ProductCategory("WEB", "Javascript&SQL");
        productCategoryDataStore.add(web);
        ProductCategory oop = new ProductCategory("OOP", "Java");
        productCategoryDataStore.add(oop);

        //setting up products and printing it
        productDataStore.add(new Product("Prog-1Week-Mentorbot", "Prog-1Week-Mentorbot-Marci.png",24.9f, "USD", "Quality demo from quality supplier.", progbasics, marci));
        productDataStore.add(new Product("Prog-2Week-Hangman", "Prog-2Week-Hangman-Eszkis.png",24.9f, "USD", "Quality demo from quality supplier.", progbasics, eszkis));
        productDataStore.add(new Product("Prog-2Week-Hangman", "Prog-2Week-Hangman-Marci.png",24.9f, "USD", "Quality demo from quality supplier.", progbasics, marci));
        productDataStore.add(new Product("Prog-3Week-TicTacToe", "Prog-3Week-TicTacToe-Eszkis.png",24.9f, "USD", "Quality demo from quality supplier.", progbasics, eszkis));
        productDataStore.add(new Product("Prog-4Week-Battleship", "Prog-4Week-Battleship-Omar.png",24.9f, "USD", "Quality demo from quality supplier.", progbasics, omar));
        productDataStore.add(new Product("Prog-5Week-ERP", "Prog-5Week-ERP-Eszkis.png",24.9f, "USD", "Quality demo from quality supplier.", progbasics, eszkis));
        productDataStore.add(new Product("Prog-5Week-SecureERP", "Prog-5Week-SecureERP-Marci.png",24.9f, "USD", "Quality demo from quality supplier.", progbasics, marci));
        productDataStore.add(new Product("Prog-6Week-RogueLikeGame", "Prog-6Week-RogueLikeGame-Omar.png",24.9f, "USD", "Quality demo from quality supplier.", progbasics, omar));
        productDataStore.add(new Product("Prog-6Week-RougeLikeGame", "Prog-6Week-RougeLikeGame-Eszkis.png",24.9f, "USD", "Quality demo from quality supplier.", progbasics, eszkis));
        productDataStore.add(new Product("WEB-1Week-AskMate1", "WEB-1Week-AskMate1-Eszkis.png",39.9f, "USD", "Quality demo from quality supplier.", web, eszkis));
        productDataStore.add(new Product("WEB-1Week-AskMate", "WEB-1Week-AskMate-Dominik.jpg",39.9f, "USD", "Quality demo from quality supplier.", web, dominik));
        productDataStore.add(new Product("WEB-1Week-AskMate", "WEB-1Week-AskMate-Omar.png",39.9f, "USD", "Quality demo from quality supplier.", web, omar));
        productDataStore.add(new Product("WEB-2Week-AskMate2", "WEB-2Week-AskMate2-Eszkis.png",39.9f, "USD", "Quality demo from quality supplier.", web, eszkis));
        productDataStore.add(new Product("WEB-2Week-AskMate2", "WEB-2Week-AskMate2-Omar.png",39.9f, "USD", "Quality demo from quality supplier.", web, omar));
        productDataStore.add(new Product("WEB-3Week-AskMate3", "WEB-3Week-AskMate3-Eszkis.png",39.9f, "USD", "Quality demo from quality supplier.", web, eszkis));
        productDataStore.add(new Product("WEB-3Week-AskMate3", "WEB-3Week-AskMate3-Omar.png",39.9f, "USD", "Quality demo from quality supplier.", web, omar));
        productDataStore.add(new Product("WEB-4Week-FreeStyleJavascript", "WEB-4Week-FreeStyleJavascript-Eszkis.png",39.9f, "USD", "Quality demo from quality supplier.", web, eszkis));
        productDataStore.add(new Product("WEB-4Week-FreestyleJavaScript", "WEB-4Week-FreestyleJavaScript-Marci.png",39.9f, "USD", "Quality demo from quality supplier.", web, marci));
        productDataStore.add(new Product("WEB-5Week-ProMan", "WEB-5Week-ProMan-Dominik.jpg",39.9f, "USD", "Quality demo from quality supplier.", web, dominik));
        productDataStore.add(new Product("WEB-5Week-ProMan", "WEB-5Week-ProMan-Eszkis.png",39.9f, "USD", "Quality demo from quality supplier.", web, eszkis));
        productDataStore.add(new Product("WEB-5Week-ProMan", "WEB-5Week-ProMan-Marci.png",39.9f, "USD", "Quality demo from quality supplier.", web, marci));
        productDataStore.add(new Product("WEB-6Week-ProMan2", "WEB-6Week-BroMan2-Omar.png",39.9f, "USD", "Quality demo from quality supplier.", web, omar));
        productDataStore.add(new Product("WEB-6Week-ProMan2", "WEB-6Week-ProMan2-Eszkis.png",39.9f, "USD", "Quality demo from quality supplier.", web, eszkis));
        productDataStore.add(new Product("WEB-6Week-ProMan", "WEB-6Week-ProMan-Dominik.jpg",39.9f, "USD", "Quality demo from quality supplier.", web, dominik));
        productDataStore.add(new Product("WEB-7week-PetProject", "WEB-7week-PetProject-Eszkis.png",39.9f, "USD", "Quality demo from quality supplier.", web, eszkis));
        productDataStore.add(new Product("OOP-1Week-FiveInARow", "OOP-1Week-FiveInARow-Dominik.jpg",49.9f, "USD", "Quality demo from quality supplier.", oop, omar));
        productDataStore.add(new Product("OOP-1Week-FiveInARow", "OOP-1Week-FiveInARow-Eszkis.png",49.9f, "USD", "Quality demo from quality supplier.", oop, eszkis));
        productDataStore.add(new Product("OOP-1Week-FiveInRow", "OOP-1Week-FiveInRow-Omar.png",49.9f, "USD", "Quality demo from quality supplier.", oop, omar));
        productDataStore.add(new Product("OOP-2Week-ProcessWatch", "OOP-2Week-ProcessWatch-Dominik.jpg",49.9f, "USD", "Quality demo from quality supplier.", oop, dominik));
        productDataStore.add(new Product("OOP-2Week-ProcessWatch", "OOP-2Week-ProcessWatch-Marci.png",49.9f, "USD", "Quality demo from quality supplier.", oop, marci));
        productDataStore.add(new Product("OOP-3Week-DungeonCrawl", "OOP-3Week-DungeonCrawl-Eszkis.png",49.9f, "USD", "Quality demo from quality supplier.", oop, eszkis));
        productDataStore.add(new Product("OOP-4Week-DungeonCrawl", "OOP-4Week-DungeonCrawl-Dominik.jpg",49.9f, "USD", "Quality demo from quality supplier.", oop, dominik));
        productDataStore.add(new Product("OOP-5Week-CodecoolShop", "OOP-5Week-CodecoolShop-Dominik.png", 69.9f, "USD", "Definitely not our current presentation", oop, dominik));
    }
}
