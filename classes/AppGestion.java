import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class AppGestion <T> extends JFrame {

    private DAO<T> dao;
    private String[] attributes;
    private JButton createButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JTextField searchField;
    private JComboBox<String> attributeBox ;
    private JPanel searchPanel,buttonPanel,tablePanel;
    private JScrollPane tablePane;
    
    public AppGestion(DAO<T> dao, String[] attributes) {
        super( "Gestion du base de donnée");
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.dao = dao;
        this.attributes=attributes;

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
        tablePane = new JScrollPane( createTable(dao.findAll()));


        tablePanel.add(tablePane);
        
        pack();
    }
    
    /*Creates a JTable with the given data (ArrayList) and it's stolen */
    public JTable createTable(ArrayList<T> list) {
        if(list.isEmpty()){
            return null;
        }
        // Create an array to store the column names
        String[] columnNames = new String[list.get(0).getClass().getDeclaredFields().length];

        // Get the fields of the generic type T and add their names to the columnNames array
        Field[] fields = list.get(0).getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            columnNames[i] = fields[i].getName();
        }

        // Create a 2D array to store the data
        Object[][] data = new Object[list.size()][columnNames.length];

        // Loop through the list and add each object's field values to a new row in the data array
        for (int i = 0; i < list.size(); i++) {
            T object = list.get(i);
            for (int j = 0; j < columnNames.length; j++) {
                try {
                    Field field = fields[j];
                    field.setAccessible(true);
                    Object value = field.get(object);
                    data[i][j] = value;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // Create a new DefaultTableModel with the columnNames and data arrays
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create a new JTable with the DefaultTableModel and return it
        return new JTable(model);
    }

}

           