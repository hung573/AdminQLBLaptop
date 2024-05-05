/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author maiho
 */
@Entity(name ="NhanVien")
@Table(name ="NhanVien")
public class Person_NhanVien extends Person{
    @Column
    private String BoPhan;
    @Column
    private String ChucVu;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date NgaySinh;
    @Column
    private String TrangThai;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Account.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdAccount", nullable = true,insertable=true, updatable=true)
    private Account account;
    
    public Person_NhanVien() {
    }

    public String getIdPerson() {
        return IdPerson;
    }

    public void setIdPerson() {
        SimpleDateFormat sdfday = new SimpleDateFormat("dd");
        SimpleDateFormat sdfmonth = new SimpleDateFormat("MM");
        SimpleDateFormat sdfdayyear = new SimpleDateFormat("yyyy");
        String id = "";
        int ten =0;
        String bp ="";
        String cv ="";
        String[] bophan = this.BoPhan.split(" ");
        String[] chucvu = this.ChucVu.split(" ");
        String[] hoten = this.Ten.split(" ");
        for (String temp1 : hoten) {
            ten += temp1.charAt(0);
        }
        for (String temp2 : chucvu) {
            bp += temp2.charAt(0);
        }
        for (String temp3 : bophan) {
            cv += temp3.charAt(0);
        }
        id += cv.toUpperCase()+bp.toUpperCase()+String.valueOf(ten) + sdfday.format(this.NgaySinh)+ sdfmonth.format(this.NgaySinh)+ sdfdayyear.format(this.NgaySinh);
        this.IdPerson = id.toUpperCase();
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getBoPhan() {
        return BoPhan;
    }

    public void setBoPhan(String BoPhan) {
        this.BoPhan = BoPhan;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    
}