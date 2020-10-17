package Ninja.Jinja;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Parkcontroller {
	Carpark c=new Carpark();
	 ExecutorService executor = Executors.newFixedThreadPool(10);
		row0 r0;
		row1 r1;
		row2 r2;
		row3 r3;
		row4 r4;
		
		insert0 in0=new insert0(c);
		insert1 in1=new insert1(c);
		insert2 in2=new insert2(c);
		insert3 in3=new insert3(c);
		insert4 in4=new insert4(c);
		
	
		
		
	@RequestMapping("/")
	public String hello() {
		in0.start();
		in1.start();
		in2.start();
		in3.start();
		in4.start();
		return "Hello";
	}

	
	
	
	@RequestMapping("/fetchcar")
	public String fetch(@RequestParam int num) {
		int a=num%5;
		if(a==0)
			{r0=new row0(c,num);
			try {
			return executor.submit(r0).get();}catch(Exception e) {e.printStackTrace();}
			}
		else if(a==1)
			{r1=new row1(c,num);
			try {
			return executor.submit(r1).get();}catch(Exception e) {e.printStackTrace();}
			}
		else if(a==2)
			{r2=new row2(c,num);
			try {
			return executor.submit(r2).get();}catch(Exception e) {e.printStackTrace();}
			}
		else if(a==3)
			{r3=new row3(c,num);
			try {
			return executor.submit(r3).get();}catch(Exception e) {e.printStackTrace();}
			}
		else
			{r4=new row4(c,num);
			try {
			return executor.submit(r4).get();}catch(Exception e) {e.printStackTrace();}
			}
		
		return null;
	}
	
	

	
	
	@RequestMapping("/parkCars")
	public String park(@RequestParam int num) {

	if(c.inp(num)==0)
	return "Car Park Full";

	in0.run();
	in1.run();
	in2.run();
	in3.run();
	in4.run();

	try {
	in0.join();
	in1.join();
	in2.join();
	in3.join();
	in4.join();}catch(Exception e) {e.printStackTrace();}

	
	return "Ok";
	}
	
	
	
	@RequestMapping("/showCarParkStatus")
	public  int[][] lis()
	{
		return c.cars;
	}
	


}
	

class Carpark{
	int cars[][]=new int [5][10];
	int temp[][]=new int [5][10];
	int counter[] = new int[5];
	int yet_add[]=new int[5];
	
	
	Queue<Integer> buffer0=new LinkedList<>();
	Queue<Integer> buffer1=new LinkedList<>();
	Queue<Integer> buffer2=new LinkedList<>();
	Queue<Integer> buffer3=new LinkedList<>();
	Queue<Integer> buffer4=new LinkedList<>();
	
	
	
	
	synchronized int inp(int n) {
		
		for(int i=1;i<=n;i++)
		{
			if(i%5==0 && (counter[i%5]+yet_add[i%5])<10)
				{buffer0.add(i);
				yet_add[i%5]++;
				}
			else if(i%5==1 && (counter[i%5]+yet_add[i%5])<10)
				{buffer1.add(i);yet_add[i%5]++;				}
			else if(i%5==2 && (counter[i%5]+yet_add[i%5])<10)
				{buffer2.add(i);yet_add[i%5]++;}
			else if(i%5==3 &&(counter[i%5]+yet_add[i%5])<10)
				{buffer3.add(i);yet_add[i%5]++;}
			else if (i%5==4 && (counter[i%5]+yet_add[i%5])<10)
				{buffer4.add(i);yet_add[i%5]++;}
			else
				return 0;
		}
		return 1;
	}
	
