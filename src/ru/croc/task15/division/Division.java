package ru.croc.task15.division;

public class Division {
    private final String currentName;
    private final String parent;
    private int processingTime;

    public Division(String currentName, String parent, int processingTime) {
        this.currentName = currentName;
        this.parent = parent;
        this.processingTime = processingTime;
    }

    public String getCurrentName() {
        return currentName;
    }

    public String getParent() {
        return parent;
    }

    public void processing() {
        processingTime--;
    }
}
