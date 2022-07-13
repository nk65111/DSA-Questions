//leetcode -   473. Matchsticks to Square



//approch
// 1.We have to use all sticks , so sum of all sticks must be divided by 4 and the length of each side must be not greater than sum/4.
// 2.If we sort Decending order than we can pick first those stick whose length is maximum.
// 3.we create 4 size array where every index shows side of a Square
// 4.put every stick in every index of array and check is all value of array is equal or not.


class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks==null||matchsticks.length<3){
            return false;
        }
        int sum=0;
        for(int val:matchsticks){
            sum+=val;
        }
        if(sum%4!=0){
            return false;
        }
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] arr=new int[4];
      return check(matchsticks,0,arr,sum/4);
    }
    

    //reverse
    public static void reverse(int[] arr){
        int lo=0;
        int hi=arr.length-1;
        while(lo<hi){
            int temp=arr[lo];
            arr[lo]=arr[hi];
            arr[hi]=temp;
            lo++;
            hi--;
        }
    }
    
    public static boolean check(int[] match,int idx,int[] arr,int target){
        if(idx==match.length){
            //check all value is equal to target or not
            if(arr[0]==target&&arr[1]==target&&arr[2]==target&&arr[3]==target){
                return true;
            }
            
            return false;
        }
        for(int i=0;i<arr.length;i++){
            //if side is greater than target we will not add that stick
            if(arr[i]+match[idx]>target){
                continue;
            }
           arr[i]+=match[idx];
           if(check(match,idx+1,arr,target)){
               return true;
           }
            arr[i]-=match[idx];
        }
        return false;
    }
}

