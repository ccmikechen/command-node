package lightmis.gui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import lightmis.core.nodes.Node;
import lightmis.core.nodes.NodesContainer;
import lightmis.listener.UpdateListener;

public class NodesListModel extends DefaultListModel<NodeButton> implements UpdateListener {

	public NodesContainer nodesContainer;

	public NodesListModel(NodesContainer nodesContainer) {
		this.nodesContainer = nodesContainer;
		nodesContainer.addUpdateListener(this);
	}
	
	@Override
	public void update() {
		this.clear();
		for (int i = 0; i < nodesContainer.size(); i++) {
			Node node = nodesContainer.getNode(i);
			NodeButton nodeButton = new NodeButton(node);
			this.addElement(nodeButton);
		}
	}
	
}