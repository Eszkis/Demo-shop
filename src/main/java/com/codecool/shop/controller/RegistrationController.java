package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ShopDatabaseManager;
import com.codecool.shop.model.PasswordHandler;
import com.codecool.shop.model.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/register"})
public class RegistrationController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        engine.process("registration.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        if (req.getServletContext().getAttribute("PasswordHandler") == null) {
            req.getServletContext().setAttribute("PasswordHandler", new PasswordHandler());
        }

        PasswordHandler passwordHandler = (PasswordHandler) req.getServletContext().getAttribute("PasswordHandler");

        ShopDatabaseManager databaseManager = null;
        try {
            databaseManager = ShopDatabaseManager.getInstance();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String hashedPassword = passwordHandler.hash(password.toCharArray());

        User user = new User(username, hashedPassword, email);

        databaseManager.addUser(user);

        resp.sendRedirect("/");

    }
}
