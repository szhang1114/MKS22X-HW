public class MyLinkedList{
    private LNode start;
    private LNode end;
    private int size;

    public MyLinkedList(){
    }

    public void add(int value, int index){
	if(size == 0){
	    start = new LNode(value);
	    end = start;
	}
	else{
	    LNode temp = new LNode(value);
	    end.next = temp;
	    end = temp;	    
	}

	size++;
    }

    public boolean add(int value){
	add(value, size);
	return true;
    }

    private void addAfter(LNode location, LNode toBeAdded){
    }
    
    private void remove(LNode target){
    }

    public int indexOf(int value){
    }

    public int remove
    public int size(){
	return size;
    }


    public int get(int index){
	return 
    }

    public int set(int index, int newValue){

    }

    public String toString(){
	return "";
    }

    private class LNode{
	int value;
	LNode next;
	LNode prev;

	public LNode(int value){
	    this.value = value;
	}
	
	public LNode(int value, LNode next, LNode prev){
	    this.value = value;
	    this.next = next;
	    this.previous = prev;
	}
	public String toString(){
	    return value + "";
	}
	
    }
}
