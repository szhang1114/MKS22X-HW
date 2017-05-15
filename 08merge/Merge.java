import java.util.*;
public class Merge{
    
    public static void mergesort(int[] ary){
	if(ary.length == 1){
	}
	else{
	    int mid = ary.length / 2;
	    int aryIndex = 0;
	    int[]left = new int[mid];
	    for(int l = 0; l < mid; l ++){
		left[l] = ary[aryIndex];
		aryIndex++;
	    }
	    int[]right = new int[ary.length - mid];
	    for(int r = 0; aryIndex < ary.length; r ++){
		right[r] = ary[aryIndex];
		aryIndex ++;
	    }
	    mergesort(left);
	    mergesort(right);
	    merge(left, right, ary);
	}
    }
	
			      
    
    public static void merge(int[] a, int[] b, int[] destination){
	int i = 0;
	int j = 0;
	
	for(int d = 0; d < destination.length; d ++){
	    if(i < a.length && j < b.length){
		if(a[i] < b[j]){
		    destination[d] = a[i];
		    i ++;
		}
		else{
		    destination[d] = b[j];
		    j++;
		}
	    }
	}
	int dest = i + j;
	if(i == a.length){
	    for(; j < b.length ;){
		destination[dest] = b[j];
		dest++;
		j++;
	    }
	}
	else{

	    for(; i < a.length ;){
		destination[dest] = a[i];
		dest++;
		i++;
	    }
	}
    }

    public static String toString(int[] ary){
	String out = "[";
	for(int i = 0; i < ary.length; i ++){
	    out += ary[i] + " ";
	}
	return out += "]";
    }
    public static void main(String[] args) {
        int[] a = { 3,123,34,23,234,2341,123,12,3 };
        int[] b = { 0, 2, 4, 6, 8 };
        int[] destination = new int[a.length + b.length];
        mergesort(a);
        System.out.println(toString(a));
    }

}
