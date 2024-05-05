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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author maiho
 */
@Entity(name ="DonHang")
@Table(name ="DonHang")
public class DonHang implements Serializable {
    @Id
    private String IdDonHang;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date NgayLap;
    @Column
    private int TongSoLuong;
    @Column
    private double TongTienTamTinh;
    @Column
    private double PhiVanChuyen;
    @Column
    private double ThanhTien;
    @Column
    private String GhiChu;
    @Column
    private String TrangThai;
   
    @OneToMany (fetch = FetchType.LAZY, targetEntity = DonHangChiTiet.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdDonHang", nullable = true,insertable=true, updatable=true)
    private List<DonHangChiTiet> listdonhangchitiet;
      
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdNhanVien",foreignKey = @ForeignKey(name="fk_IdNhanVien_DonHang"), nullable = true, insertable=true, updatable=true)
    private Person_NhanVien nhanvien;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdKhachHang",foreignKey = @ForeignKey(name="fk_IdKhachHang_DonHang"), nullable = true, insertable=true, updatable=true)
    private Person_KhachHang khachhang;
    


    public DonHang() {
    }



    public List<DonHangChiTiet> getListdonhangchitiet() {
        return listdonhangchitiet;
    }

    public void setListdonhangchitiet(List<DonHangChiTiet> listdonhangchitiet) {
        this.listdonhangchitiet = listdonhangchitiet;
    }

    public Person_NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Person_NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public Person_KhachHang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(Person_KhachHang khachhang) {
        this.khachhang = khachhang;
    }
    
    public String getIdDonHang() {
        return IdDonHang;
    }

    public void setIdDonHang(String IdDonHang ) {
        
        this.IdDonHang = IdDonHang;
    }


    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
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

    public double getTongTienTamTinh() {
        return TongTienTamTinh;
    }

    public void setTongTienTamTinh(double TongTienTamTinh) {
        this.TongTienTamTinh = TongTienTamTinh;
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
    
}
