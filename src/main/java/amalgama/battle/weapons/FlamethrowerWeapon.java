package amalgama.battle.weapons;

import amalgama.battle.Tank;
import amalgama.battle.Weapon;
import amalgama.utils.RandomUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FlamethrowerWeapon extends Weapon {
    public FlamethrowerWeapon(Tank attacker) {
        super(attacker);
    }

    @Override
    public int calculateDamage(Tank target) {
        int minDamage = (int) attacker.turret.min_damage;
        int maxDamage = (int) attacker.turret.max_damage;
        int damage = RandomUtils.randomIntBetween(minDamage, maxDamage + 1);
        return (Tank.MAX_HEALTH * damage / target.hull.hp);
    }

    @Override
    public String[] getTargets(JSONObject jsonData) {
        JSONArray targetsIds = (JSONArray) jsonData.get("targetsIds");
        return (String[]) targetsIds.stream().map(Object::toString).toArray(String[]::new);
    }
}
