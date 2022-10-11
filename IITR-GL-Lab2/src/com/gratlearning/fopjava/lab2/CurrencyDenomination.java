package com.gratlearning.fopjava.lab2;
import java.util.Scanner;

public class CurrencyDenomination {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Takes the no of currency denominations 
		System.out.println("Enter the size of currency denominations:");
		int size = sc.nextInt();
		
		//Array to store the currency denominations
		int curr_denom[] = new int[size];
		
		//Takes all the currency denominations and stores it in array
		System.out.println("Enter the currency denominations value:");
		for(int i=0; i<size; i++) {
			curr_denom[i] = sc.nextInt();
		}
		
		//The total amount that is to be paid
		System.out.println("Enter the amount you want to pay:");
		int amount_payable = sc.nextInt();
		
		//Sorts the array in descending order
		sortArray(curr_denom, 0, size-1);
		
		//Traversing through the currency denominations to make exact payment 
		for(int i=0; i<size; i++ ) {
			int sum=0;
			
			if(amount_payable-curr_denom[i] >= curr_denom[i]) {
				while(amount_payable >= curr_denom[i]) {
					amount_payable = amount_payable-curr_denom[i];
					sum += 1;
				}
			}
			
			else if(amount_payable>=curr_denom[i]) {
				amount_payable = amount_payable-curr_denom[i];
				sum += 1;
			}
			
			if(sum>0) {
				System.out.println(curr_denom[i]+" : "+sum);
			}
		}
		sc.close();
	}

	public static void sortArray(int curr_denom[], int left, int right) {
		if(left<right) {
			int mid = left+(right-left)/2;
			sortArray(curr_denom, left, mid);
			sortArray(curr_denom, mid+1, right);
			mergeArray(curr_denom, left, mid, right);
		}
	}

	public static void mergeArray(int curr_denom[], int left, int mid, int right) {
		int n_left = mid-left+1;
		int n_right = right-mid;

		int[] left_arr = new int[n_left];
		int[] right_arr = new int[n_right];

		for(int i=0; i<n_left; i++) {
			left_arr[i] = curr_denom[left+i];
		}
		for(int j=0; j<n_right; j++) {
			right_arr[j] = curr_denom[mid+1+j];
		}

		int i=0, j=0, k=left;
		while(i<n_left && j<n_right) {
			if(left_arr[i] >= right_arr[j]) {
				curr_denom[k] = left_arr[i];
				i++;
			}
			else {
				curr_denom[k] = right_arr[j];
				j++;
			}
			k++;
		}

		while(i<n_left) {
			curr_denom[k] = left_arr[i];
			i++;
			k++;
		}

		while(j<n_right) {
			curr_denom[k] = right_arr[j];
			j++;
			k++;
		}
	}

}
