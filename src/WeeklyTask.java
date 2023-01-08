import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repeat{
    public WeeklyTask(String title, String descriptionTask, TypeTask typeTask, LocalDateTime localDateTime)throws WrongInputException{
        super(title, descriptionTask, typeTask, localDateTime);
    }

    @Override
    public boolean checkDate(LocalDateTime requestedDate) {
        return getFirstDate().getDayOfWeek().equals(requestedDate.getDayOfWeek());
    }
}
