package boundary;

import control.ControllerCentroEstetico;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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


    /**
     * Launch the application.
     */
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

    /**
     * Create the frame.
     */
    public FormAggiuntaNuovoTrattamento() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 350);

        setTitle("Aggiunta trattamento");
        setLocationRelativeTo(null);
        setResizable(false);

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

                // Ottengo l'unica istanza della classe Singleton ControllerCentroEstetico, e la uso per avviare la richiesta
                // di aggiunta di un nuovo trattamento
                ControllerCentroEstetico controller_centro_estetico = ControllerCentroEstetico.getControllerCentroEstetico();

                // di seguito il metodo parseInt della classe Wrapper Integer può sollevare una eccezione di tipo
                // NumberFormatException se il costo inserito non è un numero intero
                try {
                    boolean trattamento_aggiunto = controller_centro_estetico.aggiungiTrattamento(nomeTrattamento, descrizione, Integer.parseInt(costo), ripetizionePeriodica);

                    if(trattamento_aggiunto) {
                        textArea_esito_aggiunta_trattamento.setText("Nuovo trattamento aggiunto!");
                        System.out.println("Nuovo trattamento aggiunto!");
                    } else {
                        textArea_esito_aggiunta_trattamento.setText("Aggiunta del trattamento fallita! " +
                                "\nIl trattamento che stai provando a inserire già esiste!");
                        System.out.println("Aggiunta del trattamento fallita! Il trattamento che stai provando a inserire già esiste!");
                    }
                } catch(NumberFormatException exception) {
                    System.out.println("Il costo deve essere un numero intero!");
                    textArea_esito_aggiunta_trattamento.setText("Il costo deve essere un numero intero!");
                }

            }
        });
        btn_aggiunta_trattamento.setForeground(new Color(128, 0, 255));
        btn_aggiunta_trattamento.setFont(new Font("Cooper Black", Font.PLAIN, 17));
        btn_aggiunta_trattamento.setBounds(179, 234, 117, 21);
        contentPane.add(btn_aggiunta_trattamento);

        textArea_esito_aggiunta_trattamento = new JTextArea();
        textArea_esito_aggiunta_trattamento.setForeground(new Color(128, 0, 255));
        textArea_esito_aggiunta_trattamento.setBounds(89, 271, 318, 35);
        contentPane.add(textArea_esito_aggiunta_trattamento);
    }
}
