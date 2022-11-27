package dunkmania101.modularmod.base.util;

import dunkmania101.modularmod.base.data.ModularModConstants;

public class NameUtils {
    public static String appendName(String prefix, String name) {
        return prefix.concat(ModularModConstants.PATH_DELIMITER).concat(name);
    }
}
