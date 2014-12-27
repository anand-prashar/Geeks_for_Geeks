package linkedLists;

@SuppressWarnings("all")

public class ListNode<T> 
{
	private ListNode Next=null, Prev=null;
	private T  data;
	
	public ListNode(T data) {
		super();
		this.data = data;
	}
	public ListNode() { super(); }
	
	public ListNode<T>  getNext() {
		return Next;
	}
	public void setNext(ListNode Next) {
		this.Next = Next;
	}
	public ListNode<T>  getPrev() {
		return Prev;
	}
	public void setPrev(ListNode Prev) {
		this.Prev = Prev;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
		
}
