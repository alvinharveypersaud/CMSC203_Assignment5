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

public class HolidayBonus
{
	//Constants for bonuses
	private static final double HIGHEST = 5000.0;
	private static final double LOWEST = 1000.0;
	private static final double MID = 2000.0;
	
	public static double[] calculateHolidayBonus(double[][] data)
	{	
		double[] bonuses = new double[data.length];
		
		//Checks to see the max number of columns in the ragged array
		int numColumns = data[0].length;
		for(int i = 0; i < data.length; i++)
		{
			if(numColumns < data[i].length)
			{
				numColumns = data[i].length;
			}
		}
		
		for (int col = 0;col < numColumns;col++)
		{
			//Gets the highest and lowest index for each column
			int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
			int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
			
			//The high bonus is added to the appropriate company if the highest is greater than 0
			if (TwoDimRaggedArrayUtility.getHighestInColumn(data, col) > 0)
			{  
				bonuses[highIndex] += HIGHEST;
			}
			
			//The low bonus is added to the appropriate company if the lowest is greater than 0 and doesnt have the same index as the high index
			if (TwoDimRaggedArrayUtility.getLowestInColumn(data, col) > 0 && highIndex != lowIndex )
			{
				bonuses[lowIndex] += LOWEST;
			}
			
			//Adds the middle bonus if the element isnt equal to the high index or low index, the column index is greater than the row's length, or if the element isnt less than or equal to 0
			for (int row = 0;row < data.length;row++)
			{
				if (row == highIndex || row == lowIndex || col >= data[row].length || data[row][col] <= 0)
				{
					continue;
				}
				else
				{
					bonuses[row] += MID;
				} 
			}
		}   
		return bonuses;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data)
	{
		double[] bonuses = calculateHolidayBonus(data);
		double total = 0.0;
		
		//Adds the bonuses from each company into one double value
		for(int i = 0; i < bonuses.length; i++)
		{
			total += bonuses[i];
			
		}
		return total;
	}
}
