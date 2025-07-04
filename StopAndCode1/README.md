# Convertitore di Temperatura

Un'applicazione Spring Boot che converte temperature da gradi Celsius a Fahrenheit e Kelvin tramite query string.

## Descrizione

Questa applicazione web permette di convertire temperature inserendo un valore in gradi Celsius tramite query string nell'URL. L'applicazione restituisce automaticamente i corrispondenti valori in gradi Fahrenheit e Kelvin con una rappresentazione grafica moderna.

## Funzionalità

- ✅ Conversione da Celsius a Fahrenheit
- ✅ Conversione da Celsius a Kelvin
- ✅ Gestione robusta degli errori (nessun crash)
- ✅ Interfaccia grafica moderna con Bootstrap
- ✅ Input tramite query string (senza form HTML)
- ✅ Gestione parametri mancanti o non validi

## Tecnologie Utilizzate

- **Spring Boot** - Framework Java per applicazioni web
- **Thymeleaf** - Template engine per le viste HTML
- **Bootstrap 5** - Framework CSS per l'interfaccia utente
- **Maven** - Gestione delle dipendenze

## Come Utilizzare l'Applicazione

### 1. Avvio dell'Applicazione

```bash
# Clona il repository
git clone <repository-url>
cd StopAndCode1

# Avvia l'applicazione
./mvnw spring-boot:run
```

L'applicazione sarà disponibile all'indirizzo: `http://localhost:8080`

### 2. Utilizzo

Accedi all'applicazione tramite browser utilizzando uno dei seguenti URL:

#### Esempi di utilizzo:

- **Temperatura valida:** `http://localhost:8080/index?temp=25`

  - Mostra: Fahrenheit: 77.0°F, Kelvin: 298.15K

- **Temperatura decimale:** `http://localhost:8080/index?temp=37.5`

  - Mostra: Fahrenheit: 99.5°F, Kelvin: 310.65K

- **Temperatura negativa:** `http://localhost:8080/index?temp=-10`

  - Mostra: Fahrenheit: 14.0°F, Kelvin: 263.15K

- **Parametro mancante:** `http://localhost:8080/index`

  - Mostra: Messaggio informativo per inserire la temperatura

- **Valore non numerico:** `http://localhost:8080/index?temp=abc`
  - Mostra: Messaggio di errore "Il valore inserito non è un numero valido"

## Struttura del Progetto

```
StopAndCode1/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── it/lorenzo/StopAndCode1/
│   │   │       ├── StopAndCode1Application.java
│   │   │       └── TemperatureController.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   └── index.html
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## Formule di Conversione

- **Celsius → Fahrenheit:** `°F = °C × 9/5 + 32`
- **Celsius → Kelvin:** `K = °C + 273.15`

## Gestione degli Errori

L'applicazione gestisce in modo robusto i seguenti casi:

1. **Parametro mancante:** Mostra un messaggio informativo
2. **Valore non numerico:** Mostra un messaggio di errore
3. **Stringa vuota:** Trattata come parametro mancante
4. **Valori null:** Gestiti senza causare crash

## Requisiti di Sistema

- Java 8 o superiore
- Maven 3.6 o superiore
- Browser web moderno

## Installazione e Configurazione

### Prerequisiti

Assicurati di avere installato:

- [Java JDK](https://adoptium.net/) (versione 8 o superiore)
- [Maven](https://maven.apache.org/download.cgi) (versione 3.6 o superiore)

### Passi di Installazione

1. **Clona il repository:**

   ```bash
   git clone <repository-url>
   cd StopAndCode1
   ```

2. **Compila il progetto:**

   ```bash
   ./mvnw clean compile
   ```

3. **Avvia l'applicazione:**

   ```bash
   ./mvnw spring-boot:run
   ```

4. **Apri il browser:**
   Naviga su `http://localhost:8080/index`

## Sviluppo

### Aggiungere Nuove Funzionalità

Per estendere l'applicazione:

1. **Nuove conversioni:** Modifica `TemperatureController.java`
2. **Nuove viste:** Aggiungi template in `src/main/resources/templates/`
3. **Nuovi controller:** Crea classi nella directory `java`

### Test

Per eseguire i test:

```bash
./mvnw test
```

## Licenza

Questo progetto è rilasciato sotto licenza MIT.

## Autore

Lorenzo - StopAndCode1

## Supporto

Per problemi o domande, apri una issue nel repository del progetto.
