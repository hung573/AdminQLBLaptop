/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author maiho
 */
@Entity
@Table(name ="PhieuXuat")
public class PhieuXuat extends Phieu{
    @Column
    private String LoaiXuat;
    @Column
    private int TongSoLuongXuat;
    @Column
    private double TongTienXuat;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdKhachHang",foreignKey = @ForeignKey(name="fk_IdKhachHang_PhieuXuat"), nullable = true, insertable=true, updatable=true)
    private Person_KhachHang khachhang;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdNhaCungCap",foreignKey = @ForeignKey(name="fk_IdNhaCungCap_PhieuXuat"), nullable = true, insertable=true, updatable=true)
    private Person_NhaCungCap nhacungcap;

    public PhieuXuat() {
    }

    public String getLoaiXuat() {
        return LoaiXuat;
    }

    public void setLoaiXuat(String LoaiXuat) {
        this.LoaiXuat = LoaiXuat;
    }

    public int getTongSoLuongXuat() {
        return TongSoLuongXuat;
    }

    public void setTongSoLuongXuat(int TongSoLuongXuat) {
        this.TongSoLuongXuat = TongSoLuongXuat;
    }

    public double getTongTienXuat() {
        return TongTienXuat;
    }

    public void setTongTienXuat(double TongTienXuat) {
        this.TongTienXuat = TongTienXuat;
    }

    public Person_KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(Person_KhachHang khachhang) {
        this.khachhang = khachhang;
    }

    public Person_NhaCungCap getNhacungcap() {
        return nhacungcap;
    }

    public void setNhacungcap(Person_NhaCungCap nhacungcap) {
        this.nhacungcap = nhacungcap;
    }

    
    
    
}
