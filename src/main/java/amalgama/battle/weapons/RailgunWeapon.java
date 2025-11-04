package amalgama.battle.weapons;

import amalgama.battle.Tank;
import amalgama.battle.Weapon;
import amalgama.utils.RandomUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RailgunWeapon extends Weapon {

    @Override
    public int calculateDamage(Tank target) {
        int minDamage = (int) attacker.turret.min_damage;
        int maxDamage = (int) attacker.turret.max_damage;
        int damage = RandomUtils.randomIntBetween(minDamage, maxDamage + 1);
        return (Tank.MAX_HEALTH * damage / target.hull.hp);
    }

    @Override
    public String[] getTargets(JSONObject jsonData) {
        JSONArray targets = (JSONArray) jsonData.get("targets");
        return (String[]) targets.stream().map(Object::toString).toArray(String[]::new);
    }

    public RailgunWeapon(Tank attacker) {
        super(attacker);
    }
}
//battle;fire;Amalgama;{"targetInc":[1],"reloadTime":6890,"hitPoints":[{"y":-231.00000000000006,"z":72.68136746975978,"x":-44.24600383623719},{"y":-8261.58962127543,"z":703.7345751100644,"x":-4700}],"targetPostitions":[{"y":-7891.220038785517,"z":694.25,"x":-987.278819346493}],"targets":["Ayanami_Rei"]}