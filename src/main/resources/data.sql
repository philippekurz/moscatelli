

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






INSERT INTO entrees_sorties (motif, id_outil, id_utilisateur, date_sortie, date_de_retour_prevue, date_retour, date_etalonnage, probleme, referencepv)

VALUES
    (0,1,1,'20211220','20030328','20220110', '20220201', 'ES11', ''),
    (0,1,1,'19971002','20030328','20220112', '20220201', 'ES12', ''),
    (0,1,1,'19971002','20030328','20220120', '20220201', 'ES13', ''),
    (0,2,2,'19971002','20030328','20030328', '20220201', 'ES21', ''),
    (0,2,2,'19971002','20030328',NULL, '20220201', 'ES22', ''),
    (0,3,3,'20220105','20030328',NULL, '20220201', 'ES31', ''),
    (0,3,2,'20220113','20030328','20220114', '20220201', 'ES32', ''),
    (0,3,5,'20220120','20030328','20220123', '20220201', 'ES33', ''),
    (0,3,4,'19971002','20030328',NULL, '20220201', 'ES34', ''),
    (0,4,4,'19971002','20030328',NULL, '20220201', 'ES41', ''),
    (0,5,5,'19971002','20030328',NULL, '20220201', 'ES51', 'PV003'),
    (0,6,6,'19971002','20030328',NULL, '20220201', 'ES61', 'PV0005'),
    (0,7,7,'19971002','20030328',NULL, '20220201', 'ES71', 'PV06'),

    -- 3 étalonnages pour l'outil 17
    (0,17,2,'20220113','20030328','20220114', '20200201', 'ES32', ''),
    (0,17,2,'20220113','20030328','20220114', '20240325', 'ES32', ''),
    (0,17,2,'20220113','20030328','20220114', '20220201', 'ES32', ''),

    (0,18,5,'20220120','20030328','20220123', '20220131', 'ES33', ''),

    (0,19,4,'19971002','20030328',NULL, '20220201', 'ES34', ''),
    (0,20,4,'19971002','20030328',NULL, '20220201', 'ES41', ''),
    (0,21,5,'19971002','20030328',NULL, '20220201', 'ES51', 'PV003'),
    (0,22,6,'19971002','20030328',NULL, '20220201', 'ES61', 'PV0005'),
    (0,23,7,'19971002','20030328',NULL, '20220201', 'ES71', 'PV06');


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
        true,
        30);