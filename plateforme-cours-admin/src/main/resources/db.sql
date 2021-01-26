insert into Utilisateur (id, email, nom, prenom) values (1, 'pierre.dupont@email.fr', 'Pierre', 'Dupont');
insert into Utilisateur (id, email, nom, prenom) values (2, 'anne.lemaire@email.fr', 'Anne', 'Lemaire');
insert into Utilisateur (id, email, nom, prenom) values (3, 'jeannefleur@mail.com', 'Jeanne', 'Fleur');

insert into Cours (id_Cours, titre, description, prix) values (1, 'Introduction au Machine Learning', 'Apprenez à créer sur Python des modèles de Machine Learning puissants et créateurs de valeur. Templates de codes inclus.', '19.99');
insert into Cours (id_Cours, titre, description, prix) values (2, 'Ansible pour DevOps', 'L''automatisation est devenu une nécessité pour les DSI afin de répondre rapidement aux nouveaux enjeux du monde de l''informatique. L''industrialisation est une discipline de l''informatique qui existe depuis plusieurs années, le besoin a été adressé avec des outils tels que puppet, chef ... . L''objectif étant de déployer l''infrastructure et installer les applications par la même occasion sans intervention humaine.', '45.50');
insert into Cours (id_Cours, titre, description, prix) values (3, 'Créer un API REST avec Spring Boot', 'Votre première API qui implémente tous les principes REST !', '15');
insert into Cours (id_Cours, titre, description, prix) values (4, 'Comment devenir développeur web sans avoir à coder ?', 'J''ai créé ce cours pour toutes les personnes qui souhaite apprendre à créer des sites vitrines pros sans avoir des connaissances en codage. Vous pourrez également apprendre à vendre vos sites vitrines au meilleur prix et générer au moins 2000 euros par mois en travaillant 4 heures par semaine. Dans cette formation je vous offre des accès gratuits et fichier qui vont vous faciliter le travaille et surtout vous aidez à réussir vos objectifs !', '0');



insert into Episode (id, nom, lien) values (1, 'Data Reprocessing', 'https://www.youtube.com/watch?v=DuyAza5teu8&ab_channel=MadProgrammer');
insert into Episode (id, nom, lien) values (2, 'Régression', 'https://www.youtube.com/watch?v=E5RjzSK0fvY&ab_channel=edureka%21');
insert into Episode (id, nom, lien) values (3, 'Classification', 'https://www.youtube.com/watch?v=gENtJYUtb-Y&ab_channel=rebiiahmed');
insert into Episode (id, nom, lien) values (4, 'K-Means', 'https://www.youtube.com/watch?v=1XqG0kaJVHY&ab_channel=edureka%21');

insert into Episode (id, nom, lien) values (5, 'Introduction au DevOps et Ansible', '');
insert into Episode (id, nom, lien) values (6, 'Commandes ad-hoc', '');
insert into Episode (id, nom, lien) values (7, 'Découverte du yaml', '');
insert into Episode (id, nom, lien) values (8, 'Inventaire Ansible', '');
insert into Episode (id, nom, lien) values (9, 'Playbook', '');
insert into Episode (id, nom, lien) values (10, 'Templating loop condition', '');
insert into Episode (id, nom, lien) values (11, 'Sécurité', '');
insert into Episode (id, nom, lien) values (12, 'K-Means', '');

insert into Episode (id, nom, lien) values (13, 'Introduction', '');
insert into Episode (id, nom, lien) values (14, 'C''est quoi REST ?', '');
insert into Episode (id, nom, lien) values (15, 'Création du projet Spring Boot', '');
insert into Episode (id, nom, lien) values (16, 'Implémentation de l''API REST', '');
insert into Episode (id, nom, lien) values (17, 'Ajout d''une nouvelle ressources "Menu"', '');
insert into Episode (id, nom, lien) values (18, 'HATEOAS', '');

insert into Episode (id, nom, lien) values (19, 'Introduction', '');
insert into Episode (id, nom, lien) values (20, 'Créer son site vitrine', '');
insert into Episode (id, nom, lien) values (21, 'Générer des revenus', '');
insert into Episode (id, nom, lien) values (22, 'Conclusion', '');

insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (1,1);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (1,2);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (1,3);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (1,4);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (2,5);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (2,6);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (2,7);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (2,8);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (2,9);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (2,10);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (2,11);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (2,12);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (3,13);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (3,14);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (3,15);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (3,16);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (3,17);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (3,18);

insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (4,19);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (4,20);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (4,21);
insert into COURS_EPISODES (COURS_ID_COURS, EPISODES_ID) values (4,22);

insert into UTILISATEUR_COURS (ID, ID_COURS) values (1, 1);
insert into UTILISATEUR_COURS (ID, ID_COURS) values (1, 2);