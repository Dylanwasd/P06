package sg.edu.rp.c346.p06;

public class Task {
    private int id;
    private String task;
    private String notes;

    public Task(int id, String task, String notes) {
        this.id = id;
        this.task = task;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getNotes() {
        return notes;
    }
}
