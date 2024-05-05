/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Util.HibernateUtils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author MY COMPUTER
 */
public class ThongKeKhachHangDAL {
      Session session;
        public ThongKeKhachHangDAL(){
          session = HibernateUtils.getSessionFactory().openSession();
      }
 public List<Object[]> thongKeTop5KhachHang() {
        try {
            session.beginTransaction();

            String hql = "SELECT p.IdPerson, p.Ten, SUM(hd.ThanhTien) AS TongThanhTien\n" +
                        "FROM Bean.Person p\n" +
                        "JOIN Bean.Person_KhachHang kh ON p.IdPerson = kh.IdPerson\n" +
                        "JOIN Bean.HoaDon hd ON kh = hd.khachhang\n" +
                        "GROUP BY p.IdPerson, p.Ten\n" +
                        "ORDER BY TongThanhTien DESC";

            Query<Object[]> query = session.createQuery(hql);
            query.setMaxResults(5);

            List<Object[]> result = query.list();

            session.getTransaction().commit();

            return result;
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;
        } 
 }
         public static void main(String[] args) {
        ThongKeKhachHangDAL thongKeKhachHangDAL = new ThongKeKhachHangDAL();

        List<Object[]> result = thongKeKhachHangDAL.thongKeTop5KhachHang();

        if (result != null) {
            System.out.println("Top 5 Khach Hang:");
            for (Object[] row : result) {
                System.out.println("IdPerson: " + row[0] + ", Ten: " + row[1] + ", TongThanhTien: " + row[2]);
            }
        } else {
            System.out.println("Khong co ket qua.");
        }

       
    }
}
