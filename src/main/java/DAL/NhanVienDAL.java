/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Bean.Account;
import Bean.Image;
import Bean.Person;
import Bean.Person_KhachHang;
import Bean.Person_NhanVien;
import Util.HibernateUtils;
import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author maiho
 */
public class NhanVienDAL {

    Session session;

    public NhanVienDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    public List loadNhanVien() {
        List<Person_NhanVien> list;
        session.beginTransaction();
        list = session.createQuery("FROM NhanVien ", Person_NhanVien.class).list();
        session.getTransaction().commit();
        return list;
    }

    public Person_NhanVien getNhanVien(String IdPerson) {
        session.beginTransaction();
        Person_NhanVien p = session.get(Person_NhanVien.class, IdPerson);
        session.getTransaction().commit();
        return p;
    }

    public boolean addNhanVien(Person_NhanVien nv) {
        session.beginTransaction();
        session.save(nv);
        session.getTransaction().commit();
        return true;
    }

    public boolean updateNhanVien(Person_NhanVien nv) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Person_NhanVien nv_old = session.get(Person_NhanVien.class, nv.getIdPerson());
            Person_NhanVien nv_update = new Person_NhanVien();
            //sửa thông tin person            
            nv_update.setTen(nv.getTen());
            nv_update.setEmail(nv.getEmail());
            nv_update.setDiaChi(nv.getDiaChi());
            nv_update.setSDT(nv.getSDT());

            //sửa thông tin person_nhanvien
            nv_update.setNgaySinh(nv.getNgaySinh());
            nv_update.setBoPhan(nv.getBoPhan());
            nv_update.setChucVu(nv.getChucVu());
            nv_update.setTrangThai(nv.getTrangThai());
            //set Id cho nv_update
            nv_update.setIdPerson();

            //thế image cũ vào nv update
            Image img_update = new Image();
            img_update.setURL(nv.getImage().getURL());
            //thế account cũ vào nv update
            Account acc_update = new Account();
            acc_update.setUserName(nv.getAccount().getUserName());
            acc_update.setPassword(nv.getAccount().getPassword());

            //bỏ vào accoun, image vào nv_update            
            nv_update.setAccount(acc_update);
            nv_update.setImage(img_update);

            //xóa nhân viên cũ từ database
            session.delete(nv_old);
            //Thêm nhân viên được sửa vào database
            session.save(nv_update);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return true;
    }

    public boolean deleteNhanVien(String IdPerson) {
        session.beginTransaction();
        Person_NhanVien nv = session.get(Person_NhanVien.class, IdPerson);
        session.delete(nv);
        session.getTransaction().commit();
        return true;
    }

    public static void main(String[] args) {

        NhanVienDAL dal = new NhanVienDAL();
        Person_NhanVien nv_update = new Person_NhanVien();
        Person_NhanVien test = dal.getNhanVien("BHQL9714122023");
        test.setTen("Trường Sa Xăm");

        dal.updateNhanVien(test);

//        //sửa thông tin person            
//        nv_update.setTen("CCCC");
//        nv_update.setEmail("");
//        nv_update.setDiaChi("");
//        nv_update.setSDT("");
//        
//        //sửa thông tin person_nhanvien
//        nv_update.setNgaySinh(test.getNgaySinh());
//        nv_update.setBoPhan(test.getBoPhan());
//        nv_update.setChucVu(test.getChucVu());
//        nv_update.setTrangThai(test.getTrangThai());
//        //set Id cho nv_update
//        nv_update.setIdPerson();
//        
//        //thế image cũ vào nv update
//        Image img_update = new Image();
//        img_update.setURL("");
//        //thế account cũ vào nv update
//        Account acc_update = new Account();
//        acc_update.setUserName("");
//        acc_update.setPassword("");
//        
//        //bỏ vào accoun, image vào nv_update            
//        nv_update.setAccount(acc_update);
//        nv_update.setImage(img_update);
//        dal.addNhanVien(nv_update);
    }
}
