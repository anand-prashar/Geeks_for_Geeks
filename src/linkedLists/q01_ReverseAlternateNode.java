/*Given a linked list, reverse alternate nodes and append them to end of list. Extra allowed space is O(1)*/

package linkedLists;

import java.util.Stack;

public class q01_ReverseAlternateNode 
{
	private static ListNode<Integer> root;

	public static void main(String[] args) 
	{
	   	root = LinkedList.createIntegerList(5); // <--- Give value here
	   	System.out.println("Input List : ");
	   	LinkedList.PrintLinkedList(root);
	   	
		solution(root);
		System.out.println("Output List (reverse and append even positions):");
		LinkedList.PrintLinkedList(root);
	}
	
	private static void solution(ListNode<Integer> root)
	{
		Stack<  ListNode<Integer> > st=new Stack< ListNode<Integer> >();
		int pos=2;
		
		if(root==null || root.getNext()==null) return ;
		
		ListNode<Integer> currentNode  = root.getNext(),
				 previousNode = root;
		
		while(currentNode!=null)  // reading list, started at even position
		{
			//System.out.println("Current node="+currentNode.getData());
				if( pos%2==0 ) // even pos
				{
					st.push(currentNode);
				}
				else
				{
					previousNode.setNext(currentNode);
					previousNode=currentNode;
				}
				
				currentNode=currentNode.getNext();
			    pos++;
		}
		
		//pull back from stack
		while(!st.empty())
		{
			previousNode.setNext(st.pop());
			previousNode = previousNode.getNext();
		}
		previousNode.setNext(null);
	}

}