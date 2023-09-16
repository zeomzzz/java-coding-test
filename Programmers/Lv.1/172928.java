class Solution {
    
    static int w;
    static int h;

    public int[] solution(String[] park, String[] routes) {
        int[] result = new int[2];
        
        w = park[0].length(); // 가로
        h = park.length; // 세로
        
        int cr = 0;
        int cc = 0;
        // 1. 시작 지점 찾기
        outer : for (int r=0; r<h; r++) {
            for (int c=0; c<w; c++) {
                if (park[r].charAt(c) == 'S') {
                    cr = r;
                    cc = c;
                    break outer;
                }
            }
        }
        
        for (String route : routes) {
            String[] route_arr = route.split(" ");
            String op = route_arr[0];
            int n = Integer.parseInt(route_arr[1]);
            
            // 2. 다음 위치 찾기
            int[] next_arr = findNext(cr, cc, op, n);
            int nr = next_arr[0];
            int nc = next_arr[1];
            
            // 3. 가능한지 확인
            if (check(park, cr, cc, nr, nc, op, n)) {
                cr = nr;
                cc = nc;
            }
        }
        
        result[0] = cr;
        result[1] = cc;
        
        return result;
    }
    
    // 도착 지점 찾기
    static int[] findNext(int cr, int cc, String op, int n) {
        int[] result = new int[2];

        int nr = cr;
        int nc = cc;
        
        switch(op) {
            case "N" : nr -= n;
                break;
            case "S" : nr += n;
                break;
            case "W" : nc -= n;
                break;
            case "E" : nc += n;
                break;
        }
        
        result[0] = nr;
        result[1] = nc;
        
        return result;
    }
    
    // 이동 가능한지 확인
    static boolean check(String[] park, int cr, int cc, int nr, int nc, String op, int n) {
        if (nr < 0 | nr >= h | nc < 0 | nc >= w) return false; // 밖으로 빠져나가는 경우
        
        int r = cr;
        int c = cc;
        
        if (op.equals("N")) {
            for (int i=0; i<n; i++) {
                r--;
                if(park[r].charAt(c) == 'X') return false;
            }
        } else if (op.equals("S")) {
            for (int i=0; i<n; i++) {
                r++;
                if(park[r].charAt(c) == 'X') return false;
            }
        } else if (op.equals("W")) {
            for (int i=0; i<n; i++) {
                c--;
                if(park[r].charAt(c) == 'X') return false;
            }
        } else {
            for (int i=0; i<n; i++) {
                c++;
                if(park[r].charAt(c) == 'X') return false;
            }
        }
        return true;
    }
    
}
