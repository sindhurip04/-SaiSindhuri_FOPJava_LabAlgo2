package com.gratlearning.fopjava.lab2;
import java.util.Scanner;

public class Transcation {
	public static void main(String args[]) throws Exception {
		Scanner s = new Scanner(System.in);
		
		//Takes the number of transactions that are done
		System.out.println("enter the size of transaction array");
		int size = s.nextInt();
		
		//Array to store all the transactions
		int arr[] = new int[size];
		
		//Takes all the transactions and stores it in array
		System.out.println("enter the values of array");
		for (int i = 0; i < size; i++)
			arr[i] = s.nextInt();
		
		//Target number of transactions that needs to done
		System.out.println("enter the total no of targets that needs to be achieved");
		int targetNo = s.nextInt();
		
		while (targetNo-- != 0) {
			int flag = 0;
			long target;
			
			//Total target 
			System.out.println("enter the value of target");
			target = s.nextInt();
			long sum = 0;
			for (int i = 0; i < size; i++) {
				sum += arr[i];
				if (sum >= target) {
					System.out.println("Target achieved after "+(i + 1) + " transactions ");
							flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println(" Given target is not achieved ");
			}
		}
		s.close();
	}
	
}
