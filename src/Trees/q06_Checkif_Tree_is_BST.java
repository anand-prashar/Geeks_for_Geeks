package Trees;

public class q06_Checkif_Tree_is_BST 
{
	public static void main(String[] args) 
	{
		TreeNode root = Tree.getBinaryTree();
		Tree.printTree_DFS_Inorder(root);
		System.out.println("\nTree follows BST property : "+checkBST(root)+"\n");
		
		root = Tree.getBinarySearchTree();
		Tree.printTree_DFS_Inorder(root);
		
		System.out.println("\n\nTree follows BST property : "+checkBST(root));

	}
	
	private static boolean checkBST(TreeNode root)
	{
		
		if(root==null) return true;
		boolean validationTrue = false;
		
		if(root.getLeftLink()!=null)
		{
			if(root.getLeftLink().getData() < root.getData())
			validationTrue = true;
		}
		else
			validationTrue = true;

		
		if(validationTrue)
		if(root.getLeftLink()!=null)
		{
			if(root.getLeftLink().getData() < root.getData())
			validationTrue = true;
		}
		else
			validationTrue = true;

		
		
		// if validation is false, checkBST will not be called in below line
		return validationTrue && (checkBST(root.getLeftLink() )) && (checkBST(root.getRightLink() )) ;
		
		
	}

}
