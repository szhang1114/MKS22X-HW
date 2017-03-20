public class Quick{

    public static int part(int[] data, int start, int end){
	int range = end - start + 1;
	int pivotIndex = (int)(Math.random() * range + start);
	int pivot = data[pivotIndex];
	System.out.println("pivot = " + pivot);
	swap(data, pivotIndex, start);
	int front = start + 1;
	
	for(int index = start + 1; index <= end; index ++){
	    //System.out.println(outString(data));
	    //System.out.println("front " + front );
	    if(data[index] < pivot){
		swap(data, front, index);
		//System.out.println(outString(data));
		front ++;
	    }
	}
	int finalPivotIndex = front - 1;
	swap(data, start, finalPivotIndex);
	return pivot;
    }
    private static void swap(int[] data, int oldIndex, int newIndex){
	int oldInt = data[oldIndex];
	data[oldIndex] = data[newIndex];
	data[newIndex] = oldInt;
    }
    public static String outString(int[] data){
	String out = "";
	for(int i = 0; i < data.length; i ++){
	    out += data[i] + " ";
	}
	return out;
    }
    public static void main(String[] args){
	int[] ary = {10, 5, 1, 6, 9, 7, 2, 8, 3, 0, 4};
	part(ary, 0, 10);
	System.out.println(outString(ary));
    }
}
