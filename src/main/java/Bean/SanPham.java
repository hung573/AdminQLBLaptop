/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author mac
 */
@Data
@Entity
@Table(name = "SanPham")
public class SanPham implements Serializable {

//    @Id
//    @Column(name="idSanPham")
//    private String IdSanPham;
//    
//    @Column(name = "tenSanPham")
//    private String TenSanPham;
//    @Column
//    private String ThuongHieu;
//    @Column
//    private String Mau; 
//    @Column
//    private String SeriesLapTop;
//    @Column
//    private String NhuCau; 
//    @Column
//    private String SeriesCPU;
//    @Column
//    private String CPU; 
//    @Column
//    private String DoHoa;
//    @Column
//    private String DoHoaRoi; 
//    @Column
//    private String RAM; 
//    @Column
//    private String BoNho; 
//    @Column
//    private String KTManHinh;
//    @Column
//    private String PhanGiai; 
//    @Column
//    private String MHCamUng; 
//    @Column
//    private String KhoiLuong;
//    
    @Id
    @Column(name = "idSanPham")
    private String IdSanPham;

    @Column(name = "tenSanPham")
    private String TenSanPham;
    @Column(name = "thuongHieu")
    private String ThuongHieu;
    @Column(name = "mau")
    private String Mau;
    @Column(name = "seriesLapTop")
    private String SeriesLapTop;
    @Column(name = "nhuCau")
    private String NhuCau;
    @Column(name = "seriesCPU")
    private String SeriesCPU;
    @Column(name = "CPU")
    private String CPU;
    @Column(name = "doHoa")
    private String DoHoa;
    @Column(name = "doHoaRoi")
    private String DoHoaRoi;
    @Column(name = "RAM")
    private String RAM;
    @Column(name = "boNho")
    private String BoNho;
    @Column(name = "KTManHinh")
    private String KTManHinh;
    @Column(name = "phanGiai")
    private String PhanGiai;
    @Column(name = "MHCamUng")
    private String MHCamUng;
    @Column(name = "khoiLuong")
    private String KhoiLuong;

    @OneToMany (fetch = FetchType.EAGER, targetEntity = Image.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdSanPham", nullable = true,insertable=true, updatable=true)
    private List<Image> listimage = new ArrayList<>();
    
//    @OneToMany (fetch = FetchType.EAGER, targetEntity = Image.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "IdSanPham", nullable = true,insertable=true, updatable=true)
//    private Image image;


    @OneToOne(fetch = FetchType.LAZY, targetEntity = Kho.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdKho", nullable = true,insertable=true, updatable=true)
    private Kho kho;


//    @OneToMany (fetch = FetchType.LAZY, targetEntity = DonHangChiTiet.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "IdSanPham", nullable = true,insertable=true, updatable=true)
//    private List<DonHangChiTiet> listdonhangchitiet;
//
//    @OneToMany (fetch = FetchType.LAZY, targetEntity = HoaDonChiTiet.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "IdSanPham", nullable = true,insertable=true, updatable=true)
//    private List<HoaDonChiTiet> listhoadonchitiet;
//    
//    @OneToMany (fetch = FetchType.LAZY, targetEntity = PhieuChiTiet.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "IdSanPham", nullable = true,insertable=true, updatable=true)
//    private List<PhieuChiTiet> listphieuchitiet;
    public SanPham() {
        super();

    }

    public SanPham(String IdSanPham, String TenSanPham, String ThuongHieu, String Mau, String SeriesLapTop, String NhuCau, String SeriesCPU, String CPU, String DoHoa, String DoHoaRoi, String RAM, String BoNho,
            String KTManHinh, String PhanGiai, String MHCamUng, String KhoiLuong) {
        super();
        this.IdSanPham = IdSanPham;
        this.TenSanPham = TenSanPham;
        this.ThuongHieu = ThuongHieu;
        this.Mau = Mau;
        this.SeriesLapTop = SeriesLapTop;
        this.NhuCau = NhuCau;
        this.SeriesCPU = SeriesCPU;
        this.CPU = CPU;
        this.DoHoa = DoHoa;
        this.DoHoaRoi = DoHoaRoi;
        this.RAM = RAM;
        this.BoNho = BoNho;
        this.KTManHinh = KTManHinh;
        this.PhanGiai = PhanGiai;
        this.MHCamUng = MHCamUng;
        this.KhoiLuong = KhoiLuong;
        this.kho = kho;

    }

    public SanPham(String TenSanPham, String ThuongHieu, String Mau, String SeriesLapTop, String NhuCau,
            String SeriesCPU, String CPU, String DoHoa, String DoHoaRoi,
            String RAM, String BoNho, String KTManHinh, String PhanGiai, String MHCamUng, String KhoiLuong) {
        super();    
        this.TenSanPham = TenSanPham;
        this.ThuongHieu = ThuongHieu;
        this.Mau = Mau;
        this.SeriesLapTop = SeriesLapTop;
        this.NhuCau = NhuCau;
        this.SeriesCPU = SeriesCPU;
        this.CPU = CPU;
        this.DoHoa = DoHoa;
        this.DoHoaRoi = DoHoaRoi;
        this.RAM = RAM;
        this.BoNho = BoNho;
        this.KTManHinh = KTManHinh;
        this.PhanGiai = PhanGiai;
        this.MHCamUng = MHCamUng;
        this.KhoiLuong = KhoiLuong;
        this.kho = kho;

    }
    public SanPham(String TenSanPham, String Mau, String SeriesLapTop, String NhuCau,
            String SeriesCPU, String CPU, String DoHoa, String DoHoaRoi,
            String RAM, String BoNho, String KTManHinh, String PhanGiai, String MHCamUng, String KhoiLuong) {
        super();
        this.TenSanPham = TenSanPham;
        this.Mau = Mau;
        this.SeriesLapTop = SeriesLapTop;
        this.NhuCau = NhuCau;
        this.SeriesCPU = SeriesCPU;
        this.CPU = CPU;
        this.DoHoa = DoHoa;
        this.DoHoaRoi = DoHoaRoi;
        this.RAM = RAM;
        this.BoNho = BoNho;
        this.KTManHinh = KTManHinh;
        this.PhanGiai = PhanGiai;
        this.MHCamUng = MHCamUng;
        this.KhoiLuong = KhoiLuong;

    }
    
    public Kho getKho() {
        return kho;
    }

    public void setKho(Kho kho) {
        this.kho = kho;
    }
    
    public List<Image> getListimage() {
        return listimage;
    }

    public void setListimage(List<Image> listimage) {
        this.listimage = listimage;
    }
    
    public String getIdSanPham() {
        return IdSanPham;
    }

    public void setIdSanPham(String IdSanPham) {
        this.IdSanPham = IdSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getThuongHieu() {
        return ThuongHieu;
    }

    public void setThuongHieu(String ThuongHieu) {
        this.ThuongHieu = ThuongHieu;
    }

    public String getMau() {
        return Mau;
    }

    public void setMau(String Mau) {
        this.Mau = Mau;
    }

    public String getSeriesLapTop() {
        return SeriesLapTop;
    }

    public void setSeriesLapTop(String SeriesLapTop) {
        this.SeriesLapTop = SeriesLapTop;
    }

    public String getNhuCau() {
        return NhuCau;
    }

    public void setNhuCau(String NhuCau) {
        this.NhuCau = NhuCau;
    }

    public String getSeriesCPU() {
        return SeriesCPU;
    }

    public void setSeriesCPU(String SeriesCPU) {
        this.SeriesCPU = SeriesCPU;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getDoHoa() {
        return DoHoa;
    }

    public void setDoHoa(String DoHoa) {
        this.DoHoa = DoHoa;
    }

    public String getDoHoaRoi() {
        return DoHoaRoi;
    }

    public void setDoHoaRoi(String DoHoaRoi) {
        this.DoHoaRoi = DoHoaRoi;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getBoNho() {
        return BoNho;
    }

    public void setBoNho(String BoNho) {
        this.BoNho = BoNho;
    }

    public String getKTManHinh() {
        return KTManHinh;
    }

    public void setKTManHinh(String KTManHinh) {
        this.KTManHinh = KTManHinh;
    }

    public String getPhanGiai() {
        return PhanGiai;
    }

    public void setPhanGiai(String PhanGiai) {
        this.PhanGiai = PhanGiai;
    }

    public String getMHCamUng() {
        return MHCamUng;
    }

    public void setMHCamUng(String MHCamUng) {
        this.MHCamUng = MHCamUng;
    }

    public String getKhoiLuong() {
        return KhoiLuong;
    }

    public void setKhoiLuong(String KhoiLuong) {
        this.KhoiLuong = KhoiLuong;
    }
    
}
