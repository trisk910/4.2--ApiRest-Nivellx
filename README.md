# 4.2--ApiRest-Nivell2

# Projecte CRUD amb Spring Boot, MySQL i Postman

## Descripció
Aquest repositori inclou un conjunt d’exercicis per implementar un CRUD (Create, Read, Update, Delete) amb diferents bases de dades utilitzant Spring Boot, MySQL i Postman. Es treballa amb el patró MVC, s’aprèn a utilitzar correctament els verbs HTTP i a gestionar els codis de resposta.

---

## Nivell 1: CRUD amb H2

### Característiques del projecte
- **Gestor de dependències**: Maven
- **Llenguatge**: Java
- **Spring Boot**: Darrera versió estable
- **Package**: JAR
- **Versió de Java**: Mínim 11

### Dependències:
- Spring Boot DevTools
- Spring Web
- Spring Data JPA
- H2 Database

### Entitat: Fruita
- **Propietats:**
  - `int id`
  - `String nom`
  - `int quantitatQuilos`

### Estructura de packages:
- `cat.itacademy.s04.t02.n01.controllers`
- `cat.itacademy.s04.t02.n01.model`
- `cat.itacademy.s04.t02.n01.services`
- `cat.itacademy.s04.t02.n01.repository`
- `cat.itacademy.s04.t02.n01.exception`

### Punts d’accés:
- `POST /fruita/add`
- `PUT /fruita/update`
- `DELETE /fruita/delete/{id}`
- `GET /fruita/getOne/{id}`
- `GET /fruita/getAll`

L’entitat "Fruita" es persisteix en una base de dades H2.

---

## Nivell 2: CRUD amb MySQL

### Característiques del projecte
- **Gestor de dependències**: Maven
- **Llenguatge**: Java
- **Spring Boot**: Darrera versió estable
- **Package**: JAR
- **Versió de Java**: Mínim 11

### Dependències:
- Spring Boot DevTools
- Spring Web
- Spring Data JPA
- MySQL Driver

### Configuració:
El projecte del nivell 2 és similar al nivell 1, amb la diferència que la base de dades H2 es substitueix per una base de dades MySQL. 

1. **Configuració del fitxer `application.properties`:**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nom_base_dades
   spring.datasource.username=usuari
   spring.datasource.password=contrasenya
   spring.jpa.hibernate.ddl-auto=update
   ```

2. **Estructura i punts d’accés:**
   - La mateixa que al nivell 1.

---

## Eines utilitzades
- **Spring Boot:** Framework per construir aplicacions Java de manera senzilla i eficient.
- **H2 Database:** Base de dades en memòria utilitzada en el nivell 1.
- **MySQL:** Base de dades relacional utilitzada en el nivell 2.
- **Postman:** Per provar i validar les peticions CRUD.

---

## Comandes Maven/Gradle
### Maven
- **Compilar el projecte:** `mvn compile`
- **Empaquetar el projecte:** `mvn package`
- **Netejar el projecte:** `mvn clean`
- **Executar l’aplicació:** `mvn spring-boot:run`

---

## Validació amb Postman
Per provar els punts d’accés de les API, utilitza Postman i realitza peticions a les URL indicades. 

### Exemples de peticions:
- **Afegir una fruita:** `POST http://localhost:8080/fruita/add`
- **Obtenir una fruita per ID:** `GET http://localhost:8080/fruita/getOne/{id}`
- **Llistar totes les fruites:** `GET http://localhost:8080/fruita/getAll`

---

## Enllaços d’ajuda
- [Documentació Spring Boot](https://spring.io/projects/spring-boot)
- [Introducció a Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Introducció a MySQL](https://dev.mysql.com/doc/)

