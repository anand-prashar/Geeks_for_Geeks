//Delete all middle points in a line segment
//URL : http://www.geeksforgeeks.org/given-linked-list-line-segments-remove-middle-points/

package linkedLists;

public class q03_DeleteCoordinates_inLineSegment 
{
	public static void main(String[] args) 
	{
		LinkedList<Coordinate> l=new LinkedList<Coordinate>();
		
		ListNode<Coordinate> root = l.listOfCoordinates();  // input
		LinkedList.PrintLinkedList( root );
		
		solution(root);
		LinkedList.PrintLinkedList(root);

	}
	
	private static ListNode<Coordinate> solution(ListNode<Coordinate> rootNode)
	{
		if(rootNode==null) return null;
		
		while(rootNode.getNext()!=null)
		{
			rootNode.setNext( find2ndCoordinate(rootNode) );
			
			rootNode=rootNode.getNext();
			if(rootNode.getNext()!=null)
			   rootNode=rootNode.getNext();
			else
				break;
		}
		return null;
	}

	private static ListNode<Coordinate> find2ndCoordinate(ListNode<Coordinate> itr) 
	{
		ListNode<Coordinate> temp, memory=null;
		temp=itr.getNext();
		
		if(temp == null) return temp;  // last node in the list
		
		while(temp!=null)
		{
			if( (itr.getData().x == temp.getData().x) ||
			    (itr.getData().y == temp.getData().y) ) 
				memory=temp;
			else
			{
				break;
			}
			temp=temp.getNext();
		}
		return memory;
	}

}
