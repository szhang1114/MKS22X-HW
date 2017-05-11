import java.util.*;

public class MyLinkedList implements Iterable<Integer>{
    private LNode head, tail;
    private int size;

    public MyLinkedList(){
	head = null;
	tail = null;
	size = 0;
    }

    public int size(){
	return size;
    }
    
    public void add(int index, int value){
	addAfter(getNthNode(index), new LNode(value));
    }

    public boolean add(int value){
        addAfter(tail, new LNode(value));
	return true;
    }

    public int remove(int index){
	int removed = get(index);
	remove(getNthNode(index));
	return removed;
    }

    public int indexOf(int value){
	int index = 0;
	LNode cur = head;
	while(index < size){
	    if(cur.value == value){
		return index;
	    }
	    else{
		cur = cur.next;
		index ++;
	    }
	}
	return -1;
    }

    public int set(int index, int value){
	int original = getNthNode(index).value;
	getNthNode(index).value = value;
	return original;
    }

    public int get(int index){
	return getNthNode(index).value;
    }

    private void remove(LNode target){	
	if(size == 1){
	    head = null;
	    tail = null;
	}
	else if(target == head){
	    head = target.next;
	    target.next.prev = null;
	}
	else if(target == tail){
	    tail = target.prev;
	    target.prev.next = null;
	}
	size --;
    }

    private void addAfter(LNode location, LNode toBeAdded){
	if(size == 0){
	    head = toBeAdded;
	    tail = toBeAdded;
	}
	else if(location == tail){
	    toBeAdded.prev = location;
	    location.next = toBeAdded;
	    tail = toBeAdded;
	}
	else{
	    toBeAdded.prev = location;
	    toBeAdded.next = location.next;
	    location.next.prev = toBeAdded;
	    location.next = toBeAdded;
	}
	size ++;	
    }

    private LNode getNthNode(int n){
        int index;
	LNode cur;
	if(n < size / 2){
	    cur = head;
	    index = 0;
	    while(index < n){
		cur = cur.next;
		index ++;
	    }
	}
	else{
	    cur = tail;
	    index = size - 1;
	    while(index > n){
		cur = cur.prev;
		index --;
	    }
	}
	return cur;
    }
		

    public String toString(){
	String out = "[ ";
	LNode cur = head;
	while(cur != null){
	    out += cur.value + ",";
	    cur = cur.next;
	}
	return out + "]";
    }

    public Iterator<Integer> iterator(){
	return new myIterator(this);
    }

    public class myIterator implements Iterator<Integer>{
	private LNode cur;
	private MyLinkedList list;

	public myIterator(MyLinkedList list){
	    this.list = list;
	    cur = list.head;
	}

	public boolean hasNext(){
	    return !(cur.next == null);
	}

	public Integer next(){
		int next =  cur.next.value;
		cur = cur.next;
		return next;
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
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
	    this.prev = prev;
	}
	public String toString(){
	    return value + "";
	}	
    }

}
  
