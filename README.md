# Riot API Client

Ce projet est un client Java pour l'API de Riot Games, permettant d'interagir avec les services de League of Legends de manière simple et efficace.

## 🚀 Fonctionnalités

- Récupération de la rotation gratuite des champions
- Recherche de compte par nom d'invocateur et tag line
- Récupération des informations d'invocateur par PUUID
- Configuration flexible des URLs d'API par région

## 📋 Prérequis

- Java 17+
- Maven 3.6+
- Une clé API Riot Games ([obtenir une clé](https://developer.riotgames.com/))

## ⚙️ Installation

1. Cloner le repository :
```bash
git clone https://github.com/votre-nom/riot-api-client.git
```

2. Configurer votre clé API dans `application.properties` :
```properties
riot.api.key=RGAPI-votre-clé-api
riot.api.protocol=https
riot.api.base_host=api.riotgames.com
riot.api.regions.euw1=euw1
riot.api.regions.europe=europe
riot.api.regions.eun1=eun1
```

3. Compiler le projet :
```bash
mvn clean install
```

## 🔨 Utilisation

### Exemple d'utilisation basique

```java
@Autowired
private RiotApiService riotApiService;

// Obtenir la rotation des champions
ChampionRotationModel rotation = riotApiService.getChampionRotation();

// Rechercher un compte
AccountModel account = riotApiService.getBySummonerName("nom-invocateur", "EUW");

// Obtenir les informations d'un invocateur
SummonerModel summoner = riotApiService.getSummonerByPuuid("puuid");
```

## 📚 Structure du Projet

```
src/
├── main/
│   ├── java/
│   │   └── com/example/riotapi/
│   │       ├── configuration/   # Configuration Spring
│   │       ├── controller/      # Endpoints API
│   │       ├── model/           # Modèles de données
│   │       └── service/         # Services et implémentations
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/example/riotapi/
            └── service/         # Tests
```

## 🔧 Configuration

Le projet utilise Spring Boot pour la configuration. Les principaux fichiers de configuration sont :

- `application.properties` : Configuration des URLs et de la clé API
- `RiotApiProperties.java` : Configuration des propriétés Spring
- `RiotApiConfig.java` : Configuration des beans Spring

## 📝 Dépendances Principales

- Spring Boot
- Spring WebFlux
- Lombok
- JUnit 5 (tests)
- Mockito (tests)
- MockWebServer (tests)

## 🤝 Contribution

1. Forker le projet
2. Créer une branche pour votre fonctionnalité
3. Commiter vos changements
4. Pousser vers la branche
5. Ouvrir une Pull Request

## 📄 Licence

Ce projet est sous licence MIT. Voir le fichier [LICENSE](LICENSE) pour plus de détails.

## ✨ Auteurs

- Votre nom (@votre-github)

## 🙏 Remerciements

- Riot Games pour leur API
- La communauté Spring Boot
```

### Suggestions pour améliorer ce README :

1. Ajouter des badges (build status, version, etc.)
2. Inclure des exemples de réponses API
3. Ajouter une section sur la gestion des erreurs
4. Inclure des informations sur le rate limiting
5. Ajouter des captures d'écran si vous avez une interface utilisateur
6. Inclure des liens vers la documentation de l'API Riot

N'oubliez pas de personnaliser :
- Les URLs
- Les noms d'auteurs
- Les versions des dépendances
- Les prérequis spécifiques à votre environnement