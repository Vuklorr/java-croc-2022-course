package ru.croc.task17.service.db;

import ru.croc.task17.service.entity.Order;

import java.sql.*;

public class OrderDAO {

    /**
     * Создает таблицу Order с помощью SQL запроса.
     */
    public void createOrderTable() throws SQLException, ClassNotFoundException {
        final String CREATE_TABLE_SQL = "CREATE TABLE \"Order\"(" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "number_order INT NOT NULL," +
                "login VARCHAR(255) NOT NULL," +
                "article VARCHAR(255) NOT NULL," +
                "name VARCHAR(255) NOT NULL," +
                "cost INT NOT NULL" +
                ");";

        try(Connection connection = UtilDB.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(CREATE_TABLE_SQL);
        }
        System.out.println("Таблица Order создана");
    }

    /**
     * Создает таблицу Product с помощью SQL запроса.
     */
    public void createProductTable() throws SQLException, ClassNotFoundException {
        final String CREATE_TABLE_SQL = "CREATE TABLE \"Product\"(" +
                "article VARCHAR(255) PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "cost INT NOT NULL" +
                ");";

        try(Connection connection = UtilDB.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(CREATE_TABLE_SQL);
        }
        System.out.println("Таблица Product создана");
    }

    /**
     * Вставляет заказ в бд.
     *
     * @param order - запись заказа
     */
    public void insertOrder(Order order) throws SQLException, ClassNotFoundException {
        final String INSERT_ORDERS_SQL = "INSERT INTO \"Order\" " +
                "(number_order, login, article, name, cost) VALUES " +
                "(?, ?, ?, ?, ?);";
        try(Connection connection = UtilDB.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDERS_SQL);

            preparedStatement.setInt(1, order.numberOrder());
            preparedStatement.setString(2, order.login());
            preparedStatement.setString(3, order.article());
            preparedStatement.setString(4, order.name());
            preparedStatement.setInt(5, order.cost());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Вставляет продукт в бд.
     *
     * @param order - запись заказа
     */
    public void insertProduct(Order order) throws SQLException, ClassNotFoundException {
        final String INSERT_ORDERS_SQL = "INSERT INTO \"Product\" " +
                "(article, name, cost) VALUES " +
                "(?, ?, ?);";
        try(Connection connection = UtilDB.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDERS_SQL);

            preparedStatement.setString(1, order.article());
            preparedStatement.setString(2, order.name());
            preparedStatement.setInt(3, order.cost());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Проверка данных заказа с данными продукта (артикул, название, цена).
     *
     * @param order - запись заказа
     * @return - true если данные совпадают
     */

    public boolean orderVerification(Order order) throws SQLException, ClassNotFoundException {
        final String ORDER_VERIFICATION_SQL = "SELECT NAME, COST " +
                "FROM \"Product\"\n" +
                "WHERE ARTICLE = '" + order.article() +"';";

        try(Connection connection = UtilDB.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(ORDER_VERIFICATION_SQL);
            if(resultSet.next()) {
                String name = resultSet.getString(1);
                int cost = resultSet.getInt(2);
                return name.equals(order.name()) && cost == order.cost();
            } else  {
                return true;
            }
        }
    }

    /**
     * Проверка: есть ли запись о продукте в бд
     *
     * @param article - артикул (PK)
     * @return true - если запись есть
     */
    public boolean productEmpty(String article) throws SQLException, ClassNotFoundException {
        final String PRODUCT_SQL = "SELECT *" +
                "FROM \"Product\"" +
                "WHERE ARTICLE ='" + article + "';";

        try(Connection connection = UtilDB.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(PRODUCT_SQL);
            return !resultSet.next();
        }
    }
}