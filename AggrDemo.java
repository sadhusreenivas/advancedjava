import java.sql.*;
public class AggrDemo {
    
    public static void main(String[] args) throws Exception {
        
        DBConnection dbcon  = new DBConnection();
        Connection con = dbcon.getConnection();
        if(con != null)
            System.out.println("Connection established");
        else 
            System.out.println("Connection failed");
       
        Statement st = con.createStatement();
        String q1 = "select count(*), max(cgpa),min(cgpa),sum(cgpa),avg(cgpa) from student";
        ResultSet rs = st.executeQuery(q1);
        
        if(rs.next()){
           System.out.println("Count of records: "+rs.getInt(1)); //count
           System.out.println("Max CGPA: "+rs.getDouble(2));
           System.out.println("Min CGPA: "+rs.getDouble(3));
           System.out.println("Sum of CGPAs: "+rs.getDouble(4));
           System.out.println("Avg CGPA: "+rs.getDouble(5));
        }
        st.close();
        rs.close();
        con.close();
        
    }
}
