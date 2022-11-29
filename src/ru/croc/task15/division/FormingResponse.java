package ru.croc.task15.division;

import ru.croc.task15.division.util.ParseFile;

import java.io.FileNotFoundException;
import java.util.List;

public class FormingResponse {
    private List<Division> listDivision;

    public int timeFormingResponse(String pathFile) throws FileNotFoundException {
        int time = 0;
        ParseFile.parseFile(pathFile, listDivision);
        return time;
    }
}
