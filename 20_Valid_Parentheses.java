/*
    The string is used to map characters to integer values. 
    The integer values can be used to tell if it is an opening/closing character
*/
public class Solution {
    public boolean isValid(String s) {
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            int StartOrClose = "(){}[]".indexOf(s.substring(i, i+1));
            if( StartOrClose % 2 == 1 ){
                if(stk.isEmpty() || stk.pop() != StartOrClose - 1){
                    return false;
                }
            } else{
                stk.push(StartOrClose);
            }
        }

        return stk.isEmpty();
    }
}