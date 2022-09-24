<%@ page import="dao.AdminDao" %>
<%@ page import="models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="config.DbConfiig" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--

  Created by IntelliJ IDEA.
  User: lim
  Date: 2022-09-23
  Time: 10:56 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@taglib  uri ="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%
    // User user = (User) request.getSession().getAttribute("user");
    AdminDao adminDao = new AdminDao(DbConfiig.connection());
    List<Product> productList = adminDao.getAllProducts("Console System");
    request.setAttribute("productList" , productList);
%>
<!DOCTYPE html>
<%@include file="includes/header.jsp" %>

<div class="container-fluid">
    <div class="row justify-content-space">
        <%@include file="includes/guidenav.jsp" %>

        <div class="col-md-9 mt-5">
            <div class="row justify-content-space mb-4">
                <div class="col-md-9">
                    <h6 class="text-muted">Admin Dashboard</h6>
                </div>
                <div class="col-md-3">
                    <a href="${pageContext.request.contextPath}/admin/addProduct.jsp" class="btn btn-primary">Add New Product</a>
                </div>
            </div>
            <div class="row justify-content-space">
                <c:forEach var="product" items="${productList}">
                    <div class="col-md-4">
                        <div class="card product__card__avatar">
                            <div class="card-body">
                                <img src="${product.avatar}" class="card-img-top" alt="product">
                                <div class="row justify-content-space">
                                    <div class="col-9"><h6>${product.name}</h6></div>
                                </div>
                                <h5 class="text-muted mb-2">${product.price}</h5>
                                <div class="d-flex admin__action_container">
                                    <a href="${pageContext.request.contextPath}/AdminShowProductServlet?id=${product.id}" class="ms-5 me-2 admin__action text-muted" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="View Product"><i class="bi bi-eye-fill"> </i></a>
                                    <a href="${pageContext.request.contextPath}/EditProductServlet?id=${product.id}" class="me-2 admin__action text-muted" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-title="Edit Product"><i class="bi bi-pencil-square"> </i> </a>
                                    <form action="${pageContext.request.contextPath}/DeleteProductServlet?id=${product.id} " method="POST">
                                        <div class="col-3"><button class="deletewishlist" id="delete${product.id}" onclick="confirm('Are You Sure You Want To Delete This?!')"   style="border: none; outline: none; background-color: transparent; color: #060863;" type="submit"> <i class="bi bi-trash"></i> </button></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html></html>
