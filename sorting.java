import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class sorting{

    public static void sorting(int arr[]){
         int swap =0;
        for(int turn=0;turn<arr.length-1;turn++){
            for(int j =0;j<arr.length-1-turn;j++){
               
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1]= temp;
                  
                 
                    
                }
               // swap++;
                //  System.out.println(j);

            }

        }
     //   System.out.print(swap);
    }

    public static void selectionsort(int mark[]){
        for(int i=0;i<mark.length-1;i++){
            int min=i;
            for(int j=i+1;j<mark.length;j++){
                if(mark[min]<mark[j]){
                    min=j;
                }
            }
           int temp= mark[min];
            mark[min] = mark[i];
            mark[i] = temp;

            

        }
    }
 public static void printarr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }   
    }
public static void insertionsort(int mark[]){
    for(int i=1;i<mark.length;i++){
        int curr = mark[i];
        int prev = i-1;
        while(prev >=0 && mark[prev]>curr){
            mark[prev+1] = mark[prev] ;
            prev--;
        }
        mark[prev+1] = curr; 
    }

}

public static void countingsort(int mark[]){
    int largest = Integer.MIN_VALUE;
    for(int i=0;i<mark.length;i++){
        largest = Math.max(largest,mark[i]);
    }
     int count[] = new int[largest+1];
    for(int i=0;i<mark.length;i++){
        count[mark[i]]++;
    }
    int j =0;
    for(int i=1;i<count.length;i++){
        while(count[i]>0){
        mark[j] = i;
        j++;

        count[i]--;
        }
    }

}

public static void merge(int arr[],int si,int end){
    if(si >= end){
        return;
    }
    int mid = si+(end-si)/2;
    merge(arr,si,mid);
    merge(arr,mid+1,end);
    mergesort(arr,si,mid,end);
}
    public static void mergesort(int arr[],int si,int mid,int end){ 
    int temp[] = new int[end-si+1];
    int i = si;
    int j = mid+1 ;
    int k =0;
    while(i<= mid && j<=end){
        if(arr[i]<arr[j]){
           temp[k] = arr[i];
            i++;
        }else{
           temp[k] = arr[j];
            j++;
        }
        k++;
    }
        //FOR LEFTOVER ELEMENT OF 1ST PART
         while(i<=mid){
            temp[k++] = arr[i++];
         }
         //FOR LEFTOVER ELEMENT OF SECOND PART
         while(j<=end){
            temp[k++] = arr[j++];
         }
//copy temp to orignal aRRAY
       for(k=0, i=si;k<temp.length; k++, i++){
        arr[i] = temp[k];
       }
    
}
public static void quick(int arr[],int si,int end){
    if(si>=end){
        return;
    }
    int pivt = quicksort(arr,si,end);
    quick(arr,si,pivt-1);
    quick(arr,pivt+1,end);
} 
public static int  quicksort(int arr[],int si,int end){
    int pivot = arr[end];
    int i = si-1;
    for(int j=si;j<end;j++){
        if(arr[j]<=pivot){
           i++;
           int temp = arr[j];
           arr[j] = arr[i];
           arr[i] = temp;
        }  
    }
    i++;
    int temp = pivot;
    arr[end] = arr[i];
    arr[i] = temp;
    return i;
}
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

    int arr[] = {4,5,3,1,2};
  //  Arrays.sort(arr,Collections.reverseOrder());
   // Arrays.sort(arr,0,4);
  quick(arr,0,arr.length-1);
  printarr(arr);
    }
}