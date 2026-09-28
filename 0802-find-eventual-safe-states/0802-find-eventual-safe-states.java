class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        ArrayList<ArrayList<Integer>> adjRev=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjRev.add(new ArrayList<>());
        }

        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int it:graph[i]){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> safenode=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node=q.remove();
            safenode.add(node);
            for(int it:adjRev.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }


        Collections.sort(safenode);
        return safenode;
    }
}