import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class AppGestion <T> extends JFrame {

    private DAO<T> dao;

    private JButton createButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JTextField searchField;
    private JComboBox<String> attributeBox ;
    private JTable table;
    private JPanel searchPanel,tablePanel,buttonPanel;
    
    public AppGestion(DAO<T> dao, String[] attributes) {
        super( "Gestion du base de donnée");
        this.setSize(500,400);
        this.setAutoRequestFocus(rootPaneCheckingEnabled);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.ABORT);
        this.setLayout(new BorderLayout());
        this.dao = dao;

        buttonPanel = new JPanel();
        searchPanel = new JPanel();
        tablePanel = new JPanel();

        add(searchPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        createButton = new JButton("Créer");
        updateButton = new JButton("Modifier");
        deleteButton = new JButton("Supprimer");
        searchButton = new JButton("Rechercher");
        attributeBox = new JComboBox<String>(attributes);

        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(createButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        searchPanel.setLayout(new FlowLayout());
        searchField = new JTextField(30);
        searchPanel.add(searchField );
        searchPanel.add(attributeBox);
        searchPanel.add(searchButton);


        table = createTable(dao.findAll());
        tablePanel.add(table);

    }
    
    /*Creates a JTable with the given data (ArrayList) and it's stolen */
    public JTable createTable(ArrayList<T> list) {
        // Create a vector to store the column names
        Vector<String> columnNames = new Vector<String>();

        // Get the fields of the generic type T and add their names to the columnNames vector
        Field[] fields = list.get(0).getClass().getDeclaredFields();
        for (Field field : fields) {
            columnNames.add(field.getName());
        }

        // Create a vector to store the data
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        // Loop through the list and add each object's field values to a new vector
        for (T object : list) {
            Vector<Object> row = new Vector<Object>();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(object);
                    row.add(value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            data.add(row);
        }

        // Create a new DefaultTableModel with the columnNames and data vectors
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create a new JTable with the DefaultTableModel and return it
        return new JTable(model);
    }
}

           