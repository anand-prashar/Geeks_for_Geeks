//  Given a linked list of 0s, 1s and 2s, sort it.

package linkedLists;

import java.util.Stack;

public class q07_SortLinkedList_012_in_Ntime 
{
	public static void main(String[] args) 
	{
		ListNode<Integer> root = LinkedList.create012List(7);
		LinkedList.PrintLinkedList(root);
		
		root=sortList(root);
		LinkedList.PrintLinkedList(root);
		
	}
	
	static ListNode<Integer> sortList(ListNode<Integer> root)
	{
		Stack<ListNode<Integer>> s_0, s_1,s_2;
		s_0 = new Stack<ListNode<Integer>>();
		s_1 = new Stack<ListNode<Integer>>();
		s_2 = new Stack<ListNode<Integer>>();
		
		ListNode<Integer> itr = root;
		while(itr!=null)
		{
			switch(itr.getData())
			{
				case 0 : s_0.push(itr);break;
				case 1 : s_1.push(itr);break;
				case 2 : s_2.push(itr);break;
				default: System.out.println("Invalid List given. Only 0,1,2 expected");
				 		 System.exit(0);
			}
			itr = itr.getNext();
		}
		
		root=itr=null;
		while(! s_0.isEmpty() )
		{
			if(root==null)
			{	
				root=s_0.pop();
				itr=root;
			}
			else
			{
				itr.setNext(s_0.pop());
				itr=itr.getNext();
			}
			
		}
		while(! s_1.isEmpty() )
		{
			if(root==null)
			{	
				root=s_1.pop();
				itr=root;
			}
			else
			{
				itr.setNext(s_1.pop());
				itr=itr.getNext();
			}
			
		}
		while(! s_2.isEmpty() )
		{
			if(root==null)
			{	
				root=s_2.pop();
				itr=root;
			}
			else
			{
				itr.setNext(s_2.pop());
				itr=itr.getNext();
			}
			
		}
		
		itr.setNext(null);
		return root;
	}

}
