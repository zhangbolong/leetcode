public class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for(int i = 0; i < sb.length; i++){
            sb[i] = new StringBuffer();
        } 

        
        for(int i = 0; i < len;){
            // vertically down
            for(int idx = 0; idx < nRows && i < len; idx++){
                sb[idx].append(c[i++]);
            }
            
            // obliquely up
            for(int idx = nRows - 2; idx >=1 && i < len; idx--){
                sb[idx].append(c[i++]);
            }

        }

        for(int idx = 1; idx < sb.length; idx++){
            sb[0].append(sb[idx]);
        }
        return sb[0].toString();
    }
}