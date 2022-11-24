package ru.croc.task11.auction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Lot {

    private final LocalDateTime timeEnd;
    private volatile BigDecimal currentCost;
    private volatile String nameClient;

    public Lot(BigDecimal startCost, LocalDateTime timeEnd) {
        this.currentCost = startCost;
        this.timeEnd = timeEnd;
    }

    public BigDecimal getCurrentCost() {
        return currentCost;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    /**
     * Метод ставки на аукционе.
     *
     * @param cost - новая ставка
     * @param name - тот, кто предложил ставку
     */
    public synchronized void bet(BigDecimal cost, String name, LocalDateTime betTime) {
        if(cost.compareTo(currentCost) > 0 && betTime.isBefore(timeEnd)) {
            currentCost = cost;
            nameClient = name;
        }
    }

    /**
     * Получение победителя по времени.
     *
     * @param currentTime - текущее время
     * @return - имя победителя
     */
    public String getWinner(LocalDateTime currentTime) {
        if(nameClient == null) {
            return "Победителя нет";
        }

        if(currentTime.isAfter(timeEnd)) {
            return nameClient;
        }

        return "Победитель не известен";
    }
}
