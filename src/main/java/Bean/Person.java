/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



/**
 *
 * @author maiho
 */
@Entity
@Table(name ="Person")

@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person implements Serializable {
    @Id
    String IdPerson;
    @Column
    String Ten;
    @Column
    String Email;
    @Column
    String DiaChi;
    @Column
    String SDT;
              
    @OneToOne(fetch = FetchType.LAZY, targetEntity = Image.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "IdImage", nullable = true,insertable=true, updatable=true)
    private Image image;
    

    public Person() {
        
    }
    
    public String getIdPerson() {
        return IdPerson;
    }
    
    public void setIdPerson(String IdPerson) {
        this.IdPerson = IdPerson;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
   
}
