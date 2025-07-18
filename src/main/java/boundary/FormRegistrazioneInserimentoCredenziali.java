package boundary;

import control.ControllerGestioneProfiloCliente;

import java.awt.*;
import java.util.regex.Pattern;
import javax.swing.*;

public class FormRegistrazioneInserimentoCredenziali extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final Pattern USERNAME_PATTERN = Pattern.compile("[A-Za-z0-9_]{6,30}");

    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confermaPasswordField;
    private JCheckBox showPasswordCheckBox;

    // private String nome;
    // private String cognome;
    // private String email;
    // private String indirizzo;
    // private String telefono;
    // private FormRegistrazioneInserimentoDati finestraPrecedente;

    public FormRegistrazioneInserimentoCredenziali(FormRegistrazioneInserimentoDati finestraPrecedente, String nome, String cognome, String email, String indirizzo, String telefono) {
        // this.finestraPrecedente = finestraPrecedente;
        // this.nome = nome;
        // this.cognome = cognome;
        // this.email = email;
        // this.indirizzo = indirizzo;
        // this.telefono = telefono;

        debugDatiPersonali(nome, cognome, email, indirizzo, telefono);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        panel = new JPanel(new java.awt.GridLayout(4, 2, 5, 5));
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        confermaPasswordField = new JPasswordField(20);
        showPasswordCheckBox = new JCheckBox("Mostra Password");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Conferma Password:"));
        panel.add(confermaPasswordField);
        panel.add(new JLabel(""));
        panel.add(showPasswordCheckBox);

        showPasswordCheckBox.addActionListener(e -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
                confermaPasswordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
                confermaPasswordField.setEchoChar('*');
            }
        });

        boolean credenzialiValide = false;

        while (!credenzialiValide) {
            int result = JOptionPane.showConfirmDialog(this, panel,
                    "Registrazione Utente - Inserimento credenziali", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result != JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this,
                        "Inserimento credenziali annullato dall'utente.",
                        "", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword());
            String confermaPassword = new String(confermaPasswordField.getPassword());

            StringBuilder erroreCredenziali = new StringBuilder();

            if (!validaUsername(username, erroreCredenziali)) {
                // messaggio aggiunto in StringBuilder
            }
            if (!validaPassword(password, erroreCredenziali)) {
                // messaggio aggiunto in StringBuilder
            }
            if (!password.equals(confermaPassword)) {
                erroreCredenziali.append("- Le password non corrispondono.\n");
            }

            if (erroreCredenziali.length() == 0) {
                credenzialiValide = true;

                // Ottengo l'unica istanza della classe Singleton ControllerGestioneProfiloCliente
                ControllerGestioneProfiloCliente controller_profilo_cliente = ControllerGestioneProfiloCliente.getControllerGestioneProfiloCliente();
                // chiamo sul Controller il metodo inserisciCliente, che verifica che l'username inserito non sia già presente nel sistema
                // se il controllo va a buon fine, avvia l'inserimento del cliente e il metodo restituisce l'esito dell'inserimento
                boolean cliente_inserito = controller_profilo_cliente.inserisciCliente(nome, cognome, indirizzo, telefono, email, username, password);

                if(cliente_inserito) {
                    JOptionPane.showMessageDialog(this,
                            "Le credenziali sono state create con successo. L'utente ora è registrato nel sistema.",
                            "Messaggio di conferma", JOptionPane.INFORMATION_MESSAGE);

                    // All'atto della creazione dell'utente all'interno del DB viene effettuato
                    // il dispose della frame precedente che viene chiusa.
                    finestraPrecedente.dispose();

                    // Successivamente si effettua il dispose su questa finestra per rilasciare le risorse
                    // e chiudere la form
                    dispose();

                    // Mostro all'utente appena registrato la homepage per effettuare l'accesso se vuole
                    FormHomePage homePage = new FormHomePage();
                    homePage.setVisible(true);

                } else {
                    JOptionPane.showConfirmDialog(this,
                            "Username già presente nel sistema! Inserisci un altro username.", "Messaggio di errore",
                            JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this,
                        "Ci sono problemi con le credenziali:\n" + erroreCredenziali + "Riprova.",
                        "Errore Credenziali", JOptionPane.WARNING_MESSAGE);
                passwordField.setText("");
                confermaPasswordField.setText("");
            }
        }

    }

    // metodi per la INPUT VALIDATION di username e password inseriti
    private boolean validaUsername(String username, StringBuilder errori) {
        if (username.isEmpty()) {
            errori.append("- Username vuoto. Inserisci un nome utente.\n");
            return false;
        }
        if (!USERNAME_PATTERN.matcher(username).matches()) {
            errori.append("- Username non valido. Deve contenere tra 6 e 30 caratteri (lettere, numeri o underscore).\n");
            return false;
        }

        return true;
    }

    private boolean validaPassword(String password, StringBuilder errori) {
        boolean isValid = true;

        if (password.isEmpty()) {
            errori.append("- La password è vuota. Inserisci una password.\n");
            return false;
        }
        if (password.length() < 6) {
            errori.append("- Password troppo corta. Deve avere almeno 6 caratteri.\n");
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            errori.append("- La password deve contenere almeno una lettera minuscola.\n");
            isValid = false;
        }
        if (!password.matches(".*[A-Z].*")) {
            errori.append("- La password deve contenere almeno una lettera maiuscola.\n");
            isValid = false;
        }
        if (!password.matches(".*\\d.*")) {
            errori.append("- La password deve contenere almeno un numero.\n");
            isValid = false;
        }
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            errori.append("- La password deve contenere almeno un carattere speciale (es. !, @, #, $).\n");
            isValid = false;
        }
        return isValid;
    }

    // metodo usato per verificare i dati ricevuti dalla finestra precedente
    private void debugDatiPersonali(String nome, String cognome, String email, String indirizzo, String telefono) {
        System.out.println("Nome ricevuto: " + nome);
        System.out.println("Nome ricevuto: " + cognome);
        System.out.println("Nome ricevuto: " + email);
        System.out.println("Nome ricevuto: " + indirizzo);
        System.out.println("Nome ricevuto: " + telefono);
    }
}
