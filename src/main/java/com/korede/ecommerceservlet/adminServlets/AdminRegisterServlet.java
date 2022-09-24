package com.korede.ecommerceservlet.adminServlets;

import config.DbConfiig;
import dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminRegisterServlet", value = "/AdminRegisterServlet")
public class AdminRegisterServlet extends HttpServlet {
        @Override
        protected void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            AdminDao adminDAO = new AdminDao(DbConfiig.connection());
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            String register = adminDAO.registerCustomer(name, username , password);
            if (register.equalsIgnoreCase("registered")){
                request.setAttribute("message" , register);
                response.sendRedirect("admin/login.jsp");
            }else if (register.equalsIgnoreCase("user exists")){
                request.setAttribute("message" , register);
                response.sendRedirect("admin/index.jsp");
            }
        }
    }

