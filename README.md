# Mars Rover – Simulation Java Spring Boot

Pilotage de rovers sur un plateau martien.

---

##  Enoncé

> Un ou plusieurs rovers reçoivent des instructions pour explorer un plateau rectangulaire.
> Chaque rover reçoit une position initiale et une chaîne de commandes composée de L (gauche), R (droite), M (avancer).
>
> Le but est de calculer la position finale de chaque rover après exécution.

---

##  Technologies utilisées

- Java 21
- Spring Boot 3.4
- Maven
- Lombok

---

##  Exécution

### 1. Compilation du projet
```bash
./mvnw clean package
```

### 2. Fichier d’entrée
Créer un fichier `input.txt` à la racine du projet avec le contenu :
```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

### 3. Lancement du programme
```bash
java -jar target/mars-rover-0.0.1-SNAPSHOT.jar input.txt
```

### 4. Sortie attendue
```
1 3 N
5 1 E
```

---

##  Structure du projet
```
com.bnpp.rover
├── MarsRoverApplication.java
├── model
│   ├── Rover.java
│   └── Plateau.java
├── service
│   └── RoverController.java
├── util
    └── FileReaderUtil.java
```

---

##  Bonnes pratiques
- Code orienté "production" : séparation des responsabilités, robustesse.
- Peut facilement être adapté en REST API.
- Simulation exécutable 100% console.

---

##  Contact
Réalisé par **Amina Chebbah** dans le cadre d'un test technique BNP Paribas.

LinkedIn : [https://www.linkedin.com/in/amina-chebbah-elbey-962972115](#)
