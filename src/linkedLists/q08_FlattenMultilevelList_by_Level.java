package linkedLists;

import java.util.Queue;

public class q08_FlattenMultilevelList_by_Level 
{
	static boolean QueueisEmpty=true;
	static Queue<DoubleListNode> downLevelQ=null;
	
	public static void main(String[] args) 
	{
		DoubleListNode root= LinkedList.createDoubleList();
		LinkedList.printCustomList(root);
		
		LinkedList.Q8_printDoubleList(flattenList(root) );
		
	}
	
	static DoubleListNode flattenList(DoubleListNode root)
	{
		DoubleListNode lastElement;
		
		if(root !=null)
		{	
			QueueisEmpty=false;
			
			while(QueueisEmpty==false)
			{
				lastElement = mergeLists_ofSameLevel(null, root);
				removeFrom_Q_andAppendtoList(lastElement);
			}
		}
		
		return root;
	}
	
	static DoubleListNode mergeLists_ofSameLevel(DoubleListNode lastNodeofExistingList, DoubleListNode rootNodeofNewList)
	{
		if(lastNodeofExistingList !=null)
		{
			lastNodeofExistingList.setDownNode(null);
			lastNodeofExistingList.setRightNode(rootNodeofNewList); // Link lists of same level
		}
		
		
		while(rootNodeofNewList.getRightNode()!=null) // goto end of that link on same level
		{
			checkAndPushto_Q(rootNodeofNewList);     // keep adding down level elements meanwhile
			
			rootNodeofNewList.setDownNode(null);
			rootNodeofNewList=rootNodeofNewList.getRightNode();
		}
		checkAndPushto_Q(rootNodeofNewList);
		
		return rootNodeofNewList;  // actually returns Last element of the newly formed list
	}

	//helper of above
	private static void checkAndPushto_Q(DoubleListNode temp) 
	{
		if(temp.getDownNode()!=null)
		{
			if(downLevelQ==null)
			{  downLevelQ= new java.util.LinkedList<DoubleListNode>();
			   QueueisEmpty = false;
			}
			
			downLevelQ.add(temp.getDownNode() );
		}
		
	}
	
	private static DoubleListNode removeFrom_Q_andAppendtoList(DoubleListNode lastNodeofList)
	{
		while(downLevelQ.peek() !=null)
		{
			lastNodeofList = mergeLists_ofSameLevel(lastNodeofList, downLevelQ.remove());
		}
		
		QueueisEmpty = true;
		
		return lastNodeofList;
	}
}
