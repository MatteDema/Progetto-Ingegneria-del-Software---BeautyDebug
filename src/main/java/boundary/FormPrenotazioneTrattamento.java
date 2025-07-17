package boundary;

import control.ControllerGestionePrenotazioni;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class FormPrenotazioneTrattamento extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField_nome_trattamento;
    private JLabel lbl_inserimento_nome_trattamento;
    private JButton btnCercaFasceOrarie;
    private JTextArea textArea_esito_ricerca_fasce;
    private JScrollPane scrollPane;
    private JTable table_fasce_orarie_libere;
    private JTextArea textArea_esito_selezione_fascia;
    private JButton btn_prenotazione;
    private JTextArea textArea_esito_prenotazione;

    /**
     * Launch the application.
     */
    /*
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormPrenotazioneTrattamento frame = new FormPrenotazioneTrattamento("pippozzo");
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
    public FormPrenotazioneTrattamento(String usernameCliente) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 420);

        setTitle("Prenotazione trattamento");
        setLocationRelativeTo(null);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        // imposto il logo del centro estetico come icona della form
        ImageIcon appIcon = new ImageIcon(getClass().getClassLoader().getResource("Centro_estetico.png"));
        setIconImage(appIcon.getImage());


        lbl_inserimento_nome_trattamento = new JLabel("Inserisci il nome del trattamento che intendi prenotare:");
        lbl_inserimento_nome_trattamento.setFont(new Font("Cooper Black", Font.PLAIN, 13));
        lbl_inserimento_nome_trattamento.setBackground(new Color(255, 255, 255));
        lbl_inserimento_nome_trattamento.setBounds(76, 10, 375, 40);
        contentPane.add(lbl_inserimento_nome_trattamento);

        textField_nome_trattamento = new JTextField();
        textField_nome_trattamento.setBounds(152, 43, 154, 25);
        contentPane.add(textField_nome_trattamento);
        textField_nome_trattamento.setColumns(10);

        btnCercaFasceOrarie = new JButton("Cerca fasce orarie libere");
        btnCercaFasceOrarie.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // avvia la prenotazione di un trattamento

                // svuoto la tabella, se contiene già delle righe risultato di visualizzazioni precedenti
                DefaultTableModel tableModel = (DefaultTableModel) table_fasce_orarie_libere.getModel();
                tableModel.setRowCount(0);
                // svuoto le aree di testo contenenti eventuali messaggi relativi a prenotazioni precedenti
                textArea_esito_selezione_fascia.setText("");
                textArea_esito_prenotazione.setText("");


                // prelevo dal campo testuale il nome del trattamento inserito
                String trattamento_da_prenotare = textField_nome_trattamento.getText();

                if(trattamento_da_prenotare.isEmpty()){
                    textArea_esito_ricerca_fasce.setForeground(Color.RED);
                    textArea_esito_ricerca_fasce.setText("Compilare il campo del trattamento!");
                    return;
                }

                // Ottengo l'unica istanza della classe Singleton ControllerGestionePrenotazioni, e la uso per avviare la richiesta
                // di prenotazione di un trattamento
                ControllerGestionePrenotazioni controller_prenotazioni = ControllerGestionePrenotazioni.getControllerGestione_prenotazioni();

                ArrayList<LocalDateTime> fasce_orarie_libere = controller_prenotazioni.prenotaTrattamento(trattamento_da_prenotare, usernameCliente);
                // il metodo prenotaTrattamento effettua i dovuti controlli (trattamento esistente e assenza di prenotazioni attive per il trattamento selezionato):
                // - se i controlli hanno esito positivo, avvia la ricerca delle fasce orarie e le mostra in una tabella in modo da poterle selezionare
                // - se il trattamento che si intende prenotare non esiste, restituisce null
                // - se il cliente ha già una prenotazione attiva per la tipologia di trattamento specificata, restituisce una lista vuota

                if(fasce_orarie_libere == null) {
                    textArea_esito_ricerca_fasce.setText("ERRORE: Il trattamento inserito " + "\nnon è offerto dal nostro centro estetico!");
                    System.out.println("ERRORE: Il trattamento inserito non è offerto dal nostro centro estetico!");
                } else if(fasce_orarie_libere.isEmpty()) {
                    textArea_esito_ricerca_fasce.setText("ERRORE: Hai già una prenotazione " + "\nattiva per questo trattamento!");
                    System.out.println("ERRORE: Hai già una prenotazione attiva per questo trattamento!");
                } else {
                    // i controlli vanno a buon fine
                    // inserisce le fasce orarie libere nella JTable

                    // definisco un certo formato per le date da mostare nella tabella
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                    for(LocalDateTime fascia_oraria : fasce_orarie_libere) {
                        // tableModel.addRow(new LocalDateTime[]{fascia_oraria}); // senza formatter -> inserisco nella tabella dei LocalDateTime
                        tableModel.addRow(new String[]{fascia_oraria.format(formatter)});
                    }

                    textArea_esito_ricerca_fasce.setText("Seleziona dalla lista la fascia oraria " + "\nper la quale vuoi prenotarti.");
                    System.out.println("Seleziona dalla lista la fascia oraria per la quale vuoi prenotarti.");
                }
            }
        });
        btnCercaFasceOrarie.setBounds(25, 78, 210, 25);
        contentPane.add(btnCercaFasceOrarie);

        textArea_esito_ricerca_fasce = new JTextArea();
        textArea_esito_ricerca_fasce.setEditable(false); // area di testo non editabile
        textArea_esito_ricerca_fasce.setBounds(245, 78, 206, 51);
        contentPane.add(textArea_esito_ricerca_fasce);


        // creazione tabella JTable interna ad uno JScrollPane
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 113, 186, 260);
        contentPane.add(scrollPane);

        table_fasce_orarie_libere = new JTable();
        table_fasce_orarie_libere.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table_fasce_orarie_libere.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                        "Fasce orarie libere"
                }
        ) {
            Class[] columnTypes = new Class[] {
                    String.class
            };
            public Class getColumnClass(int columnIndex) {
            return columnTypes[columnIndex];
        }
            boolean[] columnEditables = new boolean[] {
                    false // rendo la colonna della tabella non editabile
            };
            public boolean isCellEditable(int row, int column) {
            return columnEditables[column];
        }});
        scrollPane.setViewportView(table_fasce_orarie_libere);

        // aggiungo il listener per gestire la selezione di una fascia oraria dalla tabella
        table_fasce_orarie_libere.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                // mantengo disabilitato il bottone PRENOTATI (abilitandolo solo se clicco su una fascia oraria valida)
                btn_prenotazione.setEnabled(false);

                int selected_row  = table_fasce_orarie_libere.getSelectedRow(); // ritorna -1 se nessuna riga viene selezionata

                if(selected_row >= 0) {
                    // parte la verifica della fascia oraria selezionata
                    // (non deve essere antecedente a tre giorni dalla data corrente)

                    // recupero la fascia oraria selezionata (riga selezionata, colonna di indice 0)
                    // LocalDateTime fascia_oraria_selezionata = (LocalDateTime) table_fasce_orarie_libere.getValueAt(selected_row, 0);
                    // la riga sopra è corretta solo se nella tabella memorizzo dei LocalDateTime (senza usare formatter)

                    String fascia_oraria_selezionata = (String) table_fasce_orarie_libere.getValueAt(selected_row, 0);

                    // definisco il formato per le fasce orarie mostrate nella tabella
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                    // converto la data da stringa a LocalDateTime
                    LocalDateTime fascia_oraria = LocalDateTime.parse(fascia_oraria_selezionata, formatter);

                    // Ottengo l'unica istanza della classe Singleton ControllerGestionePrenotazioni, e la uso
                    // per verificare la fascia oraria selezionata
                    ControllerGestionePrenotazioni controller_prenotazioni = ControllerGestionePrenotazioni.getControllerGestione_prenotazioni();
                    boolean fascia_oraria_valida = controller_prenotazioni.verificaFasciaOraria(fascia_oraria);

                    if(fascia_oraria_valida) {
                        textArea_esito_selezione_fascia.setText("Fascia oraria selezionata valida! " + "\nClicca su PRENOTATI!");
                        // abilito il bottone PRENOTATI
                        btn_prenotazione.setEnabled(true);
                    } else {
                        textArea_esito_selezione_fascia.setText("Fascia oraria selezionata non valida! " +
                                "\nSeleziona un'altra data per prenotare " + "\ncorrettamente il tuo trattamento!");
                        //System.out.println("Fascia oraria selezionata non valida! " +
                        //        "Seleziona un'altra data per prenotare correttamente il tuo trattamento!");

                        // il bottone PRENOTATI resta disabilitato
                        btn_prenotazione.setEnabled(false);
                    }
                }
            }
        });


        textArea_esito_selezione_fascia = new JTextArea();
        textArea_esito_selezione_fascia.setEditable(false); // area di testo non editabile
        textArea_esito_selezione_fascia.setBackground(new Color(255, 204, 255));
        textArea_esito_selezione_fascia.setForeground(new Color(255, 0, 0));
        textArea_esito_selezione_fascia.setBounds(220, 162, 250, 60);
        contentPane.add(textArea_esito_selezione_fascia);

        btn_prenotazione = new JButton("PRENOTATI");
        btn_prenotazione.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // avvia l'aggiunta della nuova prenotazione e mostra l'esito

                // Ottengo l'unica istanza della classe Singleton ControllerGestionePrenotazioni, e la uso
                // per completare l'aggiunta della nuova prenotazione
                ControllerGestionePrenotazioni controller_prenotazioni = ControllerGestionePrenotazioni.getControllerGestione_prenotazioni();

                // recupero la fascia oraria selezionata
                int selectedRow = table_fasce_orarie_libere.getSelectedRow();
                // LocalDateTime fascia_oraria_selezionata = (LocalDateTime) table_fasce_orarie_libere.getValueAt(selectedRow, 0);
                // la riga sopra va bene solo se nella tabella memorizzo dei LocalDateTime (senza usare formatter)

                String fascia_oraria_selezionata = (String) table_fasce_orarie_libere.getValueAt(selectedRow, 0);

                // definisco il formato per le fasce orarie mostrate nella tabella
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                // converto la data da stringa a LocalDateTime
                LocalDateTime fascia_oraria = LocalDateTime.parse(fascia_oraria_selezionata, formatter);

                // recupero il trattamento da prenotare dal campo testuale
                String trattamento_da_prenotare = textField_nome_trattamento.getText();

                if(controller_prenotazioni.verificaFasciaOraria(fascia_oraria)) {
                    boolean prenotazione_aggiunta = controller_prenotazioni.aggiungiNuovaPrenotazione(fascia_oraria, trattamento_da_prenotare, usernameCliente);

                    if (prenotazione_aggiunta) {
                        textArea_esito_prenotazione.setText("Prenotazione completata con successo!");
                        // System.out.println("Prenotazione completata con successo!");

                        // dopo aver completato la prenotazione, la tabella delle fasce orarie viene svuotato
                        DefaultTableModel tableModel = (DefaultTableModel) table_fasce_orarie_libere.getModel();
                        tableModel.setRowCount(0);

                        // a prenotazione effettuata, disabilito il pulsante PRENOTATI
                        btn_prenotazione.setEnabled(false);
                    } else {
                        textArea_esito_prenotazione.setText("Prenotazione fallita!");
                        System.out.println("Prenotazione fallita!");
                    }
                }
            }
        });
        btn_prenotazione.setForeground(new Color(128, 0, 255));
        btn_prenotazione.setFont(new Font("Cooper Black", Font.PLAIN, 15));
        btn_prenotazione.setBounds(278, 287, 152, 35);
        btn_prenotazione.setEnabled(false); // il bottone PRENOTATI è inizialmente disabilitato
        contentPane.add(btn_prenotazione);

        textArea_esito_prenotazione = new JTextArea();
        textArea_esito_prenotazione.setEditable(false); // area di testo non editabile
        textArea_esito_prenotazione.setBounds(227, 332, 243, 22);
        textArea_esito_prenotazione.setForeground(new Color(128, 0, 255));
        contentPane.add(textArea_esito_prenotazione);
    }
}
