package b11_dsa_stack_queue.baitap;

import java.util.Stack;

public class DaoNguocChuoiSuDungStack {
    public static void main(String[] args) {
        String string = "di hoc tai codegym";
        String newString ="";
        Stack<String> wStack = new Stack<>();
        for (String mWord : string.split(" ")) {
            wStack.push(mWord);
        }
        while (!wStack.empty()) {
            String mWord = wStack.pop();
            newString=newString+" "+mWord;
        }
        System.out.println(newString);

    }
}
