import javax.swing.JOptionPane;

abstract class GameCharacter {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int attackDamage;
    protected int specialDamage;
    protected int secretPowerDamage;

    public GameCharacter(String name, int hp, int attackDamage, int specialDamage, int secretPowerDamage) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attackDamage = attackDamage;
        this.specialDamage = specialDamage;
        this.secretPowerDamage = secretPowerDamage;
    }

    // Abstract methods (must be implemented by subclasses)
    public abstract String attack();
    public abstract String specialMove();
    public abstract String secretPower();

    // Concrete methods
    public void showName() {
        System.out.println("Character: " + name);
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getSpecialDamage() {
        return specialDamage;
    }

    public int getSecretPowerDamage() {
        return secretPowerDamage;
    }

    public String getHpStatus() {
        return name + ": " + hp + "/" + maxHp + " HP";
    }

    public int performMove(int moveChoice) {
        return switch (moveChoice) {
            case 1 -> {
                JOptionPane.showMessageDialog(null, attack() + " (" + attackDamage + " damage)");
                yield attackDamage;
            }
            case 2 -> {
                JOptionPane.showMessageDialog(null, specialMove() + " (" + specialDamage + " damage)");
                yield specialDamage;
            }
            case 3 -> {
                JOptionPane.showMessageDialog(null, secretPower() + " (" + secretPowerDamage + " damage)");
                yield secretPowerDamage;
            }
            default -> {
                JOptionPane.showMessageDialog(null, attack() + " (" + attackDamage + " damage)");
                yield attackDamage;
            }
        };
    }
}