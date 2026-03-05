Családi Eszközkezelő Szimuláció (Spring Boot Task)
Ez a projekt egy többszintű (N-tier) architektúrára épülő Spring Boot alkalmazás,
amely felhasználók, intelligens eszközök és azok menürendszerének kezelését mutatja be.

Alkalmazott Technológiák
Java 21 (OpenJDK)

Spring Boot 4.0.3

Spring Data JPA (Hibernate 7.2.4)

H2 Database (In-memory)

Thymeleaf (Template Engine)

Lombok (Boilerplate kód csökkentése)

Maven (Dependency management)

Projekt Felépítése
Az alkalmazás követi a modern szoftverfejlesztési alapelveket:

Entity Layer: JPA annotációkkal ellátott POJO osztályok (User, Device, Menu, Icon, Application),
amelyek leképezik az adatbázis sémát.

Repository Layer: Spring Data JPA interfészek az adatkezeléshez (pl. findByNameContainingIgnoreCase szűréshez).

Service Layer: Üzleti logika elkülönítése, tranzakciókezelés (@Transactional) és Constructor Injection használata.

Controller Layer: Webes végpontok kezelése és a Thymeleaf view-k kiszolgálása.

Funkciók:
Automatikus inicializálás: Indításkor a DataInitializer létrehoz egy alapértelmezett felhasználót és eszközt.

Dinamikus Dashboard: A főoldalon listázva látható minden felhasználó, az eszközeik és a hozzájuk tartozó menüikonok.

Interaktív Szimuláció:

Új családtag hozzáadása: Egy gombnyomásra a rendszer legenerál egy új entitás-hálót
(User -> Device -> Menu -> Icon) és perzisztálja az adatbázisba.

Keresés: Szerveroldali szűrés név alapján, kis- és nagybetű érzéketlenül.

Adatbázis betekintő: Beépített H2 konzol az adatok közvetlen ellenőrzéséhez.

### Megvalósított Funkciók (Fullstack elvárások szerint):

* **User Management**: Felhasználók létrehozása (manuális és szimulált), átnevezése (módosítás) és törlése.
* **Menu & Icon System**: Minden eszközhöz egyedi főmenü tartozik, amely dinamikusan kezel almenüket (ikonokat).
* **Icon CRUD**: Új ikonok hozzáadása, listázása és törlése eszközönként.
* **App Execution**: Az alkalmazás elindítása funkció szimulálása (Frontend eseménykezelővel).
* **Customization**: Háttérkép választása és arculatváltás (Menu title módosítás) támogatott.
* **Database**: H2 in-memory adatbázis, Hibernate sémagenerálással.
  
Futtatás

Klónozás vagy kicsomagolás: git clone https://github.com/Oliver092/fullstack-crud vagy a csatolt ZIP kibontása.

Indítás:

Linux/Mac: ./mvnw spring-boot:run

Böngésző: http://localhost:8080

H2 Konzol

JDBC URL: jdbc:h2:mem:testdb

User: sa

Password: password (Az application.properties szerint kötelező megadni)
