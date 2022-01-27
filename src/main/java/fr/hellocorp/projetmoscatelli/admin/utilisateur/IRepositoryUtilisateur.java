package fr.hellocorp.projetmoscatelli.admin.utilisateur;

import fr.hellocorp.projetmoscatelli.admin.entree_sortie.EntreeSortie;
import fr.hellocorp.projetmoscatelli.admin.outil.Outil;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepositoryUtilisateur extends CrudRepository <Utilisateur, Long> {
    Long countById( Long id);

    @Query(
            value="select * from utilisateurs where ((email LIKE %?1% ) OR (prenom LIKE %?1% ) OR (nom LIKE %?1% ) OR (telephone LIKE %?1% ))",
            nativeQuery = true)
    List<Utilisateur> search(String keyword);

    Utilisateur findByEmail(String email);
}

