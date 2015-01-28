package Trees;

import HelperPackage.UserInput;

public class q05_MaxDepth_in_Tree {

	public static void main(String[] args) 
	{
		TreeNode root=null;
		while(true)
		{
			System.out.print("\nINSERT");
			Integer ui = UserInput.getUserInteger();
			root = q04_insertion_in_BST. insert_and_create_BST(root,ui);
			
			System.out.print("\nTree = ");
			Tree.printTree_DFS_Inorder(root);

			System.out.print("\nMax Depth= "+fetchDepth(root));

		}	
	}

	
	private static Integer fetchDepth(TreeNode root) 
	{
		if(root == null)               // empty tree has (depth = -1 ) by convention			
			return -1;
		
		Integer leftDepth,rightDepth;
		leftDepth  = fetchDepth(root.getLeftLink());
		rightDepth = fetchDepth(root.getRightLink());
		
		return leftDepth>=rightDepth ? ++leftDepth: ++rightDepth;
	}

}
