# ATM Simulator (Java CLI)

## Features
- Login with user ID and PIN
- Check balance, deposit, and withdraw
- Persistent storage via `users.txt`

## Getting Started
1. Compile:

javac src/*.java -d out
jar cfe atm.jar Main -C out .

2. Run:

java -jar atm.jar


## Default Users
- **admin / 1234**
- **john / 4321**

## Requirements
- Java 8 or higher
