

INSERT INTO utilisateurs (nom, prenom, email, mdp, telephone)

VALUES
    ( 'Delafontaine', 'Jean', 'Jean@gmail.com', '$2y$10$0T9ZbDIx4yCBsHeiknhQMu1TjokcUSUtGvOFSrq7byDZzWJvsyxTu', '06 42 56 60 65' ),
    ( 'Dupont', 'Marc', 'dupont@gmail.com', '$2y$10$0T9ZbDIx4yCBsHeiknhQMu1TjokcUSUtGvOFSrq7byDZzWJvsyxTu', '06 42 56 60 65'),
    ( 'John', 'poe', 'okaaay@gmail.com', '$2y$10$0T9ZbDIx4yCBsHeiknhQMu1TjokcUSUtGvOFSrq7byDZzWJvsyxTu', '06 42 56 60 65' ),
    ( 'Albert', 'Einstein', 'Albert@gmail.com', '$2y$10$0T9ZbDIx4yCBsHeiknhQMu1TjokcUSUtGvOFSrq7byDZzWJvsyxTu', '06 42 56 60 65' ),
    ( 'donald', 'trump', 'visiteur@gmail.com', '$2y$10$0T9ZbDIx4yCBsHeiknhQMu1TjokcUSUtGvOFSrq7byDZzWJvsyxTu', '06 42 56 60 65' ),
    ( 'claude', 'François', 'magasinier@gmail.com', '$2y$10$0T9ZbDIx4yCBsHeiknhQMu1TjokcUSUtGvOFSrq7byDZzWJvsyxTu', '06 42 56 60 65' ),
    ( 'quentin', 'tarantino', 'admin@gmail.com', '$2y$10$0T9ZbDIx4yCBsHeiknhQMu1TjokcUSUtGvOFSrq7byDZzWJvsyxTu', '06 42 56 60 65') ;

INSERT INTO outils (designation, fournisseur, marque,
                   modele, numero_de_serie, capacite, puissance, repere, etat, type_statut, periodicite, etalonnee)

VALUES

    ( 'Perceuse','Moscatelli','Leroy' , 'X7FF25', 'A000018851', '', '600W','A00012' ,'BON', 0 ,NULL,false),
    ( 'Perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A000018775', '', '800W', 'A00015' ,'BON', 2 ,NULL,false),
    ( 'perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A000031895', '', '600W','A00014' ,'BON', 4 ,NULL,false),
    ( 'Scie', 'Moscatelli','Leroy' , 'X7FF25', 'A000301854', '', '50W','A00013' ,'MOYEN' , 4 ,NULL,false),
    ( 'Perceuse','Moscatelli','Leroy' , 'X7FF25', 'A00067701851', '', '600W','A00012' ,'BON', 4 ,NULL,false),
    ( 'Perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A0000185875', '', '800W', 'A00015' ,'BON', 2 ,NULL,false),
    ( 'perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A00052801895', '', '600W','A00014' ,'BON', 3 ,NULL,false),
    ( 'Scie', 'Moscatelli','Leroy' , 'X7FF25', 'A0000316854', '', '50W','A00013' ,'MOYEN' , 4 ,NULL,false),
    ( 'Perceuse','Moscatelli','Leroy' , 'X7FF25', 'A0000187851', '', '600W','A00012' ,'BON', 0 ,NULL,false),
    ( 'Perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A0000187875', '', '800W', 'A00015' ,'BON', 4 ,NULL,false),
    ( 'perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A0000314895', '', '600W','A00014' ,'BON', 3 ,NULL,false),
    ( 'Scie', 'Moscatelli','Leroy' , 'X7FF25', 'A00030122854', '', '50W','A00013' ,'MOYEN' , 1 ,NULL,false),
    ( 'Perceuse','Moscatelli','Leroy' , 'X7FF25', 'A000677101851', '', '600W','A00012' ,'BON', 1 ,NULL,false),
    ( 'Perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A00001825875', '', '800W', 'A00015' ,'BON', 2 ,NULL,false),
    ( 'perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A000528012895', '', '600W','A00014' ,'BON', 3 ,NULL,false),
    ( 'Scie', 'Moscatelli','Leroy' , 'X7FF25', 'A000031681154', '', '50W','A00013' ,'MOYEN' , 2 ,NULL,false),



    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X7FF25', 'A00012735', '400mm', '250W','AC0001' ,'Bon', 0 ,'6',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X35765', 'A000152326', '600mm', '300W', 'AC0002' ,'Bon', 0 ,'1',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X7FF25', 'A000129375', '400mm', '250W','AC0001' ,'Bon', 0 ,'3',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X35765', 'A0001233+6', '600mm', '300W', 'AC0002' ,'Bon', 0 ,'12',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X7FF25', 'A000122395', '400mm', '250W','AC0001' ,'Bon', 0 ,'1',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X35765', 'A000123936', '600mm', '300W', 'AC0002' ,'Bon', 0 ,'1',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X7FF25', 'A000127835', '400mm', '250W','AC0001' ,'Bon', 0 ,'2',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X35765', 'A000127386', '600mm', '300W', 'AC0002' ,'Bon', 0 ,'2',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X7FF25', 'A000175235', '400mm', '250W','AC0001' ,'Bon', 0 ,'3',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X35765', 'A000123226', '600mm', '300W', 'AC0002' ,'Bon', 0 ,'4',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X72HH5', 'A000123227', '400mm', '400W','AC0003' ,'Non fonctionnel' , 1 ,'12',true);


