/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.Account;
import Bean.Image;
import Bean.Person_NhanVien;
import DAL.NhanVienDAL;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@MultipartConfig(maxFileSize = -1L, maxRequestSize = -1L )
@WebServlet(urlPatterns = {"/NhanVienList",
    "/action=createfrom","/action=editfrom",
    "/action=change","/action=seacrh",
    "/action=create","/action=update"})
public class NhanVienServlet extends HttpServlet {

    private NhanVienDAL nhanvienDAL;
    private  static final long serialVersionUID = 1L;
            
    public void init(){
        nhanvienDAL = new NhanVienDAL();
        
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

                case "/action=createfrom":
                    request.getRequestDispatcher("/view/nhanvienfrom.jsp").forward(request, response);
                    break;
                case "/action=editfrom":
                    editNhanvien(request, response);
                    break;
                case "/action=change":
                    changeTTNhanVien(request, response);
                    break;
                case "/action=seacrh":
                    searchNhanVien(request, response);
                    break;
                case "/NhanVienList":
                    listNV(request, response);
                    break;
                case "/action=create":
                    createNhanVien(request, response);
                    break;
                case "/action=update":
                    updateNhanVien(request, response);
                    break;
                default:
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        } catch (ParseException ex) {
            Logger.getLogger(NhanVienServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void listNV(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        List<Person_NhanVien> list = nhanvienDAL.loadNhanVien();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/view/nhanvienlist.jsp").forward(request, response);  

    }
    private void editNhanvien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
            String id = request.getParameter("submit");
            NhanVienDAL dal = new NhanVienDAL();
            Person_NhanVien nv = dal.getNhanVien(id);
            request.setAttribute("nhanvien", nv);
            request.getRequestDispatcher("/view/nhanvienfrom.jsp").forward(request, response);

    }
    private void changeTTNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
            String id = request.getParameter("submit");
            NhanVienDAL dal = new NhanVienDAL();
            Person_NhanVien nv = dal.getNhanVien(id);
            if(nv.getTrangThai().equals("0")){
                nv.setTrangThai("1");
            }else{
                nv.setTrangThai("0");
            }
            dal.updateNhanVien(nv);
            List<Person_NhanVien> list = dal.loadNhanVien();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/view/nhanvienlist.jsp").forward(request, response);
//            response.sendRedirect("NhanVienList");


    }
    private void searchNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
            String keyword = request.getParameter("textTim");
        NhanVienDAL dal = new NhanVienDAL();
        List<Person_NhanVien> list = dal.loadNhanVien();
        List<Person_NhanVien> listfind = new ArrayList<>();
        for(Person_NhanVien nv :list){
            if(nv.getTen().contains(keyword)){
                listfind.add(nv);
            }
        }
        if(!listfind.isEmpty()){
            request.setAttribute("listfind", listfind);
        }else{
            request.setAttribute("listfind", list);
        }
        request.getRequestDispatcher("/view/nhanvienlist.jsp").forward(request, response);

    }
    private void createNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        String ten = request.getParameter("Ten");
        String email = request.getParameter("Email");
        String diaChi = request.getParameter("Diachi");
        String SDT = request.getParameter("SDT");
        String ngaySinh = request.getParameter("NgaySinh");        
        String boPhan = request.getParameter("BoPhan");
        String chucVu = request.getParameter("ChucVu");
        String trangThai = request.getParameter("TrangThai");
        
        Person_NhanVien nv = new Person_NhanVien();
        nv.setTen(ten);
        nv.setNgaySinh(dateFormat.parse(ngaySinh));
        nv.setEmail(email);
        nv.setDiaChi(diaChi);
        nv.setSDT(SDT);
        nv.setBoPhan(boPhan);
        nv.setChucVu(chucVu);
        nv.setTrangThai(trangThai);
        nv.setIdPerson();
        System.out.println(ten);
        Account ac = new Account();
        ac.setUserName("");
        ac.setPassword("");
        nv.setAccount(ac);
        
        Image img = new Image();
        
        //Phía folder ảnh nhân viên
        //Check người dùng có chọn ảnh ko
        Part photo = request.getPart("photo");
        if(photo.getSubmittedFileName().equals("")){
            img.setURL("");
        }else{
            img.setURL(nv.getIdPerson()+".png");
            //Mở folder lưu ảnh nhân viên
            File dir = new File(request.getServletContext().getRealPath("Image//Employee"));
            //Lưu ảnh được chọn vào folder trước            
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            //Đổi tên ảnh được lưu trc đó thành id nhân viên
            File rename = new File(dir, img.getURL());
            photoFile.renameTo(rename);
        }
        nv.setImage(img);       

        NhanVienDAL dal = new NhanVienDAL();
        dal.addNhanVien(nv);
        
        
        List<Person_NhanVien> listnv = dal.loadNhanVien();
        request.setAttribute("list", listnv);
        request.getRequestDispatcher("/view/nhanvienlist.jsp").forward(request, response);

    }
    private void updateNhanVien(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException, ParseException {
        try {
            String id = request.getParameter("submit");
            NhanVienDAL dal = new NhanVienDAL();
            Person_NhanVien nv = dal.getNhanVien(id);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String ten = request.getParameter("Ten");
            String email = request.getParameter("Email");
            String diaChi = request.getParameter("Diachi");
            String SDT = request.getParameter("SDT");
            String ngaySinh = request.getParameter("NgaySinh");        
            String boPhan = request.getParameter("BoPhan");
            String chucVu = request.getParameter("ChucVu");
            String trangThai = request.getParameter("TrangThai");
            
            nv.setTen(ten);
            nv.setEmail(email);
            nv.setDiaChi(diaChi);
            nv.setSDT(SDT);
            nv.setNgaySinh(dateFormat.parse(ngaySinh));           
            nv.setBoPhan(boPhan);
            nv.setChucVu(chucVu);
            nv.setTrangThai(trangThai);


            //Phía folder ảnh nhân viên
            //Check người dùng có chọn ảnh ko            
            Part photo = request.getPart("photo");
            if(photo.getSubmittedFileName().equals("")){
                Image img = nv.getImage();
                if(img.getURL().equals("")){
                    img.setURL(photo.getSubmittedFileName());
                    nv.setImage(img);
                    dal.updateNhanVien(nv);    
                }else{
                    dal.updateNhanVien(nv);   
                }                            
            }
            else{
                Image img = nv.getImage();
                if(img.getURL().equals("")){
                    img.setURL(nv.getIdPerson()+".png");
                    nv.setImage(img);
                    
                    
                    // đường dẫn thư mục tính từ gốc của website
                    File dir = new File(request.getServletContext().getRealPath("Image//Employee"));
                    //Lưu ảnh được chọn vào folder trước            
                    File photoFile = new File(dir, photo.getSubmittedFileName());
                    photo.write(photoFile.getAbsolutePath());
                    //Đổi tên ảnh được lưu trc đó thành id nhân viên
                    File rename = new File(dir, nv.getIdPerson()+".png");
                    photoFile.renameTo(rename);
                    
                    dal.updateNhanVien(nv);
                }else{
                    img.setURL(nv.getIdPerson()+".png");
                    nv.setImage(img);
                    dal.updateNhanVien(nv);
                    
                    //Xóa file ảnh trước đó trong folder
                    // đường dẫn thư mục tính từ gốc của website
                    File dir = new File(request.getServletContext().getRealPath("Image//Employee"));
                    if(!dir.exists()) { // tạo nếu chưa tồn tạiup
                        dir.mkdirs();
                    }
                    File photoFile_del = new File(dir, img.getURL());
                    photoFile_del.delete();

                    //Lưu ảnh được chọn vào folder trước            
                    File photoFile = new File(dir, photo.getSubmittedFileName());
                    photo.write(photoFile.getAbsolutePath());
                    //Đổi tên ảnh được lưu trc đó thành id nhân viên
                    File rename = new File(dir, nv.getIdPerson()+".png");
                    photoFile.renameTo(rename);

                    
                }
            }
            
            NhanVienDAL dal2 = new NhanVienDAL();
            List<Person_NhanVien> listnew = dal2.loadNhanVien();
            request.setAttribute("list", listnew);
            request.getRequestDispatcher("/view/nhanvienlist.jsp").forward(request, response);
            
        } catch (Exception e) {
        }
    }

}
