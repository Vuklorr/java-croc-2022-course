package ru.croc.task17;

import ru.croc.task17.service.OrderService;
import ru.croc.task17.service.db.OrderDAO;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Task17 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
        OrderDAO orderDAO = new OrderDAO();
        OrderService orderService = new OrderService(args[0]);

        orderDAO.createOrderTable();
        orderDAO.createProductTable();
        orderService.importInDB();
    }
}
