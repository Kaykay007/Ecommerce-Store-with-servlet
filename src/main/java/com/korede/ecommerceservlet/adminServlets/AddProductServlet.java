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
@WebServlet(name = "AddProductServlet", value = "/AddProductServlet")
public class AddProductServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String filename = request.getParameter("file");
            String productName = request.getParameter("name");
            String description = request.getParameter("desc");
            double price = Double.parseDouble(request.getParameter("price"));
            String category = request.getParameter("category");


            AdminDao adminDao = new AdminDao(DbConfiig.connection());
            Product product = new Product();
            product.setName(productName);
            product.setDesc(description);
            product.setPrice(price);
            product.setCategory(category);
            product.setAvatar(filename);

            if (adminDao.addProduct(product).equals("product added")){
                request.setAttribute("success" , "Successfully Added");
                response.sendRedirect("admin/addProduct.jsp");
            }

        }


    }


