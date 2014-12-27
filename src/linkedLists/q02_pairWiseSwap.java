/*Pairwise swap elements of a given linked list by changing links*/
// since Recursion has stack limit~20k .. if input is high(say, 2500000)
// we passed VM arguments in Run configuration : -Xss100m  [allocates 100mb to stack]

package linkedLists;

import HelperPackage.Timer;

public class q02_pairWiseSwap 
{
	public static void main(String[] args) 
	{
		ListNode<Integer> root=LinkedList.createIntegerList(10);  // Note : READ LINE 2
		LinkedList.PrintLinkedList(root);
		Timer t= new Timer();
		
		root=swapPair(root);
		LinkedList.PrintLinkedList(root);
		
		t.getRunTime();
	}

	private static ListNode<Integer> swapPair(ListNode<Integer> current) 
	{
		ListNode<Integer> tempLink,nextNode;
		if(current==null) return null;
		
		nextNode=current.getNext();
		if  (nextNode==null) 
			return current;
		else
		{
			tempLink=swapPair(nextNode.getNext());  // recursion for next-of-pair
			
			nextNode.setNext(current);
			current.setNext(tempLink);
			
			return nextNode;
		}
	}
}