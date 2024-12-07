/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        String hello = "hello";
        System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(countChar("", 'z'));
        System.out.println(remove("committee","meet"));
        System.out.println(insertRandomly('s',"cat"));
        //// Put your other tests here.
        /*System.out.println(subsetOf("sap", "space"));
        System.out.println(subsetOf("spa", "space"));
        System.out.println(subsetOf("pass", "space"));
        System.out.println(subsetOf("c", "space"));*/
    }   

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ch) count += 1;
        }
        return count;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        if (str1 == "") return true;
        boolean check = false;

        for(int i = 0; i < str1.length(); i++){
            char c = str1.charAt(i);
            
            for(int j = 0; j < str2.length(); j++){

                if(c == str2.charAt(j)){

                    check = true;
                    if(j == 0) str2 = str2.substring(1, str2.length()); //the char in location 0
                    if(j == str2.length() - 1) str2 = str2.substring(0, j); //the char is in the end
                    if(j > 0 && j < str2.length() - 1) str2 = str2.substring(0, j) + str2.substring(j + 1); //the char is in the middle
                        
                    break;
                }
            }

            if(!check) return false;
            check = false;

        }

        return true;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String s = "";
        for(int i = 0; i < str.length(); i++){
            if(i == str.length() - 1) s += str.charAt(i);
            else s += str.charAt(i) + " ";
        }
        return s;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String s = "";
        while(n > 0){
            s += (char) (97 + (int)(Math.random() * ((122 - 97) + 1)));
            n -= 1;
        }
        return s;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("committee","meet") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) { // remove the letters of str2 from str1 and return fixed str1
        if (str2 == "") return str1;

        for(int i = 0; i < str2.length(); i++){
            char c = str2.charAt(i);
            
            for(int j = 0; j < str1.length(); j++){

                if(c == str1.charAt(j)){

                    if(j == 0) str1 = str1.substring(1, str1.length()); //the char in location 0
                    if(j == str1.length() - 1) str1 = str1.substring(0, j); //the char is in the end
                    if(j > 0 && j < str1.length() - 1) str1 = str1.substring(0, j) + str1.substring(j + 1); //the char is in the middle
                        
                    break;
                }
            }
        }

        return str1;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
