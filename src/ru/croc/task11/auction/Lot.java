package src.ru.croc.task11.auction;

import java.util.Date;

public class Lot {
    private double currentCost; //FIXME заменить дабл
    private String nameClient;
    private Date timeEnd; //FIXME посмотреть переменную для времени

    public Lot(double currentCost, String nameClient, Date timeEnd) {
        this.currentCost = currentCost;
        this.nameClient = nameClient;
        this.timeEnd = timeEnd;
    }

    /**
     * Метод ставки на аукйионе
     * @param cost - новая ставка
     * @param name - тот, кто предложил ставку
     */

    public void bet (double cost, String name) { //FIXME поменять дабл, учесть условие, что торги еще идут
        currentCost = cost;
        nameClient = name;
    }

    /**
     * Метод получения победителя
     * @return возвращает победителя аукциона
     */
    public String getWinner () {
        return nameClient;
    }
}
