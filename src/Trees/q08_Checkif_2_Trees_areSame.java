package Trees;

public class q08_Checkif_2_Trees_areSame 
{
	public static void main(String[] args) 
	{
		TreeNode root1, root2;
		root1 = Tree.getBinarySearchTree();
		Tree.printTree_DFS_Inorder(root1);
        
		System.out.println();
		root2 =  Tree.getBinarySearchTree(); // Tree.getBinaryTree();
		Tree.printTree_DFS_Inorder(root2);
		
		if(compare2Trees(root1,root2))
		    System.out.println("\n\nBoth Trees are same(have same structure & data).");
		else
			System.out.println("\n\nDifferent Trees");
	}

	
	
	private static boolean compare2Trees(TreeNode root1, TreeNode root2) 
	{
		if(root1==null && root2==null) 
			return true;
		
		if( (root1==null && root2!=null) || (root1!=null && root2==null))
		return false;
		
		if(root1.equals(root2))  // equals overridden.. true, when value is same
		
			return true && compare2Trees(root1.getLeftLink(), root2.getLeftLink())
					    && compare2Trees(root1.getRightLink(), root2.getRightLink());
		else
			return false;
			
	}

}
