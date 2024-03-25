public class Employee {
    private int baseSalary;
    private int hourlyRate;
    private int extraHours;

    // public Employee(int baseSalary, int hourlyRate, int extraHours){
    //     this.baseSalary =baseSalary;
    //     this.hourlyRate=hourlyRate;
    //     this.extraHours=extraHours;
    // }

    //getters
    public int getBaseSalary(){
        return baseSalary;
    }
    public int getHourlyRate(){
        return hourlyRate;
    }
    public int getExtraHours(){
        return extraHours;
    }

    //setters
    public void setBaseSalary(int baseSalary){
        this.baseSalary=baseSalary;
    }

    public void setHourlyRate(int hourlyRate){
        this.hourlyRate=hourlyRate;
    }
    public void setExtraHours(int extraHours){
        this.extraHours=extraHours;
    }

    public int calculateWage(){
        return baseSalary+(hourlyRate*extraHours);
    }

}
