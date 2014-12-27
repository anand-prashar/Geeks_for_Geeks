package linkedLists;

public class ListMerge 
{
	public static void main(String[] args) 
	{
		ListMerge driver=new ListMerge();
		ListNode<Integer> root1= LinkedList.createOddList(4),
						  root2= LinkedList.createEvenList(8);
		
		LinkedList.PrintLinkedList(root1);
		LinkedList.PrintLinkedList(root2);
		driver.merge(root1, root2);
		
		System.out.println("\n\n");
		LinkedList.PrintLinkedList(root1);
		
	}

	//to merge 2 sorted lists
	void merge(ListNode<Integer> root1, ListNode<Integer> root2)
	{
		ListNode<Integer> r1_next=null, r2_next=null;
		while(root1!=null && root2!=null)
		{
			/*if(root1.getData()<root2.getData())
			{
				
			}*/
			r1_next=root1.getNext();
			if(r1_next != null && 
			   root1.getData()<=root2.getData() && root2.getData()< r1_next.getData())
			{
				r2_next=root2.getNext();
				root1.setNext(root2);
				root2.setNext(r1_next);
				
				root2=r2_next;
				root1=r1_next;
			}
			else
				root2=root2.getNext();
			
		}
		if(r2_next!=null)
			root1.setNext(r2_next);
	}
}
