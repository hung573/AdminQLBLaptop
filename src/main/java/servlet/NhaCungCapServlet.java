/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.Image;
import Bean.Person_NhaCungCap;
import DAL.NhaCungCapDAL;

//import jakarta.servlet.http.Part;
import java.io.File;
//import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

//import javax.servlet.http.Part;
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
@WebServlet(urlPatterns = {"/Nhacungcaplist", "/newNhaCungCap", "/ncc_form",
    "/insertNCC", "/editNCC", "/updateNCC"})
@MultipartConfig(maxFileSize = -1L, maxRequestSize = -1L)
public class NhaCungCapServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private NhaCungCapDAL nhaCungCapDAL;
//    private Person_NhaCungCap person_NhaCungCap;
//    private Person psPerson;
//    private Image img;

    public NhaCungCapServlet() {
        super();
    }

    public void init() {
        nhaCungCapDAL = new NhaCungCapDAL();
//        person_NhaCungCap = new Person_NhaCungCap();
//        psPerson =  new Person() {
//        };
//        img = new Image();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8") ;
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {

            switch (action) {

                case "/newNhaCungCap":
                    showNewForm(request, response);
                    break;
                case "/insertNCC":
                    ThemNCC(request, response);
                    break;
                case "/editNCC":
                    showEditForm(request, response);
                    break;
                case "/updateNCC":
                    UpdateNCC(request, response);
                    break;
                case "/Nhacungcaplist":
                    listNCC(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/view/ncc_form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String idPerson = request.getParameter("idPerson");
        Person_NhaCungCap person_NhaCungCap = nhaCungCapDAL.getNhaCungCap(idPerson);

        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/view/ncc_form.jsp");
        request.setAttribute("nhacungcap", person_NhaCungCap);
        dispatcher.forward(request, response);

    }

    private void listNCC(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String Id = request.getParameter("keyword");
        int Page = 1;
        if (request.getParameter("page") != null && request.getParameter("page") != "") {
            Page = Integer.parseInt(request.getParameter("page"));
        }
        if (Id != null) {
            ArrayList<Person_NhaCungCap> listncc = nhaCungCapDAL.findbyIDNCC(Id, 2, Page);
            long countRecord = nhaCungCapDAL.TinhTongSLNCCSearch(Id);
            double countPage = Math.ceil(countRecord / 2 + 1);
            request.setAttribute("listncc", listncc);
            request.setAttribute("countRecord", countRecord);
            request.setAttribute("countPage", countPage);
            request.setAttribute("page", Page);
            request.setAttribute("id", Id);
            RequestDispatcher dispatcher = request.getServletContext().
                    getRequestDispatcher("/view/nhacungcaplist.jsp");
            dispatcher.forward(request, response);
        }
        if (Id == null) {
            List< Person_NhaCungCap> listncc = nhaCungCapDAL.listNCC(2, Page);
//            List < Person_NhaCungCap > listncc = nhaCungCapDAL.listNCC();

            long countRecord = nhaCungCapDAL.TinhTongSLNCCList();
            double countPage = Math.ceil(countRecord / 2 + 1);
            request.setAttribute("listncc", listncc);
            request.setAttribute("countRecord", countRecord);
            request.setAttribute("countPage", countPage);
            request.setAttribute("page", Page);
            request.setAttribute("id", Id);

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/nhacungcaplist.jsp");
            dispatcher.forward(request, response);
        }

    }

    private void ThemNCC(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String errorString = null;
        String loai = request.getParameter("loai");
        String ten = request.getParameter("ten");
        String email = request.getParameter("email");
        String diachi = request.getParameter("diachi");
        String sodienthoai = request.getParameter("sodienthoai");
        Part photo = request.getPart("photo");

        if (loai == "" || ten == "" || email == "" || diachi == ""
                || sodienthoai == "") {
            errorString = "Thông tin sản phẩm không được để tróng. Thêm Thất bại";

        }
        Person_NhaCungCap ps = new Person_NhaCungCap();

        ps.setLoai(loai);
        ps.setTen(ten);
        ps.setEmail(email);
        ps.setDiaChi(diachi);
        ps.setSDT(sodienthoai);
        ps.setIdPerson();

        Image img = new Image();

        if (photo.getSubmittedFileName().equals("")) {
            img.setURL("");
        } else {
            img.setURL(ps.getIdPerson() + ".png");
            //Mở folder lưu ảnh nhân viên
            File dir = new File(request.getServletContext().getRealPath("Image//Supplier"));
            //Lưu ảnh được chọn vào folder trước            
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            //Đổi tên ảnh được lưu trc đó thành id nhân viên
            File rename = new File(dir, img.getURL());
            photoFile.renameTo(rename);
        }
        ps.setImage(img);
        if (errorString == null) {
            nhaCungCapDAL.InsertNhaCungCap(ps);
        }

        request.setAttribute("errorString", errorString);

        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/view/ncc_form.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Nhacungcaplist");
        }
    }

    private void UpdateNCC(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String errorString = null;

        String loai = request.getParameter("loai");
        String ten = request.getParameter("ten");
        String email = request.getParameter("email");
        String diachi = request.getParameter("diachi");
        String sodienthoai = request.getParameter("sodienthoai");
        Part photo = request.getPart("photo");
        String idPerson = request.getParameter("idPerSon");
        NhaCungCapDAL nccdal = new NhaCungCapDAL();
        Person_NhaCungCap ps = nccdal.getNhaCungCap(idPerson);
//        System.out.println(ps);

        Image img = new Image();

        ps.setLoai(loai);
        ps.setTen(ten);
        ps.setEmail(email);
        ps.setDiaChi(diachi);
        ps.setSDT(sodienthoai);
//        ps.setIdPerson();
//        ps.setImage(img);

        System.out.println(photo.getSubmittedFileName().equals(""));
        System.out.println(ps.getImage());
        System.out.println(ps.getIdPerson());
        System.out.println(ps.getIdPerson());
//        System.out.println(img.getURL().equals(""));

        System.out.println("abc"+photo.getSubmittedFileName());

        if (loai == "" || ten == "" || email == "" || diachi == ""
                || sodienthoai == "") {
            errorString = "Thông tin sản phẩm không được để tróng. Thêm Thất bại";

        }
        if (photo.getSubmittedFileName().equals("")) {
            img = ps.getImage();
//            if (img.getURL().equals("")) {
            if ("".equals(img.getURL())) {
                img.setURL(photo.getSubmittedFileName());
                ps.setImage(img);
                nhaCungCapDAL.UpdateNhaCungCap(ps);
            } else {
                nhaCungCapDAL.UpdateNhaCungCap(ps);
            }
        } else {
            img = ps.getImage();
            if ("".equals(img.getURL())) {
                img.setURL(ps.getIdPerson() + ".png");
                ps.setImage(img);

                // đường dẫn thư mục tính từ gốc của website
                File dir = new File(request.getServletContext().getRealPath("Image//Supplier"));
                //Lưu ảnh được chọn vào folder trước            
                File photoFile = new File(dir, photo.getSubmittedFileName());
                photo.write(photoFile.getAbsolutePath());
                //Đổi tên ảnh được lưu trc đó thành id nhân viên
                File rename = new File(dir, ps.getIdPerson() + ".png");
                photoFile.renameTo(rename);

                nhaCungCapDAL.UpdateNhaCungCap(ps);
            } else {
                img.setURL(ps.getIdPerson() + ".png");
                ps.setImage(img);
                nhaCungCapDAL.UpdateNhaCungCap(ps);

                //Xóa file ảnh trước đó trong folder
                // đường dẫn thư mục tính từ gốc của website
                File dir = new File(request.getServletContext().getRealPath("Image//Supplier"));
                if (!dir.exists()) { // tạo nếu chưa tồn tạiup
                    dir.mkdirs();
                }
                File photoFile_del = new File(dir, img.getURL());
                photoFile_del.delete();

                //Lưu ảnh được chọn vào folder trước            
                File photoFile = new File(dir, photo.getSubmittedFileName());
                photo.write(photoFile.getAbsolutePath());
                //Đổi tên ảnh được lưu trc đó thành id nhân viên
                File rename = new File(dir, ps.getIdPerson() + ".png");
                photoFile.renameTo(rename);

            }
        }
        request.setAttribute("errorString", errorString);

        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/view/ncc_form.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("Nhacungcaplist");
        }
    }

}
