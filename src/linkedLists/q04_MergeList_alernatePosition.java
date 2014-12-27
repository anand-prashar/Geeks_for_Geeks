//Q :  insert nodes of second list into first list at alternate positions of first list.
// http://www.geeksforgeeks.org/merge-a-linked-list-into-another-linked-list-at-alternate-positions/

package linkedLists;

public class q04_MergeList_alernatePosition 
{
	public static void main(String[] args) 
	{
		ListNode<Integer> root1 =LinkedList.createIntegerList(1, 2);
		System.out.print("List1 : "); LinkedList.PrintLinkedList(root1);
		
		ListNode<Integer> root2 =LinkedList.createIntegerList(101, 105);
		System.out.print("List2 : "); LinkedList.PrintLinkedList(root2);
		
		solution(root1, root2);
		System.out.print("\nFinal List1 : ");
		LinkedList.PrintLinkedList(root1);
	}

	private static void solution(ListNode<Integer> root1, ListNode<Integer> root2) 
	{
		ListNode<Integer> temp;
		while(root1.getNext()!=null && root2.getNext()!=null)
		{
			temp=root1.getNext();
			root1.setNext(root2);
			
			root2=root2.getNext();
			root1=root1.getNext();
			
			//2nd jump: to skip end list's element
			root1.setNext(temp);
			root1=root1.getNext();
		}
		
		if(root2.getNext()!=null ) 		// if list2 is longer
		{
			root1.setNext(root2);
		}
		else if(root1.getNext()!=null) // if list1 is longer
		{
			temp=root1.getNext();
			root1.setNext(root2);
			
			root2.setNext(temp);
		}
		else root1.setNext(root2);  // if List has 1 element each
		
	}

}
