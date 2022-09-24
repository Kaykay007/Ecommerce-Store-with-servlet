package com.korede.ecommerceservlet.adminServlets;

import config.DbConfiig;
import dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WishlistServlet", value = "/WishlistServlet")
public class WishListServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int UserId = Integer.parseInt(request.getParameter("user_id"));
            int productId = Integer.parseInt(request.getParameter("product_id"));

            CustomerDao customerDAO = new CustomerDao(DbConfiig.connection());


    }
}
