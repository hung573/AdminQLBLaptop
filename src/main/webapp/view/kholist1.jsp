<%-- 
    Document   : kholist1
    Created on : 10 thg 11, 2023, 14:00:25
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
                                        <div class="clearfix"></div>
                                        <form class="d-flex">
                                            <h2>Search<small>Theo Mã Kho</small></h2><br>
                                            <br><input style="width: 200px" class="form-control" type = "text" name="keyword" value="<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>" placeholder="Enter Keyword">
                                            <button class="btn btn-outline-success" type="submit">Search</button>   
                                        </form><br>
                                </div>

                                <div class="x_content">
                                    <div class="table-responsive">
                                        <table class="table table-striped jambo_table bulk_action">
                                            <thead>
                                                <tr class="headings">
                                                    <th class="column-title">Mã kho</th>
                                                    <th class="column-title">Giá nhập</th>
                                                    <th class="column-title">Giá bán</th>
                                                    <th class="column-title">Số lượng</th>
                                                    <th class="column-title">Edit</th>

                                                    <th class="bulk-actions" colspan="7">
                                                        <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                                    </th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach items="${listKHO}" var="kho" >
                                                    <tr class="even pointer">
                                                        <td>${kho.idKho}</td>
                                                        <td>${kho.giaNhap}</td>
                                                        <td>${kho.giaBan}</td>
                                                        <td>${kho.soLuong}</td>
                                                        <td>
                                                            <a href="${pageContext.request.contextPath}/editkho?idKho=<c:out value='${kho.idKho}'/>">Edit</a>
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
                                <a class="page-link" href="${pageContext.request.contextPath}/KhoList?page=${page-1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                        </c:if>
                        <c:if test="${id != null && page != 1}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/KhoList?keyword=<%=request.getParameter("keyword")%>&page=${page-1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                        </c:if>

                        <c:if test="${id == null}">
                            <c:forEach var="i" begin="1" end="${countPage}">
                                <c:choose >
                                    <c:when test="${page == i}">
                                        <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/KhoList?page=${i}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/KhoList?page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:if>
                            <c:if test="${id != null}">
                                <c:forEach var="i" begin="1" end="${countPage}">
                                    <c:choose >
                                        <c:when test="${page == i}">
                                        <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/KhoList?keyword=<%=request.getParameter("keyword")%>&page=${i}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/KhoList?keyword=<%=request.getParameter("keyword")%>&page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:if>  
                            <c:if test="${id == null && page < countPage}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/KhoList?page=${page+1}">Next</a></li>
                            </c:if>
                            <c:if test="${id != null && page < countPage}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/KhoList?keyword=<%=request.getParameter("keyword")%>&page=${page+1}">Next</a></li>
                            </c:if>

                    </ul>
                </nav>
            </div>
            <!-- /page content -->
        </div>
    </div>
</body>
<jsp:include page="_footer1.jsp"></jsp:include>