public class task implements Comparable<task> {

    String name;
    int priority; // 1 = High, 2 = Medium, 3 = Low
    String deadline;

    public task(String name, int priority, String deadline) {
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
    }

    @Override
    public int compareTo(task other) {
        return Integer.compare(this.priority, other.priority);
    }
}
