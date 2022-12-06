package ru.croc.task18.dao;

import ru.croc.task18.entity.Product;
import ru.croc.task18.util.UtilDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO {

    /**
     * Ищет продукт в бд.
     *
     * @param productCode  - артикул
     * @return - найденный продукт или null, если не найдет
     */
    public Product findProduct(String productCode) throws SQLException, ClassNotFoundException {
        final String FIND_QUERY_SQL = "SELECT*" +
                "FROM \"Product\" " +
                "WHERE ARTICLE = '" + productCode +"';";
        try(Connection connection = UtilDB.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(FIND_QUERY_SQL);
            if(resultSet.next()) {
               String article = resultSet.getString(1);
               String name = resultSet.getString(2);
               int cost = resultSet.getInt(3);

               return new Product(article,name, cost);
            }
        }
        return null;
    }

    /**
     * Создает новый продукт в бд.
     *
     * @param product - продукт
     * @return - продукт, который создался в бд
     */
    public Product createProduct(Product product) throws SQLException, ClassNotFoundException {
        if(productExists(product)) {
            throw new UnsupportedOperationException(product.article());
        }

        final String CREATE_QUERY_SQL = "INSERT INTO \"Product\" " +
                "(article, name, cost) VALUES " +
                "(?, ?, ?);";

        try(Connection connection = ru.croc.task17.service.db.UtilDB.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY_SQL);

            preparedStatement.setString(1, product.article());
            preparedStatement.setString(2, product.name());
            preparedStatement.setInt(3, product.cost());
            preparedStatement.executeUpdate();
        }
        return product;
    }

    /**
     * Обновляет запись о продукте.
     *
     * @param product - продукт
     * @return - продукт, данными которого обновили запись в бд
     */
    public Product updateProduct(Product product) throws SQLException, ClassNotFoundException {
        final String UPDATE_QUERY_SQL = "UPDATE \"Product\" " +
                "SET NAME = '" + product.name() + "', " +
                "    COST = " + product.cost() +
                " WHERE ARTICLE = '" + product.article() + "';";

        try(Connection connection = ru.croc.task17.service.db.UtilDB.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY_SQL);
            preparedStatement.executeUpdate();

            return product;
        }
    }

    /**
     * Удаляет продукт и все записи о нем в заказах.
     *
     * @param productCode - артикул
     */
    public void deleteProduct(String productCode) throws SQLException, ClassNotFoundException {
        final String DELETE_PRODUCT_QUERY_SQL = "DELETE From \"Product\" " +
                "WHERE ARTICLE = '" + productCode + "';";
        OrderDAO orderDAO = new OrderDAO();

        try(Connection connection = ru.croc.task17.service.db.UtilDB.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_QUERY_SQL);
            preparedStatement.executeUpdate();
        }
        orderDAO.deleteOrder(productCode);
    }

    /**
     * Проверка на то есть ли продукт в бд.
     *
     * @param product - продукт
     * @return - true, если продукт есть в бд
     */
    private boolean productExists(Product product) throws SQLException, ClassNotFoundException {
        final String EXISTS_QUERY_SQL = "SELECT*" +
                "FROM \"Product\" " +
                "WHERE ARTICLE = '" + product.article() +"';";

        try(Connection connection = UtilDB.getConnection()) {
            ResultSet resultSet = connection.createStatement().executeQuery(EXISTS_QUERY_SQL);
            return resultSet.next();
        }
    }
}