package linkedLists;

public class q06_ListAdditions 
{
	public static void main(String[] args) 
	{
		q06_ListAdditions driver=new q06_ListAdditions();
		driver.solution();
	}
	
	@SuppressWarnings("unchecked")
	private void solution() 
	{
		ListNode<Integer> root1=LinkedList.createRepititveList(5, 9);
		ListNode<Integer> root2=LinkedList.createRepititveList(3, 9);
		
		LinkedList.PrintLinkedList(root1);
		LinkedList.PrintLinkedList(root2);
		
		int length1=getLength(root1),
		    length2=getLength(root2), lastCarry;
		
		if(length1==length2)
		{
			lastCarry=addLists(root1, root2);
			if(lastCarry!=0)
			{
				ListNode<Integer> leftMost_NewNode= new ListNode<Integer>();
				leftMost_NewNode.setData( lastCarry );
				leftMost_NewNode.setNext(root1);
				LinkedList.PrintLinkedList(leftMost_NewNode);
			}
			else
				LinkedList.PrintLinkedList(root1);
			
		}
		else if(length1>length2)
		{
			ListNode<Integer> addPoint=findAdditionPoint(root1, length2, length1);
			lastCarry=addLists(addPoint.getNext(), root2);
			
			//cleanseListCarry (root1,addPoint) ; //comment: check issue for input (5 times, 3 times) '9'
			if(lastCarry!=0)
			   addPoint.setData(lastCarry + addPoint.getData() );
			
			LinkedList.PrintLinkedList( root1 );
		}
		else  //if len1 < len2
		{
			ListNode<Integer> addPoint=findAdditionPoint(root2, length1, length2);
			lastCarry= addLists(addPoint.getNext(), root1);
			
			if(lastCarry!=0)
				   addPoint.setData(lastCarry + addPoint.getData() );
			
			LinkedList.PrintLinkedList(root2);
		}
	}

	private int getLength(ListNode<Integer> root)
	{
		int length=0;
		
		while(root!=null)
		{
			root=root.getNext();
			length++;
		}
		return length;
	}
	
	private int addLists(ListNode<Integer> n1, ListNode<Integer> n2)
	{
		if(n1.getNext()!=null && n2.getNext()!=null )
		   n1.setData( (n1.getData()+n2.getData() + 
				        addLists(n1.getNext(), n2.getNext()))    // recursion will return Carry-ins
				     );
		else
			n1.setData( (n1.getData()+n2.getData() ) );
			
		if(n1.getData()/10 > 0)
		{
			int carry= n1.getData()/10;
			n1.setData(n1.getData()%10);
			return carry;
		}
		else
			return 0;
	}
	
	private ListNode<Integer> findAdditionPoint(ListNode<Integer> temp, int expectedLength, int currentLength)
	{
		while( (currentLength-1)>expectedLength ) // left most part will add carry somewhere in code
		{
			temp=temp.getNext();
			currentLength--;
		}
		return temp;
	}
	
/*	private void cleanseListCarry(ListNode<Integer> root, ListNode<Integer> temp)
	{
		if(root!=temp.getNext())
		{
			if(root.getData()/10 > 0)
			{
				Integer t=temp.getData()%10;
			}
		}
		}
	}*/
}
