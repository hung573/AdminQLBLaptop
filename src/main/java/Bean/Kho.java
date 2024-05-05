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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author maiho
 */
@Entity
@Table(name ="Kho")
public class Kho implements Serializable {
    @Id
    @Column(name = "idKho")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IdKho;
    @Column(name = "giaNhap")
    private double GiaNhap;
    @Column(name = "giaBan")
    private double GiaBan;
    @Column(name = "soLuong")
    private int SoLuong;
    
//    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "IdSanPham", nullable = true, foreignKey = @ForeignKey(name="fk_IdSanPham_Kho"),insertable=true, updatable=true)
//    private SanPham sanpham;

    public Kho() {
        super();
    }
    public Kho(int IdKho,double GiaNhap, double GiaBan, int SoLuong) {
        this.IdKho = IdKho;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
//        this.sanpham = sanpham;
    }
    public Kho(double GiaNhap, double GiaBan, int SoLuong) {
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.SoLuong = SoLuong;
//        this.sanpham = sanpham;
    }

    

    public int getIdKho() {
        return IdKho;
    }

    public void setIdKho(int IdKho) {
        this.IdKho = IdKho;
    }
    
//    public SanPham getSanpham() {
//        return sanpham;
//    }
//
//    public void setSanpham(SanPham sanpham) {
//        this.sanpham = sanpham;
//    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    
}
