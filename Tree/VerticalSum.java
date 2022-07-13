//https://practice.geeksforgeeks.org/problems/vertical-sum/1
//Vertical Sum



public class VerticalSum{
    //calculate width of tree
    private static void findWidth(Node root,int[] arr,int idx){
        if(root==null){
            return;
        }
        //store leftmost length from left
        arr[0]=Math.min(arr[0],idx);
        //store rightmost length from right
        arr[1]=Math.max(arr[1],idx);

        findWidth(root.left,arr,idx-1);
        findWidth(root.right,arr,idx+1);
    }
    public ArrayList <Integer> verticalSum(Node root) {
        int[] arr=new int[2];
        findWidth(root,arr,0);
        ArrayList<Integer> al=new ArrayList<Integer>();

        //length will be rightmost length + leftmost length +1
        int len=arr[1]-arr[0]+1;
        for(int i=0;i<len;i++){
            al.add(0);
        }
        verticalSum(root,al,-arr[0]);
        return al;
    }
    private static void verticalSum(Node node,ArrayList<Integer> al,int lev){
        if(node==null){
            return;
        }
        //add value on perticular level
        al.set(lev,al.get(lev)+node.data);
        verticalSum(node.left,al,lev-1);
        verticalSum(node.right,al,lev+1);
    }
}


