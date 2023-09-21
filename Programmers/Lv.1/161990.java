class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int maxC = Integer.MIN_VALUE;
        int maxR = Integer.MIN_VALUE;
        int minC = Integer.MAX_VALUE;
        int minR = Integer.MAX_VALUE;
        
        int h = wallpaper.length;
        int w = wallpaper[0].length();
        
        for (int r=0; r<h; r++) {
            for (int c=0; c<w; c++) {
                if(wallpaper[r].charAt(c) == '#') {
                    if(r > maxR) { maxR = r; } 
                    if (r < minR) { minR = r; }
                    
                    if(c > maxC) { maxC = c; }
                    if (c < minC) { minC = c; }
                }
            }
        }
        
        answer[0] = minR;
        answer[1] = minC;
        answer[2] = ++maxR;
        answer[3] = ++maxC;
        
        return answer;
    }
}
