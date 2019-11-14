package util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ProductMapper<Product> {
    default Product map(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String category = resultSet.getString("category");
        int quantity = resultSet.getInt("quantity");
        boolean isAvailable = resultSet.getBoolean("isAvailable");
        int price = resultSet.getInt("price");

        return map(resultSet);
    }
}
