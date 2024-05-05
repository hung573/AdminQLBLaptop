///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
package servlet;

import Bean.Image;
import Bean.Kho;
import java.io.IOException;
import java.io.PrintWriter;


import DAL.SanPhamDAL;
import Bean.SanPham;

//import java.io.File;
//import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author mac
 */
@WebServlet(urlPatterns = { "/productList","/edit","/newSanPham","/insert","/delete","/update"})
@MultipartConfig(maxFileSize = -1L, maxRequestSize = -1L)

public class SanPhamServlet extends HttpServlet {
    private  static final long serialVersionUID = 1L;
    private SanPhamDAL sanPhamDAL;
    private  SanPham sanPham;
    
    public  SanPhamServlet(){
        super();
    }
    
    public  void  init(){
        sanPhamDAL = new SanPhamDAL();
        sanPham = new SanPham();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();
     
        try {
            
            switch (action) {
                case "/newSanPham":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertSanPham(request, response);
                    break;
                case "/delete":
                    deleteSanPham(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateSanPham(request, response);
                    break;     
                default:
                    listSanPham(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        
    }

    private void listSanPham(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        String tensp = request.getParameter("keyword");
        String gia = request.getParameter("keywordGia");
        String[] mau = request.getParameterValues("keywordMau");
        String[] giatrongkhoang = request.getParameterValues("keywordGiaTrongKhoan");
        String[] giaMin = request.getParameterValues("keywordGiaMin");
        String[] giaMax = request.getParameterValues("keywordGiaMax");

        
        int page = 1;
        if(request.getParameter("page") != null && request.getParameter("page") != ""){
            page = Integer.parseInt(request.getParameter("page"));
        }
        if(tensp != null && gia == null && mau==null && giatrongkhoang == null && giaMin == null && giaMax == null){
            ArrayList < SanPham > listsp = sanPhamDAL.findbyIDsanpham(tensp, 3, page);
            long countRecord = sanPhamDAL.TinhTongSLSPSearchTen(tensp);
            double countPage = Math.ceil(countRecord/3 +1);
            request.setAttribute("listSP", listsp);
            request.setAttribute("countRecord", countRecord);
            request.setAttribute("countPage", countPage);
            request.setAttribute("page", page);
            request.setAttribute("id", tensp);
            request.setAttribute("gia", gia);
            request.setAttribute("mau", mau);
            request.setAttribute("giatrongkhoang", giatrongkhoang);
            request.setAttribute("giaMin", giaMin);
            request.setAttribute("giaMax", giaMax);


            request.getServletContext().getRequestDispatcher("/view/sanphamlist1.jsp").forward(request, response);
        }
        else if(gia !=null && tensp == null && mau==null&& giatrongkhoang == null&& giaMin == null && giaMax == null){
            ArrayList < SanPham > listsp = sanPhamDAL.findbyGiaBan(gia,3,page);
            long countRecord = sanPhamDAL.TinhTongSLSPSearchGia(gia);
            double countPage = Math.ceil(countRecord/3 +1);
            request.setAttribute("listSP", listsp);
            request.setAttribute("countRecord", countRecord);
            request.setAttribute("countPage", countPage);
            request.setAttribute("page", page);
            request.setAttribute("id", tensp);
            request.setAttribute("gia", gia);
            request.setAttribute("mau", mau);
            request.setAttribute("giatrongkhoang", giatrongkhoang);
            request.setAttribute("giaMin", giaMin);
            request.setAttribute("giaMax", giaMax);

            request.getServletContext().getRequestDispatcher("/view/sanphamlist1.jsp").forward(request, response);
        }
        else if(gia ==null && tensp == null && mau!=null && giatrongkhoang == null&& giaMin == null && giaMax == null){
            for (String maukt : mau) {
                ArrayList < SanPham > listsp = sanPhamDAL.findbyMauSanPham(maukt,3,page);
                long countRecord = sanPhamDAL.TinhTongSLSPSearchMau(maukt);
                double countPage = Math.ceil(countRecord/3 +1);
                request.setAttribute("listSP", listsp);
                request.setAttribute("countRecord", countRecord);
                request.setAttribute("countPage", countPage);
                request.setAttribute("page", page);
                request.setAttribute("id", tensp);
                request.setAttribute("gia", gia);
                request.setAttribute("mau", mau);
                request.setAttribute("giatrongkhoang", giatrongkhoang);
                request.setAttribute("giaMin", giaMin);
                request.setAttribute("giaMax", giaMax);

            }
            request.getServletContext().getRequestDispatcher("/view/sanphamlist1.jsp").forward(request, response);

        }
        else if(gia ==null && tensp == null && mau==null && giatrongkhoang != null&& giaMin == null && giaMax == null){
//            for (String giatrongkhoangkt : giatrongkhoang) {
                String[] giaValues = giatrongkhoang[0].split("-");
                String gianho = giaValues[0].trim();
                String gialon = giaValues[1].trim();
                System.out.println("servlet.SanPhamServlet.listSanPham()"+gianho+gialon);
                ArrayList < SanPham > listsp = sanPhamDAL.findbyGiaBanTrongKhoang(gianho,gialon,3,page);
                long countRecord = sanPhamDAL.TinhTongSLSPSearchGiaKhong(gianho,gialon);
                double countPage = Math.ceil(countRecord/3 +1);
                request.setAttribute("listSP", listsp);
                request.setAttribute("countRecord", countRecord);
                request.setAttribute("countPage", countPage);
                request.setAttribute("page", page);
                request.setAttribute("id", tensp);
                request.setAttribute("gia", gia);
                request.setAttribute("mau", mau);
                request.setAttribute("giatrongkhoang", giatrongkhoang);
                request.setAttribute("giaMin", giaMin);
                request.setAttribute("giaMax", giaMax);

//            }
            request.getServletContext().getRequestDispatcher("/view/sanphamlist1.jsp").forward(request, response);

        }
        else if(gia ==null && tensp == null && mau==null && giatrongkhoang == null&& giaMin != null && giaMax == null){
            for (String giaMinkt : giaMin) {
                ArrayList < SanPham > listsp = sanPhamDAL.findbyGiaBanMin(giaMinkt,3,page);
                long countRecord = sanPhamDAL.TinhTongSLSPSearchGiaMin(giaMinkt);
                double countPage = Math.ceil(countRecord/3 +1);
                request.setAttribute("listSP", listsp);
                request.setAttribute("countRecord", countRecord);
                request.setAttribute("countPage", countPage);
                request.setAttribute("page", page);
                request.setAttribute("id", tensp);
                request.setAttribute("gia", gia);
                request.setAttribute("mau", mau);
                request.setAttribute("giatrongkhoang", giatrongkhoang);
                request.setAttribute("giaMin", giaMin);
                request.setAttribute("giaMax", giaMax);

            }
            request.getServletContext().getRequestDispatcher("/view/sanphamlist1.jsp").forward(request, response);
        }
        else if(gia ==null && tensp == null && mau==null && giatrongkhoang == null&& giaMin == null && giaMax != null){
            for (String giaMaxkt : giaMax) {
                ArrayList < SanPham > listsp = sanPhamDAL.findbyGiaBanMax(giaMaxkt,3,page);
                long countRecord = sanPhamDAL.TinhTongSLSPSearchGiamax(giaMaxkt);
                double countPage = Math.ceil(countRecord/3 +1);
                request.setAttribute("listSP", listsp);
                request.setAttribute("countRecord", countRecord);
                request.setAttribute("countPage", countPage);
                request.setAttribute("page", page);
                request.setAttribute("id", tensp);
                request.setAttribute("gia", gia);
                request.setAttribute("mau", mau);
                request.setAttribute("giatrongkhoang", giatrongkhoang);
                request.setAttribute("giaMin", giaMin);
                request.setAttribute("giaMax", giaMax);

            }
            request.getServletContext().getRequestDispatcher("/view/sanphamlist1.jsp").forward(request, response);
        }
        else{
            List < SanPham > listsp = sanPhamDAL.listSanPham(3,page);
            long countRecord = sanPhamDAL.TinhTongSLSPList();
            double countPage = Math.ceil(countRecord/3+1); 
            request.setAttribute("listSP", listsp);
            request.setAttribute("countRecord", countRecord);
            request.setAttribute("countPage", countPage);
            request.setAttribute("page", page);
            request.setAttribute("id", tensp);
            request.setAttribute("gia", gia);
            request.setAttribute("mau", mau);
            request.setAttribute("giatrongkhoang", giatrongkhoang);
            request.setAttribute("giaMin", giaMin);
            request.setAttribute("giaMax", giaMax);

            request.getServletContext().getRequestDispatcher("/view/sanphamlist1.jsp").forward(request, response);
        }
        
              
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String[] listThuongHieu = sanPhamDAL.listThuongHieu();
        request.setAttribute("listTH", listThuongHieu);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/view/sanpham_form1.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String IdSanIdPham = request.getParameter("idSanPham");
//        String IdSanIdPham = sanPham.getIdSanPham();

        SanPham existingSanPham = sanPhamDAL.getSanPham(IdSanIdPham);
        
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/view/sanpham_form1.jsp");
        request.setAttribute("sanpham", existingSanPham);
        dispatcher.forward(request, response);

    }

    private void insertSanPham(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        String errorString = null;
        String tenSanPham = request.getParameter("tenSanPham");
        String ThuongHieu = request.getParameter("thuongHieu");
        String Mau = request.getParameter("mau");
        String SeriesLapTop = request.getParameter("seriesLapTop");
        String NhuCau = request.getParameter("nhuCau");
        String SeriesCPU = request.getParameter("seriesCPU");
        String CPU = request.getParameter("CPU");
        String DoHoa = request.getParameter("doHoa");
        String DoHoaRoi = request.getParameter("doHoaRoi");
        String RAM = request.getParameter("RAM");
        String BoNho = request.getParameter("boNho");
        String KTManHinh = request.getParameter("KTManHinh");
        String PhanGiai = request.getParameter("phanGiai");
        String MHCamUng = request.getParameter("MHCamUng");
        String KhoiLuong = request.getParameter("khoiLuong");
        String giaNhap = request.getParameter("giaNhap");
        String giaBan = request.getParameter("giaBan");
        String soLuong = request.getParameter("soLuong");
        Part photo = request.getPart("photo");
 
        System.out.println("ten"+tenSanPham);
        SanPham sp = new SanPham();
//        sp.setTenSanPham(tenSanPham);
//        SanPham sp = new SanPham(TenSanPham,ThuongHieu,Mau,SeriesLapTop,NhuCau,SeriesCPU,CPU,DoHoa,
//                DoHoaRoi,RAM,BoNho,KTManHinh,PhanGiai,MHCamUng,KhoiLuong);
//
//        if( TenSanPham == "" || ThuongHieu == "" || Mau == "" || SeriesLapTop == ""
//                || NhuCau=="" || SeriesCPU == "" || CPU == "" || DoHoa == "" || DoHoaRoi == ""
//                || RAM =="" || BoNho =="" || KTManHinh == "" || PhanGiai=="" || MHCamUng == "" || KhoiLuong==""){
//            errorString = "Thông tin sản phẩm không được để tróng. Thêm Thất bại";
//
//        }
//        if(errorString == null){
//            
//            sanPhamDAL.InsertSanPham(sp,giaBan,giaNhap,soLuong);
//
//        }
    //        request.setAttribute("errorString", errorString);
//
//        if(errorString != null){
//            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/view/sanpham_form.jsp");
//            dispatcher.forward(request, response);
//        }
//        else{
//            response.sendRedirect("productList");
//        }
    }
//    private String Hop2(HttpServletRequest request, HttpServletResponse response)
//            throws SQLException, IOException, ServletException {
//        // xử lý upload file khi người dùng nhấn nút thực hiện
//        String fileURLs = null;
//        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
//        try {
//            List<FileItem> fileItems = upload.parseRequest(request);
//            for (FileItem fileItem : fileItems) {
//                if (!fileItem.isFormField()) {
//                    // xử lý file
//                    String nameimg = fileItem.getName();
//                    if (!nameimg.equals("")) {
//                        String dirUrl = request.getServletContext()
//                                .getRealPath("") + File.separator + "Image//Product//ACER";
//                        File dir = new File(dirUrl);
//                        if (!dir.exists()) {
//                            dir.mkdir();
//                        }
//                        String fileImg = dirUrl + File.separator + nameimg;
//                        File file = new File(fileImg);
//                        try {
//                            fileItem.write(file);
//                            fileURLs = nameimg;
//                            System.out.println("UPLOAD THÀNH CÔNG...!");
//                            System.out.println("ĐƯỜNG DẪN KIỂM TRA UPLOAD HÌNH ẢNH : \n" + nameimg);
//                            
//                        } catch (Exception e) {
//                            System.out.println("CÓ LỖ TRONG QUÁ TRÌNH UPLOAD!");
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        }
//        return fileURLs;
//
//    }
    private void updateSanPham(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        String errorString = null;
        String IdSanPham =  request.getParameter("idSanPham");
        String TenSanPham = request.getParameter("tenSanPham");
        String ThuongHieu = request.getParameter("thuongHieu");
        String Mau = request.getParameter("mau");
        String SeriesLapTop = request.getParameter("seriesLapTop");
        String NhuCau = request.getParameter("nhuCau");
        String SeriesCPU = request.getParameter("seriesCPU");
        String CPU = request.getParameter("CPU");
        String DoHoa = request.getParameter("doHoa");
        String DoHoaRoi = request.getParameter("doHoaRoi");
        String RAM = request.getParameter("RAM");
        String BoNho = request.getParameter("boNho");
        String KTManHinh = request.getParameter("KTManHinh");
        String PhanGiai = request.getParameter("phanGiai");
        String MHCamUng = request.getParameter("MHCamUng");
        String KhoiLuong = request.getParameter("khoiLuong");
        String idKho = request.getParameter("idKho");
        String giaNhap = request.getParameter("giaNhap");
        String giaBan = request.getParameter("giaBan");
        String soLuong = request.getParameter("soLuong");
//        List<String> fileURLs = Hop2(request, response);

        String textURL1 = request.getParameter("textURL1");
        String textURL2 = request.getParameter("textURL2");
        String textURL3 = request.getParameter("textURL3");
        String textURL4 = request.getParameter("textURL4");
        String textURL5 = request.getParameter("textURL5");

        
        List<String> fileURLs = Arrays.asList(textURL1,textURL2,textURL3,textURL4,textURL5);

        
        SanPham sp = new SanPham(IdSanPham,TenSanPham,ThuongHieu,Mau,SeriesLapTop,NhuCau,SeriesCPU,CPU,DoHoa,
                DoHoaRoi,RAM,BoNho,KTManHinh,PhanGiai,MHCamUng,KhoiLuong);
        
        
        if( IdSanPham == "" || TenSanPham == "" || ThuongHieu == "" || Mau == "" || SeriesLapTop == ""
                || NhuCau=="" || SeriesCPU == "" || CPU == "" || DoHoa == "" || DoHoaRoi == ""
                || RAM =="" || BoNho =="" || KTManHinh == "" || PhanGiai=="" || MHCamUng == "" || KhoiLuong==""
                    ){
            errorString = "Thông tin sản phẩm không được để tróng. UpDate Thất bại";

        }

        if(errorString == null){
//            khoDAL.UpdateKho(Integer);
//            System.out.println(fileURLs);
            System.out.println(idKho);

            sanPhamDAL.UpdateSanPham(sp,idKho,giaBan,giaNhap,soLuong,fileURLs);
        }
        request.setAttribute("errorString", errorString);

        if(errorString != null){
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/view/sanpham_form.jsp");
//            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/view/404.jsp");
            dispatcher.forward(request, response);
        }
        else{
            response.sendRedirect("productList");
        }
    }

    private void deleteSanPham(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String IdSanPham = request.getParameter("idSanPham");
        sanPhamDAL.DeleteSanPham(IdSanPham);
        response.sendRedirect("productList");
    }

}
