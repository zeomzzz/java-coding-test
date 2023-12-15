// 1. 길이 순으로 정렬 -> 안해도 될듯 -> 사전순으로 정렬!!
// 2. 완탐
// 실행결과 : 정확성 20/20, 효율성 2/4 -> 어떻게 효율성 높일 것인가.. -> String을 사전순으로 정렬하면?

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int l = phone_book.length;
        
        outer : for (int i=0; i<l-1; i++) {
            String num1 = phone_book[i];
            int n = num1.length();
            
            for (int k=i+1; k<l; k++) {
                String num2 = phone_book[k];
                int m = num2.length();
                
                if (n < m) {
                    for (int o=0; o<n; o++) {
                        if (num1.charAt(o) != num2.charAt(o)) {
                            break;
                        } else {
                            if (o == n-1) {
                                answer = false;
                                break outer;
                            }
                        }
                    }
                } else if (n > m) {
                    for (int o=0; o<m; o++) {
                        if (num1.charAt(o) != num2.charAt(o)) {
                            break;
                        } else {
                            if (o == m-1) {
                                answer = false;
                                break outer;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}

// 효율성 해결
// 1. 사전 순으로 정렬
// 2. 다음 것과만 비교

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int l = phone_book.length;
        
        Arrays.sort(phone_book);
        
        for (int i=0; i<l-1; i++) {
            int n = phone_book[i].length();
            int m = phone_book[i+1].length();
            
            if (n < m) {
                if (phone_book[i].equals(phone_book[i+1].substring(0, n))) {
                    answer = false;
                    break;
                }
            } else if (n > m) {
                if (phone_book[i+1].equals(phone_book[i].substring(0, m))) {
                    answer = false;
                    break;
                }
            }
        }
        
        return answer;
    }
}
