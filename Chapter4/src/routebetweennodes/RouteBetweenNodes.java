package routebetweennodes;

public class RouteBetweenNodes<T> {

    public boolean checkRouteConnected(DirectedGraph<T> graph, T node1, T node2) {
        if (!graph.contains(node1) && !graph.contains(node2))
            return false;
        return graph.getNode(node1).getChildren().contains(node2) && graph.getNode(node2).getChildren().contains(node1);
    }
}
