package com.korede.ecommerceservlet.adminServlets;

import config.DbConfiig;
import dao.AdminDao;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminShowProductServlet", value = "/AdminShowProductServlet")
public class AdminShowProductServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            AdminDao adminDao = new AdminDao(DbConfiig.connection());
            Product product = adminDao.getSingle(id);
            if (product != null){
                HttpSession session = request.getSession();
                session.setAttribute("adminProduct" , product);
                response.sendRedirect("admin/product.jsp");
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }
    }

