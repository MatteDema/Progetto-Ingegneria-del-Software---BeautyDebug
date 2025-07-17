package boundary;

import control.ControllerGestioneProfiloCliente;

import java.awt.EventQueue;
import javax.naming.ldap.Control;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class FormRegistrazioneInserimentoDati extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nomeTextField;
    private JTextField cognomeTextField;
    private JTextField telefonoTextField;
    private JTextField indirizzoTextField;
    private JTextField emailTextField;
    private JLabel messaggiErroreLabel;

    private JLabel nomeLabel;
    private JLabel cognomeLabel;
    private JLabel emailLabel;
    private JLabel indirizzoLabel;
    private JLabel telefonoLabel;
    private JLabel disclaimerLabel;
    private JButton confermaButton;

    private static final Pattern NOME_COGNOME_PATTERN = Pattern.compile("[a-zA-ZàèìòùÀÈÌÒÙ' ]+");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    private static final Pattern INDIRIZZO_PATTERN = Pattern.compile("[a-zA-Z0-9àèìòùÀÈÌÒÙ'/. ]+");
    private static final Pattern TELEFONO_PATTERN = Pattern.compile("[0-9]+");

    /* qui il main potrebbe anche non esserci in quanto pensiamo di rendere "avviabile"
     * solo l'interfaccia iniziale.
     * */

    /*
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                FormRegistrazioneInserimentoDati frame = new FormRegistrazioneInserimentoDati();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
     */



    public FormRegistrazioneInserimentoDati() {
        setTitle("Registrazione Utente - Inserimento dati personali");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 650, 420);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        ImageIcon appIcon = new ImageIcon(getClass().getClassLoader().getResource("Centro_estetico.png"));
        setIconImage(appIcon.getImage());

        initComponents();
        setupLayout();
    }

    /**
     * Crea tutti i componenti grafici della finestra.
     *
     * In questo metodo:
     * - Creo i campi di testo (nome, cognome, email, indirizzo, telefono)
     * - Creo le etichette (label) per ogni campo
     * - Creo la label per messaggi di errore o conferma
     * - Creo la label con le istruzioni per l'utente
     * - Creo il pulsante di conferma con il suo ascoltatore (ActionListener)
     * - Aggiungo tutti questi componenti al pannello principale (contentPane)
     *
     * Non si occupa di come i componenti sono disposti nella finestra:
     * il layout viene gestito da setupLayout().
     */
    private void initComponents() {
        nomeTextField = new JTextField(20);
        cognomeTextField = new JTextField(20);
        emailTextField = new JTextField(20);
        indirizzoTextField = new JTextField(20);
        telefonoTextField = new JTextField(20);

        nomeLabel = new JLabel("<html><b>Nome</b>:</html>");
        cognomeLabel = new JLabel("<html><b>Cognome</b>:</html>");
        emailLabel = new JLabel("<html><b>Email</b>:</html>");
        indirizzoLabel = new JLabel("<html><b>Indirizzo</b>:</html>");
        telefonoLabel = new JLabel("<html><b>Telefono</b>:</html>");

        messaggiErroreLabel = new JLabel("");
        messaggiErroreLabel.setForeground(Color.RED);

        disclaimerLabel = new JLabel("<html>"
                + "Benvenuto! Inserisci i tuoi dati personali nei campi sottostanti. Assicurati che:<br>"
                + " - Il <b>Nome</b> e il <b>Cognome</b> siano corretti e contengano solo lettere.<br>"
                + " - L'<b>Email</b> sia in un formato valido (es. `nome@dominio.com`).<br>"
                + " - Il <b>Telefono</b> contenga esattamente 10 cifre numeriche.<br>"
                + " - L'<b>Indirizzo</b> sia completo di numero civico e contenga solo lettere, numeri e caratteri `/.`."
                + "</html>");
        disclaimerLabel.setForeground(new Color(0, 102, 204));

        confermaButton = new JButton("Conferma dati inseriti");
        confermaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confermaDati();
            }
        });

        contentPane.add(nomeLabel);
        contentPane.add(nomeTextField);
        contentPane.add(cognomeLabel);
        contentPane.add(cognomeTextField);
        contentPane.add(emailLabel);
        contentPane.add(emailTextField);
        contentPane.add(indirizzoLabel);
        contentPane.add(indirizzoTextField);
        contentPane.add(telefonoLabel);
        contentPane.add(telefonoTextField);
        contentPane.add(confermaButton);
        contentPane.add(messaggiErroreLabel);
        contentPane.add(disclaimerLabel);
    }

    /**
     * Organizza e dispone graficamente i componenti creati in initComponents().
     *
     * In questo metodo:
     * - Imposto il layout usando GroupLayout
     * - Posiziono le label e i campi di testo su righe ordinate
     * - Posiziono in alto la label degli errori e la label di istruzioni
     * - Posiziono in basso il pulsante di conferma
     *
     * Serve per definire l'aspetto finale della finestra.
     */
    private void setupLayout() {
        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(messaggiErroreLabel)
                        .addComponent(disclaimerLabel)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(nomeLabel)
                                        .addComponent(cognomeLabel)
                                        .addComponent(emailLabel)
                                        .addComponent(indirizzoLabel)
                                        .addComponent(telefonoLabel))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(nomeTextField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(cognomeTextField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(emailTextField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(indirizzoTextField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(telefonoTextField, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)))
                        .addComponent(confermaButton)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(disclaimerLabel)
                        .addGap(10)

                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nomeLabel)
                                .addComponent(nomeTextField))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(cognomeLabel)
                                .addComponent(cognomeTextField))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(emailLabel)
                                .addComponent(emailTextField))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(indirizzoLabel)
                                .addComponent(indirizzoTextField))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(telefonoLabel)
                                .addComponent(telefonoTextField))

                        .addGap(20)
                        .addComponent(confermaButton)
                        .addComponent(messaggiErroreLabel)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    // metodo per la INPUT VALIDATION di tutti i dati personali inseriti
    /**
     * Verifica la coerenza dei dati inseriti.
     * Questi devono rispettare la semantica definita in fase di progettazione
     */
    private void confermaDati() {
        String nome = nomeTextField.getText().trim();
        String cognome = cognomeTextField.getText().trim();
        String email = emailTextField.getText().trim();
        String indirizzo = indirizzoTextField.getText().trim();
        String telefono = telefonoTextField.getText().trim();

        if (!validaNome(nome)) {
            nomeTextField.requestFocusInWindow();
            return;
        }
        if (!validaCognome(cognome)) {
            cognomeTextField.requestFocusInWindow();
            return;
        }
        if (!validaEmail(email)) {
            emailTextField.requestFocusInWindow();
            return;
        }
        if (!validaIndirizzo(indirizzo)) {
            indirizzoTextField.requestFocusInWindow();
            return;
        }
        if (!validaTelefono(telefono)) {
            telefonoTextField.requestFocusInWindow();
            return;
        }


        // chiama il metodo registrazione del ControllerGestioneProfiloCliente per avviare la registrazione (verificando la email)
        // Ottengo l'unica istanza della classe Singleton ControllerGestioneProfiloCliente
        ControllerGestioneProfiloCliente controller_profilo_cliente= ControllerGestioneProfiloCliente.getControllerGestioneProfiloCliente();
        boolean email_gia_presente = controller_profilo_cliente.registrazione(email);

        if(!email_gia_presente){
            messaggiErroreLabel.setForeground(new Color(0, 102, 204));
            messaggiErroreLabel.setText("Dati personali validati! Ora inserisci le credenziali");
            FormRegistrazioneInserimentoCredenziali credenzialiPane = new FormRegistrazioneInserimentoCredenziali(this, capitalizeEachWord(nome), capitalizeEachWord(cognome), email.toLowerCase(), indirizzo, telefono);
        } else {
            messaggiErroreLabel.setForeground(Color.RED);
            messaggiErroreLabel.setText("Dati personali validati ma email già presente nel sistema! Scegliere un'altra email");
            emailTextField.requestFocusInWindow();
        }
    }


    private boolean validaNome(String nome) {
        if (nome.isEmpty()) {
            setErrore("Il campo Nome non può essere vuoto.");
            return false;
        } else if (!NOME_COGNOME_PATTERN.matcher(nome).matches()) {
            setErrore("Il Nome contiene caratteri non validi. Usa solo lettere e apostrofi.");
            return false;
        } else if (nome.length() < 2) {
            setErrore("Nome troppo corto. Minimo 2 caratteri.");
            return false;
        } else if (nome.length() > 30) {
            setErrore("Nome troppo lungo. Massimo 30 caratteri.");
            return false;
        }
        return true;
    }

    private boolean validaCognome(String cognome) {
        if (cognome.isEmpty()) {
            setErrore("Il campo Cognome non può essere vuoto.");
            return false;
        } else if (!NOME_COGNOME_PATTERN.matcher(cognome).matches()) {
            setErrore("Il Cognome contiene caratteri non validi. Usa solo lettere e apostrofi.");
            return false;
        } else if (cognome.length() < 2) {
            setErrore("Cognome troppo corto. Minimo 2 caratteri.");
            return false;
        } else if (cognome.length() > 30) {
            setErrore("Cognome troppo lungo. Massimo 30 caratteri.");
            return false;
        }
        return true;
    }

    private boolean validaEmail(String email) {
        if (email.isEmpty()) {
            setErrore("Il campo Email non può essere vuoto.");
            return false;
        } else if (!EMAIL_PATTERN.matcher(email).matches()) {
            setErrore("Il formato dell'email non è valido. Es: utente@esempio.com");
            return false;
        }
        return true;
    }

    private boolean validaIndirizzo(String indirizzo) {
        if (indirizzo.isEmpty()) {
            setErrore("Il campo Indirizzo non può essere vuoto.");
            return false;
        } else if (indirizzo.length() < 7) {
            setErrore("Indirizzo troppo corto. Inserisci l'indirizzo completo con numero civico.");
            return false;
        } else if (indirizzo.length() > 40) {
            setErrore("Indirizzo troppo lungo. Massimo 40 caratteri.");
            return false;
        } else if (!INDIRIZZO_PATTERN.matcher(indirizzo).matches()) {
            setErrore("L'Indirizzo contiene caratteri non ammessi. Usa lettere, numeri, spazi e i caratteri '/' e '.'.");
            return false;
        } else if (!indirizzo.matches(".*[0-9].*")) {
            setErrore("L'Indirizzo deve contenere un numero civico.");
            return false;
        }
        return true;
    }

    private boolean validaTelefono(String telefono) {
        if (telefono.isEmpty()) {
            setErrore("Il campo Telefono non può essere vuoto.");
            return false;
        } else if (!TELEFONO_PATTERN.matcher(telefono).matches()) {
            setErrore("Il Telefono deve contenere solo cifre numeriche.");
            return false;
        } else if (telefono.length() != 10) {
            setErrore("Il numero di Telefono deve essere di 10 cifre.");
            return false;
        }
        return true;
    }

    /**
     * Mostra un messaggio di errore nella label dedicata,
     * impostando il testo in rosso.
     */
    private void setErrore(String messaggio) {
        messaggiErroreLabel.setForeground(Color.RED);
        messaggiErroreLabel.setText("Attenzione: " + messaggio);
    }

    /**
     * Converte la stringa in lowercase e mette la prima lettera di ogni parola in maiuscolo.
     * Es: "mario rossi" -> "Mario Rossi"
     */
    private static String capitalizeEachWord(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.toLowerCase().split("\\s+");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }

        return capitalized.toString().trim(); // rimuove spazio finale
    }

}