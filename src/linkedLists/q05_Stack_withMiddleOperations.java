package linkedLists;

import HelperPackage.UserInput;

public class q05_Stack_withMiddleOperations 
{
	private ListNode<Integer> root=null, top=null, middle=null;
	int elementCount=0, oldMiddlePosition=0;
	
	public static void main(String[] args) 
	{
		q05_Stack_withMiddleOperations obj=new q05_Stack_withMiddleOperations();
		obj.solution();
}
	
	private void solution() 
	{
		//root=LinkedList.createIntegerList(5);
		Integer choice;
		while(true)
		{
			LinkedList.PrintLinkedList(root);
			System.out.print("1.Push\n2.Pop\n3.findMiddle\n4.DeleteMiddle        : ");
			try {
					choice=Integer.parseInt( UserInput.getUserData());
					switch(choice)
					{
						case 1 : push();   break;
						case 2 : pop();    break;
						case 3 : showMid();break;
						case 4 : delMid(); break;
						default: System.exit(0);
					}
				}
			catch(NumberFormatException e)
				{
					System.out.print("Invalid choice.. enter numbers only !\n");
				}
			}
		
		}
	
	private void delMid() {
		if(middle!=null)
		{
			ListNode<Integer> prevLink, nextLink;
			prevLink=middle.getPrev();
			nextLink=middle.getNext();
			
			elementCount--;
			oldMiddlePosition--;
			if(elementCount!=0)
			{
				prevLink.setNext(nextLink);
				nextLink.setNext(prevLink);
			}
		}
		
	}

	private void showMid() {
		if(middle!=null)
			System.out.println("\nMiddle element : "+middle.getData());
		else
			System.out.println("\nNo middle. Stack is empty");
	}

	private void pop() 
	{
		if(root==null)
		{
			System.out.println("Stack empty. Can not delete");
		}
		else
		{
			if(elementCount==1) 
			{
				root=null; top=null; middle=null;
				
			}
			else
			{
				top=top.getPrev();
				top.setNext(null);
			}
			elementCount--;
			resetStackMetadata(false);
		}
	}
	

	@SuppressWarnings("all")
	private boolean push()
	{
		try
		{
			Integer data= Integer.parseInt( UserInput.getUserData() );
			if(root==null)
			{
				root= new ListNode<Integer>();
				root.setData(data);
				middle=top=root;
			}
			else
			{
				ListNode<Integer> temp=new ListNode<Integer>();
				temp.setData(data);
				
				top.setNext(temp);
				temp.setPrev(top);
				
				top=top.getNext();
			}
			
			elementCount++;
			resetStackMetadata(true);  // change metadata
			return true;
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid User Entry. Program exited");
		}
		finally
		{
			return false;
		}
	}

	private void resetStackMetadata(boolean addedEntry) 
	{
		if(addedEntry==true)  // Push
		{
		
			if(elementCount/2 > oldMiddlePosition )
			{  
				oldMiddlePosition++;
				middle=middle.getNext();
			}
		
		}
		else   				// Pop
		{
			if(elementCount/2 < oldMiddlePosition )
			{  
				oldMiddlePosition--;
				middle=middle.getPrev();
			}
		}
	}
}