/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Bean.Image;
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
public class ImageDAL {
    Session session;
    public ImageDAL(){
                session = HibernateUtils.getSessionFactory().openSession();

    }
     @SuppressWarnings("unchecked") 
    public List<Image> listImage(int limit, int page){
        Transaction transaction = null;
        List<Image> imageList = new ArrayList<>();
        int offset = (page - 1) * limit;
        try {
            transaction = session.beginTransaction();

            Query query = session.createQuery("from image");
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            
            imageList = query.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return imageList;
    }
     public ArrayList<Image> findbyIDsanpham(String id, int limit, int page) {
        Transaction transaction = null;
        ArrayList<Image> ig = new ArrayList<>();
        int offset = (page - 1) * limit;

        try {
            transaction = session.beginTransaction();

            String hql = "FROM image WHERE IdSanPham LIKE :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", "%" + id + "%");
            query.setFirstResult(offset);
            query.setMaxResults(limit);

            ig = (ArrayList<Image>) query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return ig;
    }
     public long TinhTongSLImageSearch(String id) {
        Transaction transaction = null;
        long tinhthong = 0;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM image WHERE IdSanPham LIKE :id";
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
     public long TinhTongSLImageList() {
        Transaction transaction = null;
        long tinhthong = 0;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM image";
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
}
