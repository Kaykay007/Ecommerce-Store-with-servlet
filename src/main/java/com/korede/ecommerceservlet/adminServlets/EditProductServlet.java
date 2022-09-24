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

@WebServlet(name = "EditProductServlet", value = "/EditProductServlet")
public class EditProductServlet  extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("Edit servlet id:" + id);
            AdminDao adminDAO = new AdminDao(DbConfiig.connection());
            Product product = adminDAO.getSingle(id);
            if (product != null){
                HttpSession session = request.getSession();
                System.out.println(product);
                session.setAttribute("editProduct" , product );
                response.sendRedirect("admin/editProduct.jsp");
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        }
    }


