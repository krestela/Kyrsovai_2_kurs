import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class MyCalendar {
    private static final Map<Integer, Repeat> actualTasks = new HashMap<>();

    public static void addTask(Scanner scanner) {

        try {
            scanner.nextLine();
            System.out.print("Введите название задачи: ");
            String title = ValidateUtils.checkString(scanner.nextLine());
            System.out.println("Введите описание задачи: ");
            String description = ValidateUtils.checkString(scanner.nextLine());
            System.out.println("Введите тип задачи: 0 - Рабочая 1 - Личная");
            TypeTask typeTask = TypeTask.values()[scanner.nextInt()];
            System.out.println("Введите повторяемость задачи: 0 - Однократное, 1 - Ежедневная, 2 - Еженедельная, 3 - Ежемесячная, 4 - Ежегодная");
            int occurance = scanner.nextInt();
            System.out.println("Введите дату dd.MM.yyyy HH:mm ");
            scanner.nextLine();
            createEvent(scanner, title, description, typeTask, occurance);
            System.out.println("Для выхода нажмите Enter\n");
            scanner.nextLine();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createEvent(Scanner scanner, String title, String description, TypeTask typeTask, int occurance) {
        try {
            LocalDateTime eventDate = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
            Repeat task = null;
            try {
                task = createTask(occurance, title, description, typeTask, eventDate);
                System.out.println("Создана задача " + task);

            } catch (WrongInputException e) {
                System.out.println(e.getMessage());
            }
        } catch (DateTimeParseException e) {
            System.out.println("Проверьте формат даты dd.MM.yyyy HH:mm и попробуйте еще раз");
            createEvent(scanner, title, description, typeTask, occurance);
        }
    }

    public static void deleteTask(Scanner scanner) {
        System.out.println("Текущие задачи\n");
        printActualTasks();
        System.out.println("Для удаления введите Id задачи\n");
        int id = scanner.nextInt();
        if (actualTasks.containsKey(id)) {
            actualTasks.remove(id);
            System.out.println("Задча удалена\n");
        } else {
            System.out.println("Такой задачи не существует\n");
        }
    }

    private static Repeat createTask(int occurance, String title, String description, TypeTask typeTask, LocalDateTime localDateTime) throws WrongInputException {
        return switch (occurance) {
            case 0 -> {
                OnceTask onceTask = new OnceTask(title, description, typeTask, localDateTime);
                actualTasks.put(onceTask.getId(), onceTask);
                yield onceTask;
            }
            case 1 -> {
                DailyTask dailyTask = new DailyTask(title, description, typeTask, localDateTime);
                actualTasks.put(dailyTask.getId(), dailyTask);
                yield dailyTask;
            }
            case 2 -> {
                WeeklyTask weeklyTask = new WeeklyTask(title, description, typeTask, localDateTime);
                actualTasks.put(weeklyTask.getId(), weeklyTask);
                yield weeklyTask;
            }
            case 3 -> {
                MothlyTask mothlyTask = new MothlyTask(title, description, typeTask, localDateTime);
                actualTasks.put(mothlyTask.getId(), mothlyTask);
                yield mothlyTask;
            }
            case 4 -> {
                YearlyTask yearlyTask = new YearlyTask(title, description, typeTask, localDateTime);
                actualTasks.put(yearlyTask.getId(), yearlyTask);
                yield yearlyTask;
            }
            default -> null;
        };
    }

    private static void printActualTasks() {
        for (Repeat task : actualTasks.values()) {
            System.out.println(task);
        }
    }
}
