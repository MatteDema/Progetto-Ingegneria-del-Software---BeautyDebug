package boundary;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FormHomePageCliente extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private String username;

    public FormHomePageCliente(String username) {

        this.username = username;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon appIcon = new ImageIcon(getClass().getClassLoader().getResource("Centro_estetico.png"));
        setIconImage(appIcon.getImage());

    }

}
