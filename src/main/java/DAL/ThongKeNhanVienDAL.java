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
public class ThongKeNhanVienDAL {
      Session session;
     public  ThongKeNhanVienDAL(){
          session = HibernateUtils.getSessionFactory().openSession();
     }
          
 public List<Object[]> thongKeTop5NhanVien() {
        try {
            session.beginTransaction();
//  String hql = "SELECT p.IdPerson, p.Ten, SUM(hd.ThanhTien) AS TongThanhTien\n" +
//                        "FROM Beans.Person p\n" +
//                        "JOIN Beans.Person_KhachHang kh ON p.IdPerson = kh.IdPerson\n" +
//                        "JOIN Beans.HoaDon hd ON kh = hd.khachhang\n" +
//                        "GROUP BY p.IdPerson, p.Ten\n" +
//                        "ORDER BY TongThanhTien DESC";
String hql = "SELECT p.IdPerson, p.Ten, COUNT(hd.nhanvien.IdPerson) AS SoLuongDonHang, SUM(hd.ThanhTien) AS TongThanhTien\n" +
            "FROM Bean.Person_NhanVien p\n" +
            "JOIN Bean.HoaDon hd ON p.IdPerson = hd.nhanvien.IdPerson\n" +
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
        ThongKeNhanVienDAL DAL = new ThongKeNhanVienDAL();

        List<Object[]> result = DAL.thongKeTop5NhanVien();

        if (result != null) {
            System.out.println("Top 5 Nhân Viên:");
            for (Object[] row : result) {
                System.out.println("IdPerson: " + row[0] + ", Ten: " + row[1] + ", So Luong Don: " + row[2] + ", TongThanhTien: " + row[3]);
            }
        } else {
            System.out.println("Khong co ket qua.");
        }
    }
}
