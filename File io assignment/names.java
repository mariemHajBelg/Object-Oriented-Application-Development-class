import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
/*
 * Mariem Haj Belgacem
 * Cs280
 * assignment 6
 */
public class names {
	// main method
	public static void main(String[] args) {
		
		Scanner scan= null;
		int i=0;
		
			try
		{
				scan= new Scanner(new File("C:\\CS280\\girlnames.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
			//hashSet for girls names and arraylist for the common names 
		HashSet<String> allNames= new HashSet<String>();
		ArrayList<String> comNames = new ArrayList<String>();
		
	
		while(scan.hasNext())
		{
			String name= scan.next();
		int numOcc=scan.nextInt();
			allNames.add(name);	
			
		}
		
		// find the names in common between the girls and the boys
		try
		{
			scan= new Scanner(new File("C:\\CS280\\boynames.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		
	
	
		while(scan.hasNext())
		{
			String name=scan.next();
			
			int numOcc= scan.nextInt();
			if(!allNames.add(name))
			{
				comNames.add(name);
				i++;
			}				
		}
	
		
	// total number of boys + girls in the census
		int censusBoyTotal=0,censusGirlTotal=0 ,girlTotal=0,boyTotal=0;
		// boys
		try
		{
			scan= new Scanner(new File("C:\\CS280\\boynames.txt"));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		
		while(scan.hasNext())
		{
			String line=scan.nextLine();
			int x =Integer.parseInt(line.substring(line.indexOf(" ")+1));

			boyTotal=boyTotal+x;
			if(comNames.contains(line.substring(0, line.indexOf(" "))))
				
			{
				censusBoyTotal= censusBoyTotal +x;
			}				
		}
		//girls
		try
		{
				scan= new Scanner(new File("C:\\CS280\\girlnames.txt"));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		}
		while(scan.hasNext())
		{
			String line=scan.nextLine();
			int x =Integer.parseInt(line.substring(line.indexOf(" ")+1));
			
			girlTotal= girlTotal+x; 
			
			if(comNames.contains(line.substring(0, line.indexOf(" "))))
				
			{
				
				censusGirlTotal= censusGirlTotal +x;
			}				
		}
		
		//outputs
		System.out.println("The  number of common names between boys and girls is "+i+" the names are:");
		System.out.println();

		System.out.println(comNames);
		System.out.println();

		System.out.println("The total number of boys recorded in the census is "+censusBoyTotal+ " over a total of "+ boyTotal+" boys." );
		System.out.println("The total number of girls recorded in the census is "+censusGirlTotal+ " over a total of "+ girlTotal+" girls." );

		


		
}
	
	
}