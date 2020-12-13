package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.ShopDatabaseManager;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(urlPatterns = {"/"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        boolean runFromDB = true;
        Map<String, String[]> paramaters = req.getParameterMap();
        int categoryId = 0;
        int supplierId = 0;
        if (paramaters.size() > 0) {
            categoryId = Integer.parseInt(paramaters.get("category")[0]);
            supplierId = Integer.parseInt(paramaters.get("supplier")[0]);
        }
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        HttpSession session = req.getSession();
        if (session.getAttribute("username") != null) {
            context.setVariable("username", session.getAttribute("username"));
        }
        if (runFromDB) {
            ShopDatabaseManager shopDatabaseManager = null;
            try {
                shopDatabaseManager = ShopDatabaseManager.getInstance();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            context.setVariable("allCategories", shopDatabaseManager.getAllProductCategory());
            context.setVariable("suppliers", shopDatabaseManager.getAllSupplier());
            if (paramaters.size() == 0 || (categoryId == 4 && supplierId == 5)) {
                context.setVariable("category", shopDatabaseManager.getAllProductCategory().get(0));
                context.setVariable("products", shopDatabaseManager.getAllProduct());
            } else if (categoryId == 4 && supplierId != 1) {
                context.setVariable("category", shopDatabaseManager.getSupplier(supplierId));
                context.setVariable("products", shopDatabaseManager.getProductBy(shopDatabaseManager.getSupplier(supplierId)));
            } else if (categoryId != 1 && supplierId == 5) {
                context.setVariable("category", shopDatabaseManager.getProductCategory(categoryId));
                context.setVariable("products", shopDatabaseManager.getProductBy(shopDatabaseManager.getProductCategory(categoryId)));
            } else {
                context.setVariable("category", shopDatabaseManager.getProductCategory(categoryId));
                context.setVariable("products", shopDatabaseManager.getProductBy(shopDatabaseManager.getSupplier(supplierId), shopDatabaseManager.getProductCategory(categoryId)));
            }
            engine.process("product/index.html", context, resp.getWriter());
        } else {
            ProductDao productDataStore = ProductDaoMem.getInstance();
            ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
            SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
            context.setVariable("allCategories", productCategoryDataStore.getAll());
            context.setVariable("suppliers", supplierDataStore.getAll());
            if (paramaters.size() == 0 || (categoryId == 1 && supplierId == 1)) {
                context.setVariable("category", productCategoryDataStore.getAll().get(0));
                context.setVariable("products", productDataStore.getAll());
            } else if (categoryId == 1 && supplierId != 1) {
                context.setVariable("category", supplierDataStore.find(supplierId));
                context.setVariable("products", productDataStore.getBy(supplierDataStore.find(supplierId)));
            } else if (categoryId != 1 && supplierId == 1) {
                context.setVariable("category", productCategoryDataStore.find(categoryId));
                context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(categoryId)));
            } else {
                context.setVariable("category", productCategoryDataStore.find(categoryId));
                context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(categoryId), supplierDataStore.find(supplierId)));
            }
            engine.process("product/index.html", context, resp.getWriter());
        }
    }
}
