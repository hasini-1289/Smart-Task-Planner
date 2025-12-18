import java.util.PriorityQueue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class taskManager {

    PriorityQueue<task> tasks = new PriorityQueue<>();
    Stack<task> completedTasks = new Stack<>();

    public void addTask(task task) {
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Pending Tasks (Priority Order):");
        for (task task : tasks) {
            System.out.println(task.name +
                    " | Priority: " + task.priority +
                    " | Deadline: " + task.deadline);
        }
    }

    public void completeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to complete.");
            return;
        }

        task completed = tasks.poll();
        completedTasks.push(completed);
        System.out.println("Completed Task: " + completed.name);
    }
    public void undoLastTask() {
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks to undo.");
            return;
        }

        task undone = completedTasks.pop();
        tasks.add(undone);
        System.out.println("Undo successful! Task restored: " + undone.name);
    }
    public void viewTasksByDeadline() {
    if (tasks.isEmpty()) {
        System.out.println("No tasks available.");
        return;
    }

    System.out.println("Pending Tasks (Sorted by Deadline):");

    List<task> list = new ArrayList<>(tasks);

    list.sort(Comparator.comparing(t -> t.deadline));

    for (task task : list) {
        System.out.println(task.name +
                " | Priority: " + task.priority +
                " | Deadline: " + task.deadline);
    }
}

}
