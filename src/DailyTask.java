import java.time.LocalDateTime;

public class DailyTask extends Task implements Repeat{
    public DailyTask(String title, String descriptionTask, TypeTask typeTask, LocalDateTime localDateTime) throws WrongInputException {
        super(title, descriptionTask, typeTask, localDateTime);
    }

    @Override
    public boolean checkDate(LocalDateTime requestedDate) {
        return getFirstDate().toLocalDate().equals(requestedDate.toLocalDate());
    }
}
