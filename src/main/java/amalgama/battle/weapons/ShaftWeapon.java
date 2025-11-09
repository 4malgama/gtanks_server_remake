package amalgama.battle.weapons;

import amalgama.battle.Tank;
import amalgama.battle.Weapon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShaftWeapon extends Weapon {
    private float powerFactor = 0; //[0..1]

    @Override
    public int calculateDamage(Tank target) {
        int minDamage = (int) attacker.turret.min_damage;
        int maxDamage = (int) attacker.turret.max_damage;

        int damage = lerp(minDamage, maxDamage, powerFactor);

        return (Tank.MAX_HEALTH * damage / target.hull.hp);
    }

    @Override
    public String[] getTargets(JSONObject jsonData) {
        JSONArray targets = (JSONArray) jsonData.get("targets");
        List<String> returnTargets = new ArrayList<>();

        if (jsonData.containsKey("energy")) {
            powerFactor = calculatePowerFactor(((Number) jsonData.get("energy")).intValue());

            for (Object o : targets) {
                JSONObject jsonTarget = (JSONObject) o;
                JSONObject target = (JSONObject) jsonTarget.get("target");
                returnTargets.add((String) target.get("id"));
            }
        }
        else {
            powerFactor = 0;

            for (Object o : targets) {
                JSONObject jsonTarget = (JSONObject) o;
                returnTargets.add((String) jsonTarget.get("target_id"));
            }
        }

        return returnTargets.toArray(new String[0]);
    }

    private float calculatePowerFactor(int energy) {
        return (float) (1 - (energy / 1000.0));
    }

    public ShaftWeapon(Tank attacker) {
        super(attacker);
    }

    public float getPowerFactor() {
        return powerFactor;
    }

    public void setPowerFactor(float powerFactor) {
        this.powerFactor = Math.min(Math.max(powerFactor, 0), 1);
    }

    private int lerp(int a, int b, float t) {
        return (int) (a + (b - a) * t);
    }
}
