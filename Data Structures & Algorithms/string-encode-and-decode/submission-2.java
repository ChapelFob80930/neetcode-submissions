/*
 * Encode Strings (NeetCode)
 *
 * Store all string lengths first -> "4,2,5,#"
 * Then append all strings together.
 *
 * Decode:
 * 1. Read lengths until '#'
 * 2. Use lengths to split the remaining string.
 *
 * Why it works:
 * String contents can contain any character because boundaries
 * are determined by stored lengths, not by separators inside strings.
 */

class Solution {

    /*
     * ENCODING IDEA:
     * ----------------
     * Store the length of every string first, separated by commas,
     * then place a '#' delimiter, followed by all strings concatenated together.
     *
     * Format:
     * len1,len2,len3,#string1string2string3
     *
     * Example:
     * Input  = ["neet","code","love","you"]
     *
     * Length section:
     * 4,4,4,3,
     *
     * Data section:
     * neetcodeloveyou
     *
     * Encoded string:
     * 4,4,4,3,#neetcodeloveyou
     *
     * Time Complexity:  O(total characters)
     * Space Complexity: O(total characters)
     */
    public String encode(List<String> strs) {
        if(strs.isEmpty()){
            return "";
        }

        List<Integer> sizes = new ArrayList<>();
        StringBuilder res = new StringBuilder();

        for(String str: strs){
            sizes.add(str.length());
        }

        for(int size: sizes){
            res.append(size).append(",");
        }

        res.append("#");

        for(String str: strs){
            res.append(str);
        }

        return res.toString();
    }

    /*
     * DECODING IDEA:
     * ----------------
     * Step 1:
     * Read characters until '#' is found.
     * Extract all stored lengths.
     *
     * Example:
     * "4,4,4,3,#neetcodeloveyou"
     *
     * Lengths extracted:
     * [4, 4, 4, 3]
     *
     * Step 2:
     * Start reading after '#'.
     * Using each stored length, slice the required number
     * of characters from the string.
     *
     * Example:
     * Data portion = "neetcodeloveyou"
     *
     * size = 4 -> "neet"
     * size = 4 -> "code"
     * size = 4 -> "love"
     * size = 3 -> "you"
     *
     * Result:
     * ["neet", "code", "love", "you"]
     *
     * Time Complexity:  O(total characters)
     * Space Complexity: O(number of strings)
     */
    public List<String> decode(String str) {
        if(str.isEmpty()){
            return new ArrayList<>();
        }

        List<Integer> sizes = new ArrayList<>();
        List<String> strs = new ArrayList<>();

        int i = 0;

        while(str.charAt(i) != '#'){
            StringBuilder cur = new StringBuilder();
            while (str.charAt(i) != ',') {
                cur.append(str.charAt(i));
                i++;
            }
            sizes.add(Integer.parseInt(cur.toString()));
            i++;
        }

        i++;

        for(int size: sizes){
            strs.add(str.substring(i,i+size));
            i += size;
        }

        return strs;
    }   
}
