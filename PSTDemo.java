import java.sql.*;
import java.util.Scanner;
public class PSTDemo {
  
    public static void main(String[] args) throws Exception{
       DBConnection dbcon  = new DBConnection();
        Connection con = dbcon.getConnection();
        if(con != null)
            System.out.println("Connection established");
        else 
            System.out.println("Connection failed");
        
        Scanner in = new Scanner(System.in);
        String q1 = "insert into student values(?,?,?)";
        System.out.println("Enter sid, sname and cgpa");
        int sid = in.nextInt();
        String sname = in.next();
        double cgpa = in.nextDouble();
        
        PreparedStatement pst = con.prepareStatement(q1);
        pst.setInt(1, sid);
        pst.setString(2, sname);
        pst.setDouble(3, cgpa);
        
        int x = pst.executeUpdate(); // returns int - 
        if(x>0)
            System.out.println("No of records inserted: "+x);
        else
            System.out.println("Insertion failed...!");
        
        String q2 = "select * from student where sid >= ? and sid <= ?";
        
        System.out.println("Enter range of sids!");
        int sid1 = in.nextInt();
        int sid2 = in.nextInt();
        
        PreparedStatement pst1 = con.prepareStatement(q2);
        pst1.setInt(1, sid1);
        pst1.setInt(2,sid2);
        
        ResultSet rs = pst1.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));   
        }
    }
}
