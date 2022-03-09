package fr.hellocorp.projetmoscatelli.admin.utilisateur;

import fr.hellocorp.projetmoscatelli.admin.droit.Droit;
import fr.hellocorp.projetmoscatelli.admin.droit.IRepositoryDroit;
import fr.hellocorp.projetmoscatelli.admin.outil.Outil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("utilisateurService")
public class UtilisateurService {
    @Autowired
    private IRepositoryUtilisateur repo;
    @Autowired
    private IRepositoryDroit repositoryDroit;

    public List<Utilisateur> findAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);}
        return (List<Utilisateur>) repo.findAll();
    }

    public List<Utilisateur> findAll(){
        return (List<Utilisateur>) repo.findAll();
    }

    public void enregistrer(Utilisateur utilisateur) {
        if (utilisateur.getId() == null) {

            //Cryptage du mot de passe
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            utilisateur.setMdp(encoder.encode(utilisateur.getMdp()));

            //role
            Droit droit = repositoryDroit.findByNom("Visiteur");
            utilisateur.ajouterDroit(droit);
        }
        repo.save(utilisateur);
    }

    public void supprimer(Long id) throws UtilisateurNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count ==0) {
            throw new UtilisateurNotFoundException("l'utilisateur " + id + " n'existe pas.");
        }
        repo.deleteById(id);
    }

}
