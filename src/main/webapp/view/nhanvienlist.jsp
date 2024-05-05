<%-- 
    Document   : nhacungcap
    Created on : 10 thg 12, 2023, 20:21:31
    Author     : mac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
                                <h3>Nhân Viên<small>Some</small></h3>
                            </div>
                        </div>

                        <div class="clearfix"></div>
                        <form method="post" id="form">
                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="x_panel">
                                        <div class="x_title">
                                            <h2>Button Example <small>Users</small></h2>
                                            <div class="clearfix"></div>
                                            <label>Tìm kiếm</label>
                                            <input type="text" name="textTim">
                                            <button formaction="${pageContext.request.contextPath}/action=seacrh?keyword=" name="submit" onclick="submit()">Tìm</button>
                                        <button formaction="${pageContext.request.contextPath}/action=createfrom">Tạo mới</button>
                                    </div>
                                    <div class="x_content">
                                        <div class="table-responsive">
                                            <table class="table table-striped jambo_table bulk_action">
                                                <thead>
                                                    <tr class="headings">
                                                        <th class="column-title">Tên</th>
                                                        <th class="column-title">Ngày sinh</th>
                                                        <th class="column-title">Email</th>
                                                        <th class="column-title">Địa chỉ</th>
                                                        <th class="column-title">Số điện thoại</th>
                                                        <th class="column-title">Bộ phận</th>
                                                        <th class="column-title">Chức vụ</th>
                                                        <th class="column-title">Hành động</th>
                                                        <th class="column-title">Ảnh</th>
                                                        <th class="column-title">Change</th>
                                                        <th class="column-title">Edit</th>
                                                        <th class="bulk-actions" colspan="7">
                                                            <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                                        </th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:choose>
                                                        <c:when test="${listfind  == null}">
                                                            <c:forEach var="nhanvien" items="${list}">
                                                                <tr class="even pointer">
                                                                    <td>${nhanvien.ten}</td>
                                                                    <td><fmt:formatDate value="${nhanvien.ngaySinh}" pattern="yyyy-MM-dd"/> </td>
                                                                    <td>${nhanvien.email} </td>
                                                                    <td>${nhanvien.diaChi} </td>
                                                                    <td>${nhanvien.SDT} </td>
                                                                    <td>${nhanvien.boPhan} </td>
                                                                    <td>${nhanvien.chucVu} </td>
                                                                    <td>${nhanvien.trangThai ==0? 'Nghỉ':'Còn làm việc'} </td>
                                                                    <td><img src="${pageContext.request.contextPath}/Image/Employee/${nhanvien.image.URL}"width="100px"/></td>
                                                                    <td>
                                                                        <button formaction="${pageContext.request.contextPath}/action=change?id=${nhanvien.idPerson}" name="submit" value="${nhanvien.idPerson}" onclick="submit()" >${nhanvien.trangThai == 0 ? 'Còn làm':'Nghỉ'}</button>                     
                                                                    </td>
                                                                    <td>
                                                                        <button formaction="${pageContext.request.contextPath}/action=editfrom?id=${nhanvien.idPerson}" name="submit" value="${nhanvien.idPerson}" onclick="submit()" >Edit</button>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                        </c:when>
                                                        <c:when test="${listfind  != null}">
                                                            <c:forEach var="nhanvien" items="${listfind}">
                                                                <tr class="even pointer">
                                                                    <td>${nhanvien.ten}</td>
                                                                    <td><fmt:formatDate value="${nhanvien.ngaySinh}" pattern="yyyy-MM-dd"/> </td>
                                                                    <td>${nhanvien.email} </td>
                                                                    <td>${nhanvien.diaChi} </td>
                                                                    <td>${nhanvien.SDT} </td>
                                                                    <td>${nhanvien.boPhan} </td>
                                                                    <td>${nhanvien.chucVu} </td>
                                                                    <td>${nhanvien.trangThai ==0? 'Nghỉ':'Còn làm việc'} </td>
                                                                    <td><img src="${pageContext.request.contextPath}/Image/Employee/${nhanvien.image.URL}"width="100px"/></td>
                                                                    <td>
                                                                        <button formaction="${pageContext.request.contextPath}/action=change?id=${nhanvien.idPerson}" name="submit" value="${nhanvien.idPerson}" onclick="submit()" >${nhanvien.trangThai ==0? 'Còn làm':'Nghỉ'}</button>                     
                                                                    </td>
                                                                    <td>
                                                                        <button formaction="${pageContext.request.contextPath}/action=editfrom?id=${nhanvien.idPerson}" name="submit" value="${nhanvien.idPerson}" onclick="submit()" >Edit</button>
                                                                    </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </c:when>
                                                </c:choose>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
            <!-- /page content -->
        </div>
    </div>
</body>
<script  type="text/javascript">
    function submit(){
        document.getElementById("form").submit();  
    }
</script> 
<jsp:include page="_footer1.jsp"></jsp:include>
