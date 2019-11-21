/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merge_sort_s;
import java.util.*;

/**
 *
 * @author Matheus VR
 */
public class Merge_sort_S {
        
 
	//static  int  vetor[]={100,20,15,30,5,75,40,10,25,111,1,43,89,0,2,3,21,53,46,101,112,134,156,200,201,4,19,300,400,401,403,459,500};

	public static void main(String args[])
	{
            
                int[] vetor = new int[10000];
                randomFill(vetor);
            
		long startTime = System.currentTimeMillis();
		System.out.println("=================ANTES==================");
		printVetor(vetor,0,vetor.length-1);
		System.out.println("========================================");
                mergeSort(0,vetor.length-1, vetor);
		System.out.println("=================DEPOIS=================");
 
		
		
		printVetor(vetor,0,vetor.length-1);
                System.out.println("========================================");
                long stopTime = System.currentTimeMillis();
                long elapsedTime = stopTime - startTime;
                System.out.println("tempo de execução: " + (float)elapsedTime/1000 + " secondos");
 
	}
        
        public static void printVetor(int arr[],int start,int end)
	{
		for (int i = start; i <=end; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
 
 
	private static void merge(int start, int mid, int end, int vetor[]) {
		
		int[] tempArray=new int[vetor.length];
		int tempArrayIndex=start;
 
		//printArray(vetor,start,end);
 
		int startIndex=start;
		int midIndex=mid+1;
 
		// Interando sob listas pequenas
		while(startIndex<=mid && midIndex<=end)
		{
			if(vetor[startIndex]< vetor[midIndex])
			{
				tempArray[tempArrayIndex++]=vetor[startIndex++];
			}
			else
			{
				tempArray[tempArrayIndex++]=vetor[midIndex++];
			}
		}
 
		// Copy remaining elements
		while(startIndex<=mid)
		{
			tempArray[tempArrayIndex++]=vetor[startIndex++];
		}
		while(midIndex<=end)
		{
			tempArray[tempArrayIndex++]=vetor[midIndex++];
		}
 
		// Copy tempArray to actual array after sorting 
		for (int i = start; i <=end; i++) {
			vetor[i]=tempArray[i];
		}
 
	
		
	}
        
        
        // Recursão :)
	public static void mergeSort(int start,int end, int vetor[])
	{
		int mid=(start+end)/2;
		if(start<end)
		{
                     mergeSort(start,mid, vetor);
                     mergeSort(mid+1,end, vetor);
                    	
                        // direita e esquerda
                     merge(start,mid,end, vetor);
		}
 
	}
        
        static void randomFill(int[] array)
        {
            Random rand = new Random();

            for(int i = 0; i < array.length ; i++){
                array[i] = rand.nextInt(1000);
            }
        }
        
 
}