import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Dialog extends JDialog {
    ArrayList<ProductData.Product> productData;
    JTextField name;
    JTextField country;
    JTextField count;
    JButton add;

    Window parent;

    Dialog(Window parent){
        super();
        this.parent = parent;
        setBounds(500, 400,100, 200);
        setResizable(false);
        setLayout(new FlowLayout());
        textFields();
        setVisible(true);

        add = new JButton("Add");
        add(add);
        add.addActionListener(e -> {
            try {
                if (Objects.equals(name.getText(), "") || Objects.equals(country.getText(), "")) {
                    throw new NullPointerException("data is invalid");
                }
                parent.productData.addProduct(name.getText(), country.getText(), Integer.parseInt(count.getText()));
                parent.execute(productData);
            }catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (CloneNotSupportedException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    void textFields() {
        name = new JTextField("name");
        name.setBounds(getSize().width / 2 - 250 - name.getSize().width / 2, getSize().height / 3 - 100, 100, 30);
        add(name);

        country = new JTextField("country");
        country.setBounds(getSize().width / 2 - 250 - country.getSize().width / 2, getSize().height / 3 - 50, 100, 30);
        add(country);

        count = new JTextField("count");
        count.setBounds(getSize().width / 2 - 250 - count.getSize().width / 2, getSize().height / 3, 100, 30);
        add(count);
    }
}
