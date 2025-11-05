package amalgama.battle.weapons;

import amalgama.battle.Tank;
import amalgama.battle.Weapon;
import amalgama.utils.RandomUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FreezeWeapon extends Weapon {
    public static final int FREEZE_TEMPERATURE = 2;

    @Override
    public int calculateDamage(Tank target) {
        int minDamage = (int) attacker.turret.min_damage;
        int maxDamage = (int) attacker.turret.max_damage;
        int damage = RandomUtils.randomIntBetween(minDamage, maxDamage + 1);
        return (Tank.MAX_HEALTH * damage / target.hull.hp);
    }

    @Override
    public String[] getTargets(JSONObject jsonData) {
        JSONArray victims = (JSONArray) jsonData.get("victims");
        return (String[]) victims.stream().map(Object::toString).toArray(String[]::new);
    }

    public FreezeWeapon(Tank attacker) {
        super(attacker);
    }
}
