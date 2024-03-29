package Java_JDBC_Hibernate.Lesson1.Task1;

import Java_JDBC_Hibernate.Connection.Connect;
import lombok.SneakyThrows;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final Connect connect = new Connect();

    public static void main(String[] args) throws IOException {
        insert();
    }


    private static void insert() throws IOException {
        File f = new File("./src/main/java/Java_JDBC_Hibernate/Lesson1/Task1/INSERT.TXT");
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String insert = reader.readLine();

        try (Connection connection = DriverManager.getConnection(connect.url(), connect.login(), connect.password());
             Statement statement = connection.createStatement()){
            statement.executeUpdate(insert);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
