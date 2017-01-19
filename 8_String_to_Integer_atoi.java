public class Solution {
    public int myAtoi(String str) {
        int sign = 1, x = 0, i = 0;
        if(str.length() == 0) return 0;

        while(str.charAt(i) == ' ' && i < str.length())
            i++;

        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        while(i < str.length()){
            int digit = str.charAt(i) - '0';
            if(digit < 0 || digit > 9) break;

            if(Integer.MAX_VALUE/10 < x || (Integer.MAX_VALUE/10 == x && Integer.MAX_VALUE %10 < digit){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            x = 10 * x + digit;
            i++;
        }
        return x * sign;
    }
}