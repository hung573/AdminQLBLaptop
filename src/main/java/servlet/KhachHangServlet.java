/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.Account;
import Bean.Image;
import Bean.Person_KhachHang;
import DAL.KhachHangDAL;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author mac
 */
@MultipartConfig(maxFileSize = -1L, maxRequestSize = -1L)
@WebServlet(name = "KhachHangServlet", urlPatterns = {"/KhachHangServlet", "/newKhachHang",
    "/editKhachHang", "/search",
    "/action=createkh","/action=updatekh"})
public class KhachHangServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private List<Person_KhachHang> listkhachHangs;
    KhachHangDAL dal = new KhachHangDAL();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {

            switch (action) {
                case "/KhachHangServlet":
                    ListKhachHang(request, response);
                    break;
                case "/newKhachHang":
                    Newkhachhang(request, response);
                    break;
                case "/editKhachHang":
                    Editkhachhang(request, response);
                    break;
                case "/search":
                    searchKhachHang(request, response);
                    break;
                case "/action=createkh":
                    create(request, response);
                    break;
                case "/action=updatekh":
                    updatekh(request, response);
                    break;
                default:
                    break;
            }
        } catch (Error e) {
            throw new ServletException(e);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void ListKhachHang(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        KhachHangDAL dal = new KhachHangDAL();
        List<Person_KhachHang> list = dal.loadKhachHang();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/khachhanglist1.jsp").forward(request, response);
    }

    private void Newkhachhang(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/khachhangform1.jsp").forward(request, response);
    }

    private void Editkhachhang(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("submit");
        KhachHangDAL dal = new KhachHangDAL();
        Person_KhachHang kh = dal.getKhachHang(id);
        request.setAttribute("KhachHang", kh);
        request.getRequestDispatcher("/view/khachhangform1.jsp").forward(request, response);
    }

    private void searchKhachHang(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("textTim");
        KhachHangDAL dal = new KhachHangDAL();
        List<Person_KhachHang> list = dal.loadKhachHang();
        List<Person_KhachHang> listfind = new ArrayList<>();
        for (Person_KhachHang kh : list) {
            if (kh.getTen().contains(keyword)) {
                listfind.add(kh);
            }
        }
        if (!listfind.isEmpty()) {
            request.setAttribute("listfind", listfind);
        } else {
            request.setAttribute("listfind", list);
        }
        request.getRequestDispatcher("/view/khachhanglist1.jsp").forward(request, response);

    }

    private void create(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        Person_KhachHang khachhang = new Person_KhachHang();
        String ten = request.getParameter("name");
        String email = request.getParameter("Email");
        String diachi = request.getParameter("address");
        String sdt = request.getParameter("phone");
        String xephang = "1";
        double tichluy = 0;
//        System.out.println(ten);
        khachhang.setTen(ten);
        khachhang.setEmail(email);
        khachhang.setDiaChi(diachi);
        khachhang.setSDT(sdt);
        khachhang.setXepHang(xephang);
        khachhang.setDiemTichLy(tichluy);
        khachhang.setIdPerson();

        Account acc = new Account();
        acc.setUserName("");
        acc.setPassword("");
        khachhang.setAccount(acc);

        Image img = new Image();
        //Phía folder ảnh khách hàng
        //Check người dùng có chọn ảnh ko
        Part photo = (Part) request.getPart("photo");
        if (photo.getSubmittedFileName().equals("")) {
            img.setURL("");
            khachhang.setImage(img);

            KhachHangDAL dAL = new KhachHangDAL();
            dAL.addKhachHang(khachhang);
        } else {
            img.setURL(khachhang.getIdPerson() + ".png");
            //Mở folder lưu ảnh khách hàng
            File dir = new File(request.getServletContext().getRealPath("Image//Customer"));
            //Lưu ảnh được chọn vào folder trước            
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            //Đổi tên ảnh được lưu trc đó thành id khách hàng
            File rename = new File(dir, img.getURL());
            photoFile.renameTo(rename);

        }
        khachhang.setImage(img);

        KhachHangDAL dal2 = new KhachHangDAL();
        dal2.addKhachHang(khachhang);
        List<Person_KhachHang> listkh = dal.loadKhachHang();
        request.setAttribute("list", listkh);
        request.getRequestDispatcher("/view/khachhanglist1.jsp").forward(request, response);
    }

    private void updatekh(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String idkhachhang = request.getParameter("submit");
            KhachHangDAL dal = new KhachHangDAL();
            Person_KhachHang kh = dal.getKhachHang(idkhachhang);

            String ten = request.getParameter("name");
            String email = request.getParameter("Email");
            String diachi = request.getParameter("address");
            String sdt = request.getParameter("phone");
//            System.out.println("abc"+idkhachhang);
            kh.setTen(ten);
            kh.setEmail(email);
            kh.setDiaChi(diachi);
            kh.setSDT(sdt);
            kh.getDiemTichLuy();
            kh.getXepHang();

            Part photo = request.getPart("photo");
            if(photo.getSubmittedFileName().equals("")){
                Image img = kh.getImage();
                if(img.getURL().equals("")){
                    img.setURL(photo.getSubmittedFileName());
                    kh.setImage(img);
                    dal.updateKhachHang(kh);    
                }else{
                    dal.updateKhachHang(kh);   
                }                            
            }
            else{
                Image img = kh.getImage();
                if(img.getURL().equals("")){
                    img.setURL(kh.getIdPerson()+".png");
                    kh.setImage(img);
                    
                    
//                    // đường dẫn thư mục tính từ gốc của website
                    File dir = new File(request.getServletContext().getRealPath("Image//Customer"));
//                    //Lưu ảnh được chọn vào folder trước            
                    File photoFile = new File(dir, photo.getSubmittedFileName());
                    photo.write(photoFile.getAbsolutePath());
//                    //Đổi tên ảnh được lưu trc đó thành id nhân viên
                    File rename = new File(dir, kh.getIdPerson()+".png");
                    photoFile.renameTo(rename);
//                    
                    dal.updateKhachHang(kh);
                }else{
                    img.setURL(kh.getIdPerson()+".png");
                    kh.setImage(img);
                    dal.updateKhachHang(kh);
                    
                    //Xóa file ảnh trước đó trong folder
                    // đường dẫn thư mục tính từ gốc của website
                    File dir = new File(request.getServletContext().getRealPath("Image//Customer"));
                    if(!dir.exists()) { // tạo nếu chưa tồn tạiup
                        dir.mkdirs();
                    }
                    File photoFile_del = new File(dir, img.getURL());
                    photoFile_del.delete();

                    //Lưu ảnh được chọn vào folder trước            
                    File photoFile = new File(dir, photo.getSubmittedFileName());
                    photo.write(photoFile.getAbsolutePath());
                    //Đổi tên ảnh được lưu trc đó thành id nhân viên
                    File rename = new File(dir, kh.getIdPerson()+".png");
                    photoFile.renameTo(rename);
                }
            }

            KhachHangDAL dAL = new KhachHangDAL();
            List<Person_KhachHang> list = dAL.loadKhachHang();
            request.setAttribute("list", list);
             request.getRequestDispatcher("/view/khachhanglist1.jsp").forward(request, response);
        } catch (Exception e) {
        }

    }

}
