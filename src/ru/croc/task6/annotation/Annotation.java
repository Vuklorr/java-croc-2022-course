package ru.croc.task6.annotation;

import ru.croc.task6.figure.api.Figure;

public class Annotation {
    private Figure figure;
    private String label;

    public Annotation(Figure figure, String label) {
        this.figure = figure;
        this.label = label;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return figure.toString() + ": " + label;
    }
}
