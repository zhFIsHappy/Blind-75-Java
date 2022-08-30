class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            String hashCode = decoding(s);
            if(!map.containsKey(hashCode)){
                map.put(hashCode, new ArrayList<>());
            }
            map.get(hashCode).add(s);
        }`
        return new ArrayList<>(map.values());
    }
    private String decoding(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
    
}
// Time Complexity: O(n)
// Space Complexity: O(n)