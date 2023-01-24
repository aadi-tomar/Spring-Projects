import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EmployeeSalaryInvocationHandler implements InvocationHandler {

    private IEmployee employeeTarget;

    public EmployeeSalaryInvocationHandler(IEmployee employeeTarget) {
        this.employeeTarget = employeeTarget;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("Executing method " + method.getName());
        if(method.getName().equals("giveHike")) {
            double hikeValue = (double) args[0];
            //pre-processing
            if (hikeValue < 0.0)
                throw new RuntimeException("Hike cant be negative");
        }

        //method calling
        Object result = method.invoke(employeeTarget, args);

        //post processing

        return result;
    }
}
