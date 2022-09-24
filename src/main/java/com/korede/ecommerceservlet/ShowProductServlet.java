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

@WebServlet(name = "ShowProductServlet", value = "/ShowProductServlet")
public class ShowProductServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            CustomerDao customerDAO = new CustomerDao(DbConfiig.connection());
            Product product = customerDAO.getSingle(id);
            if (product != null){
                HttpSession session = request.getSession();
                session.setAttribute("product" , product);
                response.sendRedirect("user/product.jsp");
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
    }

