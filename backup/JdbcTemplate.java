package util;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class JdbcTemplate {

    private JdbcTemplate() {
    }

    public static <T> List<T> executeQuery(String url, String sql, RowMapper<T> mapper) {
        try (
                Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

        ) {
            List<T> results = new LinkedList<>();
            while (resultSet.next()) {
                results.add(mapper.map(resultSet));
            }
            return results;
        } catch (SQLException e) {
            throw new SqlMappingExeption(e);
        }
    }
}
