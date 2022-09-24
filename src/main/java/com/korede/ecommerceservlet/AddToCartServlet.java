package com.korede.ecommerceservlet;

import config.DbConfiig;
import dao.CustomerDao;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("cart"));
            CustomerDao customerDao = new CustomerDao(DbConfiig.connection());
            Map<Integer , Product> cart = customerDao.addToCart(id);

            HttpSession session = request.getSession();
            session.setAttribute("cart" , cart);
            response.sendRedirect("user/dashboard.jsp");

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
    }

