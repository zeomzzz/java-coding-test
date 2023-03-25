import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
   
public class Solution {
    public static void main(String[] args) {
           
        Scanner sc = new Scanner(System.in);
         
        for(int tc=1; tc<=10; tc++) { // tc 10개
             
            int n = sc.nextInt(); // 정점의 개수 n
            sc.nextLine(); // 개행문자 처리
            int[][] tree = new int[n+1][2]; // r : 노드 번호, c : 왼쪽 자식, 오른쪽 자식
            String[] strArr = new String[n+1]; // 문자 담을 배열
            for(int i=0; i<n; i++) {
                 
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                 
                LinkedList<String> tokens = new LinkedList<>();
                while (st.hasMoreTokens()) {
                    tokens.add(st.nextToken());
                }
                 
                int node = Integer.parseInt(tokens.get(0));
//              System.out.println(tokens);
                 
                strArr[node] = tokens.get(1); // 인덱스 이용하여 문자 담기
                for(int j=0; j<tokens.size()-2; j++) {
                    tree[node][j] = Integer.parseInt(tokens.get(j+2)) ; // child 정보 입력
                }
                 
            } // tree 정보 입력
             
            System.out.printf("#%d ", tc);
            // 중위순회
            inorder(tree, strArr, 1);
            System.out.println();
             
        }  // tc
    } //  main
     
    // 중위순회    
    static void inorder(int[][] tree, String[] strArr, int node) {
        if(tree[node][0] > 0) inorder(tree, strArr, tree[node][0]);
        System.out.print(strArr[node]);
        if(tree[node][1] > 0) inorder(tree, strArr, tree[node][1]);
    }
     
}
