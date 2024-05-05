<%-- 
    Document   : imagelist1
    Created on : 10 thg 11, 2023, 14:06:56
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
                                            <h2>Search<small>Theo ID Sản Phẩm</small></h2><br>
                                            <br><input style="width: 200px" class="form-control" type = "text" name="keyword" value="<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>" placeholder="Enter Keyword">
                                            <button class="btn btn-outline-success" type="submit">Search</button>   
                                        </form><br>
                                </div>

                                <div class="x_content">
                                    <div class="row">

                                        <p>Media gallery design emelents</p>
                                        <c:forEach items="${imgList}" var="img" >
                                            <div class="col-md-55" >
                                                <div class="thumbnail" style="height: auto">
                                                    <div class="image view view-first" style="height: auto">
                                                        <c:forEach items="${img.sanpham.thuongHieu}" var="thuonghieu">
                                                            <img src="Image//Product//${thuonghieu}//${img.URL}" width="100px"/>
                                                        </c:forEach>
                                                        <div class="mask">
                                                            <div class="tools tools-bottom">
                                                                <p>${img.sanpham.idSanPham}</p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="caption" style="margin-top: 15px">
                                                        <p>${img.idImage}</p>
                                                        <p>${img.sanpham.idSanPham}</p>
                                                        <a href="${pageContext.request.contextPath}/editkho?idKho=<c:out value='${kho.idKho}'/>">Edit</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
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
                                <a class="page-link" href="${pageContext.request.contextPath}/ImageList?page=${page-1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                        </c:if>
                        <c:if test="${id != null && page != 1}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/ImageList?keyword=<%=request.getParameter("keyword")%>&page=${page-1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                        </c:if>

                        <c:if test="${id == null}">
                            <c:forEach var="i" begin="1" end="${countPage}">
                                <c:choose >
                                    <c:when test="${page == i}">
                                        <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/ImageList?page=${i}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ImageList?page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:if>
                            <c:if test="${id != null}">
                                <c:forEach var="i" begin="1" end="${countPage}">
                                    <c:choose >
                                        <c:when test="${page == i}">
                                        <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/ImageList?keyword=<%=request.getParameter("keyword")%>&page=${i}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ImageList?keyword=<%=request.getParameter("keyword")%>&page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:if>  
                            <c:if test="${id == null && page < countPage}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ImageList?page=${page+1}">Next</a></li>
                            </c:if>
                            <c:if test="${id != null && page < countPage}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ImageList?keyword=<%=request.getParameter("keyword")%>&page=${page+1}">Next</a></li>
                            </c:if>

                    </ul>
                </nav>
            </div>
            <!-- /page content -->
        </div>
    </div>
</body>
<jsp:include page="_footer1.jsp"></jsp:include>
