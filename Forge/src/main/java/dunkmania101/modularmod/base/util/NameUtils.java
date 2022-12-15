package dunkmania101.modularmod.base.util;

import dunkmania101.modularmod.base.data.ModularModConstants;

public class NameUtils {
    public static String appendName(String prefix, String name) {
        return prefix.concat(ModularModConstants.PATH_DELIMITER).concat(name);
    }

    public static String[] separateParents(String id, int maxLevel) {
        return id.split(ModularModConstants.PATH_DELIMITER, maxLevel);
    }
    public static String[] separateParents(String id) {
        return separateParents(id, 0);
    }
    public static String[] separateParent(String id) {
        return separateParents(id, 1);
    }
}
