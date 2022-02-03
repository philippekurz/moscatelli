package fr.hellocorp.projetmoscatelli.admin.config;

import javax.persistence.*;
import java.time.LocalTime;


@Entity
@Table(name = "configurations")
public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false,length = 255)
    private String contact;

    @Column(nullable = false)
    private LocalTime heure_Envoi;

    @Column(name = "alerte_on_off", columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean alerte_on_off;

    @Column(nullable = false)
    private int duree_Pret;

    public Configuration() {
    }

    public Configuration(Long id, String contact, LocalTime heure_Envoi, Boolean alerte_on_off, int duree_Pret) {
        this.id = id;
        this.contact = contact;
        this.heure_Envoi = heure_Envoi;
        this.alerte_on_off = alerte_on_off;
        this.duree_Pret = duree_Pret;
    }

    public Configuration(String contact, LocalTime heure_Envoi, Boolean alerte_on_off, int duree_Pret) {
        this.contact = contact;
        this.heure_Envoi = heure_Envoi;
        this.alerte_on_off = alerte_on_off;
        this.duree_Pret = duree_Pret;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public LocalTime getHeure_Envoi() {
        return heure_Envoi;
    }

    public void setHeure_Envoi(LocalTime heure_Envoi) {
        this.heure_Envoi = heure_Envoi;
    }

    public Boolean getAlerte_on_off() {
        return alerte_on_off;
    }

    public void setAlerte_on_off(Boolean alerte_on_off) {
        this.alerte_on_off = alerte_on_off;
    }

    public int getDuree_Pret() {
        return duree_Pret;
    }

    public void setDuree_Pret(int duree_Pret) {
        this.duree_Pret = duree_Pret;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                ", heure_Envoi=" + heure_Envoi +
                ", alerte_on_off=" + alerte_on_off +
                ", duree_Pret=" + duree_Pret +
                '}';
    }
}
