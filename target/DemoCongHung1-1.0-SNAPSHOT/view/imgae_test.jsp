<%-- 
    Document   : imgae_test
    Created on : 7 thg 12, 2023, 13:22:59
    Author     : mac
--%>

<%-- 
    Document   : Bai01_item
    Created on : Oct 27, 2023, 9:06:05 PM
    Author     : maiho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
        <link href=".//css_Hop//list-item.css" rel="stylesheet">

    </head>
    <body>
        <!--<form action="ListServelt" method="get" id="theform">-->

        <div class="s-container">
            <div class="s-c-left">
                <div class="s-c-l-listitem">
                    <ul>
                        <c:forEach var="item" items="${listSP_IMG}">
                            <form action="<%=request.getContextPath()%>/uploadFile" method="post" enctype="multipart/form-data" >
                                <li>
                                    <div class="s-c-l-l-item">
                                        <div class="s-c-l-l-i-name">
                                            <p>Tên sản phẩm: </p>         
                                        </div>
                                        <div class="s-c-l-l-i-img">
                                            <img name="${item.URL}" src="Image//Product//ACER//${item.URL}" width="100px"/>                                       
                                        </div>
                                        <div class="s-c-l-l-i-listprice">
                                            <ul class="s-c-l-l-i-l-price">
                                                <li><span class="s-c-l-l-i-l-p-oldprice"></span></li>

                                                <li><span class="s-c-l-l-i-l-p-newprice"></span></li>
                                            </ul>        
                                        </div>
                                    </div>
                                </li>
                                <input type="file" value="Upload file" name="hinhanh"  /> <br />
                                <input type="submit" value="Thực hiện" name="thuchien"  />
                                <br>
                                <a href="${pageContext.request.contextPath}/delete_image">Delete</a>
                            </form>
                        </c:forEach>
                    </ul>
                </div>
                <div>
                    <h1>Upload file in servlet</h1>

                        <input type="text" value="${fileItems}" />                        
                    <form action="<%=request.getContextPath()%>/uploadFile" method="post" enctype="multipart/form-data" >
                        <label>Upload file : </label><br />
                        <input type="file" value="Upload file" name="hinhanh"  /> <br />
                        <input type="submit" value="Thực hiện" name="thuchien"  />
                    </form>
                    
                </div>
            </div>
        </div>

        <!--</form>-->
    </body>
</html>

