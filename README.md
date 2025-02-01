# NeuroScan Analytics

NeuroScan Analytics est un Proof of Concept (POC) développé en Java avec Spring Boot, Hibernate, et T-SQL. L'objectif est d'exploiter des données médicales issues de Kaggle pour analyser et visualiser des tendances neurologiques via des graphiques interactifs.

## 🚀 Fonctionnalités

- Importation de jeux de données médicaux (format CSV)
- API REST pour l'accès aux données neurologiques
- Analyse des tendances des troubles cognitifs et neurologiques
- Visualisation de données avec des graphiques interactifs (Chart.js)
- Tableau de bord dynamique pour un suivi des indicateurs clés

## 📦 Structure du Projet

```
NeuroScan-Analytics/
├── src/
│   ├── main/
│   │   ├── java/com/neuroscan/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   └── model/
│   │   └── resources/
│   └── test/
├── data/
├── docker-compose.yml
├── Dockerfile
├── pom.xml
└── README.md
```

## 🗂️ Technologies Utilisées

- **Java 17**
- **Spring Boot 3.x**
- **Hibernate (JPA)**
- **T-SQL** (SQL Server)
- **Chart.js** pour la visualisation des données
- **Docker & Docker Compose** pour la conteneurisation

## ⚙️ Installation

1. Clonez le dépôt :

```bash
git clone https://github.com/votre-repo/NeuroScan-Analytics.git
cd NeuroScan-Analytics
```

2. Configurez la base de données dans `src/main/resources/application.properties` :

```properties
spring.datasource.url=jdbc:sqlserver://db:1433;databaseName=Sleep
spring.datasource.username=sa
spring.datasource.password=VotreMotDePasse
```

3. Démarrez l'application avec Docker :

```bash
docker-compose up --build
```

L'application sera accessible à l'adresse : `http://localhost:8080`

## 📊 API Endpoints

- `GET /api/patients` - Liste des patients
- `POST /api/patients` - Ajouter un patient
- `GET /api/metrics` - Statistiques des indicateurs neurologiques

## 🗃️ Importation des Données Kaggle

1. Téléchargez le dataset depuis Kaggle (ex : Sleep Health and Lifestyle Dataset's Dataset).
2. Placez le fichier CSV dans le dossier `data/`.
3. Exécutez le service d'importation via l'API :

```bash
POST /api/data/import
```

## 📈 Exemple de Graphiques

- Heatmaps pour l'activité cérébrale
- Graphiques radar pour la comparaison des symptômes
- Histogrammes des troubles du sommeil
- Timelines des évolutions de maladies neurodégénératives

## 🐳 Configuration Docker

Exemple de `docker-compose.yml` :

```yaml
version: '3.8'
services:
  app:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - db
    environment:
      - SPRING_DATASOURCE_URL=jdbc:sqlserver://db:1433;databaseName=neuroscan
      - SPRING_DATASOURCE_USERNAME=sa
      - SPRING_DATASOURCE_PASSWORD=VotreMotDePasse

  db:
    image: mcr.microsoft.com/mssql/server:2019-latest
    environment:
      SA_PASSWORD: "VotreMotDePasse"
      ACCEPT_EULA: "Y"
    ports:
      - "1433:1433"
```

## 🤝 Contribuer

Les contributions sont les bienvenues !

1. Forkez le projet
2. Créez votre branche : `git checkout -b feature/ma-feature`
3. Commitez vos modifications : `git commit -m 'Ajout de ma feature'`
4. Poussez la branche : `git push origin feature/ma-feature`
5. Ouvrez une Pull Request

## 📄 Licence

Ce projet est sous licence MIT. Consultez le fichier `LICENSE` pour plus d'informations.

---

Développé avec ❤️ par l'équipe NeuroScan Analytics.