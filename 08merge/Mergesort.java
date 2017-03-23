import java.util.*;
public class Mergesort{
    
    public static void mergesort(int[] ary){
	if(ary.length != 1){
	    int mid = ary.length / 2 - 1;
	    
	}
    } 
    
    public static void merge(int[] a, int[] b, int[] destination){
	int i = 0;
	int j = 0;
	for(int dest = 0; dest < destination.length; dest++){
	    if(a[i] < b[j]){
		destination[dest] = a[i];
	    }
	    else destination[dest] = b[i];
	}
    }
    
    public static String toString(int[] ary){
	String out = "[";
	for(int i = 0; i < ary.length; i ++){
	    out += ary[i] + ", ";
	}
	return out += "]";
    }
    public static void main(String[] args){
	int[] a = new int[10];
	int[] b = new int[10];
	int[] c = new int[20];
	for(int i = 0; i < 10; i ++){
	    System.out.println((int)(Math.random() * 100));
	    a[i] = ((int)(Math.random() * 100));
	    b[i] = ((int)(Math.random() * 100));
	}
	merge(a, b, c);
	System.out.println(toString(c));
    }
}
