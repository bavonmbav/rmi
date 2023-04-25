
package service;

import beans.Etudiant;
import java.rmi.*;
import java.util.Date;
import java.util.List;


public interface IEtudiants extends Remote{
    
    public void AddEtudiant(String nom, String login, String passwor, Date date)throws RemoteException;
    public List<Etudiant>chercherEtudiantNom(String nom) throws RemoteException;
    public List<Etudiant>listeEtudiant()throws RemoteException;
    public void supprimerEtudiant(String nom)throws RemoteException;
    public List<Etudiant> chercherEtudiantId(int id) throws RemoteException;
    public boolean geConnecter(String login, String password)throws RemoteException;
    public void modifierEtudiant(Etudiant etudian)throws RemoteException;
      
}
