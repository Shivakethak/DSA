
class Solution {
    public String findOrder(String[] words) {
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }
      int[] indegree = new int[26];
      boolean[] present  = new boolean[26];
      for(String word: words){
          for(char c:word.toCharArray()){
              present[c-'a'] = true;
          }
      }
      for(int i=0;i<words.length-1;i++){
          String s1 = words[i];
          String s2 = words[i+1];
          int j = 0;
          int len = Math.min(s1.length() ,s2.length());
          while(j<len && s1.charAt(j)==s2.charAt(j)){
              j++;
          }
          if(j==len){
              if(s1.length()>s2.length()) return "";
              continue;
          }
          int u = s1.charAt(j)-'a';
          int v = s2.charAt(j)-'a';
          if(!adj.get(u).contains(v)){
              adj.get(u).add(v);
              indegree[v]++;
          }
      }
          Queue<Integer> q = new LinkedList<>();
          for(int i=0;i<26;i++){
              if(present[i]&&indegree[i]==0){
                  q.offer(i);
              }
          }
          StringBuilder order = new StringBuilder();
          int count =0;
          while(!q.isEmpty()){
              int node = q.poll();
              order.append((char)(node+'a'));
              count++;
              for(int neigh:adj.get(node)){
                  indegree[neigh]--;
                  if(indegree[neigh]==0){
                      q.offer(neigh);
                  }
              }
          }
          int totalChars =0;
          for(boolean b: present){
              if(b) totalChars++;
          }
          if(count!=totalChars){
              return "";
          }
          return order.toString();
      }
      
}