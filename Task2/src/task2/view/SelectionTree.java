package task2.view;

import task2.model.Computer;
import task2.model.Equipment;
import task2.service.XmlService;
import task2.service.impl.XmlServiceImpl;
import task2.view.listener.ExitListener;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;

public class SelectionTree extends JFrame implements TreeSelectionListener {
	private JTree tree;
	private JTextField currentSelectionField;

	public SelectionTree() {
		super("Equipment");

		XmlService service = new XmlServiceImpl();
		Equipment equipment = service.getInformationFromXml();

		addWindowListener(new ExitListener());
		Container content = getContentPane();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Equipment");
		DefaultMutableTreeNode ch = new DefaultMutableTreeNode("Computers");
		root.add(ch);
		DefaultMutableTreeNode computerNode, hardwareNode, softwareNode;

		for (Computer computer : equipment.getComputers().getComputers()) {
			computerNode = new DefaultMutableTreeNode("Computer -> " + computer.getId());
			ch.add(computerNode);
			hardwareNode = new DefaultMutableTreeNode("Hardware -> " + computer.getHardware().getCpu() + " - " + computer.getHardware().getHdd());
			computerNode.add(hardwareNode);
			softwareNode = new DefaultMutableTreeNode("Software -> " + computer.getSoftware());
			computerNode.add(softwareNode);
		}

		tree = new JTree(root);
		tree.addTreeSelectionListener(this);
		content.add(new JScrollPane(tree), BorderLayout.CENTER);
		currentSelectionField = new JTextField("Информация о данных: отсутствует");
		content.add(currentSelectionField, BorderLayout.SOUTH);
		setSize(300, 300);
		setVisible(true);
	}

	public void valueChanged(TreeSelectionEvent e) {
		currentSelectionField.setText("Информация о данных: " + tree.getLastSelectedPathComponent().toString());
	}
}
    
