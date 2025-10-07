import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind(n+1);
        int[] res = new int[n];
        Arrays.fill(res, 1);

        for(int i = 0; i<n; i++){
            int lake = rains[i];
            if(lake == 0) continue;

            res[i] = -1;
            uf.unite(i);

            if(map.containsKey(lake)){
                int prev = map.get(lake);
                int dry = uf.find(prev+1);

                if(dry >= i) return new int[0];
                res[dry] = lake;
                uf.unite(dry);
            }
            map.put(lake, i);
        }
        return res;
    }
    class UnionFind{
        int[] parent;
        public UnionFind(int n){
            parent = new int[n+1];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }

        public int find(int n){
            if(parent[n] != n){
                parent[n] = find(parent[n]);
            }
            return parent[n];
        }

        public void unite(int n){
            parent[n] = find(n+1);
        }
    }
}