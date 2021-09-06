package preparest;
import java.sql.*;
import java.util.Scanner;
import java.io.*;
public class Preparest
{
    public static void main(String[] args) 
    {

       try
       {
	   Class.forName("com.mysql.jdbc.Driver");
           Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/pavan","root","");
           PreparedStatement ps=c.prepareStatement("insert into ulogin values(? ,?)");
		   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                   
             Scanner in=new Scanner(System.in);
            
             while(true)
             {
             System.out.println("1 for insert / 2 for update / 3 for delete / 4 for break :");
             int d=in.nextInt();
             String name;
             int id,i;
		if(d==1)
                {   
                  try
                  {
                   System.out.println("for Insert data");
                   ps=c.prepareStatement("INSERT INTO ulogin VALUES(?,?)");
		   System.out.println("enter Name :");
		   name=br.readLine();
		   System.out.println("enter ID:");
		   id =Integer.parseInt(br.readLine());
		   
		   ps.setInt(1,id);
		   ps.setString(2,name);   
		    i=ps.executeUpdate();
		   System.out.print(i+" data affected");
                  }
                  catch(Exception e)
                  {
                      //
                  }
                }
                  
                
                if(d==2)
                {
		   try
                   {
		   System.out.println("for update data");
		   ps=c.prepareStatement("update ulogin set name=? where id = ?");
		   
		   System.out.println("enter ID:");
		    id =Integer.parseInt(br.readLine());
                    System.out.println("enter Name :");
		    name=br.readLine();
		   
		   ps.setInt(2,id);
		   ps.setString(1,name);  
		    i=ps.executeUpdate();
		   System.out.print(i+" data affected");
                   }
                   catch(Exception e)
                   {
                       //
                   }
                }
		 if(d==3)
                 {
                     try
                    {
		   System.out.println("for delete data");
		   ps=c.prepareStatement("delete from login where id=?");
		   System.out.println("enter ID which you wanna delete :");
		   id =Integer.parseInt(br.readLine());
		   
		   ps.setInt(1,id);
		   i=ps.executeUpdate();
		   System.out.print(i+" data affected");
                   }
                     catch(Exception e)
                     {
                         //
                     }
                 }
                 if(d==4)
                 {
                     break;
                 }
             }
		   
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from ulogin");
           while(rs.next()) 
           {
                System.out.print("ID : "+rs.getString("id")+", ");
                System.out.print("NAME : "+rs.getString("name")+", ");
                System.out.println("");
                
            }
         
	}
	catch(Exception e)
	{
			System.out.println("Error : " +e);
	}
    }
    
}
//INSERT INTO login VALUES(1,'Mautik','bhavnagar','mautik@gmail.com','4356782310',10)
//UPDATE login set name='donda' where ID=1
//delete from login where id=1