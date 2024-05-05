/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;


import Bean.Image;
import Bean.Kho;
import Bean.SanPham;
import Util.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
/**
 *
 * @author mac
 */
public class SanPhamDAL {
    Session session;
    public SanPhamDAL(){
        session = HibernateUtils.getSessionFactory().openSession();
    }

    @SuppressWarnings("unchecked") 
    public List<SanPham> listSanPham(int limit, int page) {
        Transaction transaction = null;
        List<SanPham> sanphamList = new ArrayList<>();
        int offset = (page - 1) * limit;
        try {
            transaction = session.beginTransaction();

            Query query = session.createQuery("from SanPham");
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            
            sanphamList = query.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sanphamList;
    }
    
    public ArrayList<SanPham> findbyIDsanpham(String tensp, int limit, int page) {
        Transaction transaction = null;
        ArrayList<SanPham> sp = new ArrayList<>();
        int offset = (page - 1) * limit;

        try {
            transaction = session.beginTransaction();

            String hql = "FROM SanPham AS sp WHERE sp.TenSanPham LIKE :tensp";
            Query query = session.createQuery(hql);
            query.setParameter("tensp", "%" + tensp + "%");
            query.setFirstResult(offset);
            query.setMaxResults(limit);

            sp = (ArrayList<SanPham>) query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return sp;
    }
    public ArrayList<SanPham> findbyMauSanPham(String mausp,int limit, int page) {
        Transaction transaction = null;
        ArrayList<SanPham> sp = new ArrayList<>();
        int offset = (page - 1) * limit;

        try {
            transaction = session.beginTransaction();

            String hql = "FROM SanPham AS sp WHERE sp.Mau LIKE :mausp";
            Query query = session.createQuery(hql);
            query.setParameter("mausp", "%" + mausp + "%");
            query.setFirstResult(offset);
            query.setMaxResults(limit);

            sp = (ArrayList<SanPham>) query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return sp;
    }
    public ArrayList<SanPham> findbyGiaBan(String giaBann,int limit, int page) {
    Transaction transaction = null;
    ArrayList<SanPham> sp = new ArrayList<>();
    double giaBan = Double.parseDouble(giaBann);
    int offset = (page - 1) * limit;

    try {
        transaction = session.beginTransaction();

        String hql = "SELECT sp FROM SanPham sp JOIN sp.kho  WHERE sp.kho.GiaBan = :GiaBan";
//        String hql = "SELECT sp FROM SanPham sp JOIN sp.kho k WHERE k.GiaBan = (SELECT MIN(kh.GiaBan) FROM Kho kh)";


        Query query = session.createQuery(hql);
        query.setParameter("GiaBan", giaBan);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        sp = (ArrayList<SanPham>) query.getResultList();
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
    return sp;
}

    
    public long TinhTongSLSPSearchTen(String tensp) {
        Transaction transaction = null;
        long tinhthong = 0;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM SanPham AS sp WHERE sp.TenSanPham LIKE :tensp";
            Query query = session.createQuery(hql);
            query.setParameter("tensp", "%" + tensp + "%");
            tinhthong = (long) query.uniqueResult(); // Cast the result to long
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return tinhthong;
    }
    public long TinhTongSLSPSearchGia(String giaBann) {
        Transaction transaction = null;
        long tinhthong = 0;
        double giaBan = Double.parseDouble(giaBann);
        try {
               transaction = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM SanPham sp JOIN sp.kho WHERE sp.kho.GiaBan = :giaBan";
            Query query = session.createQuery(hql);
            query.setParameter("giaBan", giaBan);
            tinhthong = (long) query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return tinhthong;
    }
    public long TinhTongSLSPSearchMau(String mausp) {
        Transaction transaction = null;
        long tinhthong = 0;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM SanPham AS sp WHERE sp.Mau LIKE :mausp";
            Query query = session.createQuery(hql);
            query.setParameter("mausp", "%" + mausp + "%");
            tinhthong = (long) query.uniqueResult(); // Cast the result to long
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return tinhthong;
    }
    public long TinhTongSLSPList() {
        Transaction transaction = null;
        long tinhthong = 0;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM SanPham";
            Query query = session.createQuery(hql);
            tinhthong = (long) query.uniqueResult(); // Cast the result to long
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return tinhthong;
    }
    public String[] listThuongHieu() {
        Transaction transaction = null;
        String[] thuongHieuArray= null;

        try {
            transaction = session.beginTransaction();

            String hql = "SELECT thuongHieu FROM SanPham WHERE thuongHieu IS NOT NULL"; // Lấy cột "thuongHieu"
            Query query = session.createQuery(hql);

            List<String> thuongHieuList = query.list();
                thuongHieuArray = thuongHieuList.toArray(new String[thuongHieuList.size()]);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return thuongHieuArray;
    }


     public SanPham getSanPham(String IdSanPham){
        Transaction transaction = null;
        SanPham sp = null;
        try {
            transaction = session.beginTransaction();
            sp = session.get(SanPham.class, IdSanPham);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return sp;
    }
   
    public void InsertSanPham(SanPham sp, String giaban, String gianhap, String soluong){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            sp.setIdSanPham(this.SetIdSanPham(sp));

            Kho kho = new Kho();
            
            kho.setGiaBan(Double.parseDouble(giaban));
            kho.setGiaNhap(Double.parseDouble(gianhap));
            kho.setSoLuong(Integer.parseInt(soluong));
            
//            kho.setSanpham(sp);
            sp.setKho(kho);
            session.save(sp);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public void UpdateSanPham(SanPham sp,String id, String giaban, String gianhap, String soluong
            ,List<String> URL1){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            
            Kho kho = new Kho();
//            sp.setListimage(this.imageSanPham(sp));
            kho.setIdKho(Integer.parseInt(id));
            kho.setGiaBan(Double.parseDouble(giaban));
            kho.setGiaNhap(Double.parseDouble(gianhap));
            kho.setSoLuong(Integer.parseInt(soluong));
//            kho.setSanpham(sp);
//            String joinedUrls = String.join(",", URL1);
            for(String url : URL1){
                
                Image img = new Image();

                img.setURL(url);
                img.setSanpham(sp);
                sp.getListimage().add(img);
                
            }

            sp.setKho(kho);
            session.merge(sp);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public void DeleteSanPham(String id){
        Transaction transaction = null;
        try {
             transaction = session.beginTransaction();

            // Delete a user object
            SanPham sp = session.get(SanPham.class, id);
            
            if (sp != null) {
                session.delete(sp);
                System.out.println("user is deleted");
            }

            // commit transaction\
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    private String SetIdSanPham(SanPham sp){
        List<SanPham> list = session.createQuery("FROM SanPham  WHERE  ThuongHieu LIKE :name")
                .setParameter("name","%" + sp.getThuongHieu() + "%" ).list();
        String id ="LT"+sp.getThuongHieu().substring(0,2);
        if(list.isEmpty()){
            id+= "0001";
        }else{
            SanPham check = list.get(list.size()-1);
            int num = Integer.parseInt(check.getIdSanPham().substring(4, 8))+1;
            int temp =num;
            int checknum;      
            int c = 1;
            while(num>0){
                checknum = num/c;
                if(checknum>0){
                    c = c*10;   
                }
                num = num/c;
            }
            switch (c) {
                case 10:
                    id +="000"+temp;
                    break;
                case 100:
                    id +="00"+temp;
                    break;
                case 1000:
                    id +="0"+temp;
                    break;
                case 10000:
                    id +=""+temp;
                    break;   
            }
        }      
        return id.toUpperCase();
    }
//    public List<Image> imageSanPham(SanPham sp){
////        SanPham sp  = new SanPham();
//        Transaction transaction = null;
//        List url = new ArrayList();
//        try{        
//            transaction =session.beginTransaction();
////            sp =session.get(SanPham.class, id);
//            List<Image> listimage = sp.getListimage();
//            for (Image image : listimage) {
//               String urll = image.getURL();
//                url.add(urll);
//            }
//            System.out.println(url);
//            transaction.commit();
//        }catch(Throwable ex){
//            System.out.println(ex);
//        }
//        return url;
//    }
//    public List<Image> imageSanPham(SanPham sp) {
//        Transaction transaction = null;
//        List urlList = new ArrayList<>();
//
//        try {
//            // Mở phiên
//            transaction = session.beginTransaction();
//
//            // Lấy danh sách image từ SanPham
//            List<Image> listImage = sp.getListimage();
//
//            // Lấy danh sách URL và thêm vào urlList
//            for (Image image : listImage) {
//                String url = image.getURL();
//                urlList.add(url);
//            }
//
//            // In danh sách URL
//            System.out.println(urlList);
//
//            // Commit giao dịch
//            transaction.commit();
//        } catch (Throwable ex) {
//            if (transaction != null && transaction.isActive()) {
//                // Rollback nếu có lỗi
//                transaction.rollback();
//            }
//            System.out.println(ex);
//        } 
//
//        return urlList;
//    }
    public ArrayList<SanPham> findbyGiaBanTrongKhoang(String khoangbee,String khoanglonn,int limit, int page ) {
        Transaction transaction = null;
        ArrayList<SanPham> sp = new ArrayList<>();
        double khoangbe = Double.parseDouble(khoangbee);
        double khoanglon = Double.parseDouble(khoanglonn);
        int offset = (page - 1) * limit;

        try {
            transaction = session.beginTransaction();

            String hql = "SELECT sp FROM SanPham sp JOIN sp.kho  WHERE sp.kho.GiaBan BETWEEN :khoangbe AND :khoanglon";

            Query query = session.createQuery(hql);
            query.setParameter("khoangbe", khoangbe);
            query.setParameter("khoanglon", khoanglon);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            sp = (ArrayList<SanPham>) query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sp;
    }
    public long TinhTongSLSPSearchGiaKhong(String khoangbee,String khoanglonn) {
        Transaction transaction = null;
        long tinhthong = 0;
        double khoangbe = Double.parseDouble(khoangbee);
        double khoanglon = Double.parseDouble(khoanglonn);
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM SanPham sp JOIN sp.kho  WHERE sp.kho.GiaBan BETWEEN :khoangbe AND :khoanglon";

            Query query = session.createQuery(hql);
            query.setParameter("khoangbe", khoangbe);
            query.setParameter("khoanglon", khoanglon);
            tinhthong = (long) query.uniqueResult(); // Cast the result to long
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return tinhthong;
    }
    public ArrayList<SanPham> findbyGiaBanMin(String giaminn,int limit, int page) {
        Transaction transaction = null;
        ArrayList<SanPham> sp = new ArrayList<>();
        double giamin = Double.parseDouble(giaminn);
        int offset = (page - 1) * limit;

        try {
            transaction = session.beginTransaction();

            String hql = "SELECT sp FROM SanPham sp JOIN sp.kho  WHERE sp.kho.GiaBan <= :giamin";

            Query query = session.createQuery(hql);
            query.setParameter("giamin", giamin);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            sp = (ArrayList<SanPham>) query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sp;
    }
    public long TinhTongSLSPSearchGiaMin(String giaminn) {
        Transaction transaction = null;
        long tinhthong = 0;
        double giamin = Double.parseDouble(giaminn);
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM SanPham sp JOIN sp.kho  WHERE sp.kho.GiaBan <= :giamin";

            Query query = session.createQuery(hql);
            query.setParameter("giamin", giamin);

            tinhthong = (long) query.uniqueResult(); // Cast the result to long
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return tinhthong;
    }

    public ArrayList<SanPham> findbyGiaBanMax(String maxx ,int limit, int page) {
        Transaction transaction = null;
        ArrayList<SanPham> sp = new ArrayList<>();
        double giamax = Double.parseDouble(maxx);
        int offset = (page - 1) * limit;

        try {
            transaction = session.beginTransaction();

            String hql = "SELECT sp FROM SanPham sp JOIN sp.kho  WHERE sp.kho.GiaBan >= :giamax";

            Query query = session.createQuery(hql);
            query.setParameter("giamax", giamax);
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            sp = (ArrayList<SanPham>) query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return sp;
    }
    public long TinhTongSLSPSearchGiamax(String giamaxx) {
        Transaction transaction = null;
        long tinhthong = 0;
        double giamax = Double.parseDouble(giamaxx);
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM SanPham sp JOIN sp.kho  WHERE sp.kho.GiaBan >= :giamax";

            Query query = session.createQuery(hql);
            query.setParameter("giamax", giamax);

            tinhthong = (long) query.uniqueResult(); // Cast the result to long
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return tinhthong;
    }
    public static void main(String[] args) {
       SanPhamDAL sanPhamDAL = new SanPhamDAL();
//        ArrayList<SanPham> sp = sanPhamDAL.findbyGiaBan("29000",1,1);
//        for(SanPham sp: sanPhamDAL.findbyGiaBan("39000")){
//            System.out.println(sp);
//
//        }
//        SanPhamDAL dal = new SanPhamDAL();
//        ArrayList<SanPham> result = dal.findbyGiaBan("29000");
//        for (SanPham sanPham : result) {
//            System.out.println("ID: " + sanPham.getIdSanPham() + ", Name: " + sanPham.getTenSanPham());
//        }
//        System.out.println(sanPhamDAL.TinhTongSLSPSearchGia("39000"));
//        System.out.println(sanPhamDAL.TinhTongSLSPSearchMau("Xám"));
//        System.out.println(sanPhamDAL.findbyGiaBanMin("14000"));
        System.out.println(sanPhamDAL.TinhTongSLSPSearchGiamax("10000"));



    }
}
