/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author MY COMPUTER
 */
public class ThongKeTheoThangDAL {
          Session session;
    public ThongKeTheoThangDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

public double totalMoneyMonth(int month) {
        try {
            // Sử dụng tham số :month trong HQL để tránh SQL Injection
            String hql = "SELECT SUM(hd.ThanhTien) " +
                         "FROM HoaDon hd " +
                         "WHERE MONTH(hd.NgayLap) = :month";

            Query<Double> query = session.createQuery(hql, Double.class);
            query.setParameter("month", month);

            // Trả về tổng tiền theo tháng
            // Trả về tổng tiền theo tháng, hoặc 0 nếu không có doanh thu
        Double result = query.uniqueResult();
        return result != null ? result : 0;
    } catch (Exception e) {
        e.printStackTrace();
    }
   
        return 0;
    }

     public static void main(String[] args) {
        ThongKeTheoThangDAL thongKeDAL = new ThongKeTheoThangDAL();
        
        // Ví dụ: Lấy tổng tiền cho tháng 12
        double totalMoney = thongKeDAL.totalMoneyMonth(11);
        System.out.println("Tổng tiền cho tháng 11: " + totalMoney);
    }
    }

