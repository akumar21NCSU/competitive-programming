package string;

import java.util.*;
public class Qsort2 {
       
  static void quickSort(int[] ar,int l, int h) {
      
	  if(l>=h)
		  return;
	  
      int p = partition(ar,l,h);
	  quickSort(ar,l,p-1);
	  quickSort(ar,p+1,h);
	  printAr(ar,l,h);
  }   
  
  /*public static void swap(int[]ar, int p, int i){
	  int temp = ar[p];
	  ar[p]= ar[i];
	  ar[i] = temp;
  }
  */
  static int partition(int[]ar, int l, int h){
	  
	  int pelement = ar[l];
	 
	  LinkedList bList = new LinkedList();
	  LinkedList sList = new LinkedList();
	  
	  for(int i=l+1;i<=h;i++){
		  if(ar[i] <= pelement)
			  sList.push(ar[i]);
		  else
			  bList.push(ar[i]);
	  }
	  //System.out.println("Sizes are "+ sList.size() +"  "+ bList.size());
	  
	  int sSize = sList.size();
	  int bSize = bList.size();
	  
	  for(int i=0;i<sSize;i++)
		  ar[l+i] = (int)sList.removeLast();
	  
	  ar[l+sSize]= pelement;
	  
	  for(int i=0;i<bSize;i++)
		  ar[l+sSize+1 + i] = (int)bList.removeLast();
	  
	  //System.out.println("printing -- "+pelement);
	  
	  //printAr(ar,l,h);
	  return l+sSize;
  }
  public static void printAr(int ar[],int l,int h){
	  for(int i=l;i<=h;i++)
		  System.out.print(ar[i]+ " ");
	  System.out.println();
  }
 
 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           quickSort(ar,0,n-1);
       }    
   }
