import model.Product;
import util.JdbcTemp;
import util.JdbcTemplate;
import util.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        System.out.println(JdbcTemp.executeUpdate("iphone", 0));
//        System.out.println(JdbcTemp.executeUpdate("Микроволновая печь", 0));
//        System.out.println(JdbcTemp.executeQuery(0, 5000));
//        System.out.println(JdbcTemp.selectAll());
        System.out.println(JdbcTemp.getOrdersByDate());
    }
}



//        final List<Product> products = JdbcTemplate.executeQuery(
//                "jdbc:sqlite:G:/Coding/Learning/it-park/Homeworks/E-Shop (SQL)/db.sqlite",
//                "SELECT id, name, category, quantity, isAvailable, price FROM products;",
//                new RowMapper<Product>() {
//                    @Override
//                    public Product map(ResultSet resultSet) throws SQLException {
//                        return new Product(
//                                resultSet.getInt("id"),
//                                resultSet.getString("name"),
//                                resultSet.getString("category"),
//                                resultSet.getInt("quantity"),
//                                resultSet.getBoolean("isAvailable"),
//                                resultSet.getInt("price")
//                        );
//                    }
//                }
//        );
//        System.out.println(products);
