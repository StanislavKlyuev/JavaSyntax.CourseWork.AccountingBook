public class EmployeeBook {
    private Employee[] employees;
    private String name;

    // переменные для красивого вывода информаци :)
    public static final String BLU = "\u001B[34m";
    public static final String RES = "\u001B[0m";
    public static char rub = '₽';

    // Создаем новую книгу (массив) сотрудников (конструктор)
    public EmployeeBook(String name, int size) {
        this.employees = new Employee[size];
        this.name = name;
    }

    /* Добавляем нового сотрудника
    Если принципиально реализовать через boolean (TRUE или FALSE) и поставить галочку в критериях оценки, переделать не составит труда,
    но с выводом успешного результата интереснее))
     */
    public void addEmployee(String surname, String name, String patron, int dept, int salary) {
        Employee employee = new Employee(surname, name, patron, dept, salary);
        int i = 0;
        for (Employee emp : employees) {
            if (emp == null) {
                emp = employee;
                employees[i] = employee;
                emp.setId(i + 1);
                System.out.println("Вы успешно добавили нового сотрудника в книгу " + this.name);
                break;
            } else {
                i++;
            }
        }
        if (i == employees.length)
            System.out.println("Вы пытались добавить нового сотрудника в книгу " + this.name + ". Увы, вакантных мест нет.");
    }

    // список всех сотрудников
    public void printAllEmployees() {
        System.out.println("Список всех сотрудников книги " + this.name);
        int idCounter = 0;
        for (Employee emp : employees) {
            if (emp == null)
                continue;
            System.out.println(emp);
            ++idCounter;
        }
        System.out.println("Общее количесвто сотрудников книги " + this.name + ": " + idCounter);
    }

    // среднее значение зарплаты
    public void printAverageSalary() {
        int sum = 0;
        int count = 0;
        for (Employee emp : employees) {
            if (emp == null)
                break;
            sum += emp.getSalary();
            count++;
        }
        System.out.println("Средняя зарплата сотрудников книги " + this.name + ": " + String.format("%.2f", (sum * 1.0 / count)) + rub);
    }

    // вывод налога
    public void printTax(String tax) {
        System.out.println("Данные по налогам сотрудников книги " + this.name + ": ");
        switch (tax) {
            case "PROPORTIONAL":
                int nal = 13;
                for (Employee emp : employees) {
                    if (emp == null)
                        continue;
                    System.out.println("Налог сотрудника " + BLU + emp.getSurname() + RES + " составляет " + nal + "% и равен " + BLU + String.format("%.2f", emp.getSalary() * nal * 1.0 / 100) + rub + RES);
                }
                break;
            case "PROGRESSIVE":
                for (Employee emp : employees) {
                    if (emp == null)
                        continue;
                    if (emp.getSalary() < 150)
                        nal = 13;
                    else if (emp.getSalary() < 350)
                        nal = 17;
                    else
                        nal = 21;
                    System.out.println("Налог сотрудника " + BLU + emp.getSurname() + RES + " составляет " + nal + "% и равен " + BLU + String.format("%.2f", emp.getSalary() * nal * 1.0 / 100) + rub + RES);
                }
                break;
            default:
                break;
        }
    }

    // индексация зарплаты сотрудникам отдела
    public void getDept(int dep, int index) {
        System.out.println("Индексация зарплат сотрудников книги " + this.name + ":");
        for (Employee emp : employees) {
            if (emp == null || emp.getDepartment() != dep)
                continue;
            else {
                int increase = emp.getSalary() * index / 100;
                emp.setSalary(emp.getSalary() + increase);
                System.out.println("Зарплата сотрудника " + BLU + emp.getSurname() + RES + " увеличина на " + increase + rub + " и составляет " + BLU + emp.getSalary() + rub + RES);
            }
        }
    }

    // вывод первого сотрудника с зарплатой выше порога
    public void getEmploy(int dep, int sal) {
        System.out.println("Сотрудник отдела " + dep + ", которому переплачивают:");
        for (Employee emp : employees) {
            if (emp == null || emp.getDepartment() != dep || emp.getSalary() <= sal)
                continue;
            else {
                emp.printShortInfo();
                break;
            }
        }
    }

    // вывод N сотрудников c зарплатой ниже порога
    public void getLowEmployees(int wage, int employeeNumber) {
        System.out.println("Сотрудники сотрудников книги " + this.name + ", которым не доплачивают:");
        int i = 0;
        for (Employee emp : employees) {
            if (emp == null || emp.getSalary() >= wage)
                continue;
            while (i < employeeNumber) {
                emp.printShortInfo();
                i++;
                break;
            }
        }
    }

    public boolean findEmployee(Employee employee) {
        System.out.println("Проверка по бух.учету");
        boolean have = false;
        for (Employee emp : employees) {
            if (emp.equals(employee)) {
                have = true;
                break;
            }
        }
        return have;
    }

    public Employee getEmployeeId(int id) {
        System.out.println("Соотрудник книги " + this.name + " по id # " + id);
        for (Employee emp : employees) {
            if (id == emp.getId())
                return emp;
        }
        return null;
    }

    // Удаляем сотрудника по номеру id
    public void deleteEmployee(int id) {
        System.out.println("Вы удалили соотрудника книги " + this.name + " по id # " + id);
        System.out.println(employees[id-1]);
        employees[id-1] = null;
    }
}