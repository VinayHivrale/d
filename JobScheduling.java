import java.util.*;

class Job {
    String name;
    int deadline, profit;

    Job(String name, int deadline, int profit) {
        this.name = name;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobScheduling {

     static void printJobs(String[] jobsSchedule) {
      for(String job : jobsSchedule){
        if(job==null){}
        else{
            System.out.print(job+" ");
        }
      }
    }


    public static String[] jobScheduling(List<Job> jobs) {

        Collections.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit));
        // List<String> scheduledJobs = new ArrayList<>();
        

        int totalProfit = 0;
        int maxDeadline = 0;

        for (Job job : jobs) {
            maxDeadline = Math.max(job.deadline, maxDeadline);
        }
        String[] jobsSchedule = new String[maxDeadline+1];
        boolean[] timeSlots = new boolean[maxDeadline + 1];

        for (Job job : jobs) {

            int deadline = job.deadline;

            while (deadline > 0 && timeSlots[deadline]) {
                deadline--;
            }

            if (deadline > 0) {
                // scheduledJobs.add(job.name);
                totalProfit += job.profit;
                timeSlots[deadline] = true;
                jobsSchedule[deadline] = job.name;
            }

        }

        System.out.println("Total proift is: " + totalProfit);

        return jobsSchedule;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of jobs: ");
        int numOfJobs = scanner.nextInt();

        List<Job> jobs = new ArrayList<>();
               
        for (int i = 1; i <= numOfJobs; i++) {
            System.out.print("Enter the name of job" + i + ": ");
            String jobName = scanner.next();
            System.out.print("Enter the deadline of job" + i + ": ");
            int deadline = scanner.nextInt();
            System.out.print("Enter the profit of job" + i + ": ");
            int profit = scanner.nextInt();

            jobs.add(new Job(jobName, deadline, profit));
        }

        // List<String> scheduledJobs = jobScheduling(jobs);
        String[] jobsSchedule = jobScheduling(jobs);
        System.out.print("[ ");
        printJobs(jobsSchedule);
        System.out.println("]");

        // System.out.println("Scheduled Jobs " + scheduledJobs);
        scanner.close();
    }
}