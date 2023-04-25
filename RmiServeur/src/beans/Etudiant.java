
package beans;

import java.io.Serializable;
import java.util.Date;



public class Etudiant implements Serializable{
    private int idE;
    private String nomEd;
    private String login;
    private String passWord;
    private Date date;

    public Etudiant(String nomEd, String login, String passWord) {
        this.nomEd = nomEd;
        this.login = login;
        this.passWord = passWord;
    }

    public Etudiant(String nom, String login, String password, Date date) {
        this.nomEd = nom;
        this.login = login;
        this.passWord = password;
        this.date= date;
        
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Etudiant(int idE, String nomEd, String login, String passWord, Date date) {
        this.idE = idE;
        this.nomEd = nomEd;
        this.login = login;
        this.passWord = passWord;
        this.date = date;
    }

    public Etudiant() {
    }

    public Etudiant(int idE, String nomEd, String login, String passWord) {
        this.idE = idE;
        this.nomEd = nomEd;
        this.login = login;
        this.passWord = passWord;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    public String getNomEd() {
        return nomEd;
    }

    public void setNomEd(String nomEd) {
        this.nomEd = nomEd;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
}
