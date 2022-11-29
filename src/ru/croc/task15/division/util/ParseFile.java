package ru.croc.task15.division.util;

import ru.croc.task15.division.Division;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ParseFile {

    public static void parseFile(String path, List<Division> divisionList) throws FileNotFoundException {
        File fileDivision = new File(path);
        Scanner in = new Scanner(new FileInputStream(fileDivision));

        while (in.hasNext()) {
            String str = in.nextLine();
            String currentName = str.substring(0, str.indexOf(","));
            String parent = str.substring(str.indexOf(",") + 1, str.lastIndexOf(","));
            int processingTime = Integer.parseInt(str.substring(str.lastIndexOf(",") + 1));
            divisionList.add(new Division(currentName,parent, processingTime));
        }
    }
}
