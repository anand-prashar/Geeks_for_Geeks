package Trees;

public class q07_Printall_Paths_in_Tree 
{
	public static void main(String[] args) 
	{
		TreeNode root = Tree.getBinaryTree();
		printAllPathsinATree(root,null);

	}

	private static void printAllPathsinATree(TreeNode node,String pathSoFar) 
	{
		if(node!=null)
		{ 
	    	  if(pathSoFar==null)
	    		  pathSoFar = node + " -> ";
	    	  else
	    		  pathSoFar = pathSoFar + node + " -> ";
	    	  
	    	  
	    	  if(node.getLeftLink()==null && node.getRightLink()==null )  // means reached a Leaf Node
	    		  System.out.println("\npath (Root to Leaf) :  "+pathSoFar);
	    		  
	    	  printAllPathsinATree(node.getLeftLink(), pathSoFar);
	    	  printAllPathsinATree(node.getRightLink(), pathSoFar);
	    	  
		}
		
		
	}

}
