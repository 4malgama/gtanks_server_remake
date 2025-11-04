package amalgama.battle.weapons;

import amalgama.battle.Tank;
import amalgama.battle.Weapon;
import amalgama.utils.RandomUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ThunderWeapon extends Weapon {
    @Override
    public int calculateDamage(Tank target) {
        int minDamage = (int) attacker.turret.min_damage;
        int maxDamage = (int) attacker.turret.max_damage;
        int damage = RandomUtils.randomIntBetween(minDamage, maxDamage);
        return (Tank.MAX_HEALTH * damage / target.hull.hp);
    }

    @Override
    public String[] getTargets(JSONObject jsonData) {
        String targetId = (String) jsonData.get("mainTargetId");
        return (targetId == null) ? null : new String[]{targetId};
    }

    public Map<String, Double> getSplashTargets(JSONObject jsonData) {
        JSONArray splashTargets = (JSONArray) jsonData.get("splashTargetIds");
        JSONArray splashTargetsDistances = (JSONArray) jsonData.get("splashTargetDistances");
        Map<String, Double> targets = new HashMap<>(); // id -> distance

        if (splashTargets == null || splashTargetsDistances == null) return null;
        if (splashTargets.size() != splashTargetsDistances.size()) return null;

        for (int i = 0; i < splashTargets.size(); i++) {
            targets.put((String) splashTargets.get(i), (Double) splashTargetsDistances.get(i));
        }

        return targets;
    }

    public ThunderWeapon(Tank attacker) {
        super(attacker);
    }
}
