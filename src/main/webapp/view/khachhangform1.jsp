<%-- 
    Document   : sanphamlist1
    Created on : 9 thg 11, 2023, 22:11:08
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
                <div class="right_col" role="main">
                    <div class="">
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2><c:if test="${KhachHang != null}">
                                            Edit Khách Hàng
                                        </c:if>
                                        <c:if test="${KhachHang == null}">
                                            Add New Khách Hàng
                                        </c:if> <small>different form elements</small></h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br />
                                    <c:set var="kh" value="${requestScope.KhachHang}"/>
                                    <form method="post" class="form-horizontal form-label-left" enctype="multipart/form-data" >
                                        <c:choose>
                                            <c:when test="${kh!=null}">

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên Khách Hàng <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="name" required="required" class="form-control col-md-7 col-xs-12" value="${kh.ten}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Số điện thoại:<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="phone" required="required" class="form-control col-md-7 col-xs-12" value="${kh.SDT}"required onblur="checkPhoneNumber()">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Địa chỉ:<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="address" required="required" class="form-control col-md-7 col-xs-12" value="${kh.diaChi}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Email:<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="Email" required="required" class="form-control col-md-7 col-xs-12" value="${kh.email}">
                                                    </div>
                                                </div>
                                                <c:if test="${kh.image.URL == ''}">
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Hình ảnh<span class="required">*</span>
                                                        </label>
                                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                                            <img style="width: 150px; height: 150px;" src="Image//Customer//kh2.png" alt="" id="img-view">
                                                            <ul style="margin-left: -28px">
                                                                <li style="display: block"><label class="s-c-l-l-i-l-upload" for="upload-photo" id="drop-photo">Chọn ảnh
                                                                        <input type="file" name="photo" id="upload-photo" hidden></label>                                    
                                                                </li>
                                                                <li style="display: block"><a href="${pageContext.request.contextPath}/remimg?${kh.idPerson}" name="remove-photo" value="${kh.idPerson}">Gỡ ảnh </a></li>
                                                            </ul>    
                                                        </div>
                                                    </div>
                                                </c:if>
                                                <c:if test="${kh.image.URL != ''}">
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Hình ảnh<span class="required">*</span>
                                                        </label>
                                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                                            <img style="width: 150px; height: 150px;" src="${pageContext.request.contextPath}/Image/Customer/${kh.image.URL}" alt="" id="img-view">
                                                            <ul style="margin-left: -28px">
                                                                <li style="display: block"> <label class="s-c-l-l-i-l-upload" for="upload-photo" id="drop-photo">
                                                                        <input type="file" name="photo" id="upload-photo" hidden></label>                                    
                                                                </li>
                                                                <li style="display: block">
                                                                    <input type="button"id="remove-photo" value="Gỡ ảnh"onclick="removeimage()">
                                                                </li>
                                                            </ul>    
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </c:when>
                                            <c:when test="${kh==null}">
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên Khách Hàng <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="name" required="required" class="form-control col-md-7 col-xs-12" value="${kh.ten}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Số điện thoại:<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="phone" required="required" class="form-control col-md-7 col-xs-12" value="${kh.SDT}"required onblur="checkPhoneNumber()">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Địa chỉ:<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="address" required="required" class="form-control col-md-7 col-xs-12" value="${kh.diaChi}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Email:<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="Email" required="required" class="form-control col-md-7 col-xs-12" value="${kh.email}">
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Hình ảnh<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <img style="width: 150px; height: 150px;" src="Image//Customer//kh2.png" alt="" id="img-view">
                                                        <ul style="margin-left: -28px">
                                                            <li style="display: block"><label class="s-c-l-l-i-l-upload" for="upload-photo" id="drop-photo">Chọn ảnh
                                                                    <input type="file" name="photo" id="upload-photo" hidden></label>
                                                            </li>
                                                            <li style="display: block">
                                                                <input type="button"id="remove-photo" value="Gỡ ảnh"onclick="removeimage()">
                                                            </li>
                                                        </ul> 
                                                    </div>
                                                </div>
                                            </c:when>
                                        </c:choose>

                                        <div class="ln_solid"></div>
                                        <div class="form-group">
                                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                <c:choose>
                                                    <c:when test="${kh == null}">
                                                        <button formaction="${pageContext.request.contextPath}/action=createkh" onclick="submit()">Create</button>
                                                    </c:when>  
                                                    <c:when test="${kh != null}">
                                                        <button formaction="${pageContext.request.contextPath}/action=updatekh?id=${kh.idPerson}" name="submit" value="${kh.idPerson}" onclick="submit()">Update</button>
                                                    </c:when>  
                                                </c:choose>
                                            </div>
                                        </div>
                                    </form>
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
<script>

    var uploadphoto = document.getElementById('upload-photo');
    const removephoto = document.getElementById('remove-photo');
    const imgview = document.getElementById('img-view');

    uploadphoto.addEventListener("change", UploadImage);

    function UploadImage() {
        document.getElementById('img-view').src = window.URL.createObjectURL(this.files[0]);
    }

    function submit() {
        document.getElementById("form").submit();
    }

    function removeimage() {
        document.getElementById('img-view').src = "${pageContext.request.contextPath}/Image/Customer/kh2.png";
        uploadphoto.value = '';
    }

</script>
<jsp:include page="_footer1.jsp"></jsp:include>