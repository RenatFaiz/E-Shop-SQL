import model.Product;
import util.JdbcTemplate;
import util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Product> products = JdbcTemplate.executeQuery(
                "jdbc:sqlite:G:/Coding/Learning/it-park/Homeworks/E-Shop (SQL)/db.sqlite",
                "SELECT id, name, category, quantity, isAvailable, price FROM products;",
                new RowMapper<Product>() {
                    @Override
                    public Product map(ResultSet resultSet) throws SQLException {
                        return new Product(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("category"),
                                resultSet.getInt("quantity"),
                                resultSet.getBoolean("isAvailable"),
                                resultSet.getInt("price")
                        );
                    }
                }
        );
        System.out.println(products);
    }
}
