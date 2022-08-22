import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/medicine";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String QUERY_FIND_ALL = "select m.id id, m.name name, m.price price, mt.name type from medicine m join medicine_type mt on mt.id = m.medicine_type_id order by id";

    public static List<Medicine> findAll() {
        List<Medicine> medicineList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_FIND_ALL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String type = rs.getString("type");
                medicineList.add(new Medicine(id, name, price, type));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicineList;
    }

}
