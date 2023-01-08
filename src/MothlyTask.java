import java.time.LocalDateTime;

public class MothlyTask extends Task implements Repeat{
    public MothlyTask(String title, String descriptionTask, TypeTask typeTask, LocalDateTime localDateTime) throws WrongInputException {
        super(title, descriptionTask, typeTask, localDateTime);
    }

    @Override
    public boolean checkDate(LocalDateTime requestedDate) {
        return getFirstDate().getMonth().equals(requestedDate.getMonth());
    }
}
