package org.example;
import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("JDBC sample");

// Register driver
//        Class.forName("com.mysql.cj.jdbc.Driver");

        // connection establish
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCdemo", "root", "password-1");
        System.out.println(connection);
// insert / delete / update/ view the datatable

        // create statement channel
        Statement statement = connection.createStatement();

        int rowsUpdated = statement.executeUpdate(
                "UPDATE Person SET  City='Kolkata' WHERE PersonID = 2"
        );

        System.out.println("Rows updated: " + rowsUpdated);


        // INSERT
        statement.executeUpdate(
                "INSERT INTO Person (FirstName, LastName,  Gender,  City) " +
                        "VALUES ('siva', 'test',  'M',  'Delhi')"
        );


// DELETE
        statement.executeUpdate(
                "DELETE FROM Person WHERE PersonID = 4"
        );



        //view data
        ResultSet resultSet =statement.executeQuery("Select personID,FirstName, Gender,City from Person");

        while(resultSet.next()) {
            System.out.println(resultSet.getString("personID")
                    +":"+resultSet.getString("FirstName")
                    +":"+resultSet.getString("Gender")
                    +":"+resultSet.getString("City"));
        }

        //close connection
        connection.close();

    }
}
