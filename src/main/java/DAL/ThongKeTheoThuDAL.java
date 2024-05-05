/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Util.HibernateUtils;
import java.util.Collections;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author MY COMPUTER
 */
public class ThongKeTheoThuDAL {
    
    Session session;

    public ThongKeTheoThuDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

public double totalMoneyDay(int day) {
    try {
        if (day == 8) {
            // Xử lý riêng cho Chủ Nhật
            String hqlSunday = "SELECT SUM(hd.ThanhTien) FROM HoaDon hd WHERE DAYOFWEEK(hd.NgayLap) = 1";
            Query<Double> querySunday = session.createQuery(hqlSunday, Double.class);
            Double resultSunday = querySunday.uniqueResult();
            return resultSunday != null ? resultSunday : 0;
        } else {
            // Xử lý cho các ngày khác
            String hql = "SELECT SUM(hd.ThanhTien) FROM HoaDon hd WHERE DAYOFWEEK(hd.NgayLap) = :day";
            Query<Double> query = session.createQuery(hql, Double.class);
            query.setParameter("day", day);
            Double result = query.uniqueResult();
            return result != null ? result : 0;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return 0;
}

    public static void main(String[] args) {
        ThongKeTheoThuDAL thongKeDAL = new ThongKeTheoThuDAL();

    // Ví dụ: Lấy tổng tiền cho thứ 3
    double totalMoney = thongKeDAL.totalMoneyDay(4);
    System.out.println("Tổng tiền cho thứ 4: " + totalMoney);
        }
    }

