/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author maiho
 */
@Entity(name ="PhieuNhap")
@Table(name ="PhieuNhap")
public class PhieuNhap extends Phieu{
    @Column
    private int TongSoLuongDat;
    @Column
    private int TongSoLuongNhap;
    @Column
    private double TongTienDat;
    @Column
    private int TongTienNhap;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date NgayNhap;  
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdNhaCungCap",foreignKey = @ForeignKey(name="fk_IdNhaCungCap_PhieuNhap"), nullable = true, insertable=true, updatable=true)
    private Person_NhaCungCap nhacungcap;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdNhanVienNhap",foreignKey = @ForeignKey(name="fk_IdNhanVienNhap_PhieuNhap"), nullable = true, insertable=true, updatable=true)
    private Person_NhanVien nhanviennhap;

    public PhieuNhap() {
    }

    public Person_NhanVien getNhanviennhap() {
        return nhanviennhap;
    }

    public void setNhanviennhap(Person_NhanVien nhanviennhap) {
        this.nhanviennhap = nhanviennhap;
    }

    public int getTongSoLuongDat() {
        return TongSoLuongDat;
    }

    public void setTongSoLuongDat(int TongSoLuongDat) {
        this.TongSoLuongDat = TongSoLuongDat;
    }

    public int getTongSoLuongNhap() {
        return TongSoLuongNhap;
    }

    public void setTongSoLuongNhap(int TongSoLuongNhap) {
        this.TongSoLuongNhap = TongSoLuongNhap;
    }

    public double getTongTienDat() {
        return TongTienDat;
    }

    public void setTongTienDat(double TongTienDat) {
        this.TongTienDat = TongTienDat;
    }

    public int getTongTienNhap() {
        return TongTienNhap;
    }

    public void setTongTienNhap(int TongTienNhap) {
        this.TongTienNhap = TongTienNhap;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public Person_NhaCungCap getNhacungcap() {
        return nhacungcap;
    }

    public void setNhacungcap(Person_NhaCungCap nhacungcap) {
        this.nhacungcap = nhacungcap;
    }
     
}
