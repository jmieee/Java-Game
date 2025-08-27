<p> <img src="https://static.vecteezy.com/system/resources/thumbnails/001/840/618/small/picture-profile-icon-male-icon-human-or-people-sign-and-symbol-free-vector.jpg" width="60px" height="auto"></p>

# java-game-character

# 🎮 Turn-Based Battle Game with Data Abstraction in Java

## 📌 What is Data Abstraction?

- **Abstraction** is the process of showing only the essential details and hiding the implementation.
- In **OOP with Java**, abstraction is usually implemented using **abstract classes** and **interfaces**.
- It lets us focus on _what_ an object does, not _how_ it does it.

---

## 🐾 Updated Game Features

This project now includes:

### ✨ New Features Added:
- **HP (Health Points)** - Characters start with 100 HP
- **Attack Damage** - Different damage values for each move type:
  - **Mage**: Attack (20), Special (25), Secret Power (35)
  - **Warrior**: Attack (15), Special (30), Secret Power (40)
- **JOptionPane GUI** - User-friendly input/output dialogs
- **Turn-Based Battle System** - Players take turns choosing moves
- **Win Condition** - Battle ends when one character reaches 0 HP

### 🎯 Battle Flow:
1. **Character Creation**: Enter names for Mage and Warrior
2. **Turn-Based Combat**: Choose from 3 move types each turn
3. **HP Tracking**: See current HP after each attack
4. **Victory**: Game announces the winner when battle ends

---

## 🕹️ Sample Game Flow

```
Enter Mage's name: Alfert  
Enter Warrior's name: Humphrey  

Game starts! Both have 100 HP.

Turn 1:  
Choose Alfert's move: (1) Attack (2) Special Move (3) Secret Power
👉 Output: "Alfert casts a fireball! 🔥 (20 damage)"

Turn 2:  
Choose Humphrey's move: (1) Attack (2) Special Move (3) Secret Power  
👉 Output: "Humphrey swings a mighty sword! ⚔️ (15 damage)"

HP Status:  
Alfert: 85/100 HP  
Humphrey: 80/100 HP

... battle continues until one character reaches 0 HP ...

🎉 Alfert wins the battle! 🎉
```

---

## 🏗️ Abstraction Principles Implemented

### 1. **Abstract Base Class**: `GameCharacter`
- Defines common attributes (name, hp, damage values)
- Abstract methods that subclasses must implement
- Concrete methods shared by all characters

### 2. **Polymorphism**: 
- Characters can be treated uniformly while maintaining unique behaviors
- Same method calls produce different outputs based on character type

### 3. **Encapsulation**: 
- Protected attributes prevent direct access
- Public methods provide controlled interaction

### 4. **Code Reusability**: 
- Battle system works with any character type
- Easy to add new character classes

---

## 📁 File Structure

- **GameCharacter.java** - Abstract base class with HP and battle mechanics
- **Mage.java** - Mage character with magic-based attacks
- **Warrior.java** - Warrior character with physical attacks  
- **Main.java** - Game launcher with complete battle system
- **README.md** - This documentation

---

## 🚀 How to Run

1. **Compile all files**:
   ```bash
   javac *.java
   ```

2. **Run the game**:
   ```bash
   java Main
   ```

3. **Follow the GUI prompts**:
   - Enter character names
   - Choose moves each turn
   - Watch the battle unfold!

---

## 📝 Summary

- **Abstraction** = "Define what, hide how."
- Abstract classes/interfaces define the **rules**.
- Subclasses provide the **details**.
- Our enhanced game example demonstrates:
  - `GameCharacter` = abstract base with battle mechanics
  - `Warrior`, `Mage` = concrete implementations with unique abilities
  - **Turn-based combat** with HP management and GUI interaction

The game now provides a complete interactive experience while maintaining clean abstraction principles!