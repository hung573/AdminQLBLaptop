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
@Entity(name ="PhieuChiTiet")
@Table(name ="PhieuChiTiet")
public class PhieuChiTiet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;    
    @Column
    private int SoLuongDat;
    @Column
    private int SoLuongNhan;
    @Column
    private double ThanhTienDat;
    @Column
    private double ThanhTienNhan;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdPhieu",foreignKey = @ForeignKey(name="fk_IdPhieu_PhieuChiTiet"), nullable = true, insertable=true, updatable=true)  
    private Phieu phieu;    
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdSanPham",foreignKey = @ForeignKey(name="fk_IdSanPham_PhieuChiTiet"), nullable = true, insertable=true, updatable=true)
    private SanPham sanpham;

    public PhieuChiTiet() {
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

    public int getSoLuongNhan() {
        return SoLuongNhan;
    }

    public void setSoLuongNhan(int SoLuongNhan) {
        this.SoLuongNhan = SoLuongNhan;
    }

    public double getThanhTienDat() {
        return ThanhTienDat;
    }

    public void setThanhTienDat(double ThanhTienDat) {
        this.ThanhTienDat = ThanhTienDat;
    }

    public double getThanhTienNhan() {
        return ThanhTienNhan;
    }

    public void setThanhTienNhan(double ThanhTienNhan) {
        this.ThanhTienNhan = ThanhTienNhan;
    }

    public Phieu getPhieu() {
        return phieu;
    }

    public void setPhieu(Phieu phieu) {
        this.phieu = phieu;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }
    
    
    
}
