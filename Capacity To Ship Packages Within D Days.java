class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        
        int ans=0;
        
        int max =0;
        int sum=0;
        
        for(Integer i:weights)
        {
            sum+=i;
            max = Math.max(max,i);
        }
        
        if(n==days)
        {
            return max;
        }
        
        int l = max;
        int h = sum;
        
        while(l<=h)
        {
            int mid = l + (h-l)/2;
            
            if(isPossible(weights,mid,days)==true)
            {
                ans = mid;
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        
        return ans;
        
    }
    
    boolean isPossible(int weights[],int mid,int days)
    {
        int d = 1;
        int sum =0;
        
        for(int i=0;i<weights.length;i++)
        {
            sum+=weights[i];
            if(sum>mid)
            {
                d++;
                sum = weights[i]; 
            }
        }
        
        return d<=days; 
    }
}
