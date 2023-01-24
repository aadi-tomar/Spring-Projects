public class ITEmployee implements IEmployee{

    private double salary;
    private int id;
    private String name;
    @Override
    public void giveHike(double amount) {
        this.salary = this.salary + amount;
    }

    @Override
    public void cutPay(double amout) {
        this.salary = this.salary - amout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
