package boundary;

import control.ControllerCentroEstetico;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Pattern;

public class FormAggiuntaNuovoTrattamento extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lbl_inserimento_dati_trattamento;
    private JLabel lbl_nome;
    private JTextField textField_nome;
    private JLabel lbl_descrizione;
    private JTextField textField_descrizione;
    private JLabel lbl_costo;
    private JTextField textField_costo;
    private JLabel lbl_ripetizione_periodica;
    private JTextField textField_ripetizione_periodica;
    private JButton btn_aggiunta_trattamento;
    private JTextArea textArea_esito_aggiunta_trattamento;

    // per il controllo del costo
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");


    /**
     * Launch the application.
     */
    /*
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormAggiuntaNuovoTrattamento frame = new FormAggiuntaNuovoTrattamento();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    */


    /**
     * Create the frame.
     */
    public FormAggiuntaNuovoTrattamento() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 350);

        setTitle("Aggiunta trattamento");
        setLocationRelativeTo(null);
        setResizable(false);

        ImageIcon appIcon = new ImageIcon(getClass().getClassLoader().getResource("Centro_estetico.png"));
        setIconImage(appIcon.getImage());


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lbl_inserimento_dati_trattamento = new JLabel("Inserisci i dettagli del trattamento che vuoi aggiungere");
        lbl_inserimento_dati_trattamento.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        lbl_inserimento_dati_trattamento.setBounds(55, 10, 386, 43);
        contentPane.add(lbl_inserimento_dati_trattamento);

        lbl_nome = new JLabel("Nome");
        lbl_nome.setForeground(new Color(255, 0, 0));
        lbl_nome.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbl_nome.setBounds(73, 63, 34, 19);
        contentPane.add(lbl_nome);

        textField_nome = new JTextField();
        textField_nome.setBounds(151, 64, 308, 19);
        contentPane.add(textField_nome);
        textField_nome.setColumns(10);

        lbl_descrizione = new JLabel("Descrizione");
        lbl_descrizione.setForeground(new Color(255, 0, 0));
        lbl_descrizione.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbl_descrizione.setBounds(55, 102, 76, 19);
        contentPane.add(lbl_descrizione);

        textField_descrizione = new JTextField();
        textField_descrizione.setBounds(152, 103, 307, 19);
        contentPane.add(textField_descrizione);
        textField_descrizione.setColumns(10);

        lbl_costo = new JLabel("Costo");
        lbl_costo.setForeground(new Color(255, 0, 0));
        lbl_costo.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbl_costo.setBounds(73, 145, 45, 13);
        contentPane.add(lbl_costo);

        textField_costo = new JTextField();
        textField_costo.setBounds(151, 143, 308, 19);
        contentPane.add(textField_costo);
        textField_costo.setColumns(10);

        lbl_ripetizione_periodica = new JLabel("Ripetizione periodica");
        lbl_ripetizione_periodica.setForeground(new Color(255, 0, 0));
        lbl_ripetizione_periodica.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbl_ripetizione_periodica.setBounds(24, 181, 117, 19);
        contentPane.add(lbl_ripetizione_periodica);

        textField_ripetizione_periodica = new JTextField();
        textField_ripetizione_periodica.setBounds(151, 182, 308, 19);
        contentPane.add(textField_ripetizione_periodica);
        textField_ripetizione_periodica.setColumns(10);

        btn_aggiunta_trattamento = new JButton("Aggiungi");
        btn_aggiunta_trattamento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // prelevo i valori inseriti nei campi testuali
                String nomeTrattamento = textField_nome.getText();
                String descrizione = textField_descrizione.getText();
                String costo = textField_costo.getText();
                String ripetizionePeriodica = textField_ripetizione_periodica.getText();

                if (!validaNomeTrattamento(nomeTrattamento)){
                    textField_nome.requestFocusInWindow();
                    return;
                }

                if (!validaDescrizione(descrizione)){
                    textField_descrizione.requestFocusInWindow();
                    return;
                }

                if (!validaCosto(costo)){
                    textField_costo.requestFocusInWindow();
                    return;
                }

                if (!validazionieRipetizionePeriodica(ripetizionePeriodica)){
                    textField_ripetizione_periodica.requestFocusInWindow();
                    return;
                }

                // Ottengo l'unica istanza della classe Singleton ControllerCentroEstetico, e la uso per avviare la richiesta
                // di aggiunta di un nuovo trattamento
                ControllerCentroEstetico controller_centro_estetico = ControllerCentroEstetico.getControllerCentroEstetico();

                // di seguito il metodo parseInt della classe Wrapper Integer può sollevare una eccezione di tipo
                // NumberFormatException se il costo inserito non è un numero intero
                boolean trattamento_aggiunto = controller_centro_estetico.aggiungiTrattamento(nomeTrattamento, descrizione, Integer.parseInt(costo), ripetizionePeriodica);

                if(trattamento_aggiunto) {
                    JOptionPane.showConfirmDialog(FormAggiuntaNuovoTrattamento.this, "Il Trattamento è stato inserito con successo!",
                            "Messaggio di conferma", JOptionPane.DEFAULT_OPTION);
                    dispose();
                } else {
                    setErrore("Aggiunta del trattamento fallita! " +
                            "\nIl trattamento che stai provando a inserire già esiste!");
                    System.out.println("Il trattamento già esiste!");
                }

            }
        });
        btn_aggiunta_trattamento.setForeground(new Color(128, 0, 255));
        btn_aggiunta_trattamento.setFont(new Font("Cooper Black", Font.PLAIN, 17));
        btn_aggiunta_trattamento.setBounds(179, 234, 117, 21);
        contentPane.add(btn_aggiunta_trattamento);

        textArea_esito_aggiunta_trattamento = new JTextArea();
        textArea_esito_aggiunta_trattamento.setForeground(new Color(128, 0, 255));
        textArea_esito_aggiunta_trattamento.setBounds(89, 271, 350, 35);
        contentPane.add(textArea_esito_aggiunta_trattamento);
        textArea_esito_aggiunta_trattamento.setEditable(false);

    }

    // metodi per la INPUT VALIDATION dei dati inseriti
    private boolean validaNomeTrattamento(String nomeTrattamento){
        if (nomeTrattamento.isEmpty()) {
            setErrore("Il nome del trattamento non deve essere vuoto!");
            return false;
        }else if (nomeTrattamento.length() < 2) {
            setErrore("Il nome del trattamento è troppo corto!");
            return false;
        }else if (nomeTrattamento.length() >30) {
            setErrore("Il nome del trattamento è troppo lungo!");
            return false;
        }
        return true;
    }

    private boolean validaDescrizione(String descrizione){
        if (descrizione.isEmpty()) {
            setErrore("La descrizione non può essere vuota!");
            return false;
        }else if (descrizione.length() > 250) {
            setErrore("La descrizione del trattamento è troppo lunga!");
            return false;
        }
        return true;
    }

    private boolean validaCosto(String costo){
        if (costo.isEmpty()) {
            setErrore("Il campo costo è vuoto!");
            return false;
        }else if (!NUMBER_PATTERN.matcher(costo).matches()) {
            setErrore("Il costo del trattamento deve contenere solo cifre numeriche.");
            return false;
        }else if (Integer.parseInt(costo) > 1000) {
            setErrore("Il costo del trattamento è troppo alto!");
            return false;
        } else if(Integer.parseInt(costo) < 0) {
            setErrore("Il costo del trattamento non può essere negativo!");
            return false;
        }
        return true;
    }

    private boolean validazionieRipetizionePeriodica(String ripetizione){
        if (ripetizione.length() >50) {
            setErrore("La ripetizione periodica è troppo lunga,\ndiminuire il numero di caratteri!");
            return false;
        }
        return true;
    }

    private void setErrore(String messaggio) {
        textArea_esito_aggiunta_trattamento.setForeground(Color.RED);
        textArea_esito_aggiunta_trattamento.setText("Attenzione: " + messaggio);
    }

}
