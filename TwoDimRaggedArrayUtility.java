package HolidayBonus;

/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: (Give a brief description for each Class)
 * Due: 04/14/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Alvin Persaud
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility
{
	public static double getAverage(double[][] data)
	{
		int numCells = 0;
		double total = 0;
		
		for(int i = 0; i < data.length; i++)
		{
			for(int j = 0; j < data[i].length; j++)
			{
				total += data[i][j];
				numCells++;
			}
		}
		return (total/numCells);
	}
	
	public static double getColumnTotal(double[][] data, int col)
	{
		double total = 0.0;
		for(int i = 0; i < data.length; i++)
		{
			if(col < data[i].length)
			{
				total += data[i][col];
			}
		}
		return total;
	}
	
	public static double getHighestInArray(double[][] data)
	{
		double highest = data[0][0];
		
		for(int i = 0; i < data.length; i++)
		{
			for(int j = 0; j < data[i].length; j++)
			{
				if(highest < data[i][j])
				{
					highest = data[i][j];
				}
			}
		}
		return highest;
	}
	
	public static double getHighestInColumn(double[][] data, int col)
	{
		double highest = -99999999.9;
		for(int i = 0; i < data.length; i++)
		{
			if(col < data[i].length && highest < data[i][col])
			{
				highest = data[i][col];
			}
		}
		return highest;
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		double highest = -99999999.9;
		int index = 0;
		for(int i = 0; i < data.length; i++)
		{
			if(col < data[i].length && highest < data[i][col])
			{
				highest = data[i][col];
				index = i;
			}
		}
		return index;
	}
	
	public static double getHighestInRow(double[][] data, int row)
	{
		double highest = data[row][0];
		for(int i = 0; i < data[row].length; i++)
		{
			if(highest < data[row][i])
			{
				highest = data[row][i];
			}
		}
		return highest;
	}
	
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		double highest = data[row][0];
		int index = 0;
		for(int i = 0; i < data[row].length; i++)
		{
			if(highest < data[row][i])
			{
				highest = data[row][i];
				index = i;
			}
		}
		return index;
	}
	
	public static double getLowestInArray(double[][] data)
	{
		double lowest = data[0][0];
		
		for(int i = 0; i < data.length; i++)
		{
			for(int j = 0; j < data[i].length; j++)
			{
				if(lowest > data[i][j])
				{
					lowest = data[i][j];
				}
			}
		}
		return lowest;
	}
	
	public static double getLowestInColumn(double[][] data, int col)
	{
		double lowest = 9999999999.9;
		for(int i = 0; i < data.length; i++)
		{
			if(col < data[i].length && lowest > data[i][col])
			{
				lowest = data[i][col];
			}
		}
		return lowest;
	}
	
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		double lowest = 9999999999.9;
		int index = 0;
		for(int i = 0; i < data.length; i++)
		{
			if(col < data[i].length && lowest > data[i][col])
			{
				lowest = data[i][col];
				index = i;
			}
		}
		return index;
	}
	
	public static double getLowestInRow(double[][] data, int row)
	{
		double lowest = data[row][0];
		for(int i = 0; i < data[row].length; i++)
		{
			if(lowest > data[row][i])
			{
				lowest = data[row][i];
			}
		}
		return lowest;
	}
	
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		double lowest = data[row][0];
		int index = 0;
		for(int i = 0; i < data[row].length; i++)
		{
			if(lowest > data[row][i])
			{
				lowest = data[row][i];
				index = i;
			}
		}
		return index;
	}
	
	public static double getRowTotal(double[][] data, int row)
	{
		double total = 0.0;
		for(int i = 0; i < data[row].length; i++)
		{
			total += data[row][i];
		}
		return total;
	}
	
	public static double getTotal(double[][] data)
	{
		double total = 0;
		
		for(int i = 0; i < data.length; i++)
		{
			for(int j = 0; j < data[i].length; j++)
			{
				total += data[i][j];
			}
		}
		return total;
	}
	
	public static double[][] readFile(File file) throws FileNotFoundException
	{
		final int MAX_ROW = 10;
		final int MAX_COLUMN = 10;
		
		Scanner scanner = new Scanner(file);
		int numRows = 0;
		String[][] temp = new String[MAX_ROW][MAX_COLUMN]; 
	    
		//Goes through each row in the file
		while (scanner.hasNextLine())
		{
			//Adds the row from the file into the row array and splits each of them by the " " in between each value
			String[] row = scanner.nextLine().split(" ");
			temp[numRows] = new String[row.length];
			for (int i = 0; i < row.length; i++)
			{
				//Adds each value in the row array to the temp array
				temp[numRows][i] = row[i];   
			}
			numRows++;
		}
		
		double[][] data = new double[numRows][];
		
		for (int i = 0; i < numRows; i++)
		{
			//The length of the ith row of the data array is initialized to the length of the ith row from the temp array
			data[i]= new double[temp[i].length];
			for (int j = 0; j < temp[i].length; j++)
			{
				//System.out.print(temp[i][j] + " ");
				//The i by jth index of the data array is initialized to the i by jth index of the temp array converted from a String to a double
				data[i][j] = Double.parseDouble(temp[i][j]);
	    	}
			//System.out.println();
		}
	    
		scanner.close();
		return data;
	}
	
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
	{
		PrintWriter file = new PrintWriter(outputFile);
		String str = "";
		//Goes through each element of the array and adds it to the str String
		for (int i = 0; i < data.length; i++)
		{
			for (int j = 0; j < data[i].length; j++)
			{
				str += data[i][j] + " ";
			}
			str += "\n";
		}
		//str is printed to the file
		file.print(str);
		file.close();
	  }
}
