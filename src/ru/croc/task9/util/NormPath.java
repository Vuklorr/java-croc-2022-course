package src.ru.croc.task9.util;

import java.util.ArrayList;
import java.util.List;

public class NormPath {
    public static String normPath (String path) {
        List<String> listPath = new ArrayList<>();
        StringBuilder normPath = new StringBuilder();
        String[] dir = path.split("/");

        for (String str : dir) {
            if (str.charAt(0) == '.') { //проверка на . и ..
                toThePreviousDirectory(str, listPath);
            } else { // если это директория
                listPath.add(str);
            }
        }

        for(int i = 0; i < listPath.size() - 1; i++) { // преобразовать в вид dir/dir1/dir2/
            normPath.append(listPath.get(i))
                    .append('/');
        }

        return listPath.isEmpty() ?
               "" :
               normPath.append(listPath.get(listPath.size() - 1)).toString(); //добавить последний элемент без /
    }

    private static void toThePreviousDirectory (String str, List<String> listPath) {
        if (str.length() == 2) { // проверка на ..
            if (listPath.isEmpty()) { // если пуст, то добавить ..
                listPath.add("..");
            } else if (listPath.get(listPath.size() - 1).equals("..")) { //если последний элемент .., добавить ..
                listPath.add("..");
            } else {
                listPath.remove(listPath.size() - 1); //вернуться к предыдущей директории
            }
        }
    }
}
