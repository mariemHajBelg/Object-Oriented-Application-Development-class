import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/*
 * Assignment 7
There is a database named ‘world’on the frodo server. The database contains 3 tables: city, country, and countrylanguage. 
country is in a one to many relationship with city.
You may use MySQL Workbench to determine the field names and data types for each field.

Write a Java program that determines if the city table contains a record for a city named ‘Nonsan’. If there isn’t, print this fact and exit the program. If there is, print its country code and its population.

Next, using a PreparedStatement determine the country name and the continent that the city is on using the country code returned above. Print two these values.

 */
public class world {

	public static void main(String[] args) {
		
		String name = "", code = "", dist = "", cont = "", URL = "jdbc:mysql://***",userName = "****",password = "****";		
		int pop = 0;	
	

		ArrayList<City> list = new ArrayList<City>();	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load MySQL driver.");
			return;
		}

		try (Connection con = DriverManager.getConnection(URL, userName, password)) {
			Statement stat = con.createStatement();			
			ResultSet r = stat.executeQuery("SELECT * FROM City WHERE Name = 'Nonsan';");	
			int x = 0;
		
			if(r.next() == false) {
				System.out.println("ResultSet empty");
			}else {
				do {
					name = r.getString("Name");
					code = r.getString("CountryCode");
					dist = r.getString("District");
					pop = r.getInt("Population");
					City city = new City(name, code, dist, pop);	
					list.add(city);	
					if(name.contains("Nonsan")) {	
						city.setName("Nonsan");		
						
						System.out.println("The population of " + name + " is " + pop +" its country code is "+ code);
						x ++;	
						break;
					}
					if(x == 0) {	System.out.println("This city does not exist");
					} 
				}while (r.next());	
			}
			
			
			String s = "SELECT Name, Continent FROM country WHERE Code = ?;";
			PreparedStatement prepstat = con.prepareStatement(s);	
			prepstat.setString(1, code); 
			ResultSet r1 = prepstat.executeQuery();	
			if(r1.next() == false) {	
				System.out.println("ResultSet empty");
			}else {
				do {
					if(code.equals("KOR")) {	
						name = r1.getString("Name"); 
						cont = r1.getString("Continent");	
						System.out.println("Nonsan is located in " +  name + ", a country in "+ cont);}
				}
				while(r1.next());	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
}
}
}
