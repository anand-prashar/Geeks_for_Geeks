package Trees;

public class TreeNode 
{
	private Integer data;
	private TreeNode leftLink, rightLink;
	
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
	
	public boolean equals(Object o)
	{
		if((o!=null) && (o instanceof TreeNode))
			if( ( (TreeNode)o).getData().equals(this.getData()))
				return true;
			else
				return false;
	    else	
		return false;
		
	}
	
	TreeNode(Integer d)
	{
		this.data = d;
		this.leftLink=null;
		this.rightLink=null;
	}
}
