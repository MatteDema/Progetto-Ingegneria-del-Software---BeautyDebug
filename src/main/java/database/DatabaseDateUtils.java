package database;

import java.time.format.DateTimeFormatter;

public class DatabaseDateUtils {
    //classe di utility per il package Database perché più DAO utilizzano questi formati

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    private DatabaseDateUtils() {
        // Costruttore privato per evitare istanziazione della classe di utility
    }
}