import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlTest {

    public static void main(String[] args) {

        System.out.println("starting main");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/developia?"
                            + "user=root&password=root1234");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement
                    .executeQuery("select * from developia.students");

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("firstname");
                String surname = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                System.out.println(id + " " + name + " " + surname + " " + email);
            }

//            PreparedStatement preparedStatement = connection
//                    .prepareStatement("insert into  developia.students values (default, ?, ?, ?)");
//
//            preparedStatement.setString(1, "Tarlan");
//            preparedStatement.setString(2, "Asgarzada");
//            preparedStatement.setString(3, "tarlan@gmail.com");
//
//            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
