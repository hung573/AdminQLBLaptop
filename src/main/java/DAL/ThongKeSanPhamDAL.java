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
public class ThongKeSanPhamDAL {
      Session session;
      public ThongKeSanPhamDAL(){
          session = HibernateUtils.getSessionFactory().openSession();
      }
        public List<Object[]> thongKeTop10SanPham() {
            try (Session session = HibernateUtils.getSessionFactory().openSession()) {
                String hql = "SELECT sp.TenSanPham, SUM(hdct.SoLuongDat) AS TongSoLuongDat " +
                             "FROM HoaDonChiTiet hdct " +
                             "JOIN SanPham sp ON hdct.sanpham.IdSanPham = sp.IdSanPham " +
                             "GROUP BY sp.TenSanPham " +
                             "ORDER BY TongSoLuongDat DESC";

                Query<Object[]> query = session.createQuery(hql);
                query.setMaxResults(10);

                return query.list();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        public static void main(String[] args) {
           ThongKeSanPhamDAL thongKeSanPhamDAL = new ThongKeSanPhamDAL();
           List<Object[]> result = thongKeSanPhamDAL.thongKeTop10SanPham();

           if (result != null) {
               for (Object[] row : result) {
                   String tenSanPham = (String) row[0];
                   long tongSoLuongDat = (long) row[1];
                   System.out.println("Tên Sản Phẩm: " + tenSanPham + ", Tổng Số Lượng Đặt: " + tongSoLuongDat);
               }
           }
       }
}
