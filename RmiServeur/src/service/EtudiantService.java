
package service;

import beans.Etudiant;
import beans.EtudiantDb;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;


public class EtudiantService extends UnicastRemoteObject implements IEtudiants{
    private EtudiantDb metier;
    
    public EtudiantService() throws RemoteException {
        this.metier = new EtudiantDb();
    }
    

    @Override
    public void AddEtudiant(String nom, String login, String passwor, Date date) throws RemoteException {
        Etudiant etudiant = new Etudiant(nom, login, passwor, date);
        this.metier.getAddEtudiant(nom, login, passwor, date);
    }

    @Override
    public List<Etudiant> chercherEtudiantNom(String nom) throws RemoteException {
        return this.metier.chercherEtudiantParNom(nom);
    }

    @Override
    public List<Etudiant> listeEtudiant() throws RemoteException {
        return metier.listerEtudiant();
    }

    @Override
    public void supprimerEtudiant(String nom) throws RemoteException {
        this.metier.supprimerEtudiantParNom(nom);
    }

    @Override
    public List<Etudiant> chercherEtudiantId(int id) throws RemoteException {
        return this.metier.chercherEtudiantParId(id);
    }

    @Override
    public boolean geConnecter(String login, String password) throws RemoteException {
        return this.metier.seConnecter(login, password);
    }

    @Override
    public void modifierEtudiant(Etudiant etudian) throws RemoteException {
        this.metier.modifierEtudiant(etudian);
    }
    
}
