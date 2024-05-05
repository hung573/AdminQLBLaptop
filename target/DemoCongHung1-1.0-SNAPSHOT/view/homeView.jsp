<%-- 
    Document   : homeView
    Created on : 12 thg 10, 2023, 20:19:55
    Author     : tranconghung
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>Home Page</title>
     <style>
         ul.no-bullet{
           list-style-type: none;  
         }
     </style>
  </head>
  <body>-->

<jsp:include page="_header1.jsp"></jsp:include>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
            <jsp:include page="_menu1.jsp"></jsp:include>
                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_left">
                                <h3>Users <small>Some examples to get you started</small></h3>
                            </div>
                        </div>

                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2>Button Example <small>Users</small></h2>
                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="x_content">
                                        <div class="row">
                                            <c:if test="${session != null}">
                                                <ul>
                                                    <li style="display: block"><a href="${pageContext.request.contextPath}/DangXuat">Logout</a></li>
                                                </ul>
                                            </c:if>
                                            <c:if test="${session == null}">
                                                <ul>
                                                    <li style="display: block"><a href="${pageContext.request.contextPath}/DangNhap">Login</a></li>
                                                </ul>
                                            </c:if>
                                        </div>
                                    </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /page content -->
        </div>
    </div>
</body>

<!--      <h3>Home Page</h3>
      
      <ul class="no-bullet">
         <li>Quản Lý Sản Phẩm</li>
         <li>Quản Lý Kho</li>
         <li>Quản Lý Hình Ảnh Sản Phẩm</li>

      </ul>-->

<jsp:include page="_footer1.jsp"></jsp:include>

<!--  </body>
</html>-->

