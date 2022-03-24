public class Atoi {

    public static int strToInt(String s) {

        int l = s.length();

        if (l == 0 || l > 200) {
            return 0;
        }

        int i = 0;
        int num = 0;
        char ch = s.charAt(i);
        boolean neg = false;

        //1. Read in and ignore any leading whitespace.

        while(ch == ' ' && i <= l-1){
            if (i == l-1){
                return 0;
            } else {
                i += 1;
                ch = s.charAt(i);
            }
        }

        //2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.

        if (ch == '-'){
            neg = true;
            i += 1;
        }

        if (ch == '+'){
            i += 1;
        }

        if (i > l-1){
            return 0;
        } else {
            ch = s.charAt(i);
        }

        //3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.

        while(ch >= '0' && ch <= '9' && i <= l-1){

            if (num <= Integer.MAX_VALUE/10) {

                if (!neg && num == Integer.MAX_VALUE/10 && Character.getNumericValue(ch) > 7) {
                    return Integer.MAX_VALUE;
                }

                if (neg && num == Integer.MAX_VALUE/10 && Character.getNumericValue(ch) == 9) {
                    return Integer.MIN_VALUE;
                }

                num = 10 * num + Character.getNumericValue(ch);

            } else{

                if (!neg) {return Integer.MAX_VALUE;}
                if (neg) {return Integer.MIN_VALUE;}

            }

            if (i < l-1){
                i += 1;
                ch = s.charAt(i);
            } else {
                i += 1;
            }

        }


        if (neg){
            num *= (-1);
        }

        return num;

    }


    // Driver program
    public static void main(String[] args) {

        String str = "   -002147483638";
        //String str = "  004298";

        System.out.println(strToInt(str));

    }
}

