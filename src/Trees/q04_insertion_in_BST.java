package Trees;

import HelperPackage.UserInput;

public class q04_insertion_in_BST {

	public static void main(String[] args) 
	{
		TreeNode root=null;
		while(true)
		{
			System.out.print("\nINSERT");
			Integer ui = UserInput.getUserInteger();
			root = insert_and_create_BST(root,ui);
			System.out.print("Printing Tree : ");
			Tree.printTree_DFS_Inorder(root);
			
			// begin Binary Tree- Search module only when specific input is given
			if(ui==3333)
			{System.out.print("\nSEARCH");
			System.out.println( searchInBST(root, UserInput.getUserInteger()) );}
		}

	}

	public static TreeNode insert_and_create_BST(TreeNode root, Integer userInteger) 
	{
		if(root==null)
		{
			root=new TreeNode(userInteger);
			
		}
		else
		{
			if(root.getData() <= userInteger )
				root.setRightLink(  insert_and_create_BST(root.getRightLink(), userInteger) );
			else
				root.setLeftLink( insert_and_create_BST(root.getLeftLink(), userInteger));
		}
		return root;
		
	}
	
	
	private static boolean searchInBST(TreeNode root, Integer searchValue)
	{
		if(root==null)
			return false;
		
		if(root.getData().equals( searchValue ) ) // NOTE: here normal = will not work. Its not primitive
			return true;
		
		if(root.getData() < searchValue)
			return searchInBST(root.getRightLink(), searchValue);
		else
			return searchInBST(root.getLeftLink(), searchValue);
		
		
	}

}
