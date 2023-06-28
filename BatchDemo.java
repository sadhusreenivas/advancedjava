import java.sql.*;
public class BatchDemo {
    
    public static void main(String[] args) throws Exception{
        DBConnection dbcon  = new DBConnection();
        Connection con = dbcon.getConnection();
        if(con != null)
            System.out.println("Connection established");
        else 
            System.out.println("Connection failed");
    
        Statement st = con.createStatement();
        
        st.addBatch("insert into student values(399,'DFGH',8.9)");
        st.addBatch("update student set sname='ASDF' where sid = 200");
        st.addBatch("insert into student values(499,'Dyc',6.9)");
        st.addBatch("delete from student where cgpa between 8.5 and 9");
        
       int[] res = st.executeBatch();
       
       for(int i=0;i<res.length; i++){
           System.out.println(res[i]);   
       }
       ResultSet rs = st.executeQuery("select * from student");
        
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
        }
       
       con.close();
    
    }
}
