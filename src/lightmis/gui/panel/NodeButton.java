package lightmis.gui.panel;

import javax.swing.JButton;

import lightmis.core.nodes.Node;

public class NodeButton extends JButton {

	private Node node;
	
	public NodeButton(Node node) {
		this.node = node;
		this.setText(node.getName());
	}
	
	public Node getNode() {
		return node;
	}
}
