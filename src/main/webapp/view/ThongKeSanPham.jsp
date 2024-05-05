<%-- 
Document   : sanphamlist1
Created on : 9 thg 11, 2023, 22:11:08
Author     : mac
--%>

<%@ page import="DAL.ThongKeSanPhamDAL" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<jsp:include page="_header1.jsp"></jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
            <jsp:include page="_menu1.jsp"></jsp:include>
                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_left">
                                <h3>Thống Kê <small>Sản Phẩm</small></h3>
                            </div>
                        </div>

                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <h2>Thống kê 10 sản phẩm bán chạy</h2>
                                </div>
                                <div class="x_content">
                                    <div class="table-responsive">
                                        <table class="table table-striped jambo_table bulk_action">
                                            <thead>
                                            <tr class="headings">
                                                <th class="column-title">Tên sản phẩm</th>
                                                <th class="column-title">Số lượng đặt (Cái)</th>
                                            </tr>
                                            </thead>
                                            <%
                                                ThongKeSanPhamDAL thongKeDAL = new ThongKeSanPhamDAL();
                                                List<Object[]> result = thongKeDAL.thongKeTop10SanPham();
                                                if (result != null) {
                                                    for (Object[] row : result) {
                                                        String tenSanPham = (String) row[0];
                                                        long tongSoLuongDat = (long) row[1];
                                            %>
                                            <thead>
                                            <tr class="headings">
                                                <th class="column-title"><%= tenSanPham%></th>
                                                <th class="column-title"><%= tongSoLuongDat%></th>
                                            </tr>
                                            </thead>
                                            <%
                                                    }
                                                }
                                            %>
                                        </table>
                                    </div>
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