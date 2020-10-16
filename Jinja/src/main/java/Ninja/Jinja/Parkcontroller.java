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
		row0 r;
	@RequestMapping("/")
	public String hello() {
		return "Hello";
	}

	
	
	
	@RequestMapping("/fetchcar")
	public String fetch(@RequestParam int num) {
		int a=num%5;
		if(a==0)
			{r=new row0(c,num);
			try {
			return executor.submit(r).get();}catch(Exception e) {e.printStackTrace();}
			}
		
		
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
			counter[i%5]++;}
			else
			return "Car Park Full";	
		}
		return "OK";
	}
	
	synchronized String row0(int a) {
		for(int i=0;i<10;i++)
			{if(cars[0][i]==a)
				{
				cars[0][i++]=0;
				int k=0;
				for(int j=i;j<10;j++)
				{
					temp[0][k++]=cars[0][j];
				}
				for(int j=0;j<i;j++)
				{
					temp[0][k++]=cars[0][j];
				}
				int j;
				for(j=0;j<10;j++)
				{
					cars[0][j]=temp[0][j];
				}
				counter[0]=j;
				return "found in 0";
				}}
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
			Thread.sleep(5000);
			System.out.println(d);
			return d;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}