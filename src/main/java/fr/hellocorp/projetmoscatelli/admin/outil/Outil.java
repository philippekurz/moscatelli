package fr.hellocorp.projetmoscatelli.admin.outil;

import fr.hellocorp.projetmoscatelli.admin.entree_sortie.EntreeSortie;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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
       Fonction, Rebut, Manquant, Maintenance, Etalonnage,Prêt
    }
    //////////////////////////////////////// DECLARATIONS DES VARIABLES ////////////////////////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Column(nullable = false, length = 30)
    private TypeStatut typeStatut;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_etalonnage;

    @Column(nullable = true)
    private Integer periodicite;

    @Column(name = "disponibilite", columnDefinition = "BOOLEAN DEFAULT true")
    private boolean disponibilite;

    @Column(name = "etalonnee", columnDefinition = "BOOLEAN DEFAULT false")
    private boolean etalonnee;

    @Column( length = 70 )
    private String utilisateur_creation;

    @Column(name="date_creation", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP" )
    private LocalDateTime date_creation;

    @Column( length = 70)
    private String utilisateur_maj;

    @Column(name="date_maj", columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")
    private LocalDateTime date_maj;

    @OneToMany( cascade = CascadeType.REMOVE, mappedBy = "outil")
    private List<EntreeSortie> entreesSorties = new ArrayList<>();

    @Transient
    private EntreeSortie esEnCours;

    @Transient
    private String classCouleur;

    public Outil(Long id, String designation, String fournisseur, String marque, String modele, String numero_de_serie, String capacite, String puissance, String repere, String etat, TypeStatut typeStatut, Integer periodicite, boolean disponibilite, boolean etalonnee, String utilisateur_creation, LocalDateTime date_creation, String utilisateur_maj, LocalDateTime date_maj, List<EntreeSortie> entreesSorties) {
        this.id = id;
        this.designation = designation;
        this.fournisseur = fournisseur;
        this.marque = marque;
        this.modele = modele;
        this.numero_de_serie = numero_de_serie;
        this.capacite = capacite;
        this.puissance = puissance;
        this.repere = repere;
        this.etat = etat;
        this.typeStatut = typeStatut;
        this.periodicite = periodicite;
        this.disponibilite = disponibilite;
        this.etalonnee = etalonnee;
        this.utilisateur_creation = utilisateur_creation;
        this.date_creation = date_creation;
        this.utilisateur_maj = utilisateur_maj;
        this.date_maj = date_maj;
        this.entreesSorties = entreesSorties;

    }

    public Outil(String designation, String fournisseur, String marque, String modele, String numero_de_serie, String capacite, String puissance, String repere, String etat, TypeStatut typeStatut, Integer periodicite, boolean disponibilite, boolean etalonnee, String utilisateur_creation, LocalDateTime date_creation, String utilisateur_maj, LocalDateTime date_maj, List<EntreeSortie> entreesSorties) {
        this.designation = designation;
        this.fournisseur = fournisseur;
        this.marque = marque;
        this.modele = modele;
        this.numero_de_serie = numero_de_serie;
        this.capacite = capacite;
        this.puissance = puissance;
        this.repere = repere;
        this.etat = etat;
        this.typeStatut = typeStatut;
        this.periodicite = periodicite;
        this.disponibilite = disponibilite;
        this.etalonnee = etalonnee;
        this.utilisateur_creation = utilisateur_creation;
        this.date_creation = date_creation;
        this.utilisateur_maj = utilisateur_maj;
        this.date_maj = date_maj;
        this.entreesSorties = entreesSorties;

    }

    @PostLoad
    private void postLoad() {
        // Tri de la collection sur id
        Collections.sort(entreesSorties, (es1, es2)->{
            return (int)(es2.getId()-es1.getId());
        });
        if (entreesSorties.size()==0)
            this.esEnCours = new EntreeSortie();
        else {
            if (entreesSorties.get(0).getDate_retour() == null)
                this.esEnCours = entreesSorties.get(0);
            else
                this.esEnCours = new EntreeSortie();
        }

        if (this.esEnCours.getId()==null && (this.typeStatut.equals(TypeStatut.Fonction)))
            classCouleur = "vert";
        else {
            if(this.esEnCours.getId()!=null) {
                if (this.esEnCours.getDate_de_retour_prevue()!=null) {
                    if (this.esEnCours.getDate_de_retour_prevue().isBefore(LocalDate.now()))
                        classCouleur = "rouge";
                    else
                        classCouleur = "orange";
                }
            }
            else
                classCouleur = "orange";

        }

        if (this.date_etalonnage != null)
            if (this.date_etalonnage.plusMonths(this.periodicite).isAfter(LocalDate.now()))
                classCouleur="rouge";
//        // Tri de la collection sur id
//        Collections.sort(entreesSorties, (es1, es2)->{
//            return (int)(es2.getDate_etalonnage().compareTo(es1.getDate_etalonnage()));
//        });


        if(this.typeStatut.equals(TypeStatut.Etalonnage))
            classCouleur="bleu";

        if(this.typeStatut.equals(TypeStatut.Rebut))
            classCouleur="gris";

        if(this.typeStatut.equals(TypeStatut.Maintenance))
            classCouleur="vertClair";




    }

    public Outil() {
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(String fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getNumero_de_serie() {
        return numero_de_serie;
    }

    public void setNumero_de_serie(String numero_de_serie) {
        this.numero_de_serie = numero_de_serie;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getRepere() {
        return repere;
    }

    public void setRepere(String repere) {
        this.repere = repere;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public TypeStatut getTypeStatut() {
        return typeStatut;
    }

    public void setTypeStatut(TypeStatut typeStatut) {
        this.typeStatut = typeStatut;
    }

    public Integer getPeriodicite() {
        return periodicite;
    }

    public void setPeriodicite(Integer periodicite) {
        this.periodicite = periodicite;
    }

    public boolean isDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public boolean isEtalonnee() {
        return etalonnee;
    }

    public void setEtalonnee(boolean etalonnee) {
        this.etalonnee = etalonnee;
    }

    public String getUtilisateur_creation() {
        return utilisateur_creation;
    }

    public void setUtilisateur_creation(String utilisateur_creation) {
        this.utilisateur_creation = utilisateur_creation;
    }

    public LocalDateTime getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(LocalDateTime date_creation) {
        this.date_creation = date_creation;
    }

    public String getUtilisateur_maj() {
        return utilisateur_maj;
    }

    public void setUtilisateur_maj(String utilisateur_maj) {
        this.utilisateur_maj = utilisateur_maj;
    }

    public LocalDateTime getDate_maj() {
        return date_maj;
    }

    public void setDate_maj(LocalDateTime date_maj) {
        this.date_maj = date_maj;
    }

    public List<EntreeSortie> getEntreesSorties() {
        return entreesSorties;
    }

    public void setEntreesSorties(List<EntreeSortie> entreesSorties) {
        this.entreesSorties = entreesSorties;
    }

    public EntreeSortie getEsEnCours() {
        return esEnCours;
    }

    public String getClassCouleur() {
        return classCouleur;
    }

    public void setClassCouleur(String classCouleur) {
        this.classCouleur = classCouleur;
    }

    @Override
    public String toString() {
        return "Outil{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                ", fournisseur='" + fournisseur + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", numero_de_serie='" + numero_de_serie + '\'' +
                ", capacite='" + capacite + '\'' +
                ", puissance='" + puissance + '\'' +
                ", repere='" + repere + '\'' +
                ", etat='" + etat + '\'' +
                ", typeStatut=" + typeStatut +
                ", periodicite='" + periodicite + '\'' +
                ", disponibilite=" + disponibilite +
                ", etalonnee=" + etalonnee +
                ", utilisateur_creation='" + utilisateur_creation + '\'' +
                ", date_creation=" + date_creation +
                ", utilisateur_maj='" + utilisateur_maj + '\'' +
                ", date_maj=" + date_maj +
                ", entreesSorties=" + entreesSorties +
                '}';
    }
}
