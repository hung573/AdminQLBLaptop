/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Bean.Image;
import Bean.Person;
import Bean.Person_NhaCungCap;
import Bean.Person_NhanVien;
import Util.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author maiho
 */
public class NhaCungCapDAL {

    Session session;

    public NhaCungCapDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    @SuppressWarnings("unchecked")
    public List<Person_NhaCungCap> listNCC(int limit, int page) {
        Transaction transaction = null;
        List<Person_NhaCungCap> ncclist = new ArrayList<>();
        int offset = (page - 1) * limit;

        try {
            transaction = session.beginTransaction();

            Query query = session.createQuery("from NhaCungCap");
            query.setFirstResult(offset);
            query.setMaxResults(limit);

            ncclist = query.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return ncclist;
    }

    public ArrayList<Person_NhaCungCap> findbyIDNCC(String id, int limit, int page) {
        Transaction transaction = null;
        ArrayList<Person_NhaCungCap> ncc = new ArrayList<>();
        int offset = (page - 1) * limit;

        try {
            transaction = session.beginTransaction();

            String hql = "FROM NhaCungCap AS ncc WHERE ncc.IdPerson LIKE :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", "%" + id + "%");
            query.setFirstResult(offset);
            query.setMaxResults(limit);

            ncc = (ArrayList<Person_NhaCungCap>) query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return ncc;
    }

    public long TinhTongSLNCCSearch(String id) {
        Transaction transaction = null;
        long tinhthong = 0;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM NhaCungCap AS ncc WHERE ncc.IdPerson LIKE :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", "%" + id + "%");
            tinhthong = (long) query.uniqueResult(); // Cast the result to long
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return tinhthong;
    }

    public long TinhTongSLNCCList() {
        Transaction transaction = null;
        long tinhthong = 0;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM NhaCungCap";
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

    public Person_NhaCungCap getNhaCungCap(String IdPerson) {
        session.beginTransaction();
        Person_NhaCungCap p = session.get(Person_NhaCungCap.class, IdPerson);
        session.getTransaction().commit();
        return p;
    }

//    public boolean addNhaCungCap(Person_NhaCungCap ncc)
//    {
//        session.beginTransaction();
//        session.save(ncc);
//        session.getTransaction().commit();
//        return true;
//    }
    public void InsertNhaCungCap(Person_NhaCungCap psCap) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(psCap);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
//    public boolean updateNhaCungCap(Person_NhaCungCap ncc)
//    {
//        session.beginTransaction();
//        session.saveOrUpdate(ncc);
//        session.getTransaction().commit();
//        return true;
//    }

    public boolean UpdateNhaCungCap(Person_NhaCungCap psCap) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Person_NhaCungCap ncc_old = session.get(Person_NhaCungCap.class, psCap.getIdPerson());
            Person_NhaCungCap ncc_update = new Person_NhaCungCap();
            //sửa thông tin person            
            ncc_update.setTen(psCap.getTen());
            ncc_update.setEmail(psCap.getEmail());
            ncc_update.setDiaChi(psCap.getDiaChi());
            ncc_update.setSDT(psCap.getSDT());

            //sửa thông tin person_nhanvien
            ncc_update.setLoai(psCap.getLoai());
            //set Id cho nv_update
            ncc_update.setIdPerson();

            //thế image cũ vào nv update
            Image img_update = new Image();
            img_update.setURL(psCap.getImage().getURL());
            
            ncc_update.setImage(img_update);

            //xóa nhân viên cũ từ database
            session.delete(ncc_old);
            //Thêm nhân viên được sửa vào database
            session.save(ncc_update);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return true;

    }

    public boolean deleteNhaCungCap(String IdPerson) {
        session.beginTransaction();
        Person_NhaCungCap ncc = session.get(Person_NhaCungCap.class, IdPerson);
        session.save(ncc);
        session.getTransaction().commit();
        return true;
    }

    public static void main(String[] args) {
//        try (Session session = HibernateUtils.getSessionFactory().openSession();) {
//            Person_NhaCungCap ncc = new Person_NhaCungCap();
//            session.beginTransaction();
//            session.save(ncc);
//            session.getTransaction().commit();        
//        }catch(Throwable ex){
//            System.err.println("Failed to create sessionFactory object."+ ex);
//            throw new ExceptionInInitializerError(ex);
//        }
        NhaCungCapDAL nccdal = new NhaCungCapDAL();
//          for(Person_NhaCungCap account: nccdal.listNCC()){
//            System.out.println(account.getIdPerson());
//
//        }
        Person_NhaCungCap ncc = new Person_NhaCungCap();
        ncc.setTen("Ta Hung");
        ncc.setEmail("hung@gmail.com");
        ncc.setDiaChi("TPHCM");
        ncc.setLoai("Ca nhan");
        ncc.setSDT("343434343");
        ncc.setIdPerson();
        System.out.println("DAL.NhaCungCapDAL.main()" + ncc.getIdPerson());
        NhaCungCapDAL dal = new NhaCungCapDAL();
        dal.InsertNhaCungCap(ncc);

    }
}
