package Trees;
import HelperPackage.UserInput;
public class q02_DistanceFromLeaf 
{
	public static void main(String[] args) 
	{
		TreeNode root = Tree.getBinaryTree();
		while(true)
		{
			/*Integer length = getMinDistancefromLeaf(Tree.getBinaryTree(), UserInput.getUserInteger() );
			if(length != null)
				System.out.println(" Node distance from closest Leaf = "+length);
			else
				System.out.println("Value not found in Tree");*/
			
			
			TreeNode findNode = getNodeAddress(root, UserInput.getUserInteger());
			if(findNode==null)
				System.out.println("Not found in Tree");
			else
			{
				System.out.println(findNode+ " found");
				System.out.println("\nDistance from Leaf = "+(getDistancefromLeaf(findNode)-1));
			}
			System.out.println("\n");
			
		}

	}
	
	
	// NEED TO COMBINE FINDING NODE + GETTING LENGTH INTO 1 method
	@SuppressWarnings("unused")
	private static Integer getMinDistancefromLeaf(TreeNode node, Integer searchValue)
	{
		if(node==null)
			return 0;
		
		Integer length1, length2;
		
		length1 = getMinDistancefromLeaf(node.getLeftLink(), searchValue);
		length2 = getMinDistancefromLeaf(node.getRightLink(), searchValue);
		
		if(searchValue==node.getData() || ( length1!=0 || length2!=0 ))
			return length1>length2 ? ++length1:++length2;
		else
			return 0;
	  
	}
	
	private static TreeNode getNodeAddress(TreeNode root,Integer searchValue)
	{
		if(root==null || searchValue==root.getData() )
			return root;
		
			TreeNode left  = getNodeAddress(root.getLeftLink(), searchValue);
			TreeNode right = getNodeAddress(root.getRightLink(), searchValue);
		
		if(left!=null)
			 return left;
		if(right!=null)
			 return right;
		
		return null;
		
	}
	
	private static Integer getDistancefromLeaf(TreeNode node)
	{
		if(node==null) return 0;
		
		Integer len1=0,len2=0;
		
		len1 += getDistancefromLeaf(node.getLeftLink());
		len2 += getDistancefromLeaf(node.getRightLink());
		
		return len1>len2 ? ++len1:++len2;
			
		
	}

}
