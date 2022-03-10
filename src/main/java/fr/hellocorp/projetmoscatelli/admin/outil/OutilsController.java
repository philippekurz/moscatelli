package fr.hellocorp.projetmoscatelli.admin.outil;

import fr.hellocorp.projetmoscatelli.admin.entree_sortie.EntreeSortie;
import fr.hellocorp.projetmoscatelli.admin.entree_sortie.EntreeSortieService;
import fr.hellocorp.projetmoscatelli.admin.utilisateur.Utilisateur;
import fr.hellocorp.projetmoscatelli.admin.utilisateur.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/outils")
public class OutilsController {

    @Autowired
    private OutilService service;
    @Autowired
    private EntreeSortieService entreeSortieService;
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private OutilService outilService;


    @GetMapping(value = {"/recherche",""})
    public String ShowTools(Model model, @Param("keyword") String keyword,@Param("etalonnee") boolean etalonnee) {

        List<Outil> outils = service.findAll(keyword, etalonnee);
        System.out.println(outils);
        model.addAttribute("Outils",outils);

        Outil outil = new Outil();
        model.addAttribute("Outil",outil);


        List<Utilisateur> utilisateurs = utilisateurService.findAll(keyword);
        model.addAttribute("utilisateurs", utilisateurs);

        model.addAttribute("url","/outils");
        model.addAttribute("etalonnee", etalonnee);
        model.addAttribute("keyword", keyword);

        model.addAttribute("currentDate", LocalDate.now());

        return "outils";
    }

    @PostMapping("/enregistrer")
    public String enregistrer(Outil outil,
                              @Param("etalonnee") boolean etalonnee) {
        outil.setEtalonnee(etalonnee);
        service.enregistrer(outil);

        return "redirect:/outils?etalonnee="+etalonnee;
    }

    @PostMapping("/sortie")
    public String sortie(
            @Param("keyword)") String keyword,
            @Param("etalonnee)") boolean etalonnee,
            @RequestParam Utilisateur utilisateur,
            @RequestParam Outil outil,

            @RequestParam String motif,
            @RequestParam String date_sortie,
            @RequestParam String date_de_retour_prevue)
    {
        EntreeSortie entreeSortie = new EntreeSortie();
        entreeSortie.setUtilisateur(utilisateur);
        entreeSortie.setOutil(outil);
        entreeSortie.setMotif(EntreeSortie.MotifEntreeSortie.valueOf(motif));
        entreeSortie.setDate_sortie(LocalDate.parse(date_sortie));
        entreeSortie.setDate_de_retour_prevue(LocalDate.parse(date_de_retour_prevue));

        entreeSortieService.enregistrer(entreeSortie);



        switch (EntreeSortie.MotifEntreeSortie.valueOf(motif)){

            case Maintenance:
                outil.setTypeStatut(Outil.TypeStatut.Maintenance);
                break;
            case Prêt:
                outil.setTypeStatut(Outil.TypeStatut.Prêt);
                break;
            case Rebut:
                outil.setTypeStatut(Outil.TypeStatut.Rebut);
                break;
            case Etalonnage:
                outil.setTypeStatut(Outil.TypeStatut.Etalonnage);
                break;
        }

        outilService.enregistrer(outil);

        return "redirect:/outils?keyword="+(Objects.equals(keyword, "null") ? "":keyword) +"&etalonnee="+etalonnee;
    }

    @PostMapping("/retour")
    public String retour(
            @Param("keyword)") String keyword,
            @Param("etalonnee)") boolean etalonnee,
            @RequestParam Outil outil,
            @RequestParam String idES,
            @RequestParam  String date_retour,
            @RequestParam(required = false) String date_etalonnage,
            @RequestParam String probleme,
            @RequestParam (required = false) MultipartFile file)
    {
        final String WORKING_DIR = "src/main/resources/pv";
        EntreeSortie entreeSortie = entreeSortieService.get(Long.parseLong(idES));

        if (entreeSortie != null) {
            entreeSortie.setDate_retour(LocalDate.parse(date_retour));
            if (date_etalonnage != null) entreeSortie.setDate_etalonnage(LocalDate.parse(date_etalonnage));

            if (date_retour != null){
                outil.setTypeStatut(Outil.TypeStatut.Fonction);
            }

            entreeSortie.setProbleme(probleme);
            if (null!=file) {
                entreeSortie.setReferencePV(Paths.get(WORKING_DIR + "/" + StringUtils.cleanPath(file.getOriginalFilename())).toString());

            }

            entreeSortieService.enregistrer(entreeSortie);
        }

        if (date_etalonnage != null) {
            outil.setDate_prochain_etalonnage(LocalDate.parse(date_etalonnage).plusMonths(outil.getPeriodicite()));
            outilService.enregistrer(outil);
        }

        if (file!=null) {

            // normalize the file path
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            try {
                Path path = Paths.get(WORKING_DIR + "/" + fileName);
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return "redirect:/outils?keyword="+(Objects.equals(keyword, "null") ? "":keyword) +"&etalonnee="+etalonnee;
    }



    @PostMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id,
                            @Param("etalonnee") boolean etalonnee,
                            @Param("keyword") String keyword) throws OutilNotFoundException {
        service.supprimer(id);

        return "redirect:/outils?keyword="+(Objects.equals(keyword, "null") ? "":keyword) +"&etalonnee="+etalonnee;
    }



    @PostMapping ("/modifier/{id}")
    public String modifier(@PathVariable Long id,
                           @Param("keyword)") String keyword,
                           @Param("etalonnee)") boolean etalonnee,
                           @RequestParam String designation,
                           @RequestParam String fournisseur,
                           @RequestParam String marque,
                           @RequestParam String modele,
                           @RequestParam String numero_de_serie,
                           @RequestParam String capacite,
                           @RequestParam String puissance,
                           @RequestParam String repere,
                           @RequestParam String etat,
                           @RequestParam Outil.TypeStatut typeStatut,
                           @RequestParam String periodicite) {

        Outil outil = new Outil();
        outil.setId(id);
        outil.setDesignation(designation);
        outil.setFournisseur(fournisseur);
        outil.setMarque(marque);
        outil.setModele(modele);
        outil.setNumero_de_serie(numero_de_serie);
        outil.setCapacite(capacite);
        outil.setPuissance(puissance);
        outil.setRepere(repere);
        outil.setEtat(etat);
        outil.setTypeStatut(Outil.TypeStatut.valueOf(String.valueOf(typeStatut)));
        if(periodicite.length()!=0)
            outil.setPeriodicite(Integer.parseInt(periodicite));
        outil.setEtalonnee(etalonnee);

        service.enregistrer(outil);

        return "redirect:/outils?keyword="+(Objects.equals(keyword, "null") ? "":keyword) +"&etalonnee="+etalonnee;
    }



}