

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

    ( 'Perceuse','Moscatelli','Leroy' , 'X7FF25', 'A00001851', '', '600W','A00012' ,'BON', 0 ,'',false),
    ( 'Perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A00001875', '', '800W', 'A00015' ,'BON', 0 ,'',false),
    ( 'perceuse', 'Moscatelli','Leroy' , 'X7FF25', 'A00001895', '', '600W','A00014' ,'BON', 0 ,'',false),
    ( 'Scie', 'Moscatelli','Leroy' , 'X7FF25', 'A00001854', '', '50W','A00013' ,'MOYEN' , 0 ,'',false),



    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X7FF25', 'A0001235', '400mm', '250W','AC0001' ,'Bon', 0 ,'12 mois',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X35765', 'A0001236', '600mm', '300W', 'AC0002' ,'Bon', 0 ,'12 mois',true),
    ( 'pied a coulisse', 'Moscatelli','Leroy' , 'X72HH5', 'A0001237', '400mm', '400W','AC0003' ,'Non fonctionnel' , 1 ,'12 mois',true);






INSERT INTO entrees_sorties (id_outil,id_utilisateur, date_sortie, date_de_retour_prevue, date_retour, probleme, referencepv)

VALUES
    (1,1,'19971002','20030328','20030328', 'youhouuu', ''),(2,2,'19971002','20030328','20030328', '', ''),
    (3,3,'19971002','20030328','20030328', 'brrrrrr', ''),(4,4,'19971002','20030328','20030328', '', ''),
    (5,5,'19971002','20030328','20030328', 'ahahhaah', 'PV003'),(6,6,'19971002','20030328','20030328', '', 'PV0005'),
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

