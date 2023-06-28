import java.sql.*;
public class SQDemo {
    
    public static void main(String[] args) throws Exception{
        DBConnection dbcon  = new DBConnection();
        Connection con = dbcon.getConnection();
        if(con != null)
            System.out.println("Connection established");
        else 
            System.out.println("Connection failed");
       
        Statement st = con.createStatement();
        String q1 = "select * from student where sid = ? ";
        ResultSet rs = st.executeQuery(q1);
        
        if(rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
        }
        
        rs.close();
        st.close();
        con.close();
    }
}
