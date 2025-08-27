class Mage extends GameCharacter {
    public Mage(String name) {
        super(name, 100, 20, 25, 35); // hp, attackDamage, specialDamage, secretPowerDamage
    }

    @Override
    public String attack() {
        return name + " casts a fireball! 🔥";
    }

    @Override
    public String specialMove() {
        return name + " uses Lightning Storm! ⚡";
    }

    @Override
    public String secretPower() {
        return name + " unleashes the Secret Power: Meteor Strike! ☄️";
    }
}