package com.korede.ecommerceservlet;

import config.DbConfiig;
import dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            CustomerDao customerDAO = new CustomerDao(DbConfiig.connection());
            String login = customerDAO.loginCustomer(email, password, request);
            if (login.equalsIgnoreCase("success")){
                response.sendRedirect("user/dashboard.jsp");
            }else if (login.equalsIgnoreCase("incorrect password")){
                response.sendRedirect("login.jsp");
            }
        }
}
