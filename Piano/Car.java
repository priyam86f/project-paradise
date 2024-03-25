//Car Object
public class Car {

    // data
    private boolean pressAccelerator;
    private boolean isACOn;
    private boolean applyBrakes;

    // methods on data
    public void accelerate() {
        pressAccelerator = true;
    }

    public void AC() {
        isACOn = true;
    }

    public void brake() {
        applyBrakes = true;
    }

    public static void main(String[] args) {
       
        Employee mEmployee = new Employee();
        mEmployee.setBaseSalary(50000);
        mEmployee.setHourlyRate(50);
        mEmployee.setExtraHours(8);
        
       int res = mEmployee.calculateWage();
       System.out.println(res);
       
    }
}