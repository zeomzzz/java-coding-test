class Solution {
    public int solution(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        } else if (arr.length == 2) {
            return findLcm(arr[0], arr[1]);
        } else {
            int answer = findLcm(arr[0], arr[1]);
            
            for (int i=2; i<arr.length; i++) {
                answer = findLcm(answer, arr[i]);
            }
            return answer;
        }
    }
    
    public int findLcm(int a, int b) {
        int n = a;
        int m = b;
        if (b > a) {
            n = b;
            m = a;
        } 
        
        if (n % m == 0) {
            return n;
        } else {
            // 1. 최대공약수
            int tmp = 1;
            for (int i=m-1; i>1; i--) {
                if (n % i == 0 && m % i == 0) {
                    tmp = i;
                    break;
                }
            }
            // 2. 최소공배수
            return n * m / tmp;
        }
    }
}
