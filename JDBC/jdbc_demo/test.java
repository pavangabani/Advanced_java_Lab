import java.sql.*;
class test
{
	public static void main(String []s)
	{
		try
		{
			String url="jdbc:odbc:pavan";
			Class.forName("sun.jdbc.odbc.jdbcodbcdriver");
            Connection c=DriverManager.getConnection(url);
		    Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from login");
		    while(rs.next())
		   {
				System.out.println("Name : " + rs.getString("uname"));
		   }			
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}		
	}
}
