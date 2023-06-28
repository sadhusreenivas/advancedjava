
import java.sql.*;
public class JDBCDemo {
    
    public static void main(String[] args) throws Exception{
        // 1.Loading Diver class
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/users";
            String user = "root";
            String pwd = "root";
         // 2. Establishing Connection
            Connection con = DriverManager.getConnection(url, user, pwd);
            if(con!=null)
                System.out.println("Connection established ");
            else
                System.out.println("Connection failed");
           
            Statement st = con.createStatement();
            // creating table
            String q1 = "create table emp(eid int, ename varchar(20), esal float)";
            int status = st.executeUpdate(q1);
            if(status>=0)
                System.out.println("Table created - emp");
            else
                System.out.println("Issue in ceating Table emp");
           
            //insert 2 records
           String q2 = "insert into emp values(1234,'Ramesh',780000),(1111,'Suresh',980000)";
           int  i = st.executeUpdate(q2);
           if(i>0)
               System.out.println("Insertion success!");
           else
               System.out.println("Insertion failed");
            
           // select - fetch records
           String query = "select * from emp";
           ResultSet rs = st.executeQuery(query);
           //processing the results
           while(rs.next()){ // records exist -- table
               System.out.println(rs.getInt("eid")+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
           }
           st.close();
           rs.close();
           con.close();
    }
}
