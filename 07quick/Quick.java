public class Quick{

    public static int part(int[] data, int start, int end){
	int range = end - start + 1;
	int pivotIndex = (int)(Math.random() * range + start);
	int pivot = data[pivotIndex];
	

	int finalPivotIndex = 0;
	return pivot;
    }
    private static void swap(int[] data, int oldIndex, int newIndex){
	int oldInt = data[oldIndex];
	data[oldIndex] = data[newIndex];
	data[newIndex] = oldInt;
    }
    public String toString(int[] data){
	String out = "";
	for(int i = 0; i < data.length(); i ++){
	    out += data[i] + " ";
	}
	return out;
    }
    public static void main(String[] args){
	int[] ary = {10, 5, 1, 6, 9, 7, 2, 8, 3, 0, 4};
	for(int i = 0; i < 10; i ++){
	    System.out.print(part(ary, 0, 10));
	    System.out.println("");
	}
    }
}
