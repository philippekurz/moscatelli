package fr.hellocorp.projetmoscatelli.admin.outil;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepositoryOutils extends CrudRepository <Outil, Long> {
    Long countById(Long id);


//    @Query(
//            value="select *, if(type_statut=0,'Fonction',if(type_statut=1,'Rebut',if(type_statut=2,'Manquant',if(type_statut=3,'Maintenance',if(type_statut=4,'Etalonnage','Statut inconnu'))))) AS statut from outils where (etalonnee=?2) AND ((if(type_statut=0,'Fonction',if(type_statut=1,'Rebut',if(type_statut=2,'Manquant',if(type_statut=3,'Maintenance',if(type_statut=4,'Etalonnage','Statut inconnu'))))) like %?1%) OR (designation LIKE %?1% ) OR (fournisseur LIKE %?1%) OR (periodicite LIKE %?1%) OR (marque LIKE %?1%) OR (puissance LIKE %?1%) OR (modele LIKE %?1%) OR (numero_de_serie LIKE %?1%) OR (repere LIKE %?1%) OR (etat LIKE %?1%) OR (capacite LIKE %?1%));",
//            nativeQuery = true)

    @Query(
            value="select o.*, if(o.type_statut=0,'Fonction',if(o.type_statut=1,'Rebut',if(o.type_statut=2,'Manquant',if(o.type_statut=3,'Maintenance',if(o.type_statut=4,'Etalonnage','Statut inconnu'))))) AS statut, es.id AS ides, es.date_retour, es.date_de_retour_prevue from outils o left join(select id, id_outil, date_retour, date_de_retour_prevue from entrees_sorties WHERE date_retour IS NULL) es on es.id_outil = o.id where (o.etalonnee=?2) AND ((if(o.type_statut=0,'Fonction',if(o.type_statut=1,'Rebut',if(o.type_statut=2,'Manquant',if(o.type_statut=3,'Maintenance',if(o.type_statut=4,'Etalonnage','Statut inconnu'))))) like %?1%) OR (o.designation LIKE %?1% ) OR (o.fournisseur LIKE %?1%) OR (o.periodicite LIKE %?1%) OR (o.marque LIKE %?1%) OR (o.puissance LIKE %?1%) OR (o.modele LIKE %?1%) OR (o.numero_de_serie LIKE %?1%) OR (o.repere LIKE %?1%) OR (o.etat LIKE %?1%) OR (o.capacite LIKE %?1%));",
            nativeQuery = true)
    List<Outil> search(String keyword, boolean etalonnee);

    @Query(
            value = "select o.*, es.id AS ides, es.date_retour, es.date_de_retour_prevue from outils o left outer join (select id, id_outil, date_retour, date_de_retour_prevue from entrees_sorties WHERE date_retour IS NULL) es on es.id_outil = o.id WHERE (o.etalonnee=?1);",
            nativeQuery = true)
    List<Outil> findByEtalonnee(boolean etalonnee);

}

