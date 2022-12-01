package ru.croc.task15.division.util;

import ru.croc.task15.division.Division;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ParseFile {

    /**
     * Парсит файл в список отделов.
     *
     * @param path - путь к файлу
     * @param divisionList - список отделов
     * @throws FileNotFoundException - если файл не найден
     */

    public static void parseFile(String path, List<Division> divisionList) throws FileNotFoundException {
        File divisionFile = new File(path);
        Scanner in = new Scanner(new FileInputStream(divisionFile));

        while (in.hasNextLine()) {
            String[] data = in.nextLine().split(",");
            Division parentDivision = null;

            if(!data[1].equals("-")) {
                for(Division division : divisionList) {
                    if(division.getName().equals(data[1])) {
                        parentDivision = division;
                        break;
                    }
                }
            }
            divisionList.add(new Division(data[0],parentDivision, Integer.parseInt(data[2])));
        }
    }
}