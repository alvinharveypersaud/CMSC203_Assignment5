package HolidayBonus;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent
{
	private double[][] dataSet1 = 	{{10,20,30},
			 						 {40,50},
			 						 {60,70,80}};

	private double[][] dataSet2 = 	{{8,2,9,4},
			 						 {7,3,4},
			 						 {12},
			 						 {3,9,1,1}};

	private double[][] dataSet3 = 	{{1,6,12,3},
			 						 {5,0,9,2,5},
			 						 {11,8},
			 						 {2,7,1,0}};

	private double[][] dataSet4 = 	{{-1,3,7},
			 						 {-2,11},
			 						 {-9},
			 						 {-5,7,0,-2}};
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception
	{
		outputFile = new File("outputFile.txt");
	}

	@After
	public void tearDown() throws Exception
	{
		dataSet1 = null;
		dataSet2 = null;
		dataSet3 = null;
		dataSet4 = null;
		inputFile = null;
		outputFile = null;
	}

	@Test
	public void testGetTotal()
	{
		assertEquals(360.0,TwoDimRaggedArrayUtility.getTotal(dataSet1),.001);
		assertEquals(63.0,TwoDimRaggedArrayUtility.getTotal(dataSet2),.001);
		assertEquals(72.0,TwoDimRaggedArrayUtility.getTotal(dataSet3),.001);
		assertEquals(9.0,TwoDimRaggedArrayUtility.getTotal(dataSet4),.001);
	}

	@Test
	public void testGetAverage()
	{
		assertEquals(45.0,TwoDimRaggedArrayUtility.getAverage(dataSet1),.001);
		assertEquals(5.25,TwoDimRaggedArrayUtility.getAverage(dataSet2),.001);
		assertEquals(4.8,TwoDimRaggedArrayUtility.getAverage(dataSet3),.001);
		assertEquals(0.9,TwoDimRaggedArrayUtility.getAverage(dataSet4),.001);
	}

	@Test
	public void testGetRowTotal()
	{
		
		assertEquals(90.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet1,1),.001);
		assertEquals(23.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet2,0),.001);
		assertEquals(10.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet3,3),.001);
		assertEquals(-9.0,TwoDimRaggedArrayUtility.getRowTotal(dataSet4,2),.001);
	}
	
	@Test
	public void testGetColumnTotal()
	{
		assertEquals(110.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet1,0),.001);
		assertEquals(14.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet2,2),.001);
		assertEquals(21.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet3,1),.001);
		assertEquals(-17.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet4,0),.001);
		assertEquals(21.0,TwoDimRaggedArrayUtility.getColumnTotal(dataSet4,1),.001);
	}
	
	@Test
	public void testGetHighestInRow()
	{
		assertEquals(30.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet1,0),.001);
		assertEquals(12.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet2,2),.001);
		assertEquals(9.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet3,1),.001);
		assertEquals(7.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet4,0),.001);
		assertEquals(11.0,TwoDimRaggedArrayUtility.getHighestInRow(dataSet4,1),.001);
	}

	@Test
	public void testGetHighestInRowIndex()
	{
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1,0));
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet2,2));
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet3,1));
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet4,0));
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet4,1));
	}
	
	@Test
	public void testGetLowestInRowIndex()
	{
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1,0));
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet2,2));
		assertEquals(1,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet3,1));
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet4,0));
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet4,1));
	}
	
	@Test
	public void testGetLowestInRow()
	{
		assertEquals(60.0,TwoDimRaggedArrayUtility.getLowestInRow(dataSet1,2),.001);
		assertEquals(3.0,TwoDimRaggedArrayUtility.getLowestInRow(dataSet2,1),.001);
		assertEquals(1.0,TwoDimRaggedArrayUtility.getLowestInRow(dataSet3,0),.001);
		assertEquals(-2.0,TwoDimRaggedArrayUtility.getLowestInRow(dataSet4,1),.001);
		assertEquals(-9.0,TwoDimRaggedArrayUtility.getLowestInRow(dataSet4,2),.001);
	}
	
	@Test
	public void testGetHighestInColumn()
	{
		assertEquals(80.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1,2),.001);
		assertEquals(9.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet2,1),.001);
		assertEquals(11.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet3,0),.001);
		assertEquals(11.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet4,1),.001);
		assertEquals(7.0,TwoDimRaggedArrayUtility.getHighestInColumn(dataSet4,2),.001);
	}

	@Test
	public void testGetHighestInColumnIndex()
	{
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1,2));
		assertEquals(3,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet2,1));
		assertEquals(2,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet3,0));
		assertEquals(1,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet4,1));
		assertEquals(0,TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet4,2));
	}

	@Test
	public void testGetLowestInColumn()
	{
		assertEquals(20.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1,1),.001);
		assertEquals(1.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet2,2),.001);
		assertEquals(1.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet3,0),.001);
		assertEquals(-9.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet4,0),.001);
		assertEquals(3.0,TwoDimRaggedArrayUtility.getLowestInColumn(dataSet4,1),.001);
	}

	@Test
	public void testGetLowestInColumnIndex()
	{
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1,1));
		assertEquals(3,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet2,2));
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet3,0));
		assertEquals(2,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet4,0));
		assertEquals(0,TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet4,1));
	}
	
	@Test
	public void testGetHighestInArray()
	{
		assertEquals(80.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet1),.001);
		assertEquals(12.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet2),.001);
		assertEquals(12.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet3),.001);
		assertEquals(11.0,TwoDimRaggedArrayUtility.getHighestInArray(dataSet4),.001);
	}
	
	@Test
	public void testGetLowestInArray()
	{
		assertEquals(10.0,TwoDimRaggedArrayUtility.getLowestInArray(dataSet1),.001);
		assertEquals(1.0,TwoDimRaggedArrayUtility.getLowestInArray(dataSet2),.001);
		assertEquals(0.0,TwoDimRaggedArrayUtility.getLowestInArray(dataSet3),.001);
		assertEquals(-9.0,TwoDimRaggedArrayUtility.getLowestInArray(dataSet4),.001);
	}
	
	@Test
	public void testWriteToFile()
	{
		double[][] arr;
		try
		{
			TwoDimRaggedArrayUtility.writeToFile(dataSet1, outputFile);
		}
		catch (Exception e)
		{
			fail("fail");
		}	
		 try
		 {
			arr = TwoDimRaggedArrayUtility.readFile(outputFile);
			assertEquals(10, arr[0][0],.001);
			assertEquals(20, arr[0][1],.001);
			assertEquals(30, arr[0][2],.001);
			assertEquals(40, arr[1][0],.001);
			assertEquals(50, arr[1][1],.001);
			assertEquals(60, arr[2][0],.001);
			assertEquals(70, arr[2][1],.001);
			assertEquals(80, arr[2][2],.001);
		}
		catch (FileNotFoundException e)
		{
			fail("fail");
		}	
		
	}
	
	@Test
	public void testReadFile()
	{
		double[][] arr;
		try
		{
			inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.print("10 -20 30\n-40 50\n-60 70\n-80 90");
			inFile.close();
			arr = TwoDimRaggedArrayUtility.readFile(inputFile);
			assertEquals(10, arr[0][0],.001);
			assertEquals(-20, arr[0][1],.001);
			assertEquals(30, arr[0][2],.001);
			assertEquals(-40, arr[1][0],.001);
			assertEquals(50, arr[1][1],.001);
			assertEquals(-60, arr[2][0],.001);
			assertEquals(70, arr[2][1],.001);
			assertEquals(-80, arr[3][0],.001);
			assertEquals(90, arr[3][1],.001);

		}
		catch (FileNotFoundException e)
		{
			fail("FileNotFoundException");
		}
	}
	
	
}