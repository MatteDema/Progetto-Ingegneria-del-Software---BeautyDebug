package boundary;

import control.ControllerCentroEstetico;
import dto.DTOTrattamento;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormVisualizzazioneTrattamenti extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_nomeTrattamento;
    private JTextField textField_costo;
    private JLabel lbl_scelta_visualizzazione;
    private JButton btn_visualizza_tutti_trattamenti;
    private  JButton btn_cerca_trattamento_per_nome;
    private JButton btn_cerca_per_nome;
    private JButton btn_cerca_trattamenti_per_costo;
    private  JButton btn_cerca_per_costo;
    private JTextArea textArea_esito_visualizzazione;
    private JScrollPane scrollPane;
    private JTable table_trattamenti;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormVisualizzazioneTrattamenti frame = new FormVisualizzazioneTrattamenti();
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
    public FormVisualizzazioneTrattamenti() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 500);

        setTitle("Visualizzazione trattamenti disponibili");
        setLocationRelativeTo(null);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lbl_scelta_visualizzazione = new JLabel("Scegli il tipo di visualizzazione");
        lbl_scelta_visualizzazione.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_scelta_visualizzazione.setBounds(10, 10, 224, 30);
        lbl_scelta_visualizzazione.setForeground(Color.MAGENTA);
        contentPane.add(lbl_scelta_visualizzazione);

        btn_visualizza_tutti_trattamenti = new JButton("Visualizza tutti i trattamenti");
        btn_visualizza_tutti_trattamenti.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // Ottengo l'unica istanza della classe Singleton ControllerCentroEstetico, e la uso per avviare la richiesta
                // di visualizzazione di tutti i trattamenti offerti dal centro estetico
                ControllerCentroEstetico controller_centro_estetico = ControllerCentroEstetico.getControllerCentroEstetico();

                // Usiamo i DTO per aumentare il disaccoppiamento, evitando che la GUI debba conoscere i dettagli
                // interni alla classe Entity Trattamento
                ArrayList<DTOTrattamento> lista_trattamenti_dto = controller_centro_estetico.visualizzaTuttiTrattamentiDisponibili();

                // Avvio la visualizzazione di tutti i trattamenti
                visualizza_trattamenti(lista_trattamenti_dto);

                textArea_esito_visualizzazione.setText("Trattamenti visualizzati " + "\ncon successo!");
            }
        });
        btn_visualizza_tutti_trattamenti.setForeground(new Color(153, 0, 255));
        btn_visualizza_tutti_trattamenti.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btn_visualizza_tutti_trattamenti.setBounds(10, 50, 209, 21);
        contentPane.add(btn_visualizza_tutti_trattamenti);


        btn_cerca_trattamento_per_nome = new JButton("Cerca trattamento per nome");
        btn_cerca_trattamento_per_nome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // abilita il campo di testo per inserire il nome del trattamento e il bottone Cerca per nome
                textField_nomeTrattamento.setEnabled(true);
                btn_cerca_per_nome.setEnabled(true);
            }
        });
        btn_cerca_trattamento_per_nome.setForeground(new Color(153, 0, 255));
        btn_cerca_trattamento_per_nome.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btn_cerca_trattamento_per_nome.setBounds(10, 81, 209, 21);
        contentPane.add(btn_cerca_trattamento_per_nome);

        textField_nomeTrattamento = new JTextField();
        textField_nomeTrattamento.setBounds(30, 112, 141, 19);
        contentPane.add(textField_nomeTrattamento);
        textField_nomeTrattamento.setColumns(10);
        textField_nomeTrattamento.setEnabled(false);

        btn_cerca_per_nome = new JButton("Cerca");
        btn_cerca_per_nome.setEnabled(false);
        btn_cerca_per_nome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // cerca il trattamento per nome e lo mostra
                // prelevo dal campo testuale il nome del trattamento inserito
                String nomeTrattamento = textField_nomeTrattamento.getText();

                // Ottengo l'unica istanza della classe Singleton ControllerCentroEstetico, e la uso per avviare la richiesta
                // di visualizzazione del trattamento avente il nome inserito
                ControllerCentroEstetico controller_centro_estetico = ControllerCentroEstetico.getControllerCentroEstetico();

                ArrayList<DTOTrattamento> lista_trattamenti_dto = controller_centro_estetico.visualizzaTrattamentoPerNome(nomeTrattamento);

                // il trattamento viene mostrato nella tabella solo se esiste
                if(lista_trattamenti_dto != null) {
                    // Avvio la visualizzazione dei trattamenti nella lista (in questo caso, un solo trattamento)
                    visualizza_trattamenti(lista_trattamenti_dto);
                    textArea_esito_visualizzazione.setText("Trattamento visualizzato " + "\ncon successo!");
                } else {
                    textArea_esito_visualizzazione.setText("Nessun trattamento offerto ha " + "\nil nome che hai inserito!");
                    System.out.println("Nessun trattamento offerto ha il nome che hai inserito!");
                }

                // svuoto il campo testuale usato per inserire il nome del trattamento
                textField_nomeTrattamento.setText("");
                // disabilito nuovamente il campo di testo usato per inserire il nome del trattamento e il bottone Cerca per nome
                textField_nomeTrattamento.setEnabled(false);
                btn_cerca_per_nome.setEnabled(false);
            }
        });
        btn_cerca_per_nome.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btn_cerca_per_nome.setBounds(120, 141, 85, 21);
        contentPane.add(btn_cerca_per_nome);

        btn_cerca_trattamenti_per_costo = new JButton("Cerca trattamenti per costo");
        btn_cerca_trattamenti_per_costo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // abilita il campo di testo per inserire il costo massimo e il bottone Cerca per costo
                textField_costo.setEnabled(true);
                btn_cerca_per_costo.setEnabled(true);
            }
        });
        btn_cerca_trattamenti_per_costo.setForeground(new Color(153, 0, 255));
        btn_cerca_trattamenti_per_costo.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btn_cerca_trattamenti_per_costo.setBounds(10, 172, 209, 21);
        contentPane.add(btn_cerca_trattamenti_per_costo);

        textField_costo = new JTextField();
        textField_costo.setBounds(30, 203, 141, 19);
        contentPane.add(textField_costo);
        textField_costo.setColumns(10);
        textField_costo.setEnabled(false);

        btn_cerca_per_costo = new JButton("Cerca");
        btn_cerca_per_costo.setEnabled(false);
        btn_cerca_per_costo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // cerca i trattamenti aventi costo non superiore a quello inserito e li mostra
                // prelevo dal campo testuale il costo massimo inserito
                String costo_max = textField_costo.getText();

                // Ottengo l'unica istanza della classe Singleton ControllerCentroEstetico, e la uso per avviare la richiesta
                // di visualizzazione dei trattamenti aventi costo non superiore a quello inserito
                ControllerCentroEstetico controller_centro_estetico = ControllerCentroEstetico.getControllerCentroEstetico();

                // il metodo parseInt della classe Wrapper Integer (usato di seguito per convertire la stringa costo_max in intero)
                // solleva una eccezione di tipo NumberFormatException se l'utente non inserisce un numero intero nel campo testuale dedicato
                try {
                    ArrayList<DTOTrattamento> lista_trattamenti_dto = controller_centro_estetico.visualizzaTrattamentiPerCosto(Integer.parseInt(costo_max));

                    // i trattamenti vengono mostrati nella tabella solo se la lista di oggetti DTOTrattamento non è vuota
                    if (!lista_trattamenti_dto.isEmpty()) {
                        // Avvio la visualizzazione dei trattamenti nella lista
                        visualizza_trattamenti(lista_trattamenti_dto);

                        textArea_esito_visualizzazione.setText("Trattamenti visualizzati " + "\ncon successo!");
                    } else {
                        textArea_esito_visualizzazione.setText("Nessun trattamento offerto " + "\nha un costo inferiore o uguale " +
                                "\na quello che hai inserito!");
                        System.out.println("Nessun trattamento offerto ha un costo inferiore o uguale " +
                                "a quello che hai inserito!");
                    }

                    // svuoto il campo testuale usato per inserire il costo
                    textField_costo.setText("");
                    // disabilito nuovamente il campo di testo usato per inserire il costo e il bottone Cerca per costo
                    textField_costo.setEnabled(false);
                    btn_cerca_per_costo.setEnabled(false);
                } catch(NumberFormatException exception) {
                    System.out.println("Il costo che inserisci deve essere un numero intero!");
                    textArea_esito_visualizzazione.setText("Il costo che inserisci deve essere " + "\nun numero intero!");
                }
            }
        });
        btn_cerca_per_costo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btn_cerca_per_costo.setBounds(120, 232, 85, 21);
        contentPane.add(btn_cerca_per_costo);

        textArea_esito_visualizzazione = new JTextArea();
        textArea_esito_visualizzazione.setEditable(false); // area di testo non editabile
        textArea_esito_visualizzazione.setBounds(21, 383, 184, 70);
        contentPane.add(textArea_esito_visualizzazione);
        textArea_esito_visualizzazione.setForeground(Color.RED);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(229, 10, 757, 443);
        contentPane.add(scrollPane);

        table_trattamenti = new JTable();
        table_trattamenti.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Nome trattamento", "Descrizione", "Costo", "Ripetizione periodica"
                }
        ){
            Class[] columnTypes = new Class[] {
                    String.class, String.class, String.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
            boolean[] columnEditables = new boolean[] {
                    false, false, false, false // rendo le colonne della tabella non editabili
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
        }});
        table_trattamenti.getColumnModel().getColumn(0).setPreferredWidth(130);
        table_trattamenti.getColumnModel().getColumn(1).setPreferredWidth(400);
        table_trattamenti.getColumnModel().getColumn(3).setPreferredWidth(110);
        scrollPane.setViewportView(table_trattamenti);

    }

    // metodo per visualizzare la lista di trattamenti all'interno della tabella
    // Usiamo i DTO per aumentare il disaccoppiamento, evitando che la GUI debba conoscere i dettagli
    // interni alla classe Entity Trattamento
    public void visualizza_trattamenti(ArrayList<DTOTrattamento> lista_trattamenti_dto) {
        DefaultTableModel tableModel = (DefaultTableModel) table_trattamenti.getModel();

        // svuoto la tabella, se contiene già delle righe risultato di visualizzazioni precedenti
        tableModel.setRowCount(0);

        for (int i = 0; i < lista_trattamenti_dto.size(); i++) {
            // recupero i campi di ciascun DTOTrattamento
            String nomeTrattamento = lista_trattamenti_dto.get(i).getCampo1();
            String descrizione = lista_trattamenti_dto.get(i).getCampo2();
            String costo = Integer.toString(lista_trattamenti_dto.get(i).getCampo3());
            String ripetizionePeriodica = lista_trattamenti_dto.get(i).getCampo4();

            // aggiungo alla tabella una nuova riga contenente i valori dei campi estratti dal DTO
            tableModel.addRow(new Object[] {nomeTrattamento, descrizione, costo, ripetizionePeriodica});

            // stampa di debug
            System.out.println("Visualizzato il trattamento: " + nomeTrattamento + ", Descrizione: " + descrizione +
                    ", Costo: " + costo + ", Ripetizione periodica: " + ripetizionePeriodica);
        }
    }
}
