package boundary;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class FormHomePageCliente extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lbl_presentazione_home;
    private JLabel lbl_immagine_centro_estetico;
    private JLabel lbl_scelta_operazione;
    private JButton btn_prenota_trattamento;
    private JButton btn_visualizza_trattamenti;



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormHomePageCliente frame = new FormHomePageCliente("pippozzo");
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
    public FormHomePageCliente(String usernameCliente) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 300);

        setTitle("Home cliente");
        setLocationRelativeTo(null);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lbl_presentazione_home = new JLabel("Benvenuto nel nostro centro estetico Beauty Debug!");
        lbl_presentazione_home.setForeground(new Color(128, 128, 255));
        lbl_presentazione_home.setFont(new Font("Cooper Black", Font.PLAIN, 20));
        lbl_presentazione_home.setBounds(66, 10, 610, 61);
        contentPane.add(lbl_presentazione_home);


        // aggiunta della foto del centro estetico
        lbl_immagine_centro_estetico = new JLabel();
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("Centro_estetico.png")));
        lbl_immagine_centro_estetico.setIcon(image);
        contentPane.add(lbl_immagine_centro_estetico);




        lbl_scelta_operazione = new JLabel("Scegli l'operazione da effettuare!");
        lbl_scelta_operazione.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lbl_scelta_operazione.setBounds(138, 109, 191, 31);
        contentPane.add(lbl_scelta_operazione);

        btn_prenota_trattamento = new JButton("Prenota un trattamento");
        btn_prenota_trattamento.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        btn_prenota_trattamento.setForeground(new Color(255, 0, 0));
        btn_prenota_trattamento.setBackground(new Color(255, 255, 128));
        btn_prenota_trattamento.setFont(new Font("Cooper Black", Font.PLAIN, 16));
        btn_prenota_trattamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // istanzio e rendo visibile la form di prenotazione di un trattamento
                FormPrenotazioneTrattamento form_prenotazione_trattamento = new FormPrenotazioneTrattamento(usernameCliente);
                form_prenotazione_trattamento.setVisible(true);
            }
        });
        btn_prenota_trattamento.setBounds(318, 194, 326, 44);
        contentPane.add(btn_prenota_trattamento);

        btn_visualizza_trattamenti = new JButton("Dai uno sguardo ai nostri trattamenti");
        btn_visualizza_trattamenti.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // istanzio e rendo visibile la form di visualizzazione dei trattamenti offerti dal centro estetico
                FormVisualizzazioneTrattamenti form_visualizzazione_trattamenti = new FormVisualizzazioneTrattamenti();
                form_visualizzazione_trattamenti.setVisible(true);
            }
        });
        btn_visualizza_trattamenti.setBackground(new Color(255, 255, 128));
        btn_visualizza_trattamenti.setForeground(new Color(255, 0, 0));
        btn_visualizza_trattamenti.setFont(new Font("Cooper Black", Font.PLAIN, 16));
        btn_visualizza_trattamenti.setBounds(10, 140, 367, 44);
        contentPane.add(btn_visualizza_trattamenti);
    }
}
