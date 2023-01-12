import java.time.LocalDateTime;

public interface Repeat {
    boolean checkDate(LocalDateTime requestedDate);
    void setTitle(String title);
    LocalDateTime getFirstDate();
}
