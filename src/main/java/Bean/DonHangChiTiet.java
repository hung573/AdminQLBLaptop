/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author maiho
 */
@Entity (name ="DonHangChiTiet")
@Table(name ="DonHangChiTiet")
public class DonHangChiTiet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    
    @Column
    private int SoLuongDat;
    
    @Column
    private int SoLuongCo;
    
    @Column
    private double ThanhTien;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdDonHang",foreignKey = @ForeignKey(name="fk_IdDonHang_DonHangChiTiet"), nullable = true, insertable=false, updatable=false)
    private DonHang donhang;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdSanPham",foreignKey = @ForeignKey(name="fk_IdSanPham_DonHangChiTiet"), nullable = true, insertable=true, updatable=true)
    private SanPham sanpham;

    public DonHangChiTiet() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getSoLuongDat() {
        return SoLuongDat;
    }

    public void setSoLuongDat(int SoLuongDat) {
        this.SoLuongDat = SoLuongDat;
    }

    public int getSoLuongCo() {
        return SoLuongCo;
    }

    public void setSoLuongCo(int SoLuongCo) {
        this.SoLuongCo = SoLuongCo;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public DonHang getDonhang() {
        return donhang;
    }

    public void setDonhang(DonHang donhang) {
        this.donhang = donhang;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }
    
    
    
}
