class Solution {

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
