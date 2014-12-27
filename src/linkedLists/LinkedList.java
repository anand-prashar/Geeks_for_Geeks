package linkedLists;


public class LinkedList<T>
{
	
	
	public static ListNode<Integer> createIntegerList(Integer length)
	{
		ListNode<Integer> root=null;
		ListNode<Integer> temp, last = null;
		
		for(int i=1;i<=length;i++)
		{
			temp = new ListNode<Integer>();
			temp.setData(i);   // integer List
			
			if(root!=null && last!=null)
			{
				last.setNext(temp);	
				last=temp;
			}
			else
			{
				root=temp;
				last = root;
			}
		}
		return root;
	}
	
	//if wanting to give lowe and upper limit to list
	public static ListNode<Integer> createIntegerList(Integer low, Integer high)
	{
		ListNode<Integer> root=null;
		ListNode<Integer> temp, last = null;
		
		for(int i=low;i<=high;i++)
		{
			temp = new ListNode<Integer>();
			temp.setData(i);   // integer List
			
			if(root!=null && last!=null)
			{
				last.setNext(temp);	
				last=temp;
			}
			else
			{
				root=temp;
				last = root;
			}
		}
		return root;
	}
	

	// print, if user provides Root node
	
	@SuppressWarnings("rawtypes")
	public static void PrintLinkedList(ListNode temp)
	{
		while(temp!=null)
		{
			if(temp.getNext()!=null)
				System.out.print(temp.getData()+"->");
			else
				System.out.print(temp.getData());
			
			temp=temp.getNext();
		}
		System.out.println("\n");
			
	}
	
	//used in Q3..delete Coordinates Q...
	ListNode<Coordinate> listOfCoordinates()
	{
		ListNode<Coordinate> root=null, curr=null;
		
		curr=new ListNode<Coordinate>();
		curr.setData(new Coordinate(40,5));    // inserting in rev order.. to assist Linking
		curr.setNext(null);
		root=curr;
		
		curr=new ListNode<Coordinate>();
		curr.setData(new Coordinate(20,5));
		curr.setNext(root);
		root=curr;
		
		curr=new ListNode<Coordinate>();
		curr.setData(new Coordinate(7,5));
		curr.setNext(root);
		root=curr;
		
		curr=new ListNode<Coordinate>();
		curr.setData(new Coordinate(7,10));
		curr.setNext(root);
		root=curr;
		
		curr=new ListNode<Coordinate>();
		curr.setData(new Coordinate(5,10));
		curr.setNext(root);
		root=curr;
		
		curr=new ListNode<Coordinate>();
		curr.setData(new Coordinate(1,10));
		curr.setNext(root);
		root=curr;
		
		curr=new ListNode<Coordinate>();
		curr.setData(new Coordinate(0,10));
		curr.setNext(root);
		root=curr;
		
		return root;
		
	}
	
	
	// Return repititive data in List
	@SuppressWarnings("all")
	public static ListNode createRepititveList(int length, int repititveNo)
	{
		ListNode root=null;
		ListNode temp, last = null;
		
		for(int i=1; i<=length; i++)
		{
			temp = new ListNode();
			temp.setData(repititveNo);   // integer List
			
			if(root!=null && last!=null)
			{
				last.setNext(temp);	
				last=temp;
			}
			else
			{
				root=temp;
				last = root;
			}
		}
		return root;
	}

	public static ListNode<Integer> createEvenList(int limit)
	{
		ListNode<Integer> root=null;
		ListNode<Integer> temp, last = null;
		
		for(int i=2;i<=limit;i+=2)
		{
			temp = new ListNode<Integer>();
			temp.setData(i);   // integer List
			
			if(root!=null && last!=null)
			{
				last.setNext(temp);	
				last=temp;
			}
			else
			{
				root=temp;
				last = root;
			}
		}
		return root;
	}
	
	public static ListNode<Integer> createOddList(int limit)
	{
		ListNode<Integer> root=null;
		ListNode<Integer> temp, last = null;
		
		for(int i=1;i<=limit;i+=2)
		{
			temp = new ListNode<Integer>();
			temp.setData(i);   // integer List
			
			if(root!=null && last!=null)
			{
				last.setNext(temp);	
				last=temp;
			}
			else
			{
				root=temp;
				last = root;
			}
		}
		return root;
	}
	
	
	//q7 input.. to create list of 0, 1 & 2 - randomly placed.
	public static ListNode<Integer> create012List(Integer length)
	{
		ListNode<Integer> root=null;
		ListNode<Integer> temp, last = null;
		
		for(int i=1;i<=length;i++)
		{
			temp = new ListNode<Integer>();
			temp.setData(i%3);   // integer List
			
			if(root!=null && last!=null)
			{
				last.setNext(temp);	
				last=temp;
			}
			else
			{
				root=temp;
				last = root;
			}
		}
		return root;
	}
	
	
	//--- Create a double linked list (next & down)
	public static DoubleListNode createDoubleList() 
{
	
/*     5 -> 10 -> 19 -> 28
       |    |     |     |
       V    V     V     V
       7    20    22    35
       |          |     |
       V          V     V
       8          50    40
       |                |
       V                V
       30               45    */
	
	DoubleListNode t1,t2,t3,t4,root;
	//Column-1
	t1=new DoubleListNode(5); root=t1;
	t1.setDownNode(new DoubleListNode(7));
	
	t1=t1.getDownNode();
	//t1.setRightNode(new DoubleListNode(99));
	t1.setDownNode(new DoubleListNode(8));
	
	t1=t1.getDownNode();
	t1.setDownNode(new DoubleListNode(30));
	t1=t1.getDownNode();
	
	//column-2
	t2=new DoubleListNode(10); 
	root.setRightNode(t2);
	
	t2.setDownNode(new DoubleListNode(20));
	t2=t2.getDownNode();
	
	//column-3
	t3=new DoubleListNode(19);
	root.getRightNode().setRightNode(t3);
	
	t3.setDownNode(new DoubleListNode(22));
	t3=t3.getDownNode();
	t3.setDownNode(new DoubleListNode(50));
	t3=t3.getDownNode();
	
	//column-4
	t4=new DoubleListNode(28); 
	root.getRightNode().getRightNode().setRightNode(t4);
					
	t4.setDownNode(new DoubleListNode(35));
	t4=t4.getDownNode();
	t4.setDownNode(new DoubleListNode(40));
	t4=t4.getDownNode();
	t4.setDownNode(new DoubleListNode(45));
	t4=t4.getDownNode();
	
	return root;
	
}

//Print Original List generated by above method
public static void printCustomList(DoubleListNode root) 
{
	while(root!=null)
	{
		DoubleListNode itr=root;
		System.out.print("Column : ");
		while(itr.getDownNode()!=null)
		{
			System.out.print(itr.getData()+"->");
			itr=itr.getDownNode();
		}
		System.out.print(itr.getData()+"\n\n");
		root=root.getRightNode();
	}
}

//Print the list generated by above method
public static void Q8_printDoubleList(DoubleListNode root) 
{
	DoubleListNode itr=root;
		//System.out.print("Column : ");
		while(itr.getRightNode()!=null)
		{
			System.out.print(itr.getData()+"->");
			itr=itr.getRightNode();
		}
		System.out.print(itr.getData()+"\n\n");
	
}
}

