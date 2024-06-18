public class recursion {
    public static void decorder(int n){
        if(n==1){
            System.out.print(n);
            return;
        }
        System.out.println(n);
        decorder(n-1);

    }
    public static void incorder(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        incorder(n-1);
        System.out.println(n);
    }
  
    public static int factorial(int n){
        if(n==0){
            return 1;
        }
  // int fnm1 = factorial(n-1);
   int fn = n*factorial(n-1);
   return fn;
  
}
public static int sumofprim(int n){
    if(n==0){
        return 0;
    }
  //  int fnm1 = sumofprim(n-1);
   int fn = n+sumofprim(n-1);
    return fn;
}
public static int fabinacci(int n){
    if(n==0 || n==1){
        return n;
    }
  //  int fn1 = fabinacci(n-1);
   // int fn2 = fabinacci(n-2);
    int fn  = fabinacci(n-1)+ fabinacci(n-2); 
    return fn;
}
public static boolean issorted(int arr[], int i){
if(i == arr.length-1){
    return true;
}
if(arr[i]>arr[i+1]){
    return false;
}
return issorted(arr, i+1);
}
public static void occurance(int arr[],int key,int i){
    if(i == arr.length)
    {
        return;
    }
    if(arr[i] == key){
      System.out.println(i);  
    }
    occurance(arr,key,i+1);
}
public static int lastoccurance(int arr[],int key,int i){
    if(i == arr.length){
        return -1;
    }
    int v =lastoccurance(arr,key,i+1);
    if(arr[i] == key && v ==-1 ){
        return i;
    }
    return v;
}
public static int tilessum(int n){
    if(n==0 || n==1){
        return 1;
    }
    int ways = tilessum(n-1);
    int way = tilessum(n-2);
    return ways+way;
}
public static void duplicate(String str,int idx,StringBuilder newstr,boolean map[]){
    if(idx == str.length()){
        System.out.print(newstr);
        return;
    }
    char currchar = str.charAt(idx);
    if(map[currchar-'a']==true){
      duplicate(str,idx+1,newstr,map);
    }else{
        map[currchar-'a'] = true;
        duplicate(str,idx+1,newstr.append(currchar),map);
    }
}
public static void printbinstring(int n , int ln ,String str){
    if(n==0){
        System.out.println(str);
        return;
    }
    printbinstring(n-1,0,str+"0");
    if(ln==0){
         printbinstring(n-1,1,str+"1");     
    }

}


    
    public static void main(String args[]){
      int arr[] = {1,2,3,4,3,3,3,4,5,6};
      occurance(arr,3,0);
    }

}
