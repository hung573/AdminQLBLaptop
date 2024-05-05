<%-- 
    Document   : sanphamlist1
    Created on : 9 thg 11, 2023, 22:11:08
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
                <div class="right_col" role="main">
                    <div class="">
                        <div class="clearfix"></div>
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">
                                        <h2><c:if test="${nhacungcap != null}">
                                            Edit Nhà Cung Cấp
                                        </c:if>
                                        <c:if test="${nhacungcap == null}">
                                            Add New Nhà Cung Cấp
                                        </c:if> <small>different form elements</small></h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br />
                                    <c:if test="${nhacungcap != null}">
                                        <form action="updateNCC" method="post" class="form-horizontal form-label-left" enctype="multipart/form-data" >
                                        </c:if>
                                        <c:if test="${nhacungcap == null}">
                                            <form  action="insertNCC" method="post" id="demo-form2" enctype="multipart/form-data" class="form-horizontal form-label-left">
                                            </c:if>
                                            <c:if test="${nhacungcap != null}">
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Loại nhà cung cấp<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <select id="loai" name="loai" class="form-control col-md-7 col-xs-12">
                                                            <option value="Cá nhân" <c:if test="${nhacungcap.loai eq 'Cá nhân'}">selected</c:if>>Cá Nhân</option>
                                                            <option value="Tổ chức" <c:if test="${nhacungcap.loai eq 'Tổ chức'}">selected</c:if>>Tổ Chức</option>
                                                            </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">IdPerSon  <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="idPerSon" required="required" class="form-control col-md-7 col-xs-12" value="${nhacungcap.idPerson}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên  <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="ten" required="required" class="form-control col-md-7 col-xs-12" value="${nhacungcap.ten}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Địa chỉ<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="diachi" required="required" class="form-control col-md-7 col-xs-12" value="${nhacungcap.diaChi}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Email<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="email" required="required" class="form-control col-md-7 col-xs-12" value="${nhacungcap.email}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Số điện thoại<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="sodienthoai" required="required" class="form-control col-md-7 col-xs-12" value="${nhacungcap.SDT}">
                                                    </div>
                                                </div>
                                                <c:if test="${nhacungcap.image.URL == ''}">
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Hình ảnh<span class="required">*</span>
                                                        </label>
                                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                                            <img style="width: 150px; height: 150px;" src="Image//Customer//kh2.png" alt="" id="img-view">
                                                            <ul style="margin-left: -28px">
                                                                <li style="display: block"><label class="s-c-l-l-i-l-upload" for="upload-photo" id="drop-photo">Chọn ảnh
                                                                        <input type="file" name="photo" id="upload-photo" hidden></label>                                    
                                                                </li>
                                                                <li style="display: block"><a href="${pageContext.request.contextPath}/remimg?${nhacungcap.idPerson}" name="remove-photo" value="${nhacungcap.idPerson}">Gỡ ảnh </a></li>
                                                            </ul>    
                                                        </div>
                                                    </div>
                                                </c:if>
                                                <c:if test="${nhacungcap.image.URL != ''}">
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Hình ảnh<span class="required">*</span>
                                                        </label>
                                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                                            <img style="width: 150px; height: 150px;" src="Image//Supplier//${nhacungcap.idPerson}.png" alt="" id="img-view">
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
                                                <div class="ln_solid"></div>
                                                <div class="form-group">
                                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                        <button class="btn btn-primary" type="button">Cancel</button>
                                                        <button class="btn btn-primary" type="reset">Reset</button>
                                                        <button type="submit" class="btn btn-success">Submit</button>
                                                    </div>
                                                </div>
                                                </div>

                                            </c:if>
                                            <c:if test="${nhacungcap == null}">
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Loại nhà cung cấp<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <select id="thuongHieu" name="loai" class="form-control col-md-7 col-xs-12">
                                                            <option value="Cá Nhân">Ca Nhan</option>
                                                            <option value="Tổ Chức">To Chuc</option>
                                                        </select>
                                                    </div>

                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên  <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="ten" required="required" class="form-control col-md-7 col-xs-12" value="${nhacungcap.ten}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Địa chỉ<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="diachi" required="required" class="form-control col-md-7 col-xs-12" value="${nhacungcap.diaChi}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Email<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="email" required="required" class="form-control col-md-7 col-xs-12" value="${nhacungcap.email}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Số điện thoại<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="sodienthoai" required="required" class="form-control col-md-7 col-xs-12" value="${nhacungcap.SDT}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Hình ảnh<span class="required">*</span>
                                                    </label>
                                                    <div style=" text-align: center;" class="col-md-6 col-sm-6 col-xs-12">
                                                        <img style="width: 150px; height: 150px;" src="Image//Customer//kh2.jpg" alt="" id="img-view">
                                                        <ul style="margin-left: -28px">
                                                            <li style="display: block"><label style ="cursor: pointer;"class="s-c-l-l-i-l-upload" for="upload-photo" id="drop-photo">Chọn ảnh
                                                                    <input style="opacity: 0;"type="file" name="photo" id="upload-photo" hidden></label>
                                                            </li>
                                                            <li style="display: block;margin-top: -20px">
                                                                <input type="button"id="remove-photo" value="Gỡ ảnh"onclick="removeimage()">
                                                            </li>
                                                        </ul> 
                                                    </div>
                                                </div>
                                                <div class="ln_solid"></div>
                                                <div class="form-group">
                                                    <div style=" text-align: center;"class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                        <button class="btn btn-primary" type="button">Cancel</button>
                                                        <button class="btn btn-primary" type="reset">Reset</button>
                                                        <button class="btn btn-success">Submit</button>
                                                    </div>
                                                </div>

                                            </c:if>
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