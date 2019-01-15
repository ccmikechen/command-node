package lightmis.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import lightmis.core.nodes.Node;
import lightmis.core.nodes.NodesContainer;

public class NodesPanel extends JPanel {

	private NodesContainer nodes;
	
	private JPanel optionsPanel;
	private JList<NodeButton> nodesList;
	private NodesListModel nodesListModel;
	
	public NodesPanel() {
		this.setLayout(new BorderLayout());
		
		nodesList = new JList<NodeButton>();
		nodesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		nodesList.setCellRenderer(new NodeButtonRenderer());
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.add(nodesList);
		this.add(scrollPane, BorderLayout.CENTER);
	
		nodesList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Node node = nodesList.getSelectedValue().getNode();
				if (e.getValueIsAdjusting()) System.out.println(node.getName());
			}
		});
		
		JButton addNodeButton = new JButton("Add Node");
		addNodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Node node = new Node("New Node");
				nodes.addNode(node);
			}
		});
		optionsPanel = new JPanel();
		optionsPanel.add(addNodeButton);
		this.add(optionsPanel, BorderLayout.NORTH);
	}
	
	public void setNodesContainer(NodesContainer nodes) {
		this.nodes = nodes;
		nodesListModel = new NodesListModel(nodes);
		nodesList.setModel(nodesListModel);
	}

	class NodeButtonRenderer implements ListCellRenderer<NodeButton> {

		@Override
		public Component getListCellRendererComponent(JList list, NodeButton value, int index, boolean isSelected,
				boolean cellHasFocus) {		
			if (isSelected) {
				value.setBackground(Color.GRAY);
			} else {
				value.setBackground(Color.WHITE);
			}
			return value;
		}
		
	}
	
}
