class Solution {
    static int depth;
    static int answer;
    
    public int solution(String word) {
        answer = 0;
        depth = 0;
        
        dfs("", word);
        
        return answer;
    }
    
    void dfs(String str, String word) {
        
        if (str.equals(word)) {
            answer = depth;
            return;
        }
        
        depth++;
        
        if (str.length() == 5) {
            return;
        }
        
        dfs(str+"A", word);
        dfs(str+"E", word);
        dfs(str+"I", word);
        dfs(str+"O", word);
        dfs(str+"U", word);
        
    }
}
