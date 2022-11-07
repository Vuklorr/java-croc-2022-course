package src.ru.croc.task8.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountWord {
    public static int countWord (String path) throws FileNotFoundException {
        File file = new File(path);
        int count = 0;
        Scanner in = new Scanner(new FileInputStream(file));

        while (in.hasNext()) {
            in.next();
            count++;
        }

        in.close();
        return count;
    }
}
