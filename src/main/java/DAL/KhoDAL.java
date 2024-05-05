/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

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
public class KhoDAL {
    Session session;
    public KhoDAL(){
        session = HibernateUtils.getSessionFactory().openSession();
    }
     @SuppressWarnings("unchecked") 
    public List<Kho> listKho(int limit, int page){
        Transaction transaction = null;
        List<Kho> khoList = new ArrayList<>();
        int offset = (page - 1) * limit;
        try {
            transaction = session.beginTransaction();

            Query query = session.createQuery("from Kho");
            query.setFirstResult(offset);
            query.setMaxResults(limit);
            
            khoList = query.list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return khoList;
    }
    public ArrayList<Kho> findbyIDKho(String id, int limit, int page) {
        Transaction transaction = null;
        ArrayList<Kho> kho = new ArrayList<>();
        int offset = (page - 1) * limit;

        try {
            transaction = session.beginTransaction();

            String hql = "FROM Kho WHERE idKho LIKE :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", "%" +id + "%");
            query.setFirstResult(offset);
            query.setMaxResults(limit);

            kho =  (ArrayList<Kho>) query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return kho;
    }
    public long TinhTongSLKhoSearch(String id) {
        Transaction transaction = null;
        long tinhthong = 0;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM Kho WHERE idKho LIKE :id";
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
    public long TinhTongSLkhoList() {
        Transaction transaction = null;
        long tinhthong = 0;
        try {
            transaction = session.beginTransaction();
            String hql = "SELECT COUNT(*) FROM Kho";
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
    public Kho getKho(int idkho){
        Transaction transaction = null;
        Kho kho = null;
        try {
            transaction = session.beginTransaction();
            kho = session.get(Kho.class, idkho);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return kho;
    }
public void UpdateKho(Kho kho,String IdSanPham){
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.merge(kho);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
