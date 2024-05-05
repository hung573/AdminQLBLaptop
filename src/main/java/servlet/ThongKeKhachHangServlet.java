/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAL.ThongKeKhachHangDAL;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mac
 */
@WebServlet(urlPatterns = {"/ThongKeKhachHangServlet"})
public class ThongKeKhachHangServlet extends HttpServlet {
    private  static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         ThongKeKhachHangDAL thongKeKhachHangDAL = new ThongKeKhachHangDAL();
        List<Object[]> result = thongKeKhachHangDAL.thongKeTop5KhachHang();

        if (result != null) {
//            request.setAttribute("thongkeList", result);
            request.getRequestDispatcher("/view/ThongKeKhachHang.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
