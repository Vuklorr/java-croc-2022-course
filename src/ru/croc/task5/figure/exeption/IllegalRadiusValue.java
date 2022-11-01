package src.ru.croc.task5.figure.exeption;

public class IllegalRadiusValue extends Exception {
    private final int value;

    public IllegalRadiusValue (int value) {
        this.value = value;
    }

    @Override
    public String getMessage() {
        return value + " - Невозможное значение радиуса, радиус должен быть больше 1";
    }
}
