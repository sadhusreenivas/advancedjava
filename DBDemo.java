import java.sql.*;
public class DBDemo {
    public static void main(String[] args) throws Exception {
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
          // 3. Create stattement
            Statement st = con.createStatement();
          // 4. Execute Query and process the results
           //insert
           String iquery = "insert into student values(111,'PQR',7.8)";
           int  i = st.executeUpdate(iquery);
           if(i>0)
               System.out.println("Insertion success!");
           else
               System.out.println("Insertion failed");
           //update
           String uquery = "update student set cgpa = 9.3 where sid = 199";
           int j = st.executeUpdate(uquery);
           if(j>0)
               System.out.println("update success!");
           else
               System.out.println("update failed");
          
           // delete
           int k = st.executeUpdate("delete from student where sname='PQR';");
            if(k>0)
               System.out.println("deletion success!");
           else
               System.out.println("deletion failed");
           
          // select
           String query = "select * from student";
           ResultSet rs = st.executeQuery(query);
           //processing the results
           while(rs.next()){ // records exist -- table
               System.out.println(rs.getInt("sid")+"\t"+rs.getString(2)+"\t"+rs.getDouble("cgpa"));
           }
           st.close();
           rs.close();
           con.close();
    }
}
