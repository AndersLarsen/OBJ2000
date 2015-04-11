package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class WestPanel extends JPanel {
	JTree theTree;
	GridBagConstraints gbc;

	public WestPanel() {
//		Dimension size = getPreferredSize();
//		size.width = 400;
//		setPreferredSize(new Dimension(size));
		setBackground(new Color(120,150,200));
		setBorder(new EmptyBorder(30, 30, 30, 30));
		setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();

	}
	
	public void setTree(JTree tree){
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.weightx = 0;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		theTree = tree;
		theTree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		theTree.setVisibleRowCount(20);
//		final Font currentFont = theTree.getFont();
//		final Font bigFont = new Font(currentFont.getName(), currentFont.getStyle(), currentFont.getSize() + 10);
//		theTree.setFont(bigFont);
//		theTree.setShowsRootHandles(true);
		
		expandAll2Last(theTree);
		
		
		JScrollPane ScrollPaneTree = new JScrollPane(theTree);
//		Dimension size = getPreferredSize();
//		size.width = 400;
//		size.height = 600;
		ScrollPaneTree.setPreferredSize(new Dimension(400,400));
		
		add(ScrollPaneTree, gbc);

	}
	
	//http://objectmix.com/java/73090-how-auto-expand-jtree.html
	//må endre på denne, åpner den siste noden i hvert nivå. Skal bare åpne første noden fra root
	public void expandAll2Last(JTree tree) {
		TreeModel data = tree.getModel();
		Object node = data.getRoot();
		if (node == null) {
			return;
		}
		TreePath p = new TreePath(node);

		while (true) {
			int count = data.getChildCount(node);
			if (count == 0) {
				break;
			}
			node = data.getChild(node, count - 1);
			p = p.pathByAddingChild(node);
		}
		tree.scrollPathToVisible(p);
	}

}
