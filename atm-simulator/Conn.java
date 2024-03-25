import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try {
            //step 1 - Register the Driver
            // Class.forName(com.mysql.cj.jdbc.Driver);
            //step 2 - Create connection
            c = DriverManager.getConnection("jdbc:mysql:///bms", "root", "pujan@6563");
            //step 3 - Create statement
            s = c.createStatement();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
