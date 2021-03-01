package b11_dsa_stack_queue.baitap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DemSoLanXuatHienSuDungMap {
    public static void main(String[] args) {
        Map treeMap = new HashMap();
        Set set = treeMap.keySet();
        String mainString = "di hoc code o code gym va go code o intelij";
        String lowerString, upperString;
        for (String word : mainString.split(" ")) {
            for (Object key : set) {
                lowerString=word.toLowerCase();
                upperString=word.toUpperCase();
                if (lowerString==key||upperString==key) treeMap.put(key, (int) (treeMap.get(key)) + 1);
                else treeMap.put(word, 1);
            }
        }


        for (Object key : set) {
            System.out.println(key + " " + treeMap.get(key));
        }
    }
}