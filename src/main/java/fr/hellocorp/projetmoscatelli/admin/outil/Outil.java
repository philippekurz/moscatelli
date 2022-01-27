package fr.hellocorp.projetmoscatelli.admin.outil;

import fr.hellocorp.projetmoscatelli.admin.entree_sortie.EntreeSortie;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "outils",
        indexes = {
                @Index(columnList = "designation"),
                @Index(columnList = "marque"),
                @Index(columnList = "modele"),
                @Index(columnList = "numero_de_serie", unique = true),
                @Index(columnList = "typeStatut"),
                @Index(columnList = "designation, marque, modele")})
public class Outil {

    public enum TypeStatut{
       Fonction, Rebut, Manquant, Maintenance, Etalonnage
    }
    //////////////////////////////////////// DECLARATIONS DES VARIABLES ////////////////////////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,length = 100)
    private String designation;

    @Column(length = 100)
    private String fournisseur;

    @Column(nullable = false,length = 100)
    private String marque;

    @Column(length = 100)
    private String modele;

    @Column(unique = true,length = 100)
    private String numero_de_serie;

    @Column(length = 30)
    private String capacite;

    @Column(length = 30)
    private String puissance;

    @Column(length = 30)
    private String repere;

    @Column
    private String etat;

    @Column( nullable = false, length = 30)
    private TypeStatut typeStatut;

    @Column(length = 30)
    private String periodicite;

    @Column(name = "disponibilite", columnDefinition = "BOOLEAN DEFAULT true")
    private boolean disponibilite;

    @Column(name = "etalonnee", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean etalonnee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "outil")
    private Set<EntreeSortie> entreesSorties = new HashSet<>();

    @Column( length = 70 )
    private String utilisateur_creation;

    @Column(name="date_creation", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP" )
    private LocalDateTime date_creation;

    @Column( length = 70)
    private String utilisateur_maj;

    @Column(name="date_maj", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private LocalDateTime date_maj;
    //////////////////////////////////////// DECLARATIONS DES CONSTRUCTEURS ////////////////////////////////////////


    //////////////////////////////////////// DECLARATIONS DES GETTERS AND SETTERS ////////////////////////////////////////




    //////////////////////////////////////// DECLARATIONS methode to string ////////////////////////////////////////


}
