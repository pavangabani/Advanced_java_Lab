import java.sql.*;
class jdbcwithoutdsn
{
	public static void main(String []s)
	{
		try
		{
			String database="pavan.mdb";
			String url="jdbc:odbc:Driver{Microsoft Access Driver(*.mdb)};DBQ="+dtabase+";DriverID=22;READONLY=true";
			Class.forName("sun.jdbc.odbc.jbbcodbcdriver");
            Connection c=DriverManager.getConnection(url);
		    Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from login");
		    while(rs.next())
		   {
				System.out.println(rs.getString("uname"));
		   }			
		}
		catch(Exception e)
		{
			//
		}		
	}
}
