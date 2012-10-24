Encrypted-Calendar
==================

Liste des champs du calendrier chiffrable: 
String title
String Location
String Description
String Organizer
Tout ces champs seront chiffr�s.

Quel algorithme de chiffrement ?
AES 128 ou 256 bits.

Au premier lancement de l'application, une cl� doit �tre cr�e. Deux choix s'offre � nous, l'utilisateur nous donne la cl�,l'application g�n�re la cl� et la donne � l'utilisateur.

Ensuite l'application a besoin de cette m�me cl� pour chiffr� et d�chiffr� les champs du calendrier. 

Quand, comment on r�cup�re le mot de passe ?
http://csrc.nist.gov/publications/fips/fips1401.htm

M�thode 1 :  � chaque fois qu'il faut chiffr� ou d�chiffr�, on demande � l'utilisateur une cl�.

Avantage : 
* Un mot de passe diff�rent pourra �tre utilis� pour diff�rents �v�nements.	
* Pas de mot de passe stock� sur le t�l�phone.

Inconv�nient : 
* Compliqu� pour l'utilisateur -> tendance � utiliser des mots de passe courts.
* Attaque par fishing ?
* Plus d'entr�e pour un Keylogger

M�thode 2 : La cl� est demand� au d�marrage de l'application.

Avantage : 
* Pas de mot de passe stock� sur le t�l�phone

Inconv�nient : 
* Il faut v�rifier que la cl� est bien celle transmise.
* tendance aux mot de passe court. -> Demander une longueur minimum pour les mots de passe.

M�thode 3 : La cl� est stock�e sur le t�l�phone.

Avantage : 
* Invisible pour l'utilisateur.

Inconv�nient : 
* Cl� en clair sur le t�l�phone. 
* Pas de m�canisme de base sur android pour stocker une cl�

M�thode 4 : La cl� est stock�e sur le t�l�phone chiffr� par un mot de passe.
# 4.1, 4.2 �quivalent des m�thodes 1 et 2.

# 4.3 : Mot de passe g�n�r� qui d�pendant du t�l�phone : Code PIN / code de d�blocage du t�l�phone

* L'algorithme doit �tre la m�me apr�s mise � jour de l'application.