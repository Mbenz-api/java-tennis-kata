# 🎾 Tennis Kata – Java Implementation

## 📌 Objective

This project implements a simple tennis game scoring system based on official rules.

The goal is to process a sequence of points and display the score after each point until a player wins the game.

---

## 🧠 Rules Implemented

The scoring system follows standard tennis rules:

- A game starts at **0 – 0**
- Points progression: **0 → 15 → 30 → 40**
- A player wins the game if:
  - They have **at least 4 points**, and
  - A **minimum lead of 2 points**
- At **40 – 40**, the game enters **Deuce**
- After Deuce:
  - A player scores → **Advantage**
  - Same player scores again → **wins the game**
  - Opponent scores → **back to Deuce**

---

## ⚙️ Design Choices

This implementation focuses on:

✅ Simplicity  
✅ Readability  
✅ Testability  
✅ Extensibility

---

### ✔ Architecture

| Layer        | Class            | Responsibility              |
|-------------|------------------|-----------------------------|
| Domain       | `TennisGame`     | Core game logic             |
| Application  | `GameRunner`     | Input processing & output   |
| Tests        | `TennisGameTest` | Unit testing                |

---

### ✔ Key Decisions

- Game logic is encapsulated in the `TennisGame` class
- Primitive types (`int`) are used for simplicity and clarity
- Game states (Deuce, Advantage, Win) are computed dynamically
- Output is separated from domain logic (clean architecture)

---

### ✔ State Management

- `scoreA`, `scoreB` → track player points
- `finished` → indicates whether the game ended
- `winner` → stores the winner

No explicit advantage flags are used—state is derived from scores.

---

### ✔ Clean Code Principles

- Single Responsibility Principle
- No duplicated logic
- Small, focused methods
- Readable domain logic:
  ```java
  isDeuce()
  hasWon(...)
