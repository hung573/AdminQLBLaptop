<%-- 
Document   : sanphamlist1
Created on : 9 thg 11, 2023, 22:11:08
Author     : mac
--%>

<%@ page import="java.util.List" %>
<%@page import="DAL.ThongKeKhachHangDAL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Arrays" %>
<!DOCTYPE html>
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
                                <h3>Thống Kê <small>Khách Hàng</small></h3>
                            </div>
                        </div>

                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                     <h2>Thống kê Top 5 Khách Hàng</h2>
                                </div>
                                <div class="x_content">
                                    <div class="table-responsive">
                                    <%
                                        ThongKeKhachHangDAL thongKeKhachHangDAL = new ThongKeKhachHangDAL();
                                        List<Object[]> result = thongKeKhachHangDAL.thongKeTop5KhachHang();

                                        if (result != null) {
                                    %>
                                    <table class="table table-striped jambo_table bulk_action">
                                        <thead>
                                            <tr class="headings">
                                                <th class="column-title">Id Khách Hàng</th>
                                                <th class="column-title">Tên Khách Hàng</th>
                                                <th class="column-title">Tổng Hóa Đơn (VNĐ)</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <% for (Object[] row : result) {%>

                                            <tr class="even pointer">
                                                <td><%= row[0]%></td>
                                                <td><%= row[1]%></td>
                                                <td><%= row[2]%></td>
                                            </tr>
                                            <% } %>
                                        </tbody>
                                    </table>
                                    <%
                                        } else {
                                            out.println("Không có kết quả.");
                                        }
                                    %>
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

<jsp:include page="_footer1.jsp"></jsp:include>