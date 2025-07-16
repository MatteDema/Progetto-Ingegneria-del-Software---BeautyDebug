package boundary;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class FormHomePage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel errorLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormHomePage frame = new FormHomePage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public FormHomePage() {

         /*
            Crea un oggetto ImageIcon caricando l’immagine "Centro_estetico.png" dalla cartella resources del progetto
            (usando il class loader per trovarla nel classpath) e imposto l’immagine caricata come icona principale della
            finestra (ad esempio per un JFrame).
         */
        ImageIcon appIcon = new ImageIcon(getClass().getClassLoader().getResource("Centro_estetico.png"));
        setIconImage(appIcon.getImage());


        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        // Questo metodo centra la finestra nello schermo
        // I primi due argomenti di setBounds vengono ignorati se uso questo metodo
        setLocationRelativeTo(null);


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());

        JLabel titoloLabel = new JLabel("BeautyDebug");
        titoloLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        Color colore_titolo = new Color(0x9783B4);
        titoloLabel.setForeground(colore_titolo);

        GridBagConstraints gbcTitolo = new GridBagConstraints();
        gbcTitolo.insets = new Insets(10, 10, 10, 10);
        gbcTitolo.gridx = 0;
        gbcTitolo.gridy = 0;
        gbcTitolo.gridwidth = 2;
        gbcTitolo.anchor = GridBagConstraints.CENTER;
        contentPane.add(titoloLabel, gbcTitolo);

        JLabel usernameLabel = new JLabel("Username:");
        GridBagConstraints gbcUsernameLabel = new GridBagConstraints();
        gbcUsernameLabel.insets = new Insets(10, 10, 10, 10);
        gbcUsernameLabel.gridx = 0;
        gbcUsernameLabel.gridy = 1;
        gbcUsernameLabel.anchor = GridBagConstraints.EAST;
        contentPane.add(usernameLabel, gbcUsernameLabel);

        usernameField = new JTextField(20);
        GridBagConstraints gbcUsernameField = new GridBagConstraints();
        gbcUsernameField.insets = new Insets(10, 10, 10, 10);
        gbcUsernameField.gridx = 1;
        gbcUsernameField.gridy = 1;
        gbcUsernameField.anchor = GridBagConstraints.WEST;
        contentPane.add(usernameField, gbcUsernameField);

        JLabel passwordLabel = new JLabel("Password:");
        GridBagConstraints gbcPasswordLabel = new GridBagConstraints();
        gbcPasswordLabel.insets = new Insets(10, 10, 10, 10);
        gbcPasswordLabel.gridx = 0;
        gbcPasswordLabel.gridy = 2;
        gbcPasswordLabel.anchor = GridBagConstraints.EAST;
        contentPane.add(passwordLabel, gbcPasswordLabel);

        passwordField = new JPasswordField(20);
        GridBagConstraints gbcPasswordField = new GridBagConstraints();
        gbcPasswordField.insets = new Insets(10, 10, 10, 10);
        gbcPasswordField.gridx = 1;
        gbcPasswordField.gridy = 2;
        gbcPasswordField.anchor = GridBagConstraints.WEST;
        contentPane.add(passwordField, gbcPasswordField);

        JButton btnLoginUtente = new JButton("Login Utente");
        GridBagConstraints gbcBtnLoginUtente = new GridBagConstraints();
        gbcBtnLoginUtente.insets = new Insets(10, 10, 10, 10);
        gbcBtnLoginUtente.gridx = 0;
        gbcBtnLoginUtente.gridy = 3;
        gbcBtnLoginUtente.gridwidth = 2;
        gbcBtnLoginUtente.anchor = GridBagConstraints.CENTER;
        contentPane.add(btnLoginUtente, gbcBtnLoginUtente);

        btnLoginUtente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ho premuto il bottone LoginUtente");
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // utilizziamo l'username di un cliente che è già presente nel nostro database (pippozzo)
                // in questo modo la nostra applicazione funzionerà, poiché non abbiamo implementato la funzionalità di accesso
                FormHomePageCliente finestra_cliente= new FormHomePageCliente("pippozzo");
                finestra_cliente.setVisible(true);

                // logica di autenticazione utente

                if(username.isEmpty() || password.isEmpty()) {
                    setError("Inserisci username e password!");
                } else {
                    setError(""); //pulisce errori precedenti

                    /*
                     * if(nome utente non esiste nel sistema){
                     *     setError("L'utente con questo username non risulta registrato nel sistema.\nUtilizza un username valido oppure registrati.");
                     * } else{
                     * 		if(username e password non combaciano){
                     * 			setError("Password sbagliata, riprovare.");
                     * 		} else{
                     * 			System.out.println("Login utente effettuato con: " + username);
                     *           FormHomePageCliente finestra_cliente= new FormHomePageCliente(username);
                     *           finestra_cliente.setVisible(true);
                     * 		}
                     * }
                     */
                }
            }
        });

        JButton btnLoginAmministratore = new JButton("Login Amministratore");
        GridBagConstraints gbcBtnLoginAdmin = new GridBagConstraints();
        gbcBtnLoginAdmin.insets = new Insets(10, 10, 10, 10);
        gbcBtnLoginAdmin.gridx = 0;
        gbcBtnLoginAdmin.gridy = 4;
        gbcBtnLoginAdmin.gridwidth = 2;
        gbcBtnLoginAdmin.anchor = GridBagConstraints.CENTER;
        contentPane.add(btnLoginAmministratore, gbcBtnLoginAdmin);

        btnLoginAmministratore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ho premuto il bottone Login Amministratore");
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                /*
                FormHomePageAmministratore finestra_amministratore = new FormHomePageAmministratore();
                finestra_amministratore.setVisible(true);
                */
                // logica di autenticazione amministratore

                if(username.isEmpty() || password.isEmpty()) {
                    setError("Inserisci username e password");
                } else {
                    setError(""); //pulisce errori precedenti
                    //System.out.println("Login amministratore effettuato con: " + username);
                }
            }
        });

        // Pannello interno per testo “Non sei registrato? Registrati qui”

        JPanel registrazionePanel = new JPanel();
        registrazionePanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        JLabel lblNonRegistrato = new JLabel("Non sei registrato? ");
        registrazionePanel.add(lblNonRegistrato);

        JLabel lblRegistratiQui = new JLabel("<html><u>Registrati qui</u></html>");
        lblRegistratiQui.setForeground(java.awt.Color.BLUE);
        lblRegistratiQui.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegistratiQui.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                // Apertura della finestra di registrazione utente
                System.out.println("Registrazione cliccata");
                FormRegistrazioneInserimentoDati finestra = new FormRegistrazioneInserimentoDati();
                finestra.setVisible(true);
            }
        });
        registrazionePanel.add(lblRegistratiQui);

        GridBagConstraints gbcRegistrazionePanel = new GridBagConstraints();
        gbcRegistrazionePanel.insets = new Insets(10, 10, 10, 10);
        gbcRegistrazionePanel.gridx = 0;
        gbcRegistrazionePanel.gridy = 5;
        gbcRegistrazionePanel.gridwidth = 2;
        gbcRegistrazionePanel.anchor = GridBagConstraints.CENTER;
        contentPane.add(registrazionePanel, gbcRegistrazionePanel);

        errorLabel = new JLabel("");
        errorLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        errorLabel.setForeground(java.awt.Color.RED);
        GridBagConstraints gbcErrorLabel = new GridBagConstraints();
        gbcErrorLabel.insets = new Insets(10, 10, 10, 10);
        gbcErrorLabel.gridx = 0;
        gbcErrorLabel.gridy = 6;
        gbcErrorLabel.gridwidth = 2;
        gbcErrorLabel.anchor = GridBagConstraints.CENTER;
        contentPane.add(errorLabel, gbcErrorLabel);
    }

    public void setError(String message) {
        errorLabel.setText(message);
    }
}
