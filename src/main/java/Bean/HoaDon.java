/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author maiho
 */
@Entity(name ="HoaDon")
@Table(name ="HoaDon")
public class HoaDon implements Serializable {
    @Id
    private String IdHoaDon;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date NgayLap;
    @Column
    private int TongSoLuong;
    @Column
    private double TongTien;
    @Column
    private double PhiVanChuyen;
    @Column
    private double ThanhTien;
    @Column
    private double KhachDua;
    @Column
    private double TienThua;
    @Column
    private String GhiChu;
    @Column
    private String Loai;
    @Column
    private String TrangThai;
    
    @OneToMany (fetch = FetchType.LAZY, targetEntity = HoaDonChiTiet.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdDonHang", nullable = true,insertable=true, updatable=true)
    private List<HoaDonChiTiet> listhoadonchitiet;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdNhanVien",foreignKey = @ForeignKey(name="fk_IdNhanVien_HoaDon"), nullable = true, insertable=true, updatable=true)
    private Person_NhanVien nhanvien;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdKhachHang",foreignKey = @ForeignKey(name="fk_IdKhachHang_HoaDon"), nullable = true, insertable=true, updatable=true)
    private Person_KhachHang khachhang;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdNhaCungCap",foreignKey = @ForeignKey(name="fk_IdNhaCungCap_HoaDon"), nullable = true, insertable=true, updatable=true)
    private Person_NhaCungCap nhacungcap;

    public HoaDon() {
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

    public List<HoaDonChiTiet> getListhoadonchitiet() {
        return listhoadonchitiet;
    }

    public void setListhoadonchitiet(List<HoaDonChiTiet> listhoadonchitiet) {
        this.listhoadonchitiet = listhoadonchitiet;
    }

    public Person_NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Person_NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }
    
    public String getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(String IdHoaDon) {
        this.IdHoaDon = IdHoaDon;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date NgayLap) {
        this.NgayLap = NgayLap;
    }

    public int getTongSoLuong() {
        return TongSoLuong;
    }

    public void setTongSoLuong(int TongSoLuong) {
        this.TongSoLuong = TongSoLuong;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public double getPhiVanChuyen() {
        return PhiVanChuyen;
    }

    public void setPhiVanChuyen(double PhiVanChuyen) {
        this.PhiVanChuyen = PhiVanChuyen;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public double getKhachDua() {
        return KhachDua;
    }

    public void setKhachDua(double KhachDua) {
        this.KhachDua = KhachDua;
    }

    public double getTienThua() {
        return TienThua;
    }

    public void setTienThua(double TienThua) {
        this.TienThua = TienThua;
    }

    
    
}
