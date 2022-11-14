package src.ru.croc.task11.auction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Lot {

    private final LocalDateTime timeEnd;
    private BigDecimal currentCost;
    private String nameClient;

    public Lot(BigDecimal startCost, LocalDateTime timeEnd) {
        this.currentCost = startCost;
        this.timeEnd = timeEnd;
    }

    /**
     * Метод ставки на аукйионе
     * @param cost - новая ставка
     * @param name - тот, кто предложил ставку
     */

    public synchronized void bet(BigDecimal cost, String name, LocalDateTime betTime) {
        if(cost.compareTo(currentCost) > 0 && betTime.isAfter(timeEnd)) {
            currentCost = cost;
            nameClient = name;
        }
    }

    /**
     * Метод получения победителя
     * @return возвращает победителя аукциона
     */
    public synchronized String getWinner() {
        return nameClient;
    }
}
