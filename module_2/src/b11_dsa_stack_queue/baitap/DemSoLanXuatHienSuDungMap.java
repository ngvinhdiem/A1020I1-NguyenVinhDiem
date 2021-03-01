package b11_dsa_stack_queue.baitap;

import java.util.*;

public class DemSoLanXuatHienSuDungMap {
    public static void main(String[] args) {
        Map<String,Integer> treeMap = new LinkedHashMap<>();
        Set<String> set = treeMap.keySet();
        String mainString = "di hoc code o code gym va hoc go code o intelij";
        for (String word : mainString.split(" ")) {
            if (set.contains(word)) treeMap.put(word, (int) (treeMap.get(word)) + 1);
            else treeMap.put(word, 1);
        }

        for (String key : set) {
            System.out.println(key + " " + treeMap.get(key));
        }
    }
}