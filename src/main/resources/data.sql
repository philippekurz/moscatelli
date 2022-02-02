

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

    ( 'Perceuse','Moscatelli','Leroy' , 'X7FF25', 'A000018851', '', '600W','A00012' ,'BON', 0 ,'',false),
    ( 'Perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A000018775', '', '800W', 'A00015' ,'BON', 2 ,'',false),
    ( 'perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A000031895', '', '600W','A00014' ,'BON', 4 ,'',false),
    ( 'Scie', 'Moscatelli','Leroy' , 'X7FF25', 'A000301854', '', '50W','A00013' ,'MOYEN' , 4 ,'',false),
    ( 'Perceuse','Moscatelli','Leroy' , 'X7FF25', 'A00067701851', '', '600W','A00012' ,'BON', 4 ,'',false),
    ( 'Perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A0000185875', '', '800W', 'A00015' ,'BON', 2 ,'',false),
    ( 'perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A00052801895', '', '600W','A00014' ,'BON', 3 ,'',false),
    ( 'Scie', 'Moscatelli','Leroy' , 'X7FF25', 'A0000316854', '', '50W','A00013' ,'MOYEN' , 4 ,'',false),
    ( 'Perceuse','Moscatelli','Leroy' , 'X7FF25', 'A0000187851', '', '600W','A00012' ,'BON', 0 ,'',false),
    ( 'Perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A0000187875', '', '800W', 'A00015' ,'BON', 4 ,'',false),
    ( 'perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A0000314895', '', '600W','A00014' ,'BON', 3 ,'',false),
    ( 'Scie', 'Moscatelli','Leroy' , 'X7FF25', 'A00030122854', '', '50W','A00013' ,'MOYEN' , 1 ,'',false),
    ( 'Perceuse','Moscatelli','Leroy' , 'X7FF25', 'A000677101851', '', '600W','A00012' ,'BON', 1 ,'',false),
    ( 'Perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A00001825875', '', '800W', 'A00015' ,'BON', 2 ,'',false),
    ( 'perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A000528012895', '', '600W','A00014' ,'BON', 3 ,'',false),
    ( 'Scie', 'Moscatelli','Leroy' , 'X7FF25', 'A000031681154', '', '50W','A00013' ,'MOYEN' , 2 ,'',false),



    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X7FF25', 'A00012735', '400mm', '250W','AC0001' ,'Bon', 0 ,'12 mois',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X35765', 'A000152326', '600mm', '300W', 'AC0002' ,'Bon', 0 ,'12 mois',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X7FF25', 'A000129375', '400mm', '250W','AC0001' ,'Bon', 0 ,'12 mois',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X35765', 'A0001233+6', '600mm', '300W', 'AC0002' ,'Bon', 0 ,'12 mois',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X7FF25', 'A000122395', '400mm', '250W','AC0001' ,'Bon', 0 ,'12 mois',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X35765', 'A000123936', '600mm', '300W', 'AC0002' ,'Bon', 0 ,'12 mois',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X7FF25', 'A000127835', '400mm', '250W','AC0001' ,'Bon', 0 ,'12 mois',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X35765', 'A000127386', '600mm', '300W', 'AC0002' ,'Bon', 0 ,'12 mois',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X7FF25', 'A000175235', '400mm', '250W','AC0001' ,'Bon', 0 ,'12 mois',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X35765', 'A000123226', '600mm', '300W', 'AC0002' ,'Bon', 0 ,'12 mois',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X72HH5', 'A000123227', '400mm', '400W','AC0003' ,'Non fonctionnel' , 1 ,'12 mois',true);






INSERT INTO entrees_sorties (id_outil,id_utilisateur, date_sortie, date_de_retour_prevue, date_retour, probleme, referencepv)

VALUES
    (1,1,'19971002','20030328','20220101', '', ''),
    (1,1,'19971002','20030328','20220112', '', ''),
    (1,1,'19971002','20030328','20220120', '', ''),
    (2,2,'19971002','20030328','20030328', '', ''),
    (2,2,'19971002','20030328',NULL, '', ''),
    (3,3,'20220105','20030328','20220112', '', ''),
    (3,2,'20220113','20030328','20220114', '', ''),
    (3,5,'20220120','20030328','20220123', '', ''),
    (3,4,'19971002','20030328',NULL, '', ''),
    (4,4,'19971002','20030328','20030328', '', ''),
    (5,5,'19971002','20030328',NULL, '', 'PV003'),
    (6,6,'19971002','20030328','20030328', '', 'PV0005'),
    (7,7,'19971002','20030328','20030328', 'Il est cassé', 'PV06');



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

