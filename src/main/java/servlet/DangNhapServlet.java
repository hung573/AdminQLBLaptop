/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import Bean.Account;
import Bean.Image;
import Bean.Person;
import Bean.Person_NhanVien;
import Bean.SanPham;
import DAL.AccountDAL;
import DAL.SanPhamDAL;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 *
 * @author mac
 */
@WebServlet(urlPatterns = {"/DangNhap","/DangXuat","/login"})

public class DangNhapServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Account account;
    private AccountDAL accountDAL;
    private Person_NhanVien person_NhanVien;
    private Person person;

    public DangNhapServlet() {
        super();
    }

    public void init() {
        account = new Account();
        accountDAL = new AccountDAL();
        person_NhanVien = new Person_NhanVien();
        person = new Person() {
        };
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
                case "/DangXuat":
                    DangXuat(request, response);
                    break;
                case "/login":
                    Logiin(request, response);
                    break;
                default:
                    DangNhap(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void DangNhap(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/view/login.jsp");
        dispatcher.forward(request, response);
    }

    private void Logiin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        try {
            HttpSession session = request.getSession();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String erro = null;

            boolean checkLogin = accountDAL.CheckLogin(username, password);

            if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
                erro = "Tài Khoản hoặc mật khẩu không được để tróng";
                request.setAttribute("erro", erro);
//                response.sendRedirect("login");
                RequestDispatcher dispatcher =request.getServletContext()
                        .getRequestDispatcher("/view/login.jsp");
                dispatcher.forward(request, response);
            } else if (checkLogin == false) {
                erro = "Tài khoản này không tồn tại";
                request.setAttribute("erro", erro);
                RequestDispatcher dispatcher = request.getServletContext()
                        .getRequestDispatcher("/view/login.jsp");
                dispatcher.forward(request, response);
            } else {
                Account ac = accountDAL.getIdAccountByUsername(username);
                int idAccouunt = ac.getIdAccount();
                Person_NhanVien psNhanVien = accountDAL.getIDPerson_NhanVien(idAccouunt);
                boolean checkTrangthai = accountDAL.CheckNhanVien(psNhanVien.getIdPerson());
                boolean checkBoPhan = accountDAL.CheckBoPhan(psNhanVien.getIdPerson());
                boolean checkQuanLy = accountDAL.CheckQuanLy(psNhanVien.getIdPerson());
                if (checkTrangthai == false) {
                    erro = "Tài khoản này đã bị khoá";
                    request.setAttribute("erro", erro);
                    RequestDispatcher dispatcher = request.getServletContext()
                            .getRequestDispatcher("/view/login.jsp");
                    dispatcher.forward(request, response);
                } else {
                    if (checkQuanLy == true) {
                        session.setAttribute("checkBoPhan", checkBoPhan);
                        session.setAttribute("checkQuanLy", checkQuanLy);
                        session.setAttribute("ac", ac);
                        session.setAttribute("username", username);
                        session.setAttribute("password", password);
                        session.setAttribute("session", session);
                        session.setAttribute("psNhanVien", psNhanVien);

                        RequestDispatcher dispatcher = request.getServletContext()
                                .getRequestDispatcher("/view/homeView.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        if (checkBoPhan == true) {
                            //Bộ Phận Bán Hàng
                            session.setAttribute("checkBoPhan", checkBoPhan);
                            session.setAttribute("checkQuanLy", checkQuanLy);
                            session.setAttribute("ac", ac);
                            session.setAttribute("username", username);
                            session.setAttribute("password", password);
                            session.setAttribute("session", session);
                            session.setAttribute("psNhanVien", psNhanVien);

                            RequestDispatcher dispatcher = request.getServletContext()
                                    .getRequestDispatcher("/view/homeView.jsp");
                            dispatcher.forward(request, response);
                        } else {
                            //Bộ Phần Kho Vận
                            session.setAttribute("checkBoPhan", checkBoPhan);
                            session.setAttribute("checkQuanLy", checkQuanLy);
                            session.setAttribute("ac", ac);
                            session.setAttribute("username", username);
                            session.setAttribute("password", password);
                            session.setAttribute("session", session);
                            session.setAttribute("psNhanVien", psNhanVien);

                            RequestDispatcher dispatcher = request.getServletContext()
                                    .getRequestDispatcher("/view/homeView.jsp");
                            dispatcher.forward(request, response);
                        }
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void DangXuat(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        PrintWriter logout = response.getWriter();
        try {
            HttpSession session = request.getSession();
//            session.removeAttribute("username");
//            session.removeAttribute("password");
            session.invalidate();

            RequestDispatcher dispatcher = request.getServletContext().
                    getRequestDispatcher("/view/homeView.jsp");
            dispatcher.forward(request, response);
        } finally {
            logout.close();
        }

    }

    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
