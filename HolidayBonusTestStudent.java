package HolidayBonus;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestStudent{
	
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

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateHolidayBonusA()
	{
		double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
		assertEquals(3000.0,result[0],.001);
		assertEquals(4000.0,result[1],.001);
		assertEquals(15000.0,result[2],.001);
		
		result = HolidayBonus.calculateHolidayBonus(dataSet2);
		assertEquals(13000.0,result[0],.001);
		assertEquals(6000.0,result[1],.001);
		assertEquals(5000.0,result[2],.001);
		assertEquals(8000.0,result[3],.001);
		
		result = HolidayBonus.calculateHolidayBonus(dataSet3);
		assertEquals(13000.0,result[0],.001);
		assertEquals(11000.0,result[1],.001);
		assertEquals(10000.0,result[2],.001);
		assertEquals(5000.0,result[3],.001);
		
		result = HolidayBonus.calculateHolidayBonus(dataSet4);
		assertEquals(6000.0,result[0],.001);
		assertEquals(5000.0,result[1],.001);
		assertEquals(0,result[2],.001);
		assertEquals(2000.0,result[3],.001);
	}
		
	@Test
	public void testCalculateTotalHolidayBonusA()
	{
		assertEquals(22000.0,HolidayBonus.calculateTotalHolidayBonus(dataSet1),.001);
		assertEquals(32000.0,HolidayBonus.calculateTotalHolidayBonus(dataSet2),.001);
		assertEquals(39000.0,HolidayBonus.calculateTotalHolidayBonus(dataSet3),.001);
		assertEquals(13000.0,HolidayBonus.calculateTotalHolidayBonus(dataSet4),.001);

	}
}