import java.util.Scanner;

public class Menu {

    public static void showMenu(taskManager manager) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=================================");
            System.out.println("        SMART TASK PLANNER       ");
            System.out.println("=================================");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks by Priority");
            System.out.println("3. View Tasks by Deadline");
            System.out.println("4. Complete Highest Priority Task");
            System.out.println("5. Undo Last Completed Task");
            System.out.println("6. Exit");
            System.out.println("---------------------------------");

            System.out.print("Enter your choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();   
            }
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.print("Enter task name: ");
                String name = sc.nextLine();

                System.out.print("Enter priority (1-High, 2-Medium, 3-Low): ");
                int priority = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter deadline: ");
                String deadline = sc.nextLine();

                task task = new task(name, priority, deadline);
                manager.addTask(task);

            } else if (choice == 2) {
                manager.viewTasks();
            }else if (choice == 3) {
                manager.viewTasksByDeadline();
            }else if (choice == 4) {
                manager.completeTask();
            }else if (choice == 5) {
                manager.undoLastTask();
            }else if (choice == 6) {
                System.out.println("Exiting...");
                break;
            }
        }
    }
}
