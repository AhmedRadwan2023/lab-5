package eg.edu.alexu.csd.datastructure.stack;

import java.util.EmptyStackException;

public class stack implements IStack {
	public class Node {
		  public Object element;
		  public Node next = null;
		}
	private   Node top = null;
	private int size =0;
	
	public Object pop() {
		if(top==null) 
		{ throw new EmptyStackException();}
		else 
		{Object e = top.element;
		top=top.next;
		size --;
		return e ;
		}	
	}
	


    public Object peek() {
	
	if(top==null) { throw new EmptyStackException();}
	
	else {return top.element; }
	
    }

   public void push (Object element) {
	Node n = new Node();
	n.element=element;
	n.next=top;
	top=n;
	size++;
   }
   public boolean isEmpty() {
	   if(top==null) {
		   return true;
	   }
	   else {
		   return false;
	   }
   }
   
   public int size() {
	   return size;
   }

   
}