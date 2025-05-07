# Tower Defense Game

An engaging, strategic tower defense game built with Java. Defend your base by strategically placing towers to fend off waves of enemies across multiple levels and difficulties.

---

## 🔍 Overview

* **Genre:** Tower Defense / Strategy
* **Platform:** Desktop (cross-platform via Java)
* **Programming Language:** Java
* **Design Patterns:** Singleton, Strategy, Template, Abstract Factory, Prototype, Decorator, Composite

This project showcases a robust object-oriented architecture implementing the core mechanics of a tower defense game, including:

* Tower placement and upgrading
* Enemy wave spawning and movement
* Level-based progression with varying difficulties
* In-game GUI for level selection, tower placement, and game state management

---

## ✨ Features

* **Game Modes:**

    * Multiple levels (Level 1, Level 2, Level 3)
    * Adjustable difficulty settings
* **Core Mechanics:**

    * Place towers (Turret, Cannon, Sniper) to defend against enemy waves
    * Upgrade towers with enhanced abilities (e.g., double fire rate)
    * Manage resources to strategically build and upgrade towers
    * Enemy waves with varying attributes (speed, health)
* **Clean Architecture:**

    * Modular design with separated game logic, rendering, and input handling
    * Factory-based level and enemy creation
    * Strategy-based game state management
* **Responsive UI:**

    * Interactive GUI for main menu, level selection, and tower placement
    * Real-time feedback for tower targeting and enemy movement
    * Pause and resume functionality

---

## 🛠 Tech Stack

| Layer          | Technology                                                   |
| -------------- | ------------------------------------------------------------ |
| Programming    | Java                                                         |
| Rendering      | Java Swing / AWT (via GamePanel)                             |
| Build System   | Manual compilation or IDE (e.g., IntelliJ IDEA, Eclipse)     |
| Language       | Java 8+                                                      |

---

## 🚀 Getting Started

### Prerequisites

* Java Development Kit (JDK) 8 or higher
* An IDE like IntelliJ IDEA or Eclipse (optional, for easier setup)

### Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/yourusername/tower-defense-game.git
   cd tower-defense-game
   ```
2. **Import into your IDE**

    * IntelliJ IDEA / Eclipse: Import as a Java project.
3. **Build and Run**

   * Run `Main.java` from the `main` package in your IDE, or
   * Compile and run from the command line:
     ```bash
     javac main/Main.java
     java main.Main
     ```

---

## 🎮 Usage

1. **Main Menu**

    * Select a level and difficulty from the GUI.
2. **Gameplay**

    * **Place Towers**: Click on the map to place Turret, Cannon, or Sniper towers.
    * **Upgrade Towers**: Select a tower to apply upgrades (e.g., double fire rate).
    * **Manage Waves**: Survive enemy waves by strategically placing and upgrading towers.
3. **Special Scenarios**

    * **Level Progression**: Complete a level to unlock the next.
    * **Pause Menu**: Pause the game to adjust strategies or exit.

---

## 🏗 Architecture & Design Patterns

* **Singleton**

    * `GamePanel`: Ensures a single instance for rendering and game loop management.
* **Strategy Pattern**

    * `GamePanel`, `GameplayState`, `PausedState`, `MainMenuState`, `PlacementState`: Manages different game states dynamically.
* **Template Pattern**

    * `Level`, `Level1`, `Level2`, `Level3`: Defines a common structure for level progression and behavior.
* **Abstract Factory**

    * `LevelFactory`, `ILevelFactory`, `Level`, `Level1`, `Level2`, `Level3`: Creates levels with specific configurations.
    * `EnemyWaves`, `IEnemy`, `Enemy`, `UpgradedEnemy`, `UpgradedEnemy20S`, `UpgradedEnemy30H`: Generates enemies with varying attributes.
* **Prototype Pattern**

    * `EnemyWaves`, `IEnemy`, `Enemy`, `UpgradedEnemy`, `UpgradedEnemy20S`, `UpgradedEnemy30H`: Clones enemy instances for wave spawning.
* **Decorator Pattern**

    * `IEnemy`, `Enemy`, `UpgradedEnemy`, `UpgradedEnemy20S`, `UpgradedEnemy30H`: Enhances enemy attributes dynamically.
    * `ITower`, `Tower`, `TowerDecorator`, `DoubleFireRateTowerDecorator`: Adds tower enhancements like increased fire rate.
* **Composite Pattern**

    * `EnemyManager`, `IEnemy`, `Enemy`, `UpgradedEnemy`: Manages groups of enemies as a single unit.
    * `TowerManager`, `ITower`, `Tower`, `TurretTower`, `CannonTower`, `SniperTower`: Manages collections of towers.


---

## 📁 Project Structure

## 📁 Project Structure

```
src/
├── entity/
│   ├── enemies/
│   │   ├── Difficulty.java
│   │   ├── Enemy.java
│   │   ├── EnemyFactory.java
│   │   ├── EnemyManager.java
│   │   ├── EnemyType.java
│   │   ├── EnemyWaves.java
│   │   ├── IEnemy.java
│   │   ├── UpgradedEnemy.java
│   │   ├── UpgradedEnemy20S.java
│   │   └── UpgradedEnemy30H.java
│   ├── towers/
│   │   ├── CannonTower.java
│   │   ├── DoubleFireRateTowerDecorator.java
│   │   ├── ITower.java
│   │   ├── SniperTower.java
│   │   ├── Tower.java
│   │   ├── TowerDecorator.java
│   │   ├── TowerManager.java
│   │   ├── TowerType.java
│   │   └── TurretTower.java
│   ├── Direction.java
│   ├── Entity.java
│   └── SpriteNotFoundException.java
├── levels/
│   ├── ILevel.java
│   ├── ILevelFactory.java
│   ├── Level.java
│   ├── Level1.java
│   ├── Level2.java
│   ├── Level3.java
│   ├── LevelDifficulty.java
│   ├── LevelFactory.java
│   └── MapTile.java
├── main/
│   ├── CollisionChecker.java
│   ├── GamePanel.java
│   ├── GameplayState.java
│   ├── GameState.java
│   ├── InsufficientFundsException.java
│   ├── KeyHandler.java
│   ├── Main.java
│   ├── MainMenuState.java
│   ├── MouseHandler.java
│   ├── PausedState.java
│   ├── PlacementState.java
│   ├── Player.java
│   ├── StateType.java
│   └── UtilityCenter.java
├── ui/
│   ├── GameplayUI.java
│   ├── MainMenuUI.java
│   └── PauseUI.java
├── resources/
└── test/
```

---
