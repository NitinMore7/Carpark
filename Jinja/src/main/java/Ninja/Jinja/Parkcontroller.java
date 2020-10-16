package Ninja.Jinja;

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
		
	@RequestMapping("/")
	public String hello() {
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
	return c.inp(num);
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
	
	synchronized String inp(int n) {
		for(int i=1;i<=n;i++)
		{
			if(counter[i%5]<10)
			{cars[i%5][counter[i%5]]=i;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			counter[i%5]++;}
			else
			return "Car Park Full";	
		}
		return "OK";
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