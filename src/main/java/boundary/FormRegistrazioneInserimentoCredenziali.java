package boundary;

import java.util.regex.Pattern;
import javax.swing.*;

public class FormRegistrazioneInserimentoCredenziali extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final Pattern USERNAME_PATTERN = Pattern.compile("[A-Za-z0-9_]{6,30}");

    private String nome;
    private String cognome;
    private String email;
    private String indirizzo;
    private String telefono;
    private FormRegistrazioneInserimentoDati finestraPrecedente;

    public FormRegistrazioneInserimentoCredenziali(FormRegistrazioneInserimentoDati finestraPrecedente, String nome, String cognome, String email, String indirizzo, String telefono) {
        this.finestraPrecedente = finestraPrecedente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.indirizzo = indirizzo;
        this.telefono = telefono;

        debugDatiPersonali(nome, cognome, email, indirizzo, telefono);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        JPanel panel = new JPanel(new java.awt.GridLayout(4, 2, 5, 5));
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        JPasswordField confermaPasswordField = new JPasswordField(20);
        JCheckBox showPasswordCheckBox = new JCheckBox("Mostra Password");

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
                JOptionPane.showMessageDialog(this,
                        "Le credenziali sono state create con successo. L'utente ora è registrato nel sistema.",
                        "Messaggio di conferma", JOptionPane.INFORMATION_MESSAGE);

                //In questa sezione deve essere chiamato il controller per poter aggiungere il cliente nel centro estetico

                finestraPrecedente.dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Ci sono problemi con le credenziali:\n" + erroreCredenziali + "Riprova.",
                        "Errore Credenziali", JOptionPane.WARNING_MESSAGE);
                passwordField.setText("");
                confermaPasswordField.setText("");
            }
        }

    }

    private boolean validaUsername(String username, StringBuilder errori) {
        if (username.isEmpty()) {
            errori.append("- Username vuoto. Inserisci un nome utente.\n");
            return false;
        }
        if (!USERNAME_PATTERN.matcher(username).matches()) {
            errori.append("- Username non valido. Deve contenere tra 6 e 30 caratteri (lettere, numeri o underscore).\n");
            return false;
        }
        /* Bisogna creare un metodo che restituisce true se l'username è già presente all'interno del database
         *
         * if(username già presente nel sistema){
         * 	errori.append("- Username già presente nel sistema, si prega di inserirne un altro\n");
         * 	return false;
         * }
         *
         *
         * */
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
