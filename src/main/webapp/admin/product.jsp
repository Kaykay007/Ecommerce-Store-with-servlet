<%--
  Created by IntelliJ IDEA.
  User: lim
  Date: 2022-09-23
  Time: 11:47 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="models.Product" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@include file="includes/header.jsp" %>

<%--Offcanvas for cart--%>




<%
    Product product = (Product) request.getSession().getAttribute("adminProduct");
%>
<%--Off canvas for cart ends--%>
<div class="container-fluid  ">
    <div class="row justify-content-center mt-5 ">
        <div class="col-sm-9">
            <div class="card register__card">
                <div class="card-body">
                    <div class="row justify-content-space ">
                        <div class="col-md-4 align-item-center me-5">
                            <img class="register__card__image" src="<%= product.getAvatar()%>" alt="console">
                        </div>
                        <div class="col-md-6 align-item-center mt-5">
                            <h2 class="product__name"><%= product.getName()%></h2>
                            <div class="row justify-content-space mt-3">
                                <div class="col-4 aligns-items-center ">
                                    <h3 class="text-muted product__price"><%= product.getPrice()%></h3>
                                    <span><i class="bi bi-star-fill"></i> </span>   <span><i class="bi bi-star-fill"></i> </span>  <span><i class="bi bi-star-fill"></i> </span>   <span><i class="bi bi-star-fill"></i> </span>  <span><i class="bi bi-star-half"></i> </span>
                                </div>
                                <div class="col-6 aligns-items-center">
                                    <h6 class="text-muted "><i class="bi bi-heart"></i> <span>Add to Wishlist</span></h6>
                                    <h6>76 in stock | 616 Reviews</h6>
                                </div>
                            </div>
                            <h4 class="product__description mt-3">Description:</h4>
                            <p class="product__description_text">The company itself is a very successful company. Most resilient
                                the inconveniences which, even though they may be advantages, are the consequence of the pleasures of labor
                                but he hates to flee from the flattery of these, but the mere flight of those present
                                option, and those things! They provide for such accusers, but no one.</p>
                            <form method="post" action="${pageContext.request.contextPath}/DeleteProductServlet?id=<%= product.getId()%>">
                                <input type="submit" class="add__to__cart__button form-control w-100" value="Add Console To Cart">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
