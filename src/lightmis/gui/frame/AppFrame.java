package lightmis.gui.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import lightmis.core.nodes.Node;
import lightmis.core.nodes.NodesContainer;
import lightmis.gui.panel.NodesPanel;

public class AppFrame extends JFrame {

	private static final String DEFAULT_APP_TITLE = "Command Node";
	private static final int DEFAULT_APP_WIDTH = 1024;
	private static final int DEFAULT_APP_HEIGHT = 768;
	
	private static final AppFrame APP_FRAME_INSTANCE =
			new AppFrame(DEFAULT_APP_TITLE, DEFAULT_APP_WIDTH, DEFAULT_APP_HEIGHT);

	
	private AppFrame(String title, int width, int height) {
		super(title);
		this.setSize(width, height);
		this.setLayout(new BorderLayout());
		
		
		JPanel tablePanel = new JPanel();
		NodesPanel nodesPanel = new NodesPanel();
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, nodesPanel, tablePanel);
		
		
		this.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		NodesContainer nodes = new NodesContainer();
		nodesPanel.setNodesContainer(nodes);
		for (int i = 0; i < 10; i++)
			nodes.addNode(new Node("Node " + i));
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	public static AppFrame getInstance() {
		return APP_FRAME_INSTANCE;
	}
	
	public static void main(String[] args) {
		AppFrame appFrame = AppFrame.getInstance();
		
		appFrame.setVisible(true);
	}
	
}
