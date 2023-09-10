// 1. 2차원 배열에 회원/신고 내용 넣기
// 2. 신고 당한 횟수로 정지되는 회원 찾기
// 3. 각 회원이 정지되는 회원 중 몇 명을 신고했는지 찾기
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int n = id_list.length; // 회원 수 n
        int[][] arr = new int[n][n];
        
        HashMap<String, Integer> map = new HashMap<>(); // 회원의 인덱스 저장
        for (int i=0; i<n; i++) { map.put(id_list[i], i); }
        
        int[] cnt_arr = new int[n]; // 신고 당한 횟수 저장
        
        for (String r : report) {
            String[] content = r.split(" ");
            String from = content[0];
            String to = content[1];
            
            if (arr[map.get(to)][map.get(from)] == 0) { cnt_arr[map.get(to)] += 1; }
            arr[map.get(to)][map.get(from)] = 1;
        }
        
        ArrayList<Integer> stopped_list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (cnt_arr[i] >= k) { stopped_list.add(i); }
        }
        
        int[] result = new int[n];
        
        for (int i=0; i<n; i++) {
            for (int stopped : stopped_list) {
                if (arr[stopped][i] == 1) {
                    result[i]++;
                }
            }
        }
        return result;
    }
}
