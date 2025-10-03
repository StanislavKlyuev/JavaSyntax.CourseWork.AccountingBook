public class Employee {
    private String surname;
    private String name;
    private String patronymic;
    private int department;
    private int salary;
    private int id;
    private static int idCounter;

    // переменные для красивого вывода информаци :)
    public static char rub = '₽';
    public static final String BLU = "\u001B[34m";
    public static final String RES = "\u001B[0m";

    public Employee(String surname, String name, String patronymic, int department, int salary) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        ++idCounter;
    }

    /* это метод на случай, если какого-нибуди сотрудника нужно уволить, а на его место взять нового
     и присвоить ему свободный id.
     Так же для увольнении сотрудников нужно написать метод для уменьшения idCounter. Но это уже другая история. */
    public void setId(int idnum) {
        this.id = idnum;
    }

    public static int idCounter() {
        return idCounter;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return this.department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return this.id;
    }


    // Переопределение сравнения сотрудников по зарплате
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return employee.salary == salary;
    }

    // Вывод полных данных сотрудника
    @Override
    public String toString() {
        return "id # " + id + ": ФАМИЛИЯ: " + BLU + surname + RES + "; ИМЯ: " + BLU + name + RES + "; ОТЧЕСТВО: " + BLU + patronymic + RES + "; ОТДЕЛ: " + BLU + department + RES + "; ЗАРПЛАТА: " + BLU + salary + rub + RES;
    }

    // Вывод сокращенной информации
    public void printShortInfo() {
        System.out.println("Сокращенные данные: " + "id # " + id + ": ФАМИЛИЯ: " + BLU + surname + RES + " ИМЯ: " + BLU + name + RES + "; ЗАРПЛАТА: " + BLU + salary + rub + RES);
    }
}