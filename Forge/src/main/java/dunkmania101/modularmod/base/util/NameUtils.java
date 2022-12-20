package dunkmania101.modularmod.base.util;

import java.util.ArrayList;

import dunkmania101.modularmod.base.data.ModularModConstants;

public class NameUtils {
    public static String appendName(String prefix, String name) {
        return prefix.concat(ModularModConstants.PATH_DELIMITER).concat(name);
    }

    public static ArrayList<String> separateParents(String id, int maxLevel) {
        ArrayList<String> parts = new ArrayList<String>();

        if (id.length() > 0) {
            int i = 0;
            int p = 0;
            String part = "";

            for (char cc : id.toCharArray()) {
                if (maxLevel > 0 && p >= maxLevel) {
                    break;
                }

                String c = String.valueOf(cc);
                if (c.equals(ModularModConstants.PATH_DELIMITER)) {
                    parts.add(part);
                    part = "";
                    p++;
                } else {
                    part += c;
                }

                i++;
            }
            if (part != "") {
                parts.add(part);
            }

            if (i < id.length()) {
                parts.add(id.substring(i, id.length()));
            }
        }

        return parts;
    }
    public static ArrayList<String> separateParents(String id) {
        return separateParents(id, 0);
    }
    public static ArrayList<String> separateParent(String id) {
        return separateParents(id, 1);
    }
    public static String removeParentid(String id, String parentId) {
        if (id.startsWith(parentId)) {
            int cutPoint = parentId.length()+1;
            if (id.length() > cutPoint) {
                return id.substring(cutPoint);
            }
            return "";
        }
        return id;
    }
}
