package Ninja.Jinja;
import  static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ParkcontrollerTest {
	Parkcontroller park=new Parkcontroller();
@Test
void test(){
	

	String expected="Hello";
	String actual = park.hello();
	assertEquals(expected,actual);
}
	
@Test
void test1(){
	
	
	String expected=park.park(20);
	String actual = "Ok";
	assertEquals(expected,actual);
}

@Test
void test2(){
	

	int expected[][]= {{20,5,10,0,0,0,0,0,0,0},{1,6,11,16,0,0,0,0,0,0},{2,7,12,17,0,0,0,0,0,0},
	          {3,8,13,18,0,0,0,0,0,0},{4,9,14,19,0,0,0,0,0,0}};
	park.park(20);
	park.fetch(15);
	int actual[][]=park.c.cars;
	assertEquals(10,actual[0][2]);
}


@Test
void test3() {
	park.park(30);
	
	park.fetch(6);
	park.fetch(2);
	park.fetch(3);
	int actual[][]=park.c.cars;
	assertEquals(11,actual[1][0]);
	assertEquals(7,actual[2][0]);
	assertEquals(8,actual[3][0]);
	
}
}
