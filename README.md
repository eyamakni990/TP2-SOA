# TP2 : Mise en oeuvre de Jakarta XML Web Services

**Faculté des Sciences de Sfax**  
Département d’informatique et des Communications  
**Matière :** Architecture SOA et services web  
**Filière :** LSI3-GLSI  
**Année universitaire :** 2026-2027  

**Étudiante :** Eya Makni  
**Enseignantes :** Corinne Amel ZAYANI, Hela Hakim et Rim Mohamed  

---

# Introduction

L’objectif de ce TP est de mettre en œuvre un service web SOAP en Java à l’aide de Jakarta XML Web Services (JAX-WS). L’application développée, nommée `CalculatriceWS`, permet d’effectuer des opérations arithmétiques simples.

Le travail consiste à configurer un projet Maven, créer les classes nécessaires, utiliser les annotations JAX-WS, publier le service web, consulter le document WSDL et tester les opérations avec SoapUI.

# Activité 1 : Configuration du projet Maven

## 1. Création du projet

J'ai créé un projet Java nommé `CalculatriceWS` avec Maven dans IntelliJ IDEA.

Maven permet de gérer les dépendances nécessaires au développement et à l’exécution du service web SOAP.

## 2. Configuration des dépendances

Le fichier `pom.xml` contient les dépendances nécessaires :

- `jakarta.xml.ws-api` : fournit les interfaces nécessaires à la publication du service web.
- `jaxws-rt` : fournit l’implémentation permettant d’exécuter le service web.
- `javax.jws-api` : fournit les annotations utilisées dans le service.

## 3. Création des packages

Deux packages ont été créés :

- `service` : contient l’interface `ICalculatrice` et la classe métier `Calculatrice`.
- `serveur` : contient la classe `ServeurJWS`, responsable de la publication du service.

<img width="382" height="684" alt="image" src="https://github.com/user-attachments/assets/7536c193-7761-4122-a9d6-dbb2334c75a7" />


# Activité 2 : Création de la classe métier

J'ai créé l’interface `ICalculatrice`, qui définit les opérations proposées par le service, puis la classe `Calculatrice`, qui implémente cette interface.

Dans un premier temps, seule l’opération `somme` a été implémentée et testée. Après validation de cette opération, les autres méthodes ont été ajoutées conformément à la consigne.

Les opérations implémentées sont :

- `somme(a, b)` : retourne la somme des deux nombres.
- `multiplication(a, b)` : retourne le produit des deux nombres.
- `soustraction(a, b)` : retourne la différence entre les deux nombres.
- `division(a, b)` : retourne le quotient des deux nombres.

Pour la division, une vérification a été ajoutée afin de signaler le cas où le diviseur est égal à zéro.

# Activité 3 : Annotations avec JAX-WS

Les annotations JAX-WS permettent de décrire les éléments du service web et de rendre les méthodes accessibles aux clients SOAP.

Les principales annotations utilisées sont :

- `@WebService` : déclare l’interface ou la classe comme service web.
- `@WebMethod` : indique les méthodes exposées par le service.
- `@WebParam` : permet de préciser le nom des paramètres des opérations.

Dans la classe `Calculatrice`, l’annotation `@WebService(endpointInterface = "service.ICalculatrice")` indique l’interface qui définit le contrat du service.

# Activité 4 : Publication du service web

J'ai créé la classe `ServeurJWS` dans le package `serveur`.

La publication est réalisée à l’aide de la méthode `Endpoint.publish`, avec l’adresse suivante :

`http://localhost:8080/CalculatriceWS`

Après le démarrage du serveur, le document WSDL est accessible à l’adresse :

`http://localhost:8080/CalculatriceWS?wsdl`

Le WSDL décrit le contrat du service web, notamment les opérations disponibles, les messages d’entrée et de sortie, ainsi que l’adresse du service.

La consultation du WSDL a permis de vérifier la présence des quatre opérations : `somme`, `multiplication`, `soustraction` et `division`.

Le document référence également un schéma XSD généré, accessible à travers l’adresse `http://localhost:8080/CalculatriceWS?xsd=1`.

<img width="772" height="113" alt="image" src="https://github.com/user-attachments/assets/b2660f81-3ab2-4187-8000-c88ed092afa8" />

<img width="1257" height="120" alt="image" src="https://github.com/user-attachments/assets/6abcf540-4887-4072-a135-7d4938bcb69b" />

# Activité 5 : Tests avec SoapUI

## 1. Configuration de SoapUI

J'ai lancé SoapUI et créé un projet SOAP en important le WSDL généré par notre service web.

L’importation du WSDL a permis à SoapUI de reconnaître les opérations disponibles et de générer les requêtes correspondantes.

## 2. Test de l’opération `somme`

J'ai envoyé une requête avec les paramètres suivants :

- `a = 5`
- `b = 3`

Le service a retourné le résultat `8.0`.

Ce résultat confirme le bon fonctionnement de l’opération `somme`.

<img width="861" height="184" alt="image" src="https://github.com/user-attachments/assets/c8590eb1-c5b6-467f-ab7b-50977078a60c" />


## 3. Test des autres opérations

Après validation de la première opération, j'ai ajouté les méthodes restantes et actualisé la définition du service dans SoapUI.

Les tests ont été effectués avec les valeurs suivantes :

| Opération | Paramètre a | Paramètre b | Résultat attendu |
|---|---:|---:|---:|
| Somme | 5 | 3 | 8.0 |
| Multiplication | 5 | 3 | 15.0 |
| Soustraction | 8 | 3 | 5.0 |
| Division | 10 | 2 | 5.0 |

Les réponses obtenues ont permis de vérifier le fonctionnement des opérations arithmétiques.

**multiplication :**

<img width="917" height="183" alt="image" src="https://github.com/user-attachments/assets/2fbda974-8845-4e33-b828-56b95d128a80" />

**Soustraction :**

<img width="741" height="189" alt="image" src="https://github.com/user-attachments/assets/79876ea0-fe53-46e3-a9c3-99ae0c3c7c3f" />

**division :** 

<img width="829" height="185" alt="image" src="https://github.com/user-attachments/assets/796b3ea0-0993-4e58-8bdc-94acc97a74ee" />

# Conclusion

Ce TP nous a permis de découvrir les principales étapes de développement d’un service web SOAP en Java avec JAX-WS.

J'ai appris à configurer un projet Maven, à définir une interface de service, à utiliser les annotations nécessaires, à publier le service et à consulter le contrat WSDL ainsi que le schéma XSD associé.

Enfin, les tests réalisés avec SoapUI ont permis de vérifier les opérations de la calculatrice et de comprendre l’échange de messages SOAP entre un client et un service web.
