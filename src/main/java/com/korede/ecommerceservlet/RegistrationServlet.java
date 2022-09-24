package com.korede.ecommerceservlet;

import config.DbConfiig;
import dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/registration-servlet")
public class RegistrationServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            CustomerDao customerDAO = new CustomerDao(DbConfiig.connection());
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String avatar = request.getParameter("avatar");

            String register = customerDAO.registerCustomer(name, email , password , avatar);

            if (register.equalsIgnoreCase("registered")){
                response.sendRedirect("login.jsp");
            }else if (register.equalsIgnoreCase("user exists")){
                response.sendRedirect("index.jsp");
            }

        }
    }