INSERT INTO droits (nom)
VALUES  ("ROLE_VISITEUR"),
        ("ROLE_MAGASINIER"),
        ("ROLE_ADMINISTRATEUR");

INSERT INTO utilisateurs_droits (id_utilisateur, id_droit)
VALUES  (1,1),
        (2,2),
        (3,3),
        (4,1),
        (5,1),
        (6,2),
        (7,3);

INSERT INTO configuration (destinataires_notification, heure_envoi, alerte_on_off, duree_pret)
VALUES ("hello.corp@javenir84.com",
        "12:00",
        false,
        30);
/*
INSERT INTO entrees_sorties (motif, id_outil, id_utilisateur, date_sortie, date_de_retour_prevue, date_retour, date_etalonnage, probleme, referencepv) VALUES
    (0,1,1,'20211221','20220121',NULL, NULL, 'ES11', ''),
    (0,1,1,'20211220','20220120',NULL, NULL, 'ES11', '');
*/

INSERT INTO entrees_sorties (motif, id_outil, id_utilisateur, date_sortie, date_de_retour_prevue, date_retour, date_etalonnage, probleme, referencepv)

VALUES
-- Outil 1
    (0,1,1,'20211220','20220120',NULL, NULL, 'ES11', ''),
    (0,1,1,'20201002','20201102','20201101', NULL, 'ES12', ''),
    (0,1,1,'20190525','20190625','20190628', NULL, 'ES13', ''),

-- Outil 2
    (0,2,2,'20211221','20220121',NULL, NULL, 'ES22', ''),
    (0,2,2,'20210523','20210623','20210620', NULL, 'ES21', ''),

-- Outil 3
    (0,3,3,'20220105','20220205','20220204', NULL, 'ES31', ''),
    (0,3,2,'20211217','20220117','20220116', NULL, 'ES32', ''),
    (0,3,5,'20211120','20211220','20211214', NULL, 'ES33', ''),
    (0,3,4,'20180506','20180606','20180602', NULL, 'ES34', ''),

-- Outil 4
    (0,4,4,'20211225','20220125',NULL, NULL, 'ES41', ''),
    (0,4,4,'20200625','20200725','20200720', NULL, 'ES41', ''),
    (0,4,4,'20190715','20190814','20190710', NULL, 'ES41', ''),
    (0,4,4,'20180112','20180212','20180214', NULL, 'ES41', ''),
    (0,4,4,'20170215','20170315', '20170314', NULL, 'ES41', ''),

-- Outil 5
    (0,5,5,'20210202','20210302','20210301', NULL, 'ES51', 'PV003'),

-- Outil 6
    (0,6,6,'20220103','20220203',NULL, NULL, 'ES61', 'PV0005'),

-- Outil 7

-- Outil 8

-- Outil 9

-- Outil 10
    (0,10,7,'20211023','20211123',NULL, NULL, 'ES101', 'PV06'),

-- Outil 17 : 3 étalonnages
    (1,17,2,'20220113','20220213','20220210', '20220210', 'ES32', 'PV202207'),
    (1,17,2,'20210115','20210215','20210130', '20210130', 'ES32', 'PV202106'),
    (1,17,2,'20200120','20200220','20200215', '20200215', 'ES32', 'PV202006');
