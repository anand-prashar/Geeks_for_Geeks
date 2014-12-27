package linkedLists;

public class q10_RotateList 
{
	public static void main(String[] args) 
	{
		ListNode<Integer> root = LinkedList.createIntegerList(8, 13);
		LinkedList.PrintLinkedList(root);
		
		root=rotateListbyKnode(root, 9);  // Pass K here
		LinkedList.PrintLinkedList(root);
		

	}

	private static ListNode<Integer> rotateListbyKnode(ListNode<Integer> root, Integer i) 
	{
		ListNode<Integer> temp=root, breakingPoint=null;
		if(i<=0) return root;
		
		while(temp.getNext() !=null)
		{
			if(i-- == 1)
			{
				breakingPoint= temp;
			}
			temp=temp.getNext();
		}
		if(i>0)
		{
			System.out.println("K should be less than List-length");
			System.exit(0);
		}
		
		System.out.println("breaking point node= "+breakingPoint.getData()+"\n\n");
		
		temp.setNext(root);
		root = breakingPoint.getNext();
		breakingPoint.setNext(null);
		
		return root;
	}

}
