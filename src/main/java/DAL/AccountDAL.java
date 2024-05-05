/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Bean.Account;
import Bean.Image;
import Bean.Person;
import Bean.Person_NhanVien;
import Util.HibernateUtils;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author mac
 */
public class AccountDAL {

    Session session;

    public AccountDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    @SuppressWarnings("unchecked")
    public boolean CheckLogin(String username, String password) {
        Transaction transaction = null;
        boolean isAuthenticated = false;
        try {

            transaction = session.beginTransaction();
            String hql = "FROM Account AS ac WHERE ac.UserName = :username AND ac.Password = :password";
            Query<Account> query = session.createQuery(hql, Account.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            Account account = query.uniqueResult();
            String check = account.getUserName();
            String checkkString = check.substring(0, 2);
            if (checkkString.equals("BH") || checkkString.equals("KV") && account != null) {
                isAuthenticated = true;
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle or log the exception as needed
        }

        return isAuthenticated;
    }

    public Account getIdAccountByUsername(String username) {
        Transaction transaction = null;
        Account idAccount = null;

        try {
            transaction = session.beginTransaction();

            // Using HQL to create a query
            String hql = "FROM Account AS ac WHERE ac.UserName = :username";
            Query<Account> query = session.createQuery(hql, Account.class);
            query.setParameter("username", username);

            idAccount = query.uniqueResult();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return idAccount;
    }

     public Person_NhanVien getIDPerson_NhanVien(int id) {
        Transaction transaction = null;
        Person_NhanVien person_NhanVien = null;
        try {
            String hql = "SELECT nv FROM NhanVien nv JOIN nv.account WHERE nv.account.IdAccount = :id";
            Query<Person_NhanVien> query = session.createQuery(hql, Person_NhanVien.class);
            query.setParameter("id", id);
            person_NhanVien = query.uniqueResult();
            
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return person_NhanVien;
    }
    public boolean CheckNhanVien(String idPerson) {
        Transaction transaction = null;
        boolean check = false;

        try {
            transaction = session.beginTransaction();

            String hql = "FROM NhanVien AS nv WHERE nv.IdPerson = :idPerson";
            Query<Person_NhanVien> query = session.createQuery(hql, Person_NhanVien.class);
            query.setParameter("idPerson", idPerson);

            Person_NhanVien p = query.uniqueResult();
            System.out.println(p);
            String checkk = p.getTrangThai();
            if (checkk.equals("1")) {
                check = true;
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle or log the exception as needed
        }

        return check;
    }
//5
    public boolean CheckBoPhan(String idPerson) {
        Transaction transaction = null;
        boolean check = false;

        try {
            transaction = session.beginTransaction();

            String hql = "FROM NhanVien AS nv WHERE nv.IdPerson = :idPerson";
            Query<Person_NhanVien> query = session.createQuery(hql, Person_NhanVien.class);
            query.setParameter("idPerson", idPerson);

            Person_NhanVien p = query.uniqueResult();
            String checkk = p.getIdPerson();
            String checkkString = checkk.substring(0, 2);
            if (checkkString.equals("BH")) {
                check = true;
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle or log the exception as needed
        }

        return check;
    }
    public boolean CheckQuanLy(String idPerson) {
        Transaction transaction = null;
        boolean check = false;

        try {
            transaction = session.beginTransaction();

            String hql = "FROM NhanVien AS nv WHERE nv.IdPerson = :idPerson";
            Query<Person_NhanVien> query = session.createQuery(hql, Person_NhanVien.class);
            query.setParameter("idPerson", idPerson);
            Person_NhanVien p = query.uniqueResult();
            String checkk = p.getIdPerson();
            String checkkString = checkk.substring(2, 4);
            if (checkkString.equals("QL")) {
                check = true;
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Handle or log the exception as needed
        }

        return check;
    }

    public static void main(String[] args) {
        AccountDAL accountDAL = new AccountDAL();
//        Person ac = accountDAL.getPerson("BHNV22816102023");
//        Account acc = accountDAL.getIdAccountByUsername("BHNV22816102023");
//        Person_NhanVien psNhanVien = accountDAL.getPerson_NhanVien("BHNV22816102023");
//        boolean psNhanVienn = accountDAL.CheckNhanVien("BHQL22911102023");
//        boolean abc = accountDAL.CheckBoPhan("BHQL22911102023");
//        boolean abcc = accountDAL.CheckQuanLy("BHQL22911102023");
        Account ac = accountDAL.getIdAccountByUsername("BHQL22911102023");
        int id = ac.getIdAccount();
        Person_NhanVien ps = accountDAL.getIDPerson_NhanVien(id);
        
        System.out.println(ps.getIdPerson());
        
        
        System.out.println(accountDAL.CheckLogin("KVQL23501102023","KVQL@23501102023"));

//        System.out.println("checkDangNhap " + accountDAL.CheckLogin("KVNV22310102023", "122"));
//        for(Account account: accountDAL.listSanPham()){
//            System.out.println(account.getUserName());
//            System.out.println(account.getPassword());
//
//        }
//        System.out.println("checkNhanVien " + psNhanVienn);
//        System.out.println("checkBoPhan " + abc);
//        System.out.println("getIDaccout tren Username " + acc);
//        System.out.println("check QuanLy " + abcc);
//        System.out.println(ac.getIdPerson());
//        System.out.println(psNhanVien);
//
//        System.out.println(psNhanVien.getChucVu());
//        System.out.println(psNhanVien.getBoPhan());
//
//        String idperson = "BHQL2291110202";
//        String a = idperson.substring(0, 2);
//        System.out.println(a);
    }
}