	synchronized String row0(int a) {
		int t=0;
		for(int i=0;i<10;i++)
			{if(cars[t][i]==a)
				{
				cars[t][i++]=0;
				int k=0;
				for(int j=0;j<10;j++)
				{
					if(cars[t][(j+i)%10]!=0)
					temp[t][k++]=cars[t][(j+i)%10];
				}
				
				for(int j=0;j<10;j++)
				{
					if(j<k)
					cars[t][j]=temp[t][j];
					else
						cars[t][j]=0;
				}
				return "found in 0";
				}
			}
		return "Car not found";
		
	}
	
	
	synchronized String row1(int a) {
		int t=1;
		for(int i=0;i<10;i++)
			{if(cars[t][i]==a)
				{
				cars[t][i++]=0;
				int k=0;
				for(int j=0;j<10;j++)
				{
					if(cars[t][(j+i)%10]!=0)
					temp[t][k++]=cars[t][(j+i)%10];
				}
				
				for(int j=0;j<10;j++)
				{
					if(j<k)
					cars[t][j]=temp[t][j];
					else
						cars[t][j]=0;
				}
				return "found in 1";
				}
			}
		return "Car not found";
		
	}
	
	
	synchronized String row2(int a) {
		int t=2;
		for(int i=0;i<10;i++)
			{if(cars[t][i]==a)
				{
				cars[t][i++]=0;
				int k=0;
				for(int j=0;j<10;j++)
				{
					if(cars[t][(j+i)%10]!=0)
					temp[t][k++]=cars[t][(j+i)%10];
				}
				
				for(int j=0;j<10;j++)
				{
					if(j<k)
					cars[t][j]=temp[t][j];
					else
						cars[t][j]=0;
				}
				return "found in 0";
				}
			}
		return "Car not found";
		
	}
	
	
	synchronized String row3(int a) {
		int t=3;
		for(int i=0;i<10;i++)
			{if(cars[t][i]==a)
				{
				cars[t][i++]=0;
				int k=0;
				for(int j=0;j<10;j++)
				{
					if(cars[t][(j+i)%10]!=0)
					temp[t][k++]=cars[t][(j+i)%10];
				}
				
				for(int j=0;j<10;j++)
				{
					if(j<k)
					cars[t][j]=temp[t][j];
					else
						cars[t][j]=0;
				}
				return "found in 0";
				}
			}
		return "Car not found";
		
	}
	
	
	synchronized String row4(int a) {
		int t=4;
		for(int i=0;i<10;i++)
			{if(cars[t][i]==a)
				{
				cars[t][i++]=0;
				int k=0;
				for(int j=0;j<10;j++)
				{
					if(cars[t][(j+i)%10]!=0)
					temp[t][k++]=cars[t][(j+i)%10];
				}
				
				for(int j=0;j<10;j++)
				{
					if(j<k)
					cars[t][j]=temp[t][j];
					else
						cars[t][j]=0;
				}
				return "found in 0";
				}
			}
		return "Car not found";
		
	}
	
}


 class insert0 extends Thread{
	Carpark c;
	insert0(Carpark c){
		this.c=c;
	}
	synchronized public void run() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(!c.buffer0.isEmpty()) {
		c.cars[0][c.counter[0]++]=c.buffer0.peek();
		c.buffer0.remove();
		c.yet_add[0]--;}
	}
}



class insert1 extends Thread{
	Carpark c;
	insert1(Carpark c){
		this.c=c;
	}
	synchronized public void run() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(!c.buffer1.isEmpty()) {
		c.cars[1][c.counter[1]++]=c.buffer1.peek();
		c.buffer1.remove();
		c.yet_add[1]--;}
	}
}


class insert2 extends Thread{
	Carpark c;
	insert2(Carpark c){
		this.c=c;
	}
	synchronized public void run() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(!c.buffer2.isEmpty()) {
		c.cars[2][c.counter[2]++]=c.buffer2.peek();
		c.buffer2.remove();
		c.yet_add[2]--;}
	}
}


class insert3 extends Thread{
	Carpark c;
	insert3(Carpark c){
		this.c=c;
	}
	synchronized public void run() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(!c.buffer3.isEmpty()) {
		c.cars[3][c.counter[3]++]=c.buffer3.peek();
		c.buffer3.remove();
		c.yet_add[3]--;}
	}
}


class insert4 extends Thread{
	Carpark c;
	insert4(Carpark c){
		this.c=c;
	}
	synchronized public void run() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(!c.buffer4.isEmpty()) {
		c.cars[4][c.counter[4]++]=c.buffer4.peek();
		c.buffer4.remove();
		c.yet_add[4]--;}
	}
}

/*******************************************/
/*******************************************/
/*******************************************/
/*******************************************/
/*******************************************//*******************************************/
/*******************************************//*******************************************/




class row0 implements Callable<String>{
	Carpark c;
	int a;
	row0(Carpark c,int a)
	{
		this.c=c;
		this.a=a;
	}
	public String call() {
		
		
		try {
			String d= c.row0(a);
			Thread.sleep(3000);
			System.out.println(d);
			return d;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

class row1 implements Callable<String>{
	Carpark c;
	int a;
	row1(Carpark c,int a)
	{
		this.c=c;
		this.a=a;
	}
	public String call() {
		
		
		try {
			String d= c.row1(a);
			Thread.sleep(3000);
			System.out.println(d);
			return d;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}


class row2 implements Callable<String>{
	Carpark c;
	int a;
	row2(Carpark c,int a)
	{
		this.c=c;
		this.a=a;
	}
	public String call() {
		
		
		try {
			String d= c.row2(a);
			Thread.sleep(3000);
			System.out.println(d);
			return d;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}


class row3 implements Callable<String>{
	Carpark c;
	int a;
	row3(Carpark c,int a)
	{
		this.c=c;
		this.a=a;
	}
	public String call() {
		
		
		try {
			String d= c.row3(a);
			Thread.sleep(3000);
			System.out.println(d);
			return d;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

class row4 implements Callable<String>{
	Carpark c;
	int a;
	row4(Carpark c,int a)
	{
		this.c=c;
		this.a=a;
	}
	public String call() {
		
		
		try {
			String d= c.row4(a);
			Thread.sleep(3000);
			System.out.println(d);
			return d;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}