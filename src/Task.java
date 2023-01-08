import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Task {
    private String title;
    private String descriptionTask;
    private TypeTask typeTask;
    private LocalDateTime firstDate;
    private static Integer counter = 1;
    private final Integer id;


    public Task(String title, String descriptionTask, TypeTask typeTask, LocalDateTime localDateTime) throws WrongInputException {
        this.title = ValidateUtils.checkString(title);
        this.descriptionTask = ValidateUtils.checkString(descriptionTask);
        this.typeTask = typeTask;
        this.firstDate = localDateTime;
        this.id = ++counter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(TypeTask typeTask) {
        this.typeTask = typeTask;
    }

    public LocalDateTime getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(LocalDateTime firstDate) {
        this.firstDate = firstDate;
    }

    public static Integer getCounter() {
        return counter;
    }

    public static void setCounter(Integer counter) {
        Task.counter = counter;
    }

    public Integer getId() {
        return id;
    }

    private TypeTask[] tasks = new TypeTask[0];

    public String[] typeTask() {
        String[] task = new String[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            task[i] = tasks[i].name();

        }

        return task;
    }

    public String[] allTypeTask() {
        String[] tasks = new String[TypeTask.values().length];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = TypeTask.values()[i].name();

        }
        return tasks;
    }

    public void doTypeTask(String tasks) {
        TypeTask typeTask = TypeTask.valueOf(tasks);
        if (typeTask == null) {
            typeTask = TypeTask.findByVoiceCommand(tasks);
        }
        switch (typeTask) {
            case CMD_PERSONALY:
                System.out.println("Задача добавлена в личное");
                break;
            case CMD_WORK:
                System.out.println("Задача добавлена в рабочее");
                break;
            default:
                System.out.println("Выберите тип задачи");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && Objects.equals(descriptionTask, task.descriptionTask) && typeTask == task.typeTask && Objects.equals(firstDate, task.firstDate) && Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, descriptionTask, typeTask, firstDate, id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", typeTask=" + typeTask +
                ", firstDate=" + firstDate +
                ", id=" + id +
                ", tasks=" + Arrays.toString(tasks) +
                '}';
    }
}
