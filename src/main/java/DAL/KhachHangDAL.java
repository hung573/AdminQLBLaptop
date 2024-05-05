/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;


import Bean.Account;
import Bean.Image;
import Bean.Person_KhachHang;
import Bean.Person_NhanVien;
import Util.HibernateUtils;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/**
 *
 * @author maiho
 */
public class KhachHangDAL {
    Session session;
    public KhachHangDAL() {
        session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public List loadKhachHang() {
        List<Person_KhachHang> list;
        session.beginTransaction();
        list = session.createQuery("FROM KhachHang ", Person_KhachHang.class).list();
        session.getTransaction().commit();
        return list;
    }
    
    public Person_KhachHang getKhachHang(String IdPerson)
    {
        session.beginTransaction();
        Person_KhachHang p = session.get(Person_KhachHang.class, IdPerson);
        session.getTransaction().commit();
        return p;
    }
    
    public boolean addKhachHang(Person_KhachHang kh)
    {
        session.beginTransaction();
        session.save(kh);
        session.getTransaction().commit();
        return true;
    }
    
    public boolean updateKhachHang(Person_KhachHang kh)
    {
        session.beginTransaction();
        Person_KhachHang khh = session.get(Person_KhachHang.class, kh.getIdPerson());
        Person_KhachHang kh_update = new Person_KhachHang();
        //sửa thông tin person            
        kh_update.setTen(kh.getTen());
        kh_update.setEmail(kh.getEmail());
        kh_update.setDiaChi(kh.getDiaChi());
        kh_update.setSDT(kh.getSDT());
        
        //sửa thông tin person_khachhang
        kh_update.setXepHang(kh.getXepHang());
//        kh_update.setDiemTichLuy(kh.getDiemTichLuy());
      
        //set Id cho kh_update
        kh_update.setIdPerson();
        
        //thế image cũ vào kh update
        Image img_update = new Image();
        img_update.setURL(kh.getImage().getURL());
        //thế account cũ vào kh update
        Account acc_update = new Account();
        acc_update.setUserName(kh.getAccount().getUserName());
        acc_update.setPassword(kh.getAccount().getPassword());
        
        //bỏ vào accoun, image vào kh_update            
        kh_update.setAccount(acc_update);
        kh_update.setImage(img_update);
        
        //xóa khách hàng cũ từ database
        session.delete(khh);
        //Thêm khách hàng được sửa vào database
        session.save(kh_update);
        session.getTransaction().commit();
        return true;
    
    }
    
    public boolean deleteKhachHang(String IdPerson)
    {
        try {
            session.beginTransaction();
        Person_KhachHang kh = session.get(Person_KhachHang.class, IdPerson);
        if(kh !=null){
        session.save(kh);
        session.delete(kh);
        session.getTransaction().commit();
        return true;
        } else {
            return false;
        }
        } catch (Exception ex){
            session.getTransaction().rollback();
            throw new RuntimeException(ex);
        }
        
    }    
    public static void main(String[] args) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            KhachHangDAL dal = new KhachHangDAL();
            Person_KhachHang khachhang = new Person_KhachHang();
        String xephang ="1";
        double tichluy=0;
        
        khachhang.setTen("fffffff");
        khachhang.setEmail("asdasdasdasds");
        khachhang.setDiaChi("dasdasdadadd");
        khachhang.setSDT("33333333");
        khachhang.setXepHang(xephang);
        khachhang.setDiemTichLy(tichluy);
        
        khachhang.setIdPerson();
        
        Account acc= new Account();
        acc.setUserName("");
        acc.setPassword("");
        khachhang.setAccount(acc);
        
        Image img = new Image();
        img.setURL("");
        khachhang.setImage(img);
          
        dal.addKhachHang(khachhang);
            System.out.println("OK");
            
//            kh.setTen("Trần Văn A");
//            kh.setEmail("kh001@gmail.com");
//            kh.setDiaChi("123/32 Nguyễn Văn Tạo");
//            kh.setSDT("0247953215");
//            kh.setIdPerson();
//            
//            Image img = new Image();
//            img.setURL(kh.getIdPerson()+".jpg");
//            
//            Account acc = new Account();
//            acc.setUserName("kh");
//            acc.setPassword("123");
//            
//            kh.setImage(img);
//            kh.setAccount(acc);
//            
//            dal.addKhachHang(kh);
//            
//            session.beginTransaction();
//            
//            kh =session.get(Person_KhachHang.class, "KH2350247953213");
//            System.out.println("DAL.KhachHangDAL.main()"+kh.getImage().getIdImage());
//            Image img = session.get(Image.class, kh.getImage().getIdImage());
//            img.setURL(kh.getIdPerson()+".png");
//            session.update(kh);
//            session.getTransaction().commit();      
//            KhachHangDAL dal = new KhachHangDAL();
//            List<Person_KhachHang> list = dal.loadKhachHang();
//            System.out.println("DAL.KhachHangDAL.main()"+ list);
        }catch(Throwable ex){
            System.err.println("Failed to create sessionFactory object."+ ex);
            throw new ExceptionInInitializerError(ex);
        }
         
    }

    public Person_KhachHang finById(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void getKhachHang(String ten, String email, String diachi, String sdt, String xephang, double tichluy) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
