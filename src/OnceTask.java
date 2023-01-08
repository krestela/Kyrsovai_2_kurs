import java.time.LocalDateTime;

public class OnceTask extends Task implements Repeat {
    public OnceTask(String title, String descriptionTask, TypeTask typeTask, LocalDateTime localDateTime) throws WrongInputException {
        super(title, descriptionTask, typeTask, localDateTime);
    }

    @Override
    public boolean checkDate(LocalDateTime requestedDate) {
        return getFirstDate().toLocalDate().equals(requestedDate.toLocalDate());
    }
}
