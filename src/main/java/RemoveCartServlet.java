import config.DbConfiig;
import dao.CustomerDao;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RemoveCartServlet", value = "/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int id = Integer.parseInt(request.getParameter("product_id"));
            CustomerDao customerDAO = new CustomerDao(DbConfiig.connection());
            Map<Integer, Product> cartP = (HashMap<Integer, Product>)request.getSession().getAttribute("cart");

            cartP = customerDAO.deleteFromCart(id, cartP);

        }
    }

