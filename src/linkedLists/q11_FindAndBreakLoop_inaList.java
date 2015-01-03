package linkedLists;

public class q11_FindAndBreakLoop_inaList 
{
	public static void main(String[] args) 
	{
		ListNode<Integer> root= LinkedList.createIntegerList(1, 6);
		createTestLoop(root,2);
		
		// returns a random node from within Loop, where slow & fast pointers 1st overlapped
		ListNode<Integer> loopNode = checkLinkedList_forLoop(root);  // STEP 1: FIND LOOP
		
		if( loopNode != null )  // null, means no Loop
		{											 	 
			breakLoopinList(root, loopNode);						// STEP 2: BREAK LOOP
		}
		else
			System.out.println("Linked List does not have a loop");
		
		LinkedList.PrintLinkedList(root);
		
	}

	private static void breakLoopinList(ListNode<Integer> root, ListNode<Integer> loopNode) 
	{
		// step1 : Ln1 is start of list, 
		//         Ln2 is some node inside the Loop at previous match point
		//         iterate both by 1 till their Next() meet
		
		ListNode<Integer> ln1 = root, 
						  ln2 = loopNode;

		while(ln1.getNext() != ln2.getNext())
		{
			ln2=ln2.getNext();
			ln1=ln1.getNext();
		}
		
		ln1 = root;
		System.out.println("Last Node that needs to be delinked : "+ln2.getData());
		
		
		// step2 : Break the link
		ln2.setNext(null);
		
		
	}

	private static ListNode<Integer> checkLinkedList_forLoop(ListNode<Integer> slow) 
	{
		ListNode<Integer> fast=slow;
		
		while(slow!=null && fast!=null)
		{
			slow=slow.getNext();
			
			if(fast.getNext()!=null)
				fast=fast.getNext().getNext();
			else break;
			
			if(slow == fast)
				return slow;
		}
		return null;
	}

	private static void createTestLoop(ListNode<Integer> temp, int i) 
	{
		ListNode<Integer> fusion=null;
		while(temp.getNext()!=null)
		{
			if(i==1 && fusion==null)
				fusion = temp;
			else
				i--;
			temp = temp.getNext();
		}
		System.out.println("Fusion Point in List ="+fusion.getData());

		if(fusion==temp) // invalid case handle.. IF i points to Last Node in list
			System.out.println("Error: Invalid value.. 'I' must be less than List-Length");
		else
			temp.setNext(fusion);
	}

}
