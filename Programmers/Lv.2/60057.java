// 1. 길이 1부터 압축 다 해보기
// s의 길이 절반까지 단위로만 압축했을 때 유효

import java.util.*;

class Solution {
    static int answer;
    public int solution(String s) {
        int l = s.length();
        answer = l;
        
        if (l != 1) {
            for (int cnt=1; cnt<=l/2; cnt++) {
                compress(cnt, s, l);
            }
        }
        
        return answer;
    }
    
    void compress(int cnt, String s, int l) {
        String compressed = "";
        String tmp = "";
        int start = 0;
        int end = cnt;
        
        String part = s.substring(start, end);
        int time = 1;
        start += cnt;
        end += cnt;
        
        while (true) {
            if (end >= l) { // end가 길이 이상 -> 끝내야 함
                tmp = s.substring(start, l);
                break;
            }
            
            tmp = s.substring(start, end);
            if (part.equals(tmp)) { // 압축 가능
                time++;
            } else { // 압축 불가능
                if (time != 1) { // 1은 생략
                    compressed += Integer.toString(time);
                }
                compressed += part;
                time = 1;
                part = tmp;
            }
            
            start += cnt;
            end += cnt;
            
        }
        
        if (end == l) {
            if (part.equals(tmp)) {
                time++;
                compressed += Integer.toString(time) + part;
            } else {
                if (time != 1) {
                    compressed += Integer.toString(time);
                }
                compressed += part;
                compressed += tmp;
            }
        } else {
            if (time != 1) {
                compressed += Integer.toString(time);
            }
            compressed += part;
            compressed += tmp;
        }
        answer = Math.min(answer, compressed.length());
    }
}
