package src.ru.croc.task9.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NormPath {
    public static String normPath (String path) {
        List<String> listPath = new ArrayList<>();
        StringBuilder normPath = new StringBuilder();
        String[] dir = path.split("/");

        for(String str : dir) {
            if(str.charAt(0) == '.') {
                if(str.length() == 2) {
                    if(listPath.isEmpty()) {
                        listPath.add("..");
                    } else {
                        listPath.remove(listPath.size() - 1);
                    }
                }
            } else {
                listPath.add(str);
            }
        }

        for (String str : listPath) {
            normPath.append(str).append("/");
        }

        return normPath.deleteCharAt(normPath.length() - 1).toString();
    }
}
