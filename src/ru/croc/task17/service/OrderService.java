package ru.croc.task17.service;

import ru.croc.task17.service.db.OrderDAO;
import ru.croc.task17.service.entity.Order;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class OrderService {

    private final String pathFile;

    public OrderService(String pathFile) {
        this.pathFile = pathFile;
    }

    /**
     * Импортирует данные из файла в бд.
     */
    public void importInDB() throws FileNotFoundException, SQLException, ClassNotFoundException {
        File file = new File(pathFile);
        Scanner in = new Scanner(file);
        OrderDAO orderDAO = new OrderDAO();

        while (in.hasNextLine()) {
            String[] data = in.nextLine().split(",");

            int numberOrder = Integer.parseInt(data[0]);
            String login = data[1];
            String article = data[2];
            String name = data[3];
            int cost = Integer.parseInt(data[4]);

            Order order = new Order(numberOrder, login, article, name, cost);

            if(orderDAO.productEmpty(order.article())) {
                orderDAO.insertProduct(order);
            }

           if(orderDAO.orderVerification(order)) {
               orderDAO.insertOrder(order);
            } else {
                throw new UnsupportedOperationException("Article:" + order.article());
            }
        }

        System.out.println("Данные успешно импортированы");
        in.close();
    }
}