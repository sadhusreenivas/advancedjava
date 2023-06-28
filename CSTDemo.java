import java.sql.*;
public class CSTDemo {
    public static void main(String[] args) throws Exception{  
         DBConnection dbcon  = new DBConnection();
         Connection con = dbcon.getConnection();
        if(con != null)
            System.out.println("Connection established");
        else 
            System.out.println("Connection failed");
        
        // calling stored procedure
        //String query = "{call first_pro(?,?)}"; // calling procedure
        // function - returns a value
        
        String query = "{? = call add_ab(?,?)}";
        CallableStatement cst = con.prepareCall(query);
        
        cst.setInt(2,123); // setting the i/p param
        cst.setInt(3,321);
        cst.registerOutParameter(1, Types.INTEGER);
        
        cst.execute(); // 
        
        int result = cst.getInt(1);
        System.out.println("Sum of two given numbers: "+result);
        
    }
}


/*
create function add_ab(a int, b int)
    -> returns int deterministic
    -> begin
    -> declare c int;
    -> set c = (a+b);
    -> return c;
    -> end
    -> $$
*/

/*
delimiter $$
mysql> create procedure first_pro(a int, out b int)
    -> begin
    -> set b = (a*a);
    -> end
    -> $$
*/