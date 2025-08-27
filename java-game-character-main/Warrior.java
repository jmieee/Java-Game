class Warrior extends GameCharacter {
    public Warrior(String name) {
        super(name, 100, 15, 30, 40); // hp, attackDamage, specialDamage, secretPowerDamage
    }

    @Override
    public String attack() {
        return name + " swings a mighty sword! ⚔️";
    }

    @Override
    public String specialMove() {
        return name + " uses Shield Bash! 🛡️";
    }

    @Override
    public String secretPower() {
        return name + " unleashes the Secret Power: Berserker Rage! 💢";
    }
}