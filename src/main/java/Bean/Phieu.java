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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Phieu implements Serializable {
    @Id
    private String IdPhieu;
    @Column
    private String GhiChu;
    @Column
    private String Loai;
    @Column
    private String TrangThai;
    @Column
    @Temporal(value = TemporalType.DATE)
    private Date NgayTao;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdNhanVien",foreignKey = @ForeignKey(name="fk_IdNhanVien_Phieu"), nullable = true, insertable=true, updatable=true)
    private Person_NhanVien nhanvien;
    
    @OneToMany (fetch = FetchType.LAZY, targetEntity = PhieuChiTiet.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdPhieu", nullable = true,insertable=true, updatable=true)
    private List<PhieuChiTiet> listphieuchitiet;

    public Phieu() {
    }

    public List<PhieuChiTiet> getListphieuchitiet() {
        return listphieuchitiet;
    }

    public void setListphieuchitiet(List<PhieuChiTiet> listphieuchitiet) {
        this.listphieuchitiet = listphieuchitiet;
    }

    public String getIdPhieu() {
        return IdPhieu;
    }

    public void setIdPhieu(String IdPhieu) {
        this.IdPhieu = IdPhieu;
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

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Person_NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Person_NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }
    
    

    
}
