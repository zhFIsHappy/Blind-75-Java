class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        List<Node> nodes = findNodesByBFS(node);
        Map<Node, Node> mapping = copyNode(nodes);
        copyEdges(nodes, mapping);
        return mapping.get(node);
    }
    
    private List<Node> findNodesByBFS(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        Set<Node> visited  = new HashSet<>();
        queue.offer(node);
        visited.add(node);
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            for(Node neighbor: curNode.neighbors){
                if(visited.contains(neighbor)){
                    continue;
                }
                queue.offer(neighbor);
                visited.add(neighbor);
            }
        }
        return new LinkedList<>(visited);
    }
    
    private Map<Node,Node> copyNode(List<Node> nodes){
        Map<Node, Node> map= new HashMap<>();
        for(Node node : nodes){
            map.put(node, new Node(node.val));
        }
        return map;
    }
    // 拿到copy后的node 然后copy edge
    private void copyEdges(List<Node> nodes, Map<Node, Node> mapping){
        for(Node node: nodes){
            Node newNode = mapping.get(node); 
            for(Node neighbor: node.neighbors){
                Node newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
    }
}

//Time Complexity:O(V+E) V is the number of vertex, E is the number of Edge
//Space Complexity:O(N)