package Trees;

public class q01_Traverse_BFS_DFS 
{
	public static void main(String[] args) 
	{
		TreeNode root = Tree.getBinaryTree();
		
		// breadth-wise traversal   <---------   Hint: Store in Queue
		Tree.printTree_BFS_order(root);
		
		System.out.println("\n");
		Tree.printTree_DFS_Inorder(root);

	}

}
