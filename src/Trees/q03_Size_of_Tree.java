package Trees;

public class q03_Size_of_Tree 
{
	public static void main(String[] args) 
	{
		TreeNode root= Tree.getBinaryTree();
		System.out.println("\n\n Size of Tree = No of Nodes in Tree = " + noOfNodes(root));

	}

	private static Integer noOfNodes(TreeNode root)
	{
		if(root!=null)
			return noOfNodes(root.getLeftLink()  ) +
				   1 + 
				   noOfNodes(root.getRightLink());
		
		else
			
		return 0;
	}
}
