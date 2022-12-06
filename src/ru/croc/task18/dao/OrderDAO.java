package ru.croc.task18.dao;

import ru.croc.task18.entity.Order;
import ru.croc.task18.entity.Product;
import ru.croc.task18.util.UtilDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO {

    /**
     * Создает информацию о заказе в бд.
     *
     * @param userLogin - логин пользователя
     * @param products - список товаров
     * @return - новый заказ
     */
    public Order createOrder(String userLogin, List<Product> products) throws SQLException, ClassNotFoundException {
        int numberOrder = getMaxNumberOrder() + 1; //определение номера заказа
        final String CREATE_QUERY_SQL = "INSERT INTO \"Order\" (NUMBER_ORDER, LOGIN, ARTICLE, NAME, COST) " +
                "VALUES (?, ?, ?, ?, ?);";

        try(Connection connection = UtilDB.getConnection()) {
            for(Product product : products) {
                PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY_SQL);
                preparedStatement.setInt(1, numberOrder);
                preparedStatement.setString(2,userLogin);
                preparedStatement.setString(3,product.article());
                preparedStatement.setString(4,product.name());
                preparedStatement.setInt(5,product.cost());
                preparedStatement.executeUpdate();
            }
        }

        return new Order(numberOrder, userLogin, products);
    }

    /**
     * Удаление всех записей о товаре в бд Order.
     *
     * @param productCode - артикул
     */

    public void deleteOrder(String productCode) throws SQLException, ClassNotFoundException {
        final String DELETE_PRODUCT_QUERY_SQL = "DELETE From \"Order\" " +
                "WHERE ARTICLE = '" + productCode + "';";

        try(Connection connection = ru.croc.task17.service.db.UtilDB.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_QUERY_SQL);
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Получение максимального номера заказа.
     *
     * @return - максимальный номер
     */

    private int getMaxNumberOrder() throws SQLException, ClassNotFoundException {
        final String MAX_QUERY_SQL = "SELECT MAX(NUMBER_ORDER) AS max " +
                               "FROM \"Order\";";
        try(Connection connection = UtilDB.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(MAX_QUERY_SQL);
            resultSet.next();
            return resultSet.getInt(1);
        }
    }
}