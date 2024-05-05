/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.Image;
import DAL.ImageDAL;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/ImageList"})

public class ImageServlet extends HttpServlet {
    private static final long serialVersionUID =1L;  
    private ImageDAL imageDAL;
    public ImageServlet(){
        super();
    }
    public void init(){
        imageDAL = new ImageDAL();
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
//                    showEditFormKHO(request, response);
                    break;
                case "/updateKho":
//                    updateKho(request, response);
                    break;     
                default:
                    listImage(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }   
    }
    private void listImage(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        String id = request.getParameter("keyword");
        int page = 1;
        if(request.getParameter("page") != null && request.getParameter("page") != ""){
            page = Integer.parseInt(request.getParameter("page"));
        }
        if(id != null){
            ArrayList < Image > listimg = imageDAL.findbyIDsanpham(id, 10, page);
            long countRecord = imageDAL.TinhTongSLImageSearch(id);
            double countPage = Math.ceil(countRecord/10 + 1);
            request.setAttribute("imgList", listimg);
            request.setAttribute("countRecord", countRecord);
            request.setAttribute("countPage", countPage);
            request.setAttribute("page", page);
            request.setAttribute("id", id);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/imagelist1.jsp");
            dispatcher.forward(request, response);
        }
        if(id == null){
            List <Image> listimg = imageDAL.listImage(10,page);
            long countRecord = imageDAL.TinhTongSLImageList();
            double countPage = Math.ceil(countRecord/10 + 1);
            
            request.setAttribute("imgList", listimg);
            request.setAttribute("countRecord", countRecord);
            request.setAttribute("countPage", countPage);
            request.setAttribute("page", page);
            request.setAttribute("id", id);
            
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/view/imagelist1.jsp");
            dispatcher.forward(request, response);
        }       
    }

}
