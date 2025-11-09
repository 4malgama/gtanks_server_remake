package amalgama.battle;

import amalgama.battle.weapons.*;

public class WeaponFactory {

    public static Weapon getWeapon(Tank attacker) {
        if (attacker.mount.getWeaponId().startsWith("smoky_m"))
            return new SmokyWeapon(attacker);
        else if (attacker.mount.getWeaponId().startsWith("flamethrower_m"))
            return new FlamethrowerWeapon(attacker);
        else if (attacker.mount.getWeaponId().startsWith("flamethrowerhw_m"))
            return new FlamethrowerHWWeapon(attacker);
        else if (attacker.mount.getWeaponId().startsWith("twins_m"))
            return new TwinsWeapon(attacker);
        else if (attacker.mount.getWeaponId().startsWith("railgun_m"))
            return new RailgunWeapon(attacker);
        else if (attacker.mount.getWeaponId().startsWith("isida_m"))
            return new IsidaWeapon(attacker);
        else if (attacker.mount.getWeaponId().startsWith("thunder_m"))
            return new ThunderWeapon(attacker);
        else if (attacker.mount.getWeaponId().startsWith("frezee_m"))
            return new FreezeWeapon(attacker);
        else if (attacker.mount.getWeaponId().startsWith("ricochet_m"))
            return new RicochetWeapon(attacker);
        else if (attacker.mount.getWeaponId().startsWith("shaft_m"))
            return new ShaftWeapon(attacker);
        return null;
    }
}
