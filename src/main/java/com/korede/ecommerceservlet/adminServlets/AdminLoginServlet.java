package com.korede.ecommerceservlet.adminServlets;

import config.DbConfiig;
import dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminLoginServlet", value = "/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            AdminDao adminDao = new AdminDao(DbConfiig.connection());
            String login = adminDao.loginCustomer(username, password, request);
            if (login.equalsIgnoreCase("success")){
                response.sendRedirect("admin/dashboard.jsp");
            }else if (login.equalsIgnoreCase("incorrect password")){
                response.sendRedirect("admin/login.jsp");
            }
        }
    }

