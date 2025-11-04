package amalgama.battle.weapons;

import amalgama.battle.Tank;
import amalgama.battle.Weapon;
import amalgama.utils.RandomUtils;
import org.json.simple.JSONObject;

public class IsidaWeapon extends Weapon {
    @Override
    public int calculateDamage(Tank target) {
        int minDamage = (int) attacker.turret.min_damage;
        int maxDamage = (int) attacker.turret.max_damage;
        int damage = RandomUtils.randomIntBetween(minDamage, maxDamage + 1);
        return (Tank.MAX_HEALTH * damage / target.hull.hp);
    }

    @Override
    public String[] getTargets(JSONObject jsonData) {
        return new String[] { (String) jsonData.get("victimId") };
    }

    public IsidaWeapon(Tank attacker) {
        super(attacker);
    }
}
