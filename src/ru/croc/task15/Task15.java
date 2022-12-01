package ru.croc.task15;

import ru.croc.task15.division.FormingResponse;

import java.io.FileNotFoundException;

public class Task15 {
    public static void main(String[] args) throws FileNotFoundException {
        FormingResponse formingResponse = new FormingResponse();
        System.out.println(formingResponse.timeFormingResponse());
    }
}