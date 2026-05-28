# 🏙️ Smart City Surveillance System

Simulare a unui sistem de supraveghere urbană bazat pe **Event-Driven Architecture** cu un sistem de mesagerie **Publish-Subscribe**, implementat în Java folosind biblioteca **GreenRobot EventBus** cu livrare sincronă a evenimentelor.

## Descriere

Proiectul simulează o platformă de supraveghere a unui oraș inteligent în care senzorii urbani (cameră, mișcare, trafic etc.) publică evenimente pe un bus central, iar componentele de răspuns (poliție, pompieri, trafic) se abonează și reacționează automat la evenimentele relevante — fără cuplaj direct între producători și consumatori.

## Arhitectură

```
[ Senzori / Publisheri ]
        │
        ▼  post(event)
  [ GreenRobot EventBus ]
        │
        ▼  @Subscribe
[ Handlere / Subscriberi ]
  (Poliție, Pompieri, Trafic...)
```

Livrarea evenimentelor este **sincronă** — subscriberul este apelat pe același thread pe care a fost postat evenimentul.

## Structura proiectului

```
SmartCitySurveillanceSystem/
├── src/main/java/greenRobot/   # Clasele Java (events, publisheri, subscriberi)
├── DiagramaUML.pdf             # Diagrama UML a sistemului
├── pom.xml                     # Configurație Maven + dependențe
└── .gitignore
```

## Build & Run

Necesită Java 23 și Maven instalat:

```bash
# Compilare
mvn compile

# Rulare
mvn exec:java
```

Clasa principală: `green1.MainSensors`

## Dependențe

| Librărie | Versiune |
|---|---|
| GreenRobot EventBus (Java) | 3.3.1 |
| Java | 23 |
| Maven | 3.x |

## Diagrama UML

Diagrama de secvență ilustrează fluxul complet al unui eveniment în sistem:

```
Main → bus: register(tp1), register(cd)
Main → spc1: setVehicleSpeed(90)
spc1 → bus: post(SpeedingEvent)
bus  → tp1: onSpeedingVehicle(event) → "Traffic police issued a fine..."
bus  → cd:  onSpeedingVehicle(event) → "Update stats for Aradului"
Main → cd:  printMostDangerous()
```

📄 Diagrama completă: [`DiagramaUML.pdf`](DiagramaUML.pdf)

## Tehnologii & Concepte

- Java 23
- **GreenRobot EventBus** — bus de evenimente cu `@Subscribe` și `EventBus.getDefault().post()`
- **Event-Driven Architecture** — decuplare completă între senzori și handlere
- **Publish-Subscribe pattern** — publisherii nu știu cine îi ascultă
- Maven (build tool)
- Diagrama UML inclusă (`DiagramaUML.pdf`)
