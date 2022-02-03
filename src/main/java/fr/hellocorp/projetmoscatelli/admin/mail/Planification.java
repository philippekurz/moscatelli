package fr.hellocorp.projetmoscatelli.admin.mail;


import fr.hellocorp.projetmoscatelli.admin.entree_sortie.EntreeSortie;
import fr.hellocorp.projetmoscatelli.admin.entree_sortie.EntreeSortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class Planification {

    @Autowired
    EntreeSortieService entreeSortieService;

    @Autowired
    EmailService emailService;

    @Scheduled(initialDelay = 1000000000000L, fixedDelay = 1000000000000L)
    public void alertes() {

        // Récupérer le mail destinataire (v1 en dur)

        // Créer Liste avec EntreeSortieService (méthode getOutilRetard())
        // liste de entrées sorties avec date retour prévue < now() à 00:00:00
        // Liste de Entrées Sorties avec date de retour prévue = now+7 à 00:00:00
        List<EntreeSortie> liste = entreeSortieService.retardsOutils();
        List<EntreeSortie> liste2 = entreeSortieService.notificationOutils();



        for (EntreeSortie es: liste) {
            System.out.println(
                    es.getUtilisateur().getNom()
                            + " " +  es.getUtilisateur().getPrenom()
                            + " " +  es.getOutil().getDesignation()
                            + " " +  es.getOutil().getMarque()
                            + " " +  es.getOutil().getNumero_de_serie()
                            + " " + es.getDate_sortie()
                            + " " +  es.getDate_de_retour_prevue());

            String texte = "<div> Emprunteur : " + es.getUtilisateur().getNom()
                    + " " +  es.getUtilisateur().getPrenom()
                    + " " + es.getUtilisateur().getTelephone()
                    + " " + es.getUtilisateur().getEmail() + "</div>"
                    + " <div> Outil : " +  es.getOutil().getDesignation()
                    + " " +  es.getOutil().getMarque()
                    + " " +  es.getOutil().getNumero_de_serie() + "</div>"
                    + "Date d'emprunt :  " + es.getDate_sortie()
                    + "<div>Date de retour prévue : " +  es.getDate_de_retour_prevue() +  "</div>";

            emailService.envoiEmail("hello.corp@javenir84.com", "Retard d'emprunt", texte );
        }

        for (EntreeSortie es: liste2) {
            System.out.println(
                    es.getUtilisateur().getNom()
                            + " " + es.getUtilisateur().getPrenom()
                            + " " + es.getOutil().getDesignation()
                            + " " + es.getOutil().getMarque()
                            + " " + es.getOutil().getNumero_de_serie()
                            + " " + es.getDate_sortie()
                            + " " + es.getDate_de_retour_prevue()
            );

            //String texte = Le message, peut être formaté avec de l'html
            String texte = "<div> Emprunteur : " + es.getUtilisateur().getNom()
                    + " " +  es.getUtilisateur().getPrenom()
                    + " " + es.getUtilisateur().getTelephone()
                    + " " + es.getUtilisateur().getEmail() + "</div>"
                    + " <div> Outil : " +  es.getOutil().getDesignation()
                    + " " +  es.getOutil().getMarque()
                    + " " +  es.getOutil().getNumero_de_serie() + "</div>"
                    + "Date d'emprunt :  " + es.getDate_sortie()
                    + "<div>Date de retour prévue : " +  es.getDate_de_retour_prevue() +  "</div>";
            
            emailService.envoiEmail("hello.corp@javenir84.com", "Notification d'emprunt", texte );
            //designation outil
            //date de retour prévue
            //emprunteur
            //Envoi le mail

        }


        // Logique de préparation et envoi des mails
        System.out.println("Envoi des alertes par mail à " + LocalDate.now());
    }
}