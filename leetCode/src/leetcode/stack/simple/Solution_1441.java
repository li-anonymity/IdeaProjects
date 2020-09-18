package leetcode.stack.simple;

import java.util.ArrayList;
import java.util.List;

public class Solution_1441 {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> build = new ArrayList();
        int index = 0;
        int i = 1;
        while(index < target.length && i <= n){
            build.add("Push");
            if(i != target[index]){
                build.add("Pop");
            }else{
                index++;
            }
            i++;
        }
        return build;
    }

    public static void main(String[] args) {
        int[] target = {1,3};
        System.out.println(new Solution_1441().buildArray(target,3));
    }
}
