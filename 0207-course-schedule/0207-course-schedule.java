class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge:prerequisites){
            int u=edge[0];
            int v=edge[1];
            adjList.get(u).add(v);
        }

        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adjList.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }


        ArrayList<Integer> topo=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.remove();
            topo.add(node);

            for(int it:adjList.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }

        return topo.size()==numCourses;
        
    }
}