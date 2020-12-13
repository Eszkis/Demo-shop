package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.ShopDatabaseManager;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ShoppingCart;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.SessionTrackingMode;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

    ProductDao productDataStore = ProductDaoMem.getInstance();
    HttpSession session;

    private boolean runFromDb = true;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.session = request.getSession();

        String parameter = " ";

        if (request.getParameter("action") != null) {
            parameter = request.getParameter("action");
        }

        switch (parameter) {
            case "add":
                add(Integer.parseInt(request.getParameter("id")));
                break;
            case "remove":
                remove(Integer.parseInt(request.getParameter("id")));
                break;
            case "get":
                break;
            default:
                showCart(request, response);
                break;
        }
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new ShoppingCart());
        }
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");


        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("category", productCategoryDataStore.find(2));
        context.setVariable("products", shoppingCart.getAllProduct());
        context.setVariable("price", shoppingCart.getTotalValue());
        context.setVariable("cart", shoppingCart.getAllProduct());
        getServletContext().setAttribute("context", context);
        engine.process("product/cart.html", context, resp.getWriter());

    }

    public void add(int id) {
        System.out.println("add " + id);
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new ShoppingCart());
        }
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");

        Product product = null;
        if (runFromDb) {
            try {
                ShopDatabaseManager databaseManager = ShopDatabaseManager.getInstance();
                product = databaseManager.getProduct(id);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {
            product = productDataStore.find(id);
        }
        shoppingCart.addToCart(product);
        session.setAttribute("cart", shoppingCart);
    }

    public void remove(int id) {
        System.out.println("remove " + id);

        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new ShoppingCart());
        }
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");

//        Product product = null;
//        if (runFromDb) {
//            try {
//                ShopDatabaseManager databaseManager = ShopDatabaseManager.getInstance();
//                product = databaseManager.getProduct(id);
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//        } else {
//            product = productDataStore.find(id);
//        }
//
//        shoppingCart.removeFromCart(product);
        for(Product product : shoppingCart.getAllProduct()) {
            if (product.getId() == id) {
                shoppingCart.removeFromCart(product);
                break;
            }
        }
        session.setAttribute("cart", shoppingCart);
    }
}
