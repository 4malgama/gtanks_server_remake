package amalgama.battle;

import org.json.simple.JSONObject;

public abstract class Weapon {
    protected final Tank attacker;

    public abstract int calculateDamage(Tank target);
    public abstract String[] getTargets(JSONObject jsonData);

    public Weapon(Tank attacker) {
        this.attacker = attacker;
    }
}
