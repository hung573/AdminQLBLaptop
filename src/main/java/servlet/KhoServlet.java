/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.Kho;
import Bean.SanPham;
import DAL.KhoDAL;
import DAL.SanPhamDAL;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author mac
 */
@WebServlet(urlPatterns = {"/KhoList","/updateKho","/editkho"})
public class KhoServlet extends HttpServlet {
    private static final long serialVersionUID =1L;
    private KhoDAL khoDAL;
    public KhoServlet(){
        super();
    }
    
    public void init(){
        khoDAL = new KhoDAL();
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
                
                case "/editkho":
                    showEditFormKHO(request, response);
                    break;
                case "/updateKho":
                    updateKho(request, response);
                    break;     
                default:
                    listKho(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }   
    }
    private void listKho(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        String id = request.getParameter("keyword");
        int page = 1;
        if(request.getParameter("page") != null && request.getParameter("page") != ""){
            page = Integer.parseInt(request.getParameter("page"));
        }
        if(id != null){
            ArrayList < Kho > listkho = khoDAL.findbyIDKho(id, 3, page);
            long countRecord = khoDAL.TinhTongSLKhoSearch(id);
            double countPage = Math.ceil(countRecord/3);
            request.setAttribute("listKHO", listkho);
            request.setAttribute("countRecord", countRecord);
            request.setAttribute("countPage", countPage);
            request.setAttribute("page", page);
            request.setAttribute("id", id);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/kholist1.jsp");
            dispatcher.forward(request, response);
        }
        if(id == null){
            List <Kho> listkho = khoDAL.listKho(3,page);
            long countRecord = khoDAL.TinhTongSLkhoList();
            double countPage = Math.ceil(countRecord/3);
            
            request.setAttribute("listKHO", listkho);
            request.setAttribute("countRecord", countRecord);
            request.setAttribute("countPage", countPage);
            request.setAttribute("page", page);
            request.setAttribute("id", id);
            
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/kholist1.jsp");
            dispatcher.forward(request, response);
        }       
    }
    private void showEditFormKHO(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String IdKho = request.getParameter("idKho");
        Kho existingUser = khoDAL.getKho(Integer.parseInt(IdKho));
        request.setAttribute("kho", existingUser);
        RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/kho_form1.jsp");
        dispatcher.forward(request, response);
    }
    private void updateKho(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        
        String errorString = null;
        String idSanPham = request.getParameter("idSanPham");
        String idKho = request.getParameter("idKho");
        
        Kho k = khoDAL.getKho(Integer.parseInt(idKho));
        SanPhamDAL spdal = new SanPhamDAL();
        
        SanPham sp = spdal.getSanPham(idSanPham);
//        int idKhoo = Integer.parseInt(idKho);

        String giaNhap = request.getParameter("giaNhap");
        double giaNhapp = Double.parseDouble(giaNhap);
        String giaBan = request.getParameter("giaBan");
        double giaBann = Double.parseDouble(giaBan);
        String soLuong = request.getParameter("soLuong");
        int soLuongg = Integer.parseInt(soLuong);

        k.setGiaBan(giaBann);
        k.setGiaNhap(giaNhapp);
        k.setSoLuong(soLuongg);
//        k.setSanpham(sp);

//        Kho kho = new Kho(idKhoo,giaNhapp,giaBann,soLuongg);

        

        if( idKho == "" || idSanPham=="" ||giaBan == "" || giaNhap == "" || soLuong == ""){
            errorString = "Thông tin sản phẩm không được để tróng. UpDate Thất bại";

        }
        if(errorString == null){
            
            khoDAL.UpdateKho(k,idSanPham);
            
        }
        request.setAttribute("errorString", errorString);

        if(errorString != null){
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/view/kho_form.jsp");
            dispatcher.forward(request, response);
        }
        else{
            response.sendRedirect("KhoList");
        }
    }
   
}
