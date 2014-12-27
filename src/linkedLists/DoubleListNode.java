package linkedLists;

public class DoubleListNode 
{
	private DoubleListNode rightNode=null,
						   downNode =null;	
	private int data;
	
	
	
	public DoubleListNode getRightNode() {
		return rightNode;
	}
	public void setRightNode(DoubleListNode rightNode) {
		this.rightNode = rightNode;
	}
	public DoubleListNode getDownNode() {
		return downNode;
	}
	public void setDownNode(DoubleListNode downNode) {
		this.downNode = downNode;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	DoubleListNode(int data)
	{
		this.data=data;
	}
	
}