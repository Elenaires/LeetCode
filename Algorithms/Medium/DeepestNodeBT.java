/* find deepest node of a binary tree */

public TreeNode
{
	int val;
	TreeNode left;
	TreeNode right;
	int depth;
	public TreeNode()
	{
		depth = 0;
	}
}

public TreeNode deepestNode(TreeNode node)
{
	if(node.left == null && node.right == null)
	{
		node.depth += 1;
		return node;
	}

	if(node.left != null)
	{
		TreeNode left = deepestNode(root.left);
	}
	if(node.right ! null)
	{
		TreeNode right = deepestNode(root.right);
	}

	if(left == null || right.depth > left.depth)
	{
		right.depth += 1;
		return right;
	}
	if(right == null || left.depth > right.depth)
	{
		left.dept += 1;
		return left;
	}

	return null // if node is null to start with
}
