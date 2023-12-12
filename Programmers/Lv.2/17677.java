// 1. 모두 소문자로 변경
// 2. 두 글자씩 끊어서 LinkedList에 넣고 정렬
// 3. LinkedList to Queue
// 4. Queue pop하면서 count

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 1. 모두 소문자로 변경
        String str1Lower = str1.toLowerCase();
        String str2Lower = str2.toLowerCase();
        
        // 2. 두 글자씩 끊어서 ArrayList에 넣기
        LinkedList<String> list1 = new LinkedList<>();
        String str = "";

        for (int i=0; i<str1Lower.length() - 1; i++) {
            char c1 = str1Lower.charAt(i);
            char c2 = str1Lower.charAt(i+1);
            
            if (c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') {
                str = String.valueOf(str1Lower.charAt(i)) + String.valueOf(str1Lower.charAt(i+1));
                list1.add(str);
            }
        }
        
        LinkedList<String> list2 = new LinkedList<>();
        for (int i=0; i<str2Lower.length() - 1; i++) {
            char c1 = str2Lower.charAt(i);
            char c2 = str2Lower.charAt(i+1);
            
            if (c1 >= 'a' && c1 <= 'z' && c2 >= 'a' && c2 <= 'z') {
                str = String.valueOf(str2Lower.charAt(i)) + String.valueOf(str2Lower.charAt(i+1));
                list2.add(str);
            }
        }
        
        Collections.sort(list1);
        Collections.sort(list2);
        
        // 3. LinkedList to Queue
        Queue<String> q1 = list1;
        Queue<String> q2 = list2;
        
        // 4. Queue pop하면서 count
        int inter = 0;
        int outer = 0;
        
        str1 = "";
        str2 = "";
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (str1.equals("")) {
                str1 = q1.poll();
            }
            
            if (str2.equals("")) {
                str2 = q2.poll();
            }
            
            if (str1.equals(str2)) {
                inter++;
                outer++;
                str1 = "";
                str2 = "";
            } else {
                outer++;
                String[] arr = {str1, str2};
                Arrays.sort(arr);
                
                if (arr[0].equals(str1)) {
                    str1 = "";
                } else {
                    str2 = "";
                }
            }
        }
        
        if (!str1.equals("") || !str2.equals("")) {
            outer++;
        }
        
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                System.out.println(q1.poll());
                outer++;
            }
        }
        
        if (!q2.isEmpty()) {
            while (!q2.isEmpty()) {
                System.out.println(q2.poll());
                outer++;
            }
        }
        
        if (outer == 0) {
            return 65536;
        } else {
            answer = inter * 65536 / outer;
        }
        
        return answer;
    }
}
