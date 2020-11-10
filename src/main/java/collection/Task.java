package collection;

public class Task {
    private String desc;
    private int priority;
    private String number;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public Task(String number, String description) {
        this.number = number;
        this.desc = description;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }

    public String getNumber() {
        return number;
    }
}
