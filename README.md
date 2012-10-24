Encrypted-Calendar
==================

Liste des champs du calendrier chiffrable: 
String title
String Location
String Description
String Organizer
Tout ces champs seront chiffrés.

Quel algorithme de chiffrement ?
AES 128 ou 256 bits.

Au premier lancement de l'application, une clé doit être crée. Deux choix s'offre à nous, l'utilisateur nous donne la clé,l'application génère la clé et la donne à l'utilisateur.

Ensuite l'application a besoin de cette même clé pour chiffré et déchiffré les champs du calendrier. 

Quand, comment on récupère le mot de passe ?
http://csrc.nist.gov/publications/fips/fips1401.htm

Méthode 1 :  à chaque fois qu'il faut chiffré ou déchiffré, on demande à l'utilisateur une clé.

Avantage : 
* Un mot de passe différent pourra être utilisé pour différents évènements.	
* Pas de mot de passe stocké sur le téléphone.

Inconvénient : 
* Compliqué pour l'utilisateur -> tendance à utiliser des mots de passe courts.
* Attaque par fishing ?
* Plus d'entrée pour un Keylogger

Méthode 2 : La clé est demandé au démarrage de l'application.

Avantage : 
* Pas de mot de passe stocké sur le téléphone

Inconvénient : 
* Il faut vérifier que la clé est bien celle transmise.
* tendance aux mot de passe court. -> Demander une longueur minimum pour les mots de passe.

Méthode 3 : La clé est stockée sur le téléphone.

Avantage : 
* Invisible pour l'utilisateur.

Inconvénient : 
* Clé en clair sur le téléphone. 
* Pas de mécanisme de base sur android pour stocker une clé

Méthode 4 : La clé est stockée sur le téléphone chiffré par un mot de passe.
# 4.1, 4.2 Équivalent des méthodes 1 et 2.

# 4.3 : Mot de passe généré qui dépendant du téléphone : Code PIN / code de déblocage du téléphone

* L'algorithme doit être la même après mise à jour de l'application.