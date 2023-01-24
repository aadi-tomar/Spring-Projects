import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        ITEmployee itEmployee = new ITEmployee();
        itEmployee.setId(1);
        itEmployee.setName("Aaditya");
        itEmployee.setSalary(35000);

        //System.out.println();

        EmployeeSalaryInvocationHandler empHandler = new EmployeeSalaryInvocationHandler(itEmployee);
        IEmployee employee = (IEmployee) Proxy.newProxyInstance(ITEmployee.class.getClassLoader(),
                new Class[] {IEmployee.class}, empHandler);

        employee.giveHike(5000);

        System.out.println(employee.getSalary());

    }
}
