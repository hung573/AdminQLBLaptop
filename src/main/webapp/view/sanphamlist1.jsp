<%-- 
Document   : sanphamlist1
Created on : 9 thg 11, 2023, 22:11:08
Author     : mac
--%>

<%@page import="java.util.Arrays"%>
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
                                <h3>Quản Lý Sản Phẩm</h3>
                            </div>
                        </div>

                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div style = "display: flex;"class="x_title">
                                        <div class="clearfix"></div>
                                        <form style="padding-right: 20px;"class="d-flex">
                                            <h2>Tìm kiếm<br><small>Theo Tên Sản Phẩm</small></h2><br>
                                            <br><input style="width: 200px" class="form-control" type = "text" name="keyword" value="<%= request.getParameter("keyword") != null ? request.getParameter("keyword") : ""%>" placeholder="Enter Keyword">
                                        
                                        </form>
                                        <div class="clearfix"></div>
                                        <form style="padding-right: 20px;" class="d-flex">
                                            <h2>Tìm kiếm<br><small>Theo Giá Sản Phẩm</small></h2><br>
                                            <br><input style="width: 200px" class="form-control" type = "text" name="keywordGia" value="<%= request.getParameter("keywordGia") != null ? request.getParameter("keywordGia") : ""%>" placeholder="Gia">
                                        </form>
                                        <div class="clearfix"></div>
                                        <form style="padding-right: 20px;" class="d-flex">
                                            <h2>Tìm kiếm<br><small>Theo Màu Sản Phẩm</small></h2><br>
                                            <div style="display: inline-block;">
                                                <label>
                                                    <input type="radio" name="keywordMau" value="Xám" <%= (request.getParameterValues("keywordMau") != null && Arrays.asList(request.getParameterValues("keywordMau")).contains("Xám")) ? "checked" : "" %>> Xám
                                                </label>
                                                <label>
                                                    <input type="radio" name="keywordMau" value="Vàng" <%= (request.getParameterValues("keywordMau") != null && Arrays.asList(request.getParameterValues("keywordMau")).contains("Vàng")) ? "checked" : "" %>> Vàng
                                                </label>
                                            </div>
                                            <button style="display: none;" class="btn btn-outline-success" type="submit">Tìm kiếm</button>
                                        </form><br>
                                        <div class="clearfix"></div>
                                        <form style="padding-right: 20px;" class="d-flex">
                                            <h2>Tìm kiếm<br><small>Gia Trong Khoảng</small></h2><br>
                                            <div style="display: inline-block;">
                                                <label>
                                                    <input type="radio" name="keywordGiaTrongKhoan" value="0-10000" <%= (request.getParameterValues("keywordGiaTrongKhoan") != null && Arrays.asList(request.getParameterValues("keywordGiaTrongKhoan")).contains("0-10000")) ? "checked" : "" %>> 0-10000
                                                </label>
                                                <label>
                                                    <input type="radio" name="keywordGiaTrongKhoan" value="10000-20000" <%= (request.getParameterValues("keywordGiaTrongKhoan") != null && Arrays.asList(request.getParameterValues("keywordGiaTrongKhoan")).contains("10000-20000")) ? "checked" : "" %>>10000-20000
                                                </label>
                                                <label>
                                                    <input type="radio" name="keywordGiaTrongKhoan" value="20000-30000" <%= (request.getParameterValues("keywordGiaTrongKhoan") != null && Arrays.asList(request.getParameterValues("keywordGiaTrongKhoan")).contains("20000-30000")) ? "checked" : "" %>> 20000-30000
                                                </label>
                                                <label>
                                                    <input type="radio" name="keywordGiaTrongKhoan" value="30000-40000" <%= (request.getParameterValues("keywordGiaTrongKhoan") != null && Arrays.asList(request.getParameterValues("keywordGiaTrongKhoan")).contains("30000-40000")) ? "checked" : "" %>> 30000-40000
                                                </label>
                                            </div>
                                            <button style="display: none;" class="btn btn-outline-success" type="submit">Tìm kiếm</button>
                                        </form><br>
                                </div>
                                
                                <div style = "display: flex;"class="x_title">
                                    <div class="clearfix"></div>
                                    <form style="padding-right: 20px;" class="d-flex">
                                        <h2>Tìm kiếm<br><small>Gía Nhỏ Hơn</small></h2><br>
                                        <div style="display: inline-block;">
                                            <label>
                                                <input type="radio" name="keywordGiaMin" value="10000" <%= (request.getParameterValues("keywordGiaMin") != null && Arrays.asList(request.getParameterValues("keywordGiaMin")).contains("10000")) ? "checked" : "" %>> 10000
                                            </label>
                                            <label>
                                                <input type="radio" name="keywordGiaMin" value="30000" <%= (request.getParameterValues("keywordGiaMin") != null && Arrays.asList(request.getParameterValues("keywordGiaMin")).contains("30000")) ? "checked" : "" %>>300000
                                            </label>
                                            <label>
                                                <input type="radio" name="keywordGiaMin" value="50000" <%= (request.getParameterValues("keywordGiaMin") != null && Arrays.asList(request.getParameterValues("keywordGiaMin")).contains("50000")) ? "checked" : "" %>> 50000
                                            </label>
                                            <label>
                                                <input type="radio" name="keywordGiaMin" value="70000" <%= (request.getParameterValues("keywordGiaMin") != null && Arrays.asList(request.getParameterValues("keywordGiaMin")).contains("70000")) ? "checked" : "" %>> 70000
                                            </label>
                                        </div>
                                        <button style="display: none;" class="btn btn-outline-success" type="submit">Tìm kiếm</button>
                                    </form><br>
                                    <div class="clearfix"></div>
                                    <form style="padding-right: 20px;" class="d-flex">
                                        <h2>Tìm kiếm<br><small>Gía Lớn Hơn</small></h2><br>
                                        <div style="display: inline-block;">
                                            <label>
                                                <input type="radio" name="keywordGiaMax" value="70000" <%= (request.getParameterValues("keywordGiaMax") != null && Arrays.asList(request.getParameterValues("keywordGiaMax")).contains("70000")) ? "checked" : "" %>> 70000
                                            </label>
                                            <label>
                                                <input type="radio" name="keywordGiaMax" value="100000" <%= (request.getParameterValues("keywordGiaMax") != null && Arrays.asList(request.getParameterValues("keywordGiaMax")).contains("100000")) ? "checked" : "" %>>100000
                                            </label>
                                        </div>
                                        <button style="display: none;" class="btn btn-outline-success" type="submit">Tìm kiếm</button>
                                    </form><br>
                                        
                                </div>
                                <div class="x_content">
                                    <div class="table-responsive">
                                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/newSanPham" >Tạo mới sản phẩm</a>

                                        <table class="table table-striped jambo_table bulk_action">
                                            <thead>
                                                <tr class="headings">
                                                    <th style="color: greenyellow" class="column-title">EDIT</th>
                                                    <th style="color: red" class="column-title">DELETE</th>
                                                    <th class="column-title">Hình ảnh</th>
                                                    <th class="column-title">Mã sản phẩm</th>
                                                    <th class="column-title">Mã kho</th>
                                                    <th class="column-title">Tên sản phẩm</th>
                                                    <th class="column-title">Thương hiệu</th>
                                                    <th class="column-title">Màu </th>
                                                    <th class="column-title">SeriesLapTop</th>
                                                    <th class="column-title">CPU</th>
                                                    <th class="column-title">Đồ hoạ</th>
                                                    <th class="column-title">Đồ hoạ rời</th>
                                                    <th class="column-title">RAM</th>
                                                    <th class="column-title">Bộ nhớ</th>
                                                    <th class="column-title">Độ phân giả</th>
                                                    <th class="column-title">Màn hình cảm ứng</th>
                                                    <th class="column-title">Khối lượng</th>


                                                    <th class="bulk-actions" colspan="7">
                                                        <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                                    </th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach items="${listSP}" var="sanpham" >

                                                    <tr class="even pointer">
                                                        <td>
                                                            <a href="${pageContext.request.contextPath}/edit?idSanPham=<c:out value='${sanpham.idSanPham}'/>">EDIT</a>
                                                        </td>
                                                        <td>
                                                            <a href="${pageContext.request.contextPath}/delete?idSanPham=<c:out value='${sanpham.idSanPham}'/>">DELETE</a>
                                                        </td> 
                                                        <td class="a-center ">
                                                            <c:forEach items="${sanpham.listimage}" var="img" varStatus="loop">
                                                                <c:if test="${loop.index == 0}">
                                                                    <img src="Image//Product//${sanpham.thuongHieu}//${img.URL}"width="100px"/>
                                                                </c:if>
                                                            </c:forEach>
                                                        </td>
                                                        <td>${sanpham.idSanPham}</td>
                                                        <td>${sanpham.kho.idKho}</td>
                                                        <td>${sanpham.tenSanPham}</td>
                                                        <td>${sanpham.thuongHieu}</td>
                                                        <td>${sanpham.mau}</td>
                                                        <td>${sanpham.seriesLapTop}</td>
                                                        <td>${sanpham.CPU}</td>
                                                        <td>${sanpham.doHoa}</td>
                                                        <td>${sanpham.doHoaRoi}</td>
                                                        <td>${sanpham.RAM}</td>
                                                        <td>${sanpham.boNho}</td>
                                                        <td>${sanpham.phanGiai}</td>
                                                        <td>${sanpham.MHCamUng}</td>
                                                        <td>${sanpham.khoiLuong}</td>

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
                        <!--nút Previous-->
                        <c:if test="${id ==null && empty gia && empty mau && empty giatrongkhoang && empty giaMin && empty giaMax && page != 1}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/productList?page=${page-1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                        </c:if>
                        <c:if test="${id != null && empty gia && empty mau && empty giatrongkhoang && empty giaMin && empty giaMax && page != 1}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/productList?keyword=<%=request.getParameter("keyword")%>&page=${page-1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                        </c:if>
                        <c:if test="${ not empty gia  && id == null && empty mau && empty giatrongkhoang && empty giaMin && empty giaMax && page != 1}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGia=<%=request.getParameter("keywordGia")%>&page=${page-1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                        </c:if>
                        <c:if test="${empty gia && id == null && not empty mau && empty giatrongkhoang && empty giaMin && empty giaMax && page != 1}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/productList?keywordMau=<%=request.getParameter("keywordMau")%>&page=${page-1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                        </c:if>
                        <c:if test="${empty gia && id == null && empty mau && not empty giatrongkhoang && empty giaMin  && empty giaMax &&  page != 1}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGiaTrongKhoan=<%=request.getParameter("keywordGiaTrongKhoan")%>&page=${page-1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                        </c:if>
                        <c:if test="${empty gia && id == null && empty mau && empty giatrongkhoang && not empty giaMin  && empty giaMax &&  page != 1}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGiaMin=<%=request.getParameter("keywordGiaMin")%>&page=${page-1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                        </c:if>
                        <c:if test="${gia == null && id == null && empty mau && empty giatrongkhoang && empty giaMin  && not empty giaMax &&  page != 1}">
                            <li class="page-item">
                                <a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGiaMax=<%=request.getParameter("keywordGiaMax")%>&page=${page-1}" tabindex="-1" aria-disabled="true">Previous</a>
                            </li>
                        </c:if>

                        <!--Page--> 
                        <c:if test="${id == null && empty gia && empty mau && empty giatrongkhoang && empty giaMin && empty giaMax}">
                            <c:forEach var="i" begin="1" end="${countPage}">
                                <c:choose >
                                    <c:when test="${page == i}">
                                        <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/productList?page=${i}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/productList?page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:if>
                            <c:if test="${id != null && empty gia && empty mau && empty giatrongkhoang && empty giaMin && empty giaMax}">
                                <c:forEach var="i" begin="1" end="${countPage}">
                                    <c:choose >
                                        <c:when test="${page == i}">
                                        <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/productList?keyword=<%=request.getParameter("keyword")%>&page=${i}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/productList?keyword=<%=request.getParameter("keyword")%>&page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:if>  
                            <c:if test="${not empty gia && id == null && empty mau && empty giatrongkhoang && empty giaMin && empty giaMax}">
                                <c:forEach var="i" begin="1" end="${countPage}">
                                    <c:choose >
                                        <c:when test="${page == i}">
                                        <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGia=<%=request.getParameter("keywordGia")%>&page=${i}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGia=<%=request.getParameter("keywordGia")%>&page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:if> 
                            <c:if test="${empty gia && id == null && not empty mau && empty giatrongkhoang && empty giaMin && empty giaMax}">
                                <c:forEach var="i" begin="1" end="${countPage}">
                                    <c:choose >
                                        <c:when test="${page == i}">
                                        <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordMau=<%=request.getParameter("keywordMau")%>&page=${i}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordMau=<%=request.getParameter("keywordMau")%>&page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:if> 
                            <c:if test="${empty gia && id == null && empty mau && not empty giatrongkhoang && empty giaMin && empty giaMax}">
                                <c:forEach var="i" begin="1" end="${countPage}">
                                    <c:choose >
                                        <c:when test="${page == i}">
                                        <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGiaTrongKhoan=<%=request.getParameter("keywordGiaTrongKhoan")%>&page=${i}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGiaTrongKhoan=<%=request.getParameter("keywordGiaTrongKhoan")%>&page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:if> 
                            <c:if test="${empty gia && id == null && empty mau && empty giatrongkhoang && not empty giaMin && empty giaMax}">
                                <c:forEach var="i" begin="1" end="${countPage}">
                                    <c:choose >
                                        <c:when test="${page == i}">
                                        <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGiaMin=<%=request.getParameter("keywordGiaMin")%>&page=${i}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGiaMin=<%=request.getParameter("keywordGiaMin")%>&page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:if> 
                            <c:if test="${empty gia && id == null && empty mau && empty giatrongkhoang && empty giaMin && not empty giaMax}">
                                <c:forEach var="i" begin="1" end="${countPage}">
                                    <c:choose >
                                        <c:when test="${page == i}">
                                        <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGiaMin=<%=request.getParameter("keywordGiaMin")%>&page=${i}">${i}</a></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGiaMin=<%=request.getParameter("keywordGiaMin")%>&page=${i}">${i}</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:if>
                                        
                        <!--nút Next-->
                        <c:if test="${id == null && empty gia && empty mau && empty giatrongkhoang && empty giaMin && empty giaMax && page < countPage}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/productList?page=${page+1}">Next</a></li>
                            </c:if>
                            <c:if test="${id != null && empty gia && empty mau && empty giatrongkhoang && empty giaMin && empty giaMax && page < countPage}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/productList?keyword=<%=request.getParameter("keyword")%>&page=${page+1}">Next</a></li>
                            </c:if>
                            <c:if test="${not empty gia && id ==null && empty mau && empty giatrongkhoang && empty giaMin && empty giaMax && page < countPage}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGia=<%=request.getParameter("keywordGia")%>&page=${page+1}">Next</a></li>
                            </c:if>
                            <c:if test="${empty gia && id ==null && not empty mau && empty giatrongkhoang && empty giaMin && empty giaMax && page < countPage}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordMau=<%=request.getParameter("keywordMau")%>&page=${page+1}">Next</a></li>
                            </c:if>
                            <c:if test="${empty gia && id ==null && empty mau && not empty giatrongkhoang && empty giaMin && empty giaMax && page < countPage}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGiaTrongKhoan=<%=request.getParameter("keywordGiaTrongKhoan")%>&page=${page+1}">Next</a></li>
                            </c:if>
                            <c:if test="${empty gia && id ==null && empty mau && empty giatrongkhoang && not empty giaMin && empty giaMax && page < countPage}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGiaMin=<%=request.getParameter("keywordGiaMin")%>&page=${page+1}">Next</a></li>
                            </c:if>
                            <c:if test="${empty gia && id ==null && empty mau && empty giatrongkhoang && empty giaMin && not empty giaMax && page < countPage}">
                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/productList?keywordGiaMax=<%=request.getParameter("keywordGiaMax")%>&page=${page+1}">Next</a></li>
                            </c:if>
                    </ul>
                </nav>
            </div>
            <!-- /page content -->
        </div>
    </div>
</body>

<jsp:include page="_footer1.jsp"></jsp:include>