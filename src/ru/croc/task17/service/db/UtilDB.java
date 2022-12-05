package ru.croc.task17.service.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilDB {
    private static final String connectionUrl = "jdbc:h2:./Desktop/1my/JavaКурсCroc/java-croc-2022-course/src/ru/croc/task17";
    private static final String user = "Kundovik";
    private static final String password = "kundovik";

    /**
     * Получить connection в бд.
     *
     * @return - connection
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(connectionUrl,user,password);
    }
}