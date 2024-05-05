<%-- 
Document   : sanphamlist1
Created on : 9 thg 11, 2023, 22:11:08
Author     : mac
--%>
<%@ page import="DAL.ThongKeTheoThuDAL" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<jsp:include page="_header1.jsp"></jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
            <jsp:include page="_menu1.jsp"></jsp:include>
                <!-- page content -->
                <div class="right_col" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_left">
                                <h3>Thống kê doanh thu theo thứ</h3>
                            </div>
                        </div>

                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <h2>Thống kê doanh thu theo thứ</h2>

                                </div>
                                <div class="x_content">
                                    <div class="table-responsive">
                                        <div id="myChart" style="width: 100%; height: 500px;"></div>

                                        <script type="text/javascript">
                                            google.charts.load('current', {'packages': ['corechart']});
                                            google.charts.setOnLoadCallback(drawChart);

                                            function drawChart() {
                                                var data = new google.visualization.DataTable();
                                                data.addColumn('string', 'Thứ');
                                                data.addColumn('number', 'Doanh thu (VNĐ)');

                                        <%
                                            ThongKeTheoThuDAL thongKeDAL;
                                            double totalRevenue = 0; // Tổng doanh thu
                                            for (int day = 1; day <= 7; day++) {
                                                thongKeDAL = new ThongKeTheoThuDAL();
                                                double totalMoney = thongKeDAL.totalMoneyDay(day);
                                                totalRevenue += totalMoney; // Cộng dồn doanh thu từng ngày
                                        %>
                                                data.addRow(['<%= (day == 1) ? "Chủ Nhật" : "Thứ " + day%>', <%= totalMoney%>]);
                                        <% }%>

                                                // Thêm dòng tổng doanh thu
                                                data.addRow(['Tổng', <%= totalRevenue%>]);

                                                var options = {
                                                    title: 'Thống kê doanh thu theo thứ',
                                                    hAxis: {title: 'Thứ', titleTextStyle: {color: '#333'}},
                                                    vAxis: {minValue: 0}

                                                };

                                                var chart = new google.visualization.ColumnChart(document.getElementById('myChart'));
                                                chart.draw(data, options);
                                            }
                                    </script>
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