import java.sql.*;
import java.util.Scanner;
public class TxMgmt {
    public static void main(String[] args) throws Exception{
        
        DBConnection dbcon  = new DBConnection();
        Connection con = dbcon.getConnection();
        if(con != null)
            System.out.println("Connection established");
        else 
            System.out.println("Connection failed");
        
        Scanner in = new Scanner(System.in);
        con.setAutoCommit(false); // by default - commit is true
        
        System.out.println("Enter source account");
        int src = in.nextInt();
        System.out.println("Enter destination account");
        int dest = in.nextInt();
        System.out.println("Enter amount to be transferred: ");
        double amount = in.nextDouble();
        //TX1 - atomic - transfer
        Statement st = con.createStatement();
        String wq1 = "update accounts set balance = balance - "+ amount+" where accno = "+src;
        st.addBatch(wq1);
        String dq1 = "update accounts set balance = balance + "+ amount+" where accno = "+dest;
        st.addBatch(dq1);
        
        //execute the batch
        int[] res = st.executeBatch();
        //logic for commit and rollback
        boolean flag = false;
        for(int i=0; i<res.length;i++){
            if(res[i] == 0){ // query failed
                flag = true;
                break;
            }
        }
        
        if(flag == true){
            con.rollback(); // Tx aborted
            System.out.println("Transaction rolled back");
        }
        else{
            con.commit();
            System.out.println("Transaction committed");
        }
        
        ResultSet rs = st.executeQuery("select * from accounts");
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3));
        }
    }
}
