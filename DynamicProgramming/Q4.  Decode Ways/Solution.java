class Solution {
    public int helper(int ind, String s, int dp[]){
        if(ind == s.length())
            return 1; //we have reached the end; hence it is decoded
        if(dp[ind]!=-1)
            return dp[ind]; //cached result
        int ans = 0;
        for(int i=ind; i<ind+2 && i<s.length(); i++){ //take upto 2 letters at a time
            String num = s.substring(ind, i+1);
            if(num.startsWith("0")) //invalid start
                continue;
            int val = Integer.parseInt(num);
            if(val>=1 && val<=26){
                ans += helper(i+1, s, dp);
            }
        }
        return dp[ind] = ans;
    }

    public int numDecodings(String s) {
        int dp[] = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return helper(0, s, dp);
    }
}
