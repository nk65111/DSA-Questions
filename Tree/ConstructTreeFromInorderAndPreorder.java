//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

//leetcode --> 105. Construct Binary Tree from Preorder and Inorder Traversal

class Solution {
    static HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map=new HashMap<>();
        int len=preorder.length;
        for(int i=0;i<len;i++){
            map.put(inorder[i],i);
        }
      return buildTree(preorder,0,len-1,inorder,0,len-1); 
    }
    private static TreeNode buildTree(int[] preorder,int ps,int pe,int[] inorder,int is,int ie){
        if(ps>pe||is>ie){
            return null;
        }
        int val=preorder[ps];
        TreeNode node=new TreeNode(val);
        int idx=map.get(val);
        int len=idx-is;
        node.left=buildTree(preorder,ps+1,ps+len,inorder,is,idx-1);
        node.right=buildTree(preorder,ps+len+1,pe,inorder,idx+1,ie);
        return node;
    }
}