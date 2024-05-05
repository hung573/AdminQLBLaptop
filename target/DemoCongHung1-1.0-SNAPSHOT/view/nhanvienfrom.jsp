<%-- 
    Document   : nhanvienfrom
    Created on : 14 thg 12, 2023, 22:35:38
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
                                        <h2><c:if test="${kh != null}">
                                            Edit Nhân Viên
                                        </c:if>
                                        <c:if test="${kh == null}">
                                            Add New Nhân Viên
                                        </c:if> <small>different form elements</small></h2>

                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br />
                                    <c:set var="nhanvien" value="${requestScope.nhanvien}" />
                                    <form method="post" class="form-horizontal form-label-left" enctype="multipart/form-data" >
                                        <c:choose>
                                            <c:when test="${nhanvien!=null}">
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="Ten" required="required" value="${nhanvien.ten}" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Ngày sinh<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="date" name="NgaySinh" required="required" value="${nhanvien.ngaySinh}" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Email<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="Email" required="required" value="${nhanvien.email}" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Địa chỉ<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="Diachi" required="required" value="${nhanvien.diaChi}" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">SDT<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="SDT" required="required" value="${nhanvien.SDT}" class="form-control col-md-7 col-xs-12" value="${kh.xepHang}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Bộ phận<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <select id="" name="BoPhan" class="form-control col-md-7 col-xs-12">
                                                            <option value="Bán hàng" <c:if test="${nhanvien.boPhan eq 'Bán Hàng'}">selected</c:if>>Bán hàng</option>
                                                            <option value="Kho vận" <c:if test="${nhanvien.boPhan eq 'Kho vận'}">selected</c:if>>Kho Vận</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Chức vụ<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <select id="" name="ChucVu" class="form-control col-md-7 col-xs-12">
                                                            <option value="Quản Lý" <c:if test="${nhanvien.chucVu eq 'Quản Lý'}">selected</c:if>>Quản Lý</option>
                                                            <option value="Nhân Viên"<c:if test="${nhanvien.chucVu eq 'Nhân Viên'}">selected</c:if> >Nhân Viên</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Trang thai<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <label>
                                                            <input type="radio" name="TrangThai" value="0" ${(nhanvien.trangThai == '0') ? 'checked' : ''} required="required" class="form-control col-md-7 col-xs-12">Nghỉ
                                                        </label>
                                                        <label>
                                                            <input type="radio" name="TrangThai" value="1" ${(nhanvien.trangThai == '1') ? 'checked' : ''} required="required" class="form-control col-md-7 col-xs-12">Còn Làm Việc
                                                        </label>
                                                    </div>
                                                </div>
                                                <c:if test="${nhanvien.image.URL == ''}">
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Hình ảnh<span class="required">*</span>
                                                        </label>
                                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                                            <img style="width: 150px; height: 150px;" src="Image//" alt="" id="img-view">
                                                            <ul style="margin-left: -28px">
                                                                <li style="display: block"><label class="s-c-l-l-i-l-upload" for="upload-photo" id="drop-photo">Chọn ảnh
                                                                        <input type="file" name="photo" id="upload-photo" hidden></label>                                    
                                                                </li>
                                                                <li style="display: block"><a href="${pageContext.request.contextPath}/action=remimg?${nhacungcap.idPerson}" name="remove-photo" value="${nhacungcap.idPerson}">Gỡ ảnh </a></li>
                                                            </ul>    
                                                        </div>
                                                    </div>
                                                </c:if>
                                                <c:if test="${nhanvien.image.URL != ''}">
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Hình ảnh<span class="required">*</span>
                                                        </label>
                                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                                            <img style="width: 150px; height: 150px;" src="${pageContext.request.contextPath}/Image/Employee/${nhanvien.image.URL}" alt="" id="img-view">
                                                            <ul style="margin-left: -28px">
                                                                <li style="display: block"> <label class="s-c-l-l-i-l-upload" for="upload-photo" id="drop-photo">
                                                                        <input type="file" name="photo" id="upload-photo" hidden></label>                                    
                                                                </li>
                                                                <li style="display: block">
                                                                    <button formaction="${pageContext.request.contextPath}/action=delimg?${nhanvien.image.URL}" name="delete-photo" value="${nhanvien.idPerson}" onclick="submit()">Xóa </button>
                                                                </li>
                                                            </ul>    
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </c:when>
                                            <c:when test="${nhanvien == null}">
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="Ten" required="required" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Ngày sinh<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="date" name="NgaySinh" required="required" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Email<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="Email" required="required" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Địa chỉ<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="Diachi" required="required" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">SDT<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="SDT" required="required" class="form-control col-md-7 col-xs-12" value="${kh.xepHang}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Bộ phận<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <select id="" name="BoPhan" class="form-control col-md-7 col-xs-12">
                                                            <option value="Bán hàng">Bán hàng</option>
                                                            <option value="Kho Vận">Kho Vận</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Chức vụ<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <select id="" name="ChucVu" class="form-control col-md-7 col-xs-12">
                                                            <option value="Quản Lý">Quản Lý</option>
                                                            <option value="Nhân Viên">Nhân Viên</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Trang thai<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                         <label>
                                                            <input type="radio" name="TrangThai" value="0" required="required" class="form-control col-md-7 col-xs-12">Nghỉ
                                                        </label>
                                                        <label>
                                                            <input type="radio" name="TrangThai" value="1" required="required" class="form-control col-md-7 col-xs-12">Còn Làm Việc
                                                        </label>

                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Hình ảnh<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <img style="width: 150px; height: 150px;" src="Image//" alt="" id="img-view">
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
                                                    <c:when test="${nhanvien == null}">
                                                        <button formaction="${pageContext.request.contextPath}/action=create" onclick="submit()">Create</button>
                                                    </c:when>  
                                                    <c:when test="${nhanvien != null}">
                                                        <button formaction="${pageContext.request.contextPath}/action=update?id=${nhanvien.idPerson}" name="submit" value="${nhanvien.idPerson}" onclick="submit()">Update</button>
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