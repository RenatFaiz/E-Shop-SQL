package util;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
interface Mapper<T> {
    T map (ResultSet resultSet) throws SQLException;
}
