package util;


import model.Product;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class JdbcTemp {

    private JdbcTemp() {
    }

    public static void executeUpdate(String value) {
        String url = "jdbc:sqlite:G:/Coding/Learning/it-park/Homeworks/E-Shop (SQL)/db.sqlite";

        try {
            Connection connection = DriverManager.getConnection(url);
            String sql = "UPDATE products SET name = ? WHERE id=0 ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, value);
            preparedStatement.execute();

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows);

            //ResultSet resultSet = preparedStatement.executeQuery();

//            List<T> results = new LinkedList<>();
//            while (resultSet.next()) {
//                results.add(mapper.map(resultSet));
//            }
        } catch (SQLException e) {
            throw new SqlMappingExeption(e);
        }
    }

    public static List<Product> executeQuery(int minPrice, int maxPrice) {
        String url = "jdbc:sqlite:G:/Coding/Learning/it-park/Homeworks/E-Shop (SQL)/db.sqlite";
        try {
            Connection connection = DriverManager.getConnection(url);
            String sql = "SELECT id, name, category, quantity, isAvailable," +
                    " price FROM products WHERE price BETWEEN ? AND ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, minPrice);
            preparedStatement.setInt(2, maxPrice);


            ResultSet resultSet = preparedStatement.executeQuery();
            List<Product> results = new LinkedList<>();
            while (resultSet.next()) {
                results.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("category"),
                        resultSet.getInt("quantity"),
                        resultSet.getBoolean("isAvailable"),
                        resultSet.getInt("price")
                ));
            }
            return results;
        } catch (SQLException e) {
            throw new SqlMappingExeption(e);
        }
    }
}


// Update -> UPDATE, INSERT, DELETE

// Execute -> делай, что хочешь
//Statement statement = connection.createStatement();
//ResultSet resultSet = statement.executeQuery(value);