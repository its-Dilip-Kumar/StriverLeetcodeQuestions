class Pair{
    String word;
    int steps;
    public Pair(String word,int steps){
        this.word=word;
        this.steps=steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        HashSet<String> set=new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }

        q.add(new Pair(beginWord,1));
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair curr=q.remove();
            String word=curr.word;
            int steps=curr.steps;

            if(word.equals(endWord)) return steps;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedCharArray=word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord=new String(replacedCharArray);

                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}