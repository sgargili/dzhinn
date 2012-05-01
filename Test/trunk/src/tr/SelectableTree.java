package tr;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import tr.service.XmlService;
import tr.service.impl.XmlServiceImpl;
import tr.model.Person;
import tr.model.Persons;

/**
 * JTree that reports selections by placing their string values
 * in a JTextField.
 * 1999 Marty Hall, http://www.apl.jhu.edu/~hall/java/
 */

public class SelectableTree extends JFrame implements TreeSelectionListener {
    public static void main(String[] args) {
        new SelectableTree();
    }

    private JTree tree;

    private JTextField currentSelectionField;




    public SelectableTree() {
        super("Persons");

        XmlService service = new XmlServiceImpl();
        Persons persons = service.getPersonsFromXml();
//        WindowUtilities.setNativeLookAndFeel();
        addWindowListener(new ExitListener());
        Container content = getContentPane();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Persons");
        DefaultMutableTreeNode child;
        DefaultMutableTreeNode grandChild;

        for(Person person : persons.getPersons()) {
            child = new DefaultMutableTreeNode("Person");
            root.add(child);
            grandChild = new DefaultMutableTreeNode(person.getName());
            child.add(grandChild);
            grandChild = new DefaultMutableTreeNode(person.getSurname());
            child.add(grandChild);
            grandChild = new DefaultMutableTreeNode(person.getAge());
            child.add(grandChild);
        }

//        for (int childIndex = 1; childIndex < 4; childIndex++) {
//            child = new DefaultMutableTreeNode("Child " + childIndex);
//            root.add(child);
//            for (int grandChildIndex = 1; grandChildIndex < 4; grandChildIndex++) {
//                grandChild =
//                        new DefaultMutableTreeNode("Grandchild " + childIndex +
//                                "." + grandChildIndex);
//                child.add(grandChild);
//            }
//        }
        tree = new JTree(root);
        tree.addTreeSelectionListener(this);
        content.add(new JScrollPane(tree), BorderLayout.CENTER);
        currentSelectionField = new JTextField("Current Selection: NONE");
        currentSelectionField.setSize(150, 150);
        content.add(currentSelectionField, BorderLayout.SOUTH);
        setSize(600, 600);
        setVisible(true);
    }

    public void valueChanged(TreeSelectionEvent event) {
        currentSelectionField.setText
                ("Current Selection: " + tree.getLastSelectedPathComponent().toString());
    }
}
    
