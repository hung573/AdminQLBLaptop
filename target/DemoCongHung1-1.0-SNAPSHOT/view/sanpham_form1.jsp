x<%-- 
    Document   : sanphamlist1
    Created on : 9 thg 11, 2023, 22:11:08
    Author     : mac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:include page="_header1.jsp"></jsp:include>
<style>
        .s-c-l-listitem {
            padding: 20px 20px;
        }

        .s-c-l-listitem ul {
            display: flex;
            flex-wrap: wrap;
            list-style-type: none;
            justify-content: initial;
            /* Tín đệp trai sửa css ở đây từ space-between thành initial vào lúc 12h49 ngày 12/12/2023 tại trường ĐHSG, địa điểm ông bầu khu E, bàn gần cửa ra vào, tái bút.*/
            margin: 0;
            padding: 0;
            margin-bottom: 0px;
            padding-left: 20px;
            column-gap: 40px;
            /* Tín đệp trai thêm css ở đây vào lúc 12h52 ngày 12/12/2023 tại trường ĐHSG, địa điểm ông bầu khu E, bàn gần cửa ra vào, tái bút.*/
        }

        .s-c-l-listitem li {
            margin-bottom: 20px;
        }

        .s-c-l-l-item {
            position: relative;
            width: 150px;
            border: 1px solid black;
        }
        ul{
            list-style: none;
        }
        .s-c-l-l-item {
            position: relative;
            width: 150px;
            border: 1px solid black;
        }

        .s-c-l-l-i-img {
            height: 150px;
            width: 150px;
        }

        .s-c-l-l-i-img img {
            display: flex;
            align-items: center;
            justify-content: center;
            width: 100%;
            height: 100%;
        }

        .s-c-l-l-upload {
            width: 80px;
            text-align: center;
            border: 2px solid black;
            border-radius: 4px;
            font-size: 18px;
            cursor: pointer;
        }

        .s-c-l-l-i-l-u-btn {
            cursor: pointer;
        }

        .s-c-l-l-i-l-remove {
            /*display: none;*/
            position: absolute;
            top: 0%;
            right: 0%;

        }

        .s-c-l-l-i-l-remove button {
            width: 25px;
            height: 25px;
            background-image: url('${pageContext.request.contextPath}/Image/remove.png');
            background-position: 50% 50%;
            background-color: transparent;
            border: 1px solid transparent;
            cursor: pointer;
        }

        #upload-photo {
            display: none;
        }

        .s-c-l-l-item:hover .s-c-l-l-i-img img{
            filter: blur(3px);
        }

        .s-c-l-l-item:hover  .s-c-l-l-i-l-remove{
            display: block;
        }

        .s-c-l-l-item:hover  .s-c-l-l-i-l-upload{
            display: block;
        }
    </style>
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
                                        <h2><c:if test="${sanpham != null}">
                                            Edit SanPham
                                        </c:if>
                                        <c:if test="${sanpham == null}">
                                            Add New SanPham
                                        </c:if> <small>different form elements</small></h2>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br />
                                    <c:if test="${sanpham != null}">
                                        <form action="update" method="post" enctype="multipart/form-data" id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" >
                                        </c:if>
                                        <c:if test="${sanpham == null}">
                                            <form action="insert" method="post" enctype="multipart/form-data" id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">
                                            </c:if>
                                            <c:if test="${sanpham != null}">
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Thương Hiệu Sản Phẩm<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <select id="thuongHieu" name="thuongHieu" class="form-control col-md-7 col-xs-12">
                                                            <option value="ACER" <c:if test="${sanpham.thuongHieu eq 'ACER'}">selected</c:if>>ACER</option>
                                                            <option value="APPLE" <c:if test="${sanpham.thuongHieu eq 'APPLE'}">selected</c:if>>APPLE</option>
                                                            <option value="ASUS" <c:if test="${sanpham.thuongHieu eq 'ASUS'}">selected</c:if>>ASUS</option>
                                                            <option value="DELL" <c:if test="${sanpham.thuongHieu eq 'DELL'}">selected</c:if>>DELL</option>
                                                            <option value="GIGABYTE" <c:if test="${sanpham.thuongHieu eq 'GIGABYTE'}">selected</c:if>>GIGABYTE</option>
                                                            <option value="HP" <c:if test="${sanpham.thuongHieu eq 'HP'}">selected</c:if>>HP</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Mã Sản  <span class="required">*</span>
                                                        </label>
                                                        <div class="col-md-6 col-sm-6 col-xs-12">
                                                            <input type="text" name="idSanPham" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.idSanPham}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên Sản Phẩm<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="tenSanPham" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.tenSanPham}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Màu sản phẩm<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="mau" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.mau}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">SeriesLapTop<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="seriesLapTop" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.seriesLapTop}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Nhu cầu<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="nhuCau" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.nhuCau}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">SeriesCPU<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="seriesCPU" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.seriesCPU}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">CPU<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="CPU" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.CPU}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Đồ Hoạ<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="doHoa" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.doHoa}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Đồ Hoạ Rời <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="doHoaRoi" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.doHoaRoi}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">RAM<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="RAM" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.RAM}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Bộ Nhớ <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="boNho" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.boNho}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Kích Thước Màn <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="KTManHinh" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.KTManHinh}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Phân Giải<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="phanGiai" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.phanGiai}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Màn Cảm Ứng<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="MHCamUng" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.MHCamUng}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Khối Lượng<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="khoiLuong" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.khoiLuong}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Mã Kho<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="number" name="idKho" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.kho.idKho}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Giá Nhập<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="giaNhap" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.kho.giaNhap}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Giá Bán<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="giaBan" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.kho.giaBan}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Số Lượng<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="soLuong" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.kho.soLuong}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Hình ảnh sản phẩm<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">

                                                        <c:forEach items="${sanpham.listimage}" var="img" varStatus="loop">
                                                            <img src="Image//Product//${sanpham.thuongHieu}//${img.URL}" width="100px"/>
                                                            <input type="text" name="textURL${loop.index + 1}" class="form-control col-md-7 col-xs-12" value="${img.URL}">
                                                        </c:forEach>


                                                    </div>
                                                </div>
                                                <div class="ln_solid"></div>
                                                <div class="form-group">
                                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                        <button class="btn btn-primary" type="button">Cancel</button>
                                                        <button class="btn btn-primary" type="reset">Reset</button>
                                                        <button type="submit" class="btn btn-success">Submit</button>
                                                    </div>
                                                </div>

                                            </c:if>
                                            <c:if test="${sanpham == null}">
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Thương Hiệu Sản Phẩm<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <select name="thuongHieu" class="form-control col-md-7 col-xs-12" value="<c:out value='${sanpham.thuongHieu}'/>">
                                                            <option value="ACER">ACER</option>
                                                            <option value="APPLE">APPLE</option>
                                                            <option value="ASUS">ASUS</option>
                                                            <option value="DELL">DELL</option>
                                                            <option value="GIGABYTE">GIGABYTE</option>
                                                            <option value="HP">HP</option>
                                                        </select>
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Tên Sản Phẩm<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="tenSanPham" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.tenSanPham}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Màu sản phẩm<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="mau" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.mau}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">SeriesLapTop<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="seriesLapTop" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.seriesLapTop}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Nhu cầu<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="nhuCau" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.nhuCau}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">SeriesCPU<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="seriesCPU" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.seriesCPU}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">CPU<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="CPU" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.CPU}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Đồ Hoạ<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="doHoa" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.doHoa}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Đồ Hoạ Rời <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="doHoaRoi" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.doHoaRoi}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">RAM<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="RAM" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.RAM}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Bộ Nhớ <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="boNho" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.boNho}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Kích Thước Màn <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="KTManHinh" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.KTManHinh}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Phân Giải<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="phanGiai" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.phanGiai}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Màn Cảm Ứng<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="MHCamUng" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.MHCamUng}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Khối Lượng<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="khoiLuong" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.khoiLuong}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Giá Nhập<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="giaNhap" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.kho.giaNhap}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Giá Bán<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="giaBan" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.kho.giaBan}">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Số Lượng<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" name="soLuong" required="required" class="form-control col-md-7 col-xs-12" value="${sanpham.kho.soLuong}">
                                                    </div>
                                                </div>
                                                <div class="form-group"> 
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Ảnh:<span class="required">*</span>
                                                    </label>
                                                    <div class="s-c-l-listitem">
                                                        <div class="s-c-l-l-upload">
                                                            <label for="upload-photo">Chọn ảnh
                                                                <input type="file" name="photo" id="upload-photo" hidden="">
                                                            </label>
                                                        </div>
                                                        <ul>
                                                            <li>                                                                
                                                                <div class="s-c-l-l-item">
                                                                    <div class="s-c-l-l-i-img">
                                                                        <img id="img-view" src="${pageContext.request.contextPath}/Image/image-place-holder.jpg" alt=""/>                                                                                                                                                             
                                                                    </div>  
                                                                    <div class="s-c-l-l-i-l-remove">
                                                                        <button formaction="${pageContext.request.contextPath}/delete_image?${image.URL}" name="delete-photo" value="${image.URL}"></button>    
                                                                    </div>
                                                                </div>

                                                            </li>                               
                                                        </ul>
                                                    </div>
                                                </div>
                                                </div>
                                                <div class="ln_solid"></div>
                                                <div class="form-group">
                                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                        <button class="btn btn-primary" type="button">Cancel</button>
                                                        <button class="btn btn-primary" type="reset">Reset</button>
                                                        <button type="submit" class="btn btn-success">Submit</button>
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

<script type="text/javascript">
    var uploadphoto = document.getElementById('upload-photo');
    const removephoto = document.getElementById('remove-photo');
    const imgview = document.getElementById('img-view');

    uploadphoto.addEventListener("change", UploadImage);

    function UploadImage() {
        document.getElementById('img-view').src = window.URL.createObjectURL(this.files[0]);
        document.getElementById("demo-form2").submit();
    }
    function submit() {
        document.getElementById("demo-form2").submit();
    }


</script>

<jsp:include page="_footer1.jsp"></jsp:include>