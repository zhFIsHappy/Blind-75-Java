class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        if(s.length() != t.length()) return false;
        for(int i =0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1);
            }else{
                map.put(s.charAt(i), map.get(s.charAt(i)) +1);
            }
        }
        
        for(int j =0 ; j < t.length(); j++){
            if(!map.containsKey(t.charAt(j))){
                return false;
            }else{
                map.put(t.charAt(j), map.get(t.charAt(j)) -1);
                if(map.get(t.charAt(j)) < 0){
                    return false;
                }
            }
        }
        return true;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)