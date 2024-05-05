<%-- 
    Document   : nhacungcap
    Created on : 10 thg 12, 2023, 20:21:31
    Author     : mac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                        <form class="d-flex">
                                            <label style="text-align: center">Search</label>
                                            <input style="width: 200px" class="form-control" type = "text" name="keyword" value="<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>" placeholder="Enter Keyword">
                                        <button class="btn btn-outline-success" type="submit">Search</button>   
                                    </form><br>
                                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/newNhaCungCap" >Create Product</a>

                                </div>

                                <div class="x_content">
                                    <div class="table-responsive">
                                        <table class="table table-striped jambo_table bulk_action">
                                            <thead>
                                                <tr class="headings">
                                                    <th class="column-title">IdPerson</th>
                                                    <th class="column-title">Tên nhà cung cấp</th>
                                                    <th class="column-title">Loại nhà cung cấp</th>
                                                    <th class="column-title">Địa chỉ</th>
                                                    <th class="column-title">Email</th>
                                                    <th class="column-title">Số điện thoại</th>
                                                    <th class="column-title">Edit</th>
                                                    <th class="bulk-actions" colspan="7">
                                                        <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                                    </th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach items="${listncc}" var="ncc" >
                                                    <tr class="even pointer">
                                                        <td>${ncc.idPerson}</td>
                                                        <td>${ncc.ten}</td>
                                                        <td>${ncc.loai}</td>
                                                        <td>${ncc.diaChi}</td>
                                                        <td>${ncc.email}</td>
                                                        <td>${ncc.SDT}</td>
                                                        <td>
                                                            <a href="${pageContext.request.contextPath}/editNCC?idPerson=<c:out value='${ncc.idPerson}'/>">Edit</a>
                                                        </td>

                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <nav aria-label="Page navigation example">
                    <ul class="pagination justify-content-center">
                        <c:if test="${id == null && page != 1}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/Nhacungcaplist?page=${page-1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                        </c:if>
                        <c:if test="${id != null && page != 1}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/Nhacungcaplist?keyword=<%=request.getParameter("keyword")%>&page=${page-1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                        </c:if>

                        <c:if test="${id == null}">
                            <c:forEach var="i" begin="1" end="${countPage}">
                                <c:choose >
                                    <c:when test="${page == i}">
                                        <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/Nhacungcaplist?page=${i}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Nhacungcaplist?page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:if>
                            <c:if test="${id != null}">
                                <c:forEach var="i" begin="1" end="${countPage}">
                                    <c:choose >
                                        <c:when test="${page == i}">
                                        <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/Nhacungcaplist?keyword=<%=request.getParameter("keyword")%>&page=${i}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Nhacungcaplist?keyword=<%=request.getParameter("keyword")%>&page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:if>  
                            <c:if test="${id == null && page < countPage}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Nhacungcaplist?page=${page+1}">Next</a></li>
                            </c:if>
                            <c:if test="${id != null && page < countPage}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/Nhacungcaplist?keyword=<%=request.getParameter("keyword")%>&page=${page+1}">Next</a></li>
                            </c:if>

                    </ul>
                </nav>
            </div>
            <!-- /page content -->
        </div>
    </div>
</body>
<jsp:include page="_footer1.jsp"></jsp:include>
