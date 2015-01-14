package Trees;

public class TreeNode 
{
	Integer data;
	TreeNode leftLink, rightLink;
	
	public Integer getData() 
	{
		return data;
	}
	public void setData(Integer data) 
	{
		this.data = data;
	}
	public TreeNode getLeftLink() 
	{
		return leftLink;
	}
	public void setLeftLink(TreeNode LeftLink) 
	{
		this.leftLink = LeftLink;
	}
	public TreeNode getRightLink() 
	{
		return rightLink;
	}
	public void setRightLink(TreeNode RightLink) 
	{
		this.rightLink = RightLink;
	}
	
	public String toString()
	{
		return Integer.toString(this.data);
	}
	
	TreeNode(Integer d)
	{
		this.data = d;
		this.leftLink=null;
		this.rightLink=null;
	}
}
