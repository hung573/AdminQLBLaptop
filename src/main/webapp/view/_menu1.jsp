<%-- 
    Document   : _menu1
    Created on : 9 thg 11, 2023, 22:36:27
    Author     : mac
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="" class="site_title"><span>ADMIN SHOP</span></a>
        </div>

        <div class="clearfix"></div>

        <!-- menu profile quick info -->
        <div class="profile clearfix">
            <div class="profile_pic">
                <c:if test="${session != null}">
                    <img src=".//Image//Employee//${psNhanVien.image.URL}" class="img-circle profile_img">
                </c:if>
                <c:if test="${session == null}">
                    <img src=".//Image//Employee//NVAO180723.png"class="img-circle profile_img">
                </c:if>
            </div>
            <div class="profile_info">
                <c:if test="${session != null}">
                    <span>Chức vụ: ${psNhanVien.chucVu}</span><br>
                    <span>Bộ phận: ${psNhanVien.boPhan}</span>
                    <h2>Username: ${username}</h2>
                </c:if>
                <c:if test="${session == null}">
                    <h2>Xin Chao</h2>
                </c:if>

            </div>
        </div>
        <!-- /menu profile quick info -->

        <br />

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>Chức Năng</h3>
                <c:if test="${session != null}">
                    <c:if test="${checkQuanLy == true}">
                        <ul class="nav side-menu">
                                <li><a href="${pageContext.request.contextPath}/"><i class="fa"></i> Home <span class="fa fa-chevron-down"></span></a>
                                </li>
                                <li><a><i class="fa"></i> Quản lý sản phẩm <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="${pageContext.request.contextPath}/productList">Quản lý sản phẩm</a></li>
                                        <li><a href="${pageContext.request.contextPath}/KhoList">Quản lý kho sản phẩm</a></li>
                                        <li><a href="${pageContext.request.contextPath}/ImageList">Quản lý hình ảnh</a></li>
                                    </ul>
                                </li>
                                <li><a href="#"><i class="fa"></i> Quản lý hoá đơn <span class="fa  "></span></a>
                                </li>
                                <li><a href="#"><i class="fa"></i> Quản lý đơn hàng<span class="fa  "></span></a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/Nhacungcaplist"><i class="fa"></i> Quản lý nhà cung cấp<span class="fa  "></span></a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/KhachHangServlet"><i class="fa"></i> Quản Lý Khách Hàng<span class="fa  "></span></a>
                                </li>
                                <li><a href="${pageContext.request.contextPath}/NhanVienList"><i class="fa"></i> Quản lý nhân viên<span class="fa fa-chevron-down"></span></a>
                                </li>
                                <li><a <a href="${pageContext.request.contextPath}/KhoList"><i class="fa"></i> Quản lý Kho<span class="fa fa-chevron-down"></span></a>
                                
                                </li>
                                <li><a href="${pageContext.request.contextPath}/KhoList"><i class="fa"></i>Quản Lý Phiếu Nhập<span class="fa fa-chevron-down"></span></a>
                                </li>
                                <li><a><i class="fa"></i>Thống Kê <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="${pageContext.request.contextPath}/ThongKeKhachHangServlet">Thống Kê Khách Hàng</a></li>
                                        <li><a href="${pageContext.request.contextPath}/ThongKeSanPhamServlet">Thống Kê Sản Phẩm</a></li>
                                        <li><a href="${pageContext.request.contextPath}/ThongKeNhanVienServlet">Thống Kê Nhân Viên</a></li>
                                        <li><a href="${pageContext.request.contextPath}/ThongKeTheoThangServlet">Thống Kê Theo Tháng</a></li>
                                        <li><a href="${pageContext.request.contextPath}/ThongKeTheoThuServlet">Thống Kê Theo Thứ</a></li>

                                    </ul>
                                </li>
                            </ul>
                        
                    </c:if>
                    <c:if test="${checkQuanLy == false}">
                        <c:if test="${checkBoPhan == true}">
                            <ul class="nav side-menu">
                                <li><a href="${pageContext.request.contextPath}/"><i class="fa"></i> Home <span class="fa fa-chevron-down"></span></a>
                                </li>
                                <li><a><i class="fa"></i> Quản lý sản phẩm <span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="${pageContext.request.contextPath}/productList">Quản lý sản phẩm</a></li>
                                        <li><a href="${pageContext.request.contextPath}/KhoList">Quản lý kho sản phẩm</a></li>
                                        <li><a href="${pageContext.request.contextPath}/ImageList">Quản lý hình ảnh</a></li>
                                    </ul>
                                </li>
                                <li><a><i class="fa"></i> Quản lý hoá đơn <span class="fa  "></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="${pageContext.request.contextPath}/ImageList">Quản lý hình ảnh</a></li>
                                    </ul>
                                </li>
                                <li><a><i class="fa"></i> Quản lý đơn hàng<span class="fa  "></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="${pageContext.request.contextPath}/ImageList">Quản lý hình ảnh</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </c:if>
                        <c:if test="${checkBoPhan == false}">
                            <ul class="nav side-menu">
                                <li><a href="${pageContext.request.contextPath}/"><i class="fa"></i> Home <span class="fa fa-chevron-down"></span></a>
                                </li>
                                
                                <li><a><i class="fa"></i> Sản Phẩm<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="${pageContext.request.contextPath}/KhoList">Quản lý kho</a></li>
                                    </ul>
                                </li>
                                <li><a><i class="fa"></i>Kho<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="${pageContext.request.contextPath}/KhoList">Quản lý kho</a></li>
                                    </ul>
                                </li>
                                <li><a><i class="fa"></i> Phiếu Nhập<span class="fa fa-chevron-down"></span></a>
                                    <ul class="nav child_menu">
                                        <li><a href="${pageContext.request.contextPath}/KhoList">Quản lý kho</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </c:if>
                    </c:if>

                </c:if>
                <c:if test="${session == null}">
                    <ul class="nav side-menu">
                        <li>
                            <a href="${pageContext.request.contextPath}/DangNhap"><i class="fa"></i>Login<span class="fa fa-chevron-down"></span></a>
                        </li>    
                         <li>
                             <a href="${pageContext.request.contextPath}/KhachHangServlet"><i class="fa"></i>Hiep<span class="fa fa-chevron-down"></span></a>
                        </li> 
                        <li>
                            <a href="${pageContext.request.contextPath}/NhanVienList"><i class="fa"></i>GiaHung<span class="fa fa-chevron-down"></span></a>
                        </li> 
                        <li>
                            <a href="${pageContext.request.contextPath}/ThongKeKhachHangServlet"><i class="fa"></i>Hội_Thống kê Khách Hàng<span class="fa fa-chevron-down"></span></a>
                        </li> 
                        <li>
                            <a href="${pageContext.request.contextPath}/ThongKeNhanVienServlet"><i class="fa"></i>Hội_Thống kê Nhân Viên<span class="fa fa-chevron-down"></span></a>
                        </li> 
                         <li>
                            <a href="${pageContext.request.contextPath}/ThongKeSanPhamServlet"><i class="fa"></i>Hội_Thống kê Sản Phẩm<span class="fa fa-chevron-down"></span></a>
                        </li> 
                         <li>
                            <a href="${pageContext.request.contextPath}/ThongKeTheoThangServlet"><i class="fa"></i>Hội_Thống kê Theo Tháng<span class="fa fa-chevron-down"></span></a>
                        </li>
                         <li>
                            <a href="${pageContext.request.contextPath}/ThongKeTheoThuServlet"><i class="fa"></i>Hội_Thống kê Theo Thứ<span class="fa fa-chevron-down"></span></a>
                        </li> 
                        
                    </ul>
                </c:if>

            </div>
        </div>
    </div>
</div>
