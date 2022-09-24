package com.korede.ecommerceservlet.adminServlets;

import config.DbConfiig;
import dao.AdminDao;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MultipartConfig
@WebServlet(name = "UpdateProductServlet", value = "/UpdateProductServlet")
public class UpdateProductServlet  extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }


        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            AdminDao adminDAO = new AdminDao(DbConfiig.connection());

            Product product = adminDAO.getSingle(id);
            product.setId(id);
            product.setName(request.getParameter("name"));
            product.setPrice(Double.parseDouble(request.getParameter("price")));
            product.setDesc(request.getParameter("desc"));
            product.setCategory(request.getParameter("category"));
            product.setAvatar(request.getParameter("file"));
            boolean isUpdated = adminDAO.updateProduct(product);
            if (isUpdated){
                response.sendRedirect("admin/dashboard.jsp");
            }
        }
    }

