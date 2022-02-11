package fr.hellocorp.projetmoscatelli.admin.mail;


import fr.hellocorp.projetmoscatelli.admin.config.Configuration;
import fr.hellocorp.projetmoscatelli.admin.config.ConfigurationService;
import fr.hellocorp.projetmoscatelli.admin.entree_sortie.EntreeSortie;
import fr.hellocorp.projetmoscatelli.admin.entree_sortie.EntreeSortieService;
import fr.hellocorp.projetmoscatelli.admin.pojo.EtalonnageES;
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

    @Autowired
    ConfigurationService configService;

    
    @Scheduled(cron = "0 0 12 * ?", zone = "Europe/Paris")

    public void alertes() {
        Configuration configuration = configService.getConfig();
        if(!configuration.getAlerteOnOff())
            return;

        //Requête pour les outils à recalibrer
        //SELECT o.id, o.designation, o.periodicite AS periodicite, es.date_etalonnage, IF(o.periodicite IS NULL, NULL, IF(date_etalonnage IS NULL, NOW(), DATE_ADD(date_etalonnage, INTERVAL o.periodicite MONTH))) AS date_prochain_etalonnage FROM outils o LEFT OUTER JOIN (SELECT id_outil, MAX(date_etalonnage) AS date_etalonnage FROM entrees_sorties GROUP BY id_outil) es ON o.id = es.id_outil WHERE (IF(o.periodicite IS NULL, NULL, IF(date_etalonnage IS NULL, NOW(), DATE_ADD(date_etalonnage, INTERVAL o.periodicite MONTH)))<=DATE_ADD(NOW(),INTERVAL 60 DAY));


        // Récupérer le mail destinataire (v1 en dur)

        // Créer Liste avec EntreeSortieService (méthode getOutilRetard())
        // liste de entrées sorties avec date retour prévue < now() à 00:00:00
        // Liste de Entrées Sorties avec date de retour prévue = now+7 à 00:00:00
        List<EntreeSortie> liste = entreeSortieService.retardsOutils();
        List<EntreeSortie> liste2 = entreeSortieService.notificationOutils();
        List<EtalonnageES> liste3 = entreeSortieService.notificationsEtalonnage();
        Configuration config=configService.getConfig();

        String email = config.getDestinatairesNotification();
        // Split sur email avec separateur = ";"

        for (EntreeSortie es: liste) {
            System.out.println(
                    es.getUtilisateur().getNom()
                            + " " + es.getUtilisateur().getPrenom()
                            + " " + es.getOutil().getDesignation()
                            + " " + es.getOutil().getMarque()
                            + " " + es.getOutil().getNumero_de_serie()
                            + " " + es.getDate_sortie()
                            + " " + es.getDate_de_retour_prevue());

            String texte = "<div> Emprunteur : " + es.getUtilisateur().getNom()
                    + " " + es.getUtilisateur().getPrenom()
                    + " " + es.getUtilisateur().getTelephone()
                    + " " + es.getUtilisateur().getEmail() + "</div>"
                    + " <div> Outil : " +  es.getOutil().getDesignation()
                    + " " + es.getOutil().getMarque()
                    + " " + es.getOutil().getNumero_de_serie() + "</div>"
                    + "Date d'emprunt :  " + es.getDate_sortie()
                    + "<div>Date de retour prévue : " +  es.getDate_de_retour_prevue() +  "</div>";

            emailService.envoiEmail(configService.getConfig().getDestinatairesNotification() , "Retard d'emprunt", texte );
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
            
            emailService.envoiEmail(configService.getConfig().getDestinatairesNotification(), "Notification d'emprunt", texte );
            //designation outil
            //date de retour prévue
            //emprunteur
            //Envoi le mail

        }

        /*for (EtalonnageES ese: liste3) {
            System.out.println(
                    ese.getNom()
                            + " " +  ese.getNom()
                            + " " +  ese.getNom()
                            + " " +  ese.getNom()
                            + " " +  ese.getNom()
                            + " " +  ese.getNom()
                            + " " +  ese.getNom()
            );

            //String texte = Le message, peut être formaté avec de l'html
            String texte = "<div> Emprunteur : " +  ese.getNom()
                    + " " +   ese.getNom()
                    + " " +  ese.getNom()
                    + " " +  ese.getNom() + "</div>"
                    + " <div> Outil : " +   ese.getNom()
                    + " " +   ese.getNom()
                    + " " +   ese.getNom() + "</div>"
                    + "Date d'emprunt :  " +  ese.getNom()
                    + "<div>Date de retour prévue : " +   ese.getNom() +  "</div>";

            emailService.envoiEmail(configService.getConfig().getDestinatairesNotification(), "Notification d'emprunt", texte );
            //designation outil
            //date de retour prévue
            //emprunteur
            //Envoi le mail

        }*/



        // Logique de préparation et envoi des mails
        System.out.println("Envoi des alertes par mail à " + LocalDate.now());
    }
}