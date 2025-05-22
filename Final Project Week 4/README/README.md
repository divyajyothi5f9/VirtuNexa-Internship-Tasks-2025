# Java Parking Management System

## 📋 Features
- Assign parking slots automatically
- Track vehicle entry/exit times
- Calculate parking fees
- CLI interface (simple and fast)
- SQLite database for persistent storage
- Modular and extendable design

## 🛠 Technologies
- Java 8+
- SQLite via JDBC
- CLI interface
- Optional: Swing, Apache POI

## 🚀 How to Run
1. Compile:

javac -cp "lib/sqlite-jdbc.jar" -d build src/**/*.java Main.java


2. Run:

java -cp "build:lib/sqlite-jdbc.jar" Main


3. Package JAR:

jar cfe ParkingSystem.jar Main -C build .


## 📂 Folder Structure
- `src/` – Source code
- `lib/` – SQLite JDBC driver
- `build/` – Compiled classes
- `parking.db` – SQLite DB file (auto-created)
- `ParkingSystem.jar` – Executable JAR
