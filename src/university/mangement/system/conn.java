package university.mangement.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {

    Connection connection;
    Statement statement;

    conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql:///universitymanagement","root","Password");
           statement=connection.createStatement();

        }catch(Exception e){
            e.printStackTrace();

        }

    }
}
