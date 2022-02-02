package fr.hellocorp.projetmoscatelli.admin.entree_sortie;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepositoryEntreeSortie extends CrudRepository <EntreeSortie, Long> {
    Long countById(Long id);

    @Query("SELECT p FROM EntreeSortie p WHERE p.utilisateur.nom LIKE %?1%"
            + " OR p.outil.designation LIKE %?1%"
            + " OR CONCAT(p.date_sortie, '') LIKE %?1%"
            + " OR CONCAT(p.date_de_retour_prevue, '') LIKE %?1%"
            + "OR p.probleme LIKE %?1%"
            + "OR p.referencePV LIKE %?1%" )
    List<EntreeSortie> search(String keyword);

    @Query("SELECT es FROM EntreeSortie es WHERE (es.outil.id = ?1) AND es.date_retour IS NULL")
    EntreeSortie findLastByOutil(Long id_outil);

    @Query(value="select entrees_sorties.*, outils.designation, utilisateurs.nom, utilisateurs.prenom from entrees_sorties left join outils on outils.id = entrees_sorties.id_outil left join utilisateurs on utilisateurs.id = entrees_sorties.id_utilisateur where entrees_sorties.date_de_retour_prevue <= DATE(NOW()) AND entrees_sorties.date_retour is NULL;",nativeQuery = true)
    List<EntreeSortie> retardOutils();


    @Query(value="select entrees_sorties.*, outils.designation, utilisateurs.nom, utilisateurs.prenom from entrees_sorties left join outils on outils.id = entrees_sorties.id_outil left join utilisateurs on utilisateurs.id = entrees_sorties.id_utilisateur where entrees_sorties.date_de_retour_prevue = ADDDATE(DATE(NOW()),+7) AND entrees_sorties.date_retour is NULL;",nativeQuery = true)
    List<EntreeSortie> notificationsOutils();

}
