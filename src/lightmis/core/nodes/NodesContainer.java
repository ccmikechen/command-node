package lightmis.core.nodes;

import java.util.*;

import lightmis.controllers.UpdateController;

public class NodesContainer extends UpdateController {

	private List<Node> nodesList = new ArrayList<Node>();
	
	public int size() {
		return nodesList.size();
	}
	
	public void addNode(Node node) {
		nodesList.add(node);
		notifyUpdate();
	}
	
	public void removeNode(int index) {
		nodesList.remove(index);
		notifyUpdate();
	}
	
	public void removeNode(Node node) {
		nodesList.remove(node);
		notifyUpdate();
	}
	
	public Node getNode(int index) {
		return nodesList.get(index);
	}
	
	
}
