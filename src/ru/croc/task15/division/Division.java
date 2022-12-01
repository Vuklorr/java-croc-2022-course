package ru.croc.task15.division;

public class Division {
    private final String name;
    private final Division parent;
    private final int processingTime;

    public Division(String name, Division parent, int processingTime) {
        this.name = name;
        this.parent = parent;
        this.processingTime = processingTime;
    }

    public String getName() {
        return name;
    }

    public Division getParent() {
        return parent;
    }

    public int getProcessingTime() {
        return processingTime;
    }
}