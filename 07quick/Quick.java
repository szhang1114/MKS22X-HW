import java.util.*;

public class Quick{
    //Dutch flag methods
    
    public static int[] part(int[] data, int start, int end){
	int index = (int)(Math.random() * (end - start + 1) + start);
	int v = data[index];
	swap(data, index, start);
	int i = start;
	int lt = start;
	int gt = end;	
	while(i <= gt){
	    if(data[i] < v){
		swap(data, i, lt);
		i ++;
		lt ++;
	    }
	    else if(data[i] > v){
		swap(data, i, gt);
		gt --;
	    }
	    else{
		i ++;
	    }
	}
	int[] boundaries = new int[2];
	boundaries[0] = lt;
	boundaries[1] = gt;
	return boundaries;
    }
    
    public static void quicksort(int[]ary){
	quickSortH(ary, 0, ary.length - 1);
    }

    private static void quickSortH(int[] ary, int start, int end){
	if(start < end){
	    int[] ltgt = part(ary, start, end);
	    int lt = ltgt[0];
	    int gt = ltgt[1];
	    quickSortH(ary, start, lt - 1);
	    quickSortH(ary, gt + 1, end);
	}
    }
    
    public static int quickselect(int[]ary, int k){
	return quickselectH(ary, k, 0, ary.length - 1);
    }

    public static int quickselectH(int[]ary, int k, int start, int end){
        int[] ltgt = part(ary, start, end);
	int lt = ltgt[0];
	int gt = ltgt[1];
	
	if(k < lt){
	    return quickselectH(ary, k, start, lt - 1);
	}
	else if(k > gt){
	    return quickselectH(ary, k, gt + 1, end);
	}
	else return ary[lt];
	
    }


    public static String toString(int[] ary){
	String out = "[";
	for(int i = 0; i < ary.length; i ++){
	    out += ary[i] + ",";
	}
	
	return out + "]";
    }
    
    private static void swap(int[] data, int oldIndex, int newIndex){
	int oldInt = data[oldIndex];
	data[oldIndex] = data[newIndex];
	data[newIndex] = oldInt;
    }
}
