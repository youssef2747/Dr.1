
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class database {
    private static String user ="root";
    private static String password ="";
    private static String host="jdbc:mysql://localhost/Database_of_the_project";
    private static Connection c ;
    public static void connect(){
        try {
            c= DriverManager.getConnection(host,user,password);
            Statement s = c.createStatement();
            //s.execute("insert into peoples values('youssef alaa',1,23,29)");
        } catch (SQLException throwables) {
        	System.out.println(throwables.getMessage());
        }
    }
    public static void addPerson(String name , int code, int Start_history,int End_History) {
    	try {
            c= DriverManager.getConnection(host,user,password);
            Statement s = c.createStatement();
            s.execute("insert into peoples values('"+name+"',"+code+","+Start_history+","+End_History+")");
        } catch (SQLException throwables) {
        	System.out.println(throwables.getMessage());
        }
    }
    public static ArrayList<person> getPersons(){
    	ArrayList<person> persons = new ArrayList<>();
    	try {
            c= DriverManager.getConnection(host,user,password);
            Statement s = c.createStatement();
            ResultSet r;
            r=s.executeQuery("select * from peoples");
            while(r.next()) {
            	persons.add(new person(r.getInt("code"),r.getString("name"),r.getInt("history"), r.getInt("endHistory")));
            }
        } catch (SQLException throwables) {
        	System.out.println(throwables.getMessage());
        }
    	return persons;
    }
    public static void remove (person a) {
    	int code = a.getId();
    	
    	try {
            c= DriverManager.getConnection(host,user,password);
            Statement s = c.createStatement();
            s.execute("delete from peoples where code =" + a.getId());
            System.out.println("pk");
        } catch (SQLException throwables) {
        	System.out.println(throwables.getMessage());
        }
    }
    public static void updatePerson(int id , String name , int SH,int EH,person a) {
    	
    	try {
            c= DriverManager.getConnection(host,user,password);
            Statement s = c.createStatement();
            s.execute("update peoples set code = "+id+" ,name = '"+name+"' ,history = " +SH+" ,endHistory = "+EH+" where code = "+a.getId());

           System.out.println("pk");
        } catch (SQLException throwables) {
        	System.out.println(throwables.getMessage());
        }
    }
}
