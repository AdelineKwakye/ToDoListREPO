import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // scanner object
        ArrayList<String> tasks = new ArrayList<>(); // makes an empty string array list
        int choice = 0;

        while (choice != 4) {
            displayMenu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    viewTasks(tasks);
                    break;
                case 2:
                    addTask(tasks, sc);
                    break;
                case 3:
                    removeTask(tasks, sc);
                    break;
                case 4:
                    System.out.println("Come back soon! Goodbye!"); // Exit message
                    break;

            }
        }
        sc.close();

    }

    public static void displayMenu (){ // this the menu that appears with all the choices that the user can make
        System.out.println("To Do List Menu:");
        System.out.println("Choose option 1-4:");
        System.out.println("1. View To Do List");
        System.out.println("2. Add task to list");
        System.out.println("3. Remove task from list");
        System.out.println("4. Exit");
    }
    public static void addTask (ArrayList<String> tasks, Scanner s){ // add a task to the list
        System.out.println("Enter task name: "); // prompts the user
        String taskName = s.nextLine(); // stores what the user said
        String lowerCaseTaskName = taskName.toLowerCase();
        tasks.add(lowerCaseTaskName); // adds the task tothe arrayList
    }
    public static void removeTask (ArrayList<String> tasks, Scanner s){ // remove a task from the list
       viewTasks(tasks); // look at the list of task
       if(!tasks.isEmpty()){
           System.out.println("Enter the name of the task without the number that you want to remove: ");
           String taskName = s.nextLine().trim(); // gets rid of white spaces when looking at user input
           String lowerCaseTaskName = taskName.toLowerCase();
           if(!tasks.contains(lowerCaseTaskName)){
              System.out.println("Task, " + lowerCaseTaskName + ", not found!");
           }else{
               tasks.remove(lowerCaseTaskName);
               System.out.println("Task," + lowerCaseTaskName+ ", was removed!");
           }

       } else{
           System.out.println("To Do List is empty!");
       }
    }
    public static void viewTasks(ArrayList<String> tasks){ // see the stuff in the list
        if(tasks.isEmpty()){ // checks to see if the array list is empty
            System.out.println("There are no tasks to view");
        }else{
            System.out.println("\nTo Do List:");
            int counter = 0; // keep track of the number of tasks
            for(int i=0; i<tasks.size(); i++){ // iterates through each task and prints it while keeping track of it
                counter++;
                System.out.println((i+1) + ". " + tasks.get(i));
            }
            System.out.println("There are " + counter + " tasks left to do");
        }

    }

}
