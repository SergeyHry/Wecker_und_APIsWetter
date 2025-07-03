# Wecker_und_APIsWetter
# 🌍 JavaFX Wetter- & Zeit-Anzeige (OpenWeatherMap API)

Ein JavaFX-Projekt, das aktuelle **Wetterdaten** und **lokale Uhrzeit** für Städte in **Europa** oder **Amerika** anzeigt. Die Wetterdaten stammen von der [OpenWeatherMap API](https://openweathermap.org/api), die Zeitinformationen über `ZoneId` & `LocalTime`.

---

## 🧩 Funktionsübersicht

- Nutzer wählt eine **Region**: `Europa` oder `Amerika`
- Danach wählt er eine **Stadt** aus (jede Stadt ist eine Unterklasse)
- Nach Klick auf einen Button zeigt eine `TextArea`:
  - 🌦️ Aktuelles Wetter der Stadt
  - 🕒 Lokale Zeit der Stadt

---

## 🧱 Klassenstruktur

- `Europe.java` – Basisklasse für europäische Städte  
- `Amerika.java` – Basisklasse für amerikanische Städte  
- Jede Stadt ist eine Unterklasse, z. B. `Berlin`, `Paris`, `NewYork`, `Chicago`  
- OpenWeatherMap-API wird für Live-Wetterdaten genutzt  
- `LocalTime` und `ZoneId` liefern aktuelle Zeit

---

## 🖥️ GUI (JavaFX)

- Region- und Stadtauswahl über (Texteingabe) nach dem Update( Buttons oder Dropdown)
- Ausgabe erfolgt in einer JavaFX-`TextArea`


---

## 🔧 Voraussetzungen

- Java 17 oder neuer
- JavaFX SDK installiert und im Projekt eingebunden
- Internetverbindung für API-Zugriffe
- OpenWeatherMap API-Key

---

## 🚀 Projekt starten

1. **API-Key besorgen:**  
   Erstelle ein kostenloses Konto bei https://openweathermap.org/api und hole dir deinen API-Key.

2. **API-Key in Code einfügen:**  
   Beispiel:
   ```java
   String apiKey = "DEIN_API_KEY_HIER";
Projekt in IDE öffnen (z. B. Eclipse oder IntelliJ)
Stelle sicher, dass javafx.controls und javafx.fxml korrekt eingebunden sind.

Starte die Main-Klasse: MainTimeFX.java

🛠 Verwendete Technologien
JavaFX

OpenWeatherMap API

java.time (LocalTime, ZoneId)

OOP (Vererbung: Region → Stadt)

##WICHTIG##
API und LocalTime sind nicht immer compatible weil die Städte und Regionen die als Strings eingegeben werden unterscheiden sich manchmal.
achten Sie auf die Rechtschreibung in der Klassen.
diese App wurde als Test-Projekt etwickelt um mit APIs und JavaFx zu üben und hat keine saubere Struktur.  
📄 Lizenz
Dieses Projekt ist zu Lernzwecken erstellt und frei nutzbar. Bitte respektiere die Nutzungsbedingungen der OpenWeatherMap-API.


# ⏰ Java Wecker-App für Windows

Eine einfache Java-Anwendung mit grafischer Benutzeroberfläche (GUI), die dem Nutzer erlaubt, einen **Wecker zu stellen**. Wenn die Zeit erreicht ist, wird ein **Signalton abgespielt** und ein **animiertes Wecker-GIF** auf dem Bildschirm angezeigt.

---

## 🧩 Funktionsübersicht

- ⌚ Der Nutzer stellt eine Uhrzeit über ein Panel ein
- ✅ Nach Klick auf "Bestätigen" läuft der Countdown im Hintergrund
- 🔔 Zur Weckzeit:
  - Ein akustisches Signal wird abgespielt
  - Ein animierter Wecker (`.gif`) erscheint auf dem Desktop

---

## 🖥️ Benutzeroberfläche (GUI)

- Java Swing- oder JavaFX-basiertes Zeit-Eingabefeld
- Button: "Start"
- GIF-Anzeige über separates Fenster mit `.gif`

---

## 🔧 Voraussetzungen

- Java 8 oder höher
- Betriebssystem: **Windows**
- GIF-Datei (`wecker.gif`) im gleichen Verzeichnis wie die `.jar` oder `.class`
- Optional: `.wav`- oder `.mp3`-Datei für Weckton 
  pfad für Bilder und Sound muss man manuel im code angeben.
---

## 🚀 Anwendung starten

1. Stelle sicher, dass Java installiert ist.
2. Starte die App über IDE oder Terminal:

   ```bash
   java -jar RemindeMe.jar

