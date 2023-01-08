import java.time.LocalDateTime;

public class YearlyTask extends Task implements Repeat{
    public YearlyTask(String title, String descriptionTask, TypeTask typeTask, LocalDateTime localDateTime) throws WrongInputException {
        super(title, descriptionTask, typeTask, localDateTime);
    }

    @Override
    public boolean checkDate(LocalDateTime requestedDate) {
        return getFirstDate().getYear() == requestedDate.getYear();
    }
}
