package fr.hellocorp.projetmoscatelli.admin.entree_sortie;

import fr.hellocorp.projetmoscatelli.admin.pojo.EtalonnageES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntreeSortieService {

    @Autowired
    private IRepositoryEntreeSortie repo;
    @Autowired
    private IRepositoryEtalonnageES repoEtalonnageES;

    public List<EntreeSortie> findAll(String keyword) {

        if (keyword != null) {
            return repo.search(keyword);}
        return (List<EntreeSortie>) repo.findAll();
    }

    public List<EntreeSortie> findAll() {
        return (List<EntreeSortie>) repo.findAll();
    }

    public void enregistrer(EntreeSortie entreeSortie) {
        repo.save(entreeSortie);
    }

    public void supprimer(Long id) throws EntreeSortieNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count ==0) {
            throw new EntreeSortieNotFoundException("ce pret " + id + " n'existe pas.");
        }
        repo.deleteById(id);
    }

    public EntreeSortie getLastById(Long id_outil) {
        return repo.findLastByOutil(id_outil);
    }

    public List<EntreeSortie> retardsOutils() {
        return repo.retardOutils();
    }

    public List<EntreeSortie> notificationOutils() {return repo.notificationsOutils();}

    public List<EtalonnageES> notificationsEtalonnage() {return repoEtalonnageES.notificationsEtalonnage();}
}
