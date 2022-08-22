import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TableFrame extends JFrame {
    private JTable table;

    public TableFrame() {
        List<Medicine> medicineList = DBConnection.findAll();
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Name", "Price", "Type"}, 0);
        if (medicineList != null) {
            medicineList.forEach(medicine -> {
                model.addRow(new Object[]{medicine.getId(), medicine.getName(), medicine.getPrice(), medicine.getType()});
            });
        }

        table = new JTable();
        table.setFont(new Font("Arial", Font.PLAIN, 20));
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 30));
        table.setModel(model);

        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(2).setPreferredWidth(5);
        table.setRowHeight(25);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("List of Medicine");
        //this.setLocation(650, 330);
        this.setSize(600, 350);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane);
    }
}
