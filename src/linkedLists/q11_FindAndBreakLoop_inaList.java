package linkedLists;

public class q11_FindAndBreakLoop_inaList 
{
	public static void main(String[] args) 
	{
		ListNode<Integer> root= LinkedList.createIntegerList(1, 7);
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
		// step1 : find length of Loop
		// keep 1 point Fixed in loop, and iterate another Point till they reoverlap
		
		ListNode<Integer> ln1 = loopNode, 
						  ln2 = loopNode.getNext();
		int loopLength=1 ;  // <--
		while(ln1 != ln2)
		{
			ln2=ln2.getNext();
			loopLength++;
		}
		
		
		// step2 : get length of unlooped part of Linked List
		// iterate 0 - loopLength  = last node of unlooped part
		ln1 = root;
		while(loopLength > 0)
		{
			ln1 = ln1.getNext();
			loopLength--;
		}
		System.out.println("Last Node after which Loop starts : "+ln1.getData());
		
		// step3: break link
		ln1.setNext(null);
		
		
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
