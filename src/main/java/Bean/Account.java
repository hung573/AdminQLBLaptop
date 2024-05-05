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
@Entity (name ="Account")
@Table(name ="Account")
public class Account implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdAccount")
    private int IdAccount;
    @Column(name="UserName")
    private String UserName;
    @Column(name = "Password")
    private String Password;

    public Account() {
    }

    public Account(int IdAccount, String UserName, String Password) {
        this.IdAccount = IdAccount;
        this.UserName = UserName;
        this.Password = Password;
    }
    
    public int getIdAccount() {
        return IdAccount;
    }

    public void setIdAccount(int IdAccount) {
        this.IdAccount = IdAccount;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
}
