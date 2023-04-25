
package beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EtudiantDb {

    public EtudiantDb() {
    }
    
   static Connection con;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
    public static Connection getconnexion(){
        try {
              Class.forName("com.mysql.cj.jdbc.Driver");
            // Etablir la connexion avec la base de données
            String url = "jdbc:mysql://localhost:3306/gestion";
            String utilisateur = "root";
            String motDePasse = "root";
             con = DriverManager.getConnection(url, utilisateur, motDePasse);
             System.out.println("connexion reussi...");
        } catch (Exception e) {
             System.out.println("connexion echec");
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return con;
    }
    
    public void getAddEtudiant(String nom, String login, String passwor, Date date){
        
            conn = getconnexion();
        try {
             String sql = "INSERT INTO Etudiant (nomEtudiant, login,passWord, dateNais) VALUES (?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,nom );
            stmt.setString(2, login);
            stmt.setString(3, passwor);
            stmt.setDate(4, new java.sql.Date(0));
            stmt.executeUpdate();
            System.out.println("bien ajouter...");
        } catch (Exception e) {
            System.out.println("echec lors de l'ajout...");
        }  
    }
//     Méthode pour supprimer un étudiant par nom
    public void supprimerEtudiantParNom(String nomEtudiant){
      conn = getconnexion();
    String sql = "DELETE FROM Etudiant WHERE nomEtudiant = ?";
    try{
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, nomEtudiant);
      stmt.executeUpdate();
        System.out.println("la suppresion a reussi..");
    }catch(Exception e){
        System.out.println("erreur de suppresion");
    }
  }
     // Méthode pour chercher un étudiant par nom
    public List<Etudiant> chercherEtudiantParId(int id){
      List<Etudiant> etudiants = new ArrayList<>();
      conn = getconnexion();
     String sql = "SELECT * FROM Etudiant WHERE id = ?";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setInt(1, id);
      ResultSet result = stmt.executeQuery();
      while (result.next()) {
          
        String nom = result.getString("nomEtudiant");
        String login = result.getString("login");
        String passWord = result.getString("passWord");
        Date dateNais = result.getDate("dateNais");
        Etudiant etudiant = new Etudiant(nom, login, passWord);
        
        etudiants.add(etudiant);
       System.out.println(etudiant.getLogin());
      } 
         return etudiants;
    }catch(Exception e){
         System.out.println("erreur");
    }
     return null;
  }
    public List<Etudiant> chercherEtudiantParNom(String nomEtudiant){
      List<Etudiant> etudiants = new ArrayList<>();
      conn = getconnexion();
     String sql = "SELECT * FROM Etudiant WHERE nomEtudiant = ?";
    try {
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, nomEtudiant);
      ResultSet result = stmt.executeQuery();
      while (result.next()) {
        int id = result.getInt("id");
        String login = result.getString("login");
        String passWord = result.getString("passWord");
        Date dateNais = result.getDate("dateNais");
        Etudiant etudiant = new Etudiant(id, login, login, passWord);
        
        etudiants.add(etudiant);
       System.out.println(etudiant.getLogin());
      } 
         return etudiants;
    }catch(Exception e){
         System.out.println("erreur");
    }
     return null;
  }
    public List<Etudiant> listerEtudiant(){
      List<Etudiant> etudiants = new ArrayList<>();
      conn = getconnexion();
     String sql = "SELECT * FROM Etudiant";
    try {
      stmt = conn.prepareStatement(sql);
      ResultSet result = stmt.executeQuery();
      while (result.next()) {
        int id = result.getInt("id");
        String nom = result.getString("nomEtudiant");
        String login = result.getString("login");
        String passWord = result.getString("passWord");
        Date dateNais = result.getDate("dateNais");
        Etudiant etudiant = new Etudiant(id, nom, login, passWord,dateNais);
        etudiants.add(etudiant);
       System.out.println(etudiant.getIdE()+" "+etudiant.getNomEd()+" "+etudiant.getLogin()+" "+etudiant.getPassWord()+etudiant.getDate());
      } 
         return etudiants;
    }catch(Exception e){
         System.out.println("erreur");
    }
     return null;
  }
   // Méthode pour modifier un étudiant
    
    
    
  public boolean seConnecter(String login, String password) {
      conn = getconnexion();
    String sql = "SELECT nomEtudiant FROM Etudiant WHERE login=? AND passWord=?";
    boolean estConnecte = false;
    try {
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, login);
        stmt.setString(2, password);
        rs = stmt.executeQuery();
        Etudiant et = new Etudiant();
        if(rs.next())
        {
            estConnecte = true;
           System.out.println("connecter "+login);
        }
    } catch (SQLException e) {
        System.out.println("Erreur lors de la tentative de connexion : " + e.getMessage());
    }
    return estConnecte;
}


 public void modifierEtudiant(Etudiant etudiant){
   conn = getconnexion();
  String sql = "UPDATE Etudiant SET nomEtudiant = ?, login = ?, passWord = ? WHERE id = ?";
  try{ 
    stmt = conn.prepareStatement(sql); // Initialise l'objet stmt
    stmt.setString(1, etudiant.getNomEd());
    stmt.setString(2, etudiant.getLogin());
    stmt.setString(3, etudiant.getPassWord());
    stmt.setInt(4, etudiant.getIdE());
    stmt.executeUpdate();
    System.out.println("ok");
  }catch(Exception e){
    System.out.println("erreur" + e.getMessage());
    e.printStackTrace();
  }
}

//     public static void main(String[] args) {
//         Etudiant et = new Etudiant(2,"bavon", "mer", "ert");
//        EtudiantDb db = new EtudiantDb();
//    
//
//    //   db.getAddEtudiant("patrick", "merveille", "bavon", new Date());
//
//      db.seConnecter("bavon","bavon");
//    // db.listerEtudiant();
//      //db.modifierEtudiant(et);
//   
//    }
       
}
