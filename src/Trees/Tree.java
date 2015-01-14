package Trees;

import java.util.LinkedList;
import java.util.Queue;

class Tree 
{
/*     			 1
    		 /      \
  		   2          3
		/     \         \
	  4         5        6
	/                   /
   7                   8 

*/	
	static TreeNode getBinaryTree()
	{
		Integer nodeValue = 1; TreeNode root=null,temp;
		
		root = new TreeNode(nodeValue++); temp = root;
		temp.setLeftLink(new TreeNode(nodeValue++));   //2
		temp.setRightLink(new TreeNode(nodeValue++));  //3
		
		temp=temp.getLeftLink();
		temp.setLeftLink(new TreeNode(nodeValue++));   //4
		temp.setRightLink(new TreeNode(nodeValue++));  //5
		
		root.getRightLink().setRightLink(new TreeNode(nodeValue++)); //6
		
		temp=temp.getLeftLink();
		temp.setLeftLink(new TreeNode(nodeValue++)); // 7
		
		root.getRightLink().getRightLink().setLeftLink(new TreeNode(nodeValue++)); // 8
		return root;
	}
	
	static void printTree_BFS_order(TreeNode root)
	{
		Queue<TreeNode> q = new LinkedList<TreeNode>(); // create a q to push level-data
		TreeNode currentPos;
		
		q.add(root);
		
		while(q.peek() != null)
		{
			currentPos = q.poll();
			System.out.println(currentPos);
			
			if(currentPos.getLeftLink()!=null) 
				q.add(currentPos.getLeftLink());
			
			if(currentPos.getLeftLink()!=null) 
				q.add(currentPos.getRightLink());
		}
	}
	
}
