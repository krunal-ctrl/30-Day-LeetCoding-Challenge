/*
Given an array of strings, group anagrams together.
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //map of sorted String and a list of strings
        Map<String, List> mapping = new HashMap<String, List>();

        for(int i=0; i< strs.length; i++) {
            char arrayString[] = strs[i].toCharArray();

            Arrays.sort(arrayString);

            String sortedString = new String(arrayString);

            if(!mapping.containsKey(sortedString)) {
                mapping.put(sortedString, new ArrayList());
            }
            mapping.get(sortedString).add(strs[i]);
        }

        return new ArrayList(mapping.values());

    }
}
