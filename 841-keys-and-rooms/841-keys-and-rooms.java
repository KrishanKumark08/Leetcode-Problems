class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int n = rooms.size();
        HashSet<Integer> visitedSet = new HashSet<>();
        visitingRooms(rooms, visitedSet, new boolean[rooms.size()], 0);
        return visitedSet.size() == n;
    }
    
    private void visitingRooms(List<List<Integer>> rooms, HashSet<Integer> visitedSet, boolean[] visited, int currentRoom){
        if(visited[currentRoom]){
            return;
        }
        
        visited[currentRoom] = true;
        visitedSet.add(currentRoom);
        for(int key:rooms.get(currentRoom)){
            visitingRooms(rooms, visitedSet, visited, key);
        }
        
        return;
        
    }
    
}