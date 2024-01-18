package org.example;

import java.sql.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private final static String DB_HOST = "jdbc:mysql://localhost:3306/jdbc_tasks_diana";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "Andaluzia*1";


    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD);
            Statement statement = connection.createStatement();

            boolean result = statement.execute("CREATE TABLE IF NOT EXISTS movies (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT," +
                    "title VARCHAR(225) UNIQUE," +
                    "genre VARCHAR(225)," +
                    "yearOfRelease INTEGER);");



//            ResultSet resultSet = statement.executeQuery("select title from movies");
//            Set<String> list = new HashSet<>();
//            String title = "";
//            while (resultSet.next()) {
//                title = resultSet.getString("title");
//                list.add(title);
//            }
//            if (!list.contains()) {
            statement.executeUpdate("INSERT INTO movies (title, genre, yearOfRelease) VALUES ('Titanic', 'Comedy', 1950)");
            statement.executeUpdate("INSERT INTO movies (title, genre, yearOfRelease) VALUES ('Film', 'Comedy', 1950)");
//            }




//            result = statement.execute("DROP TABLE movies");
//            System.out.println(result);


        } catch (SQLIntegrityConstraintViolationException e)  {
            System.out.println("Dublicate entry");
        } catch (SQLException e) {
            System.out.println("SQL exeption" + e);
        }

    }
}