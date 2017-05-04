public class MyHeap{
    private ArrayList<String> myHeap;
    //private String size;
    private int constant;
    
    public MyHeap(){
	myHeap = new ArrayList<String>();
	constant = 1;
    }

    public MyHeap(boolean maxmin){
	if(maxmin){
	    MyHeap();
	}
	else {
	    myHeap = new ArrayList<String>();
	    constant = -1;
	}
    }

    public void add(String s){
	
    }

    public String remove(){
    }

    public String peek(){
	return ;
    }

    private void pushUp(int start){
	if((constant * myHeap.get(start).compareTo(myHeap.get(parent(start)))) > 0)
    }

    private void pushDown(){
    }
    
    private void swap(int cur, int dest){
        String temp = myHeap.get(cur);
	myHeap.set(cur, myHeap.get(dest));
	myHeap.set(dest, temp);
    }
    
    private int Rchild(int n){
	return 2 * n + 1;
    }

    private int Lchild(int n){
	return 2 * n;
    }

    private int parent(int n){
	return n / 2;
    }
