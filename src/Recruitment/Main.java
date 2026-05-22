package Recruitment;

import java.util.Scanner;

//HRMain.java — Entry point for the HR tool
public class Main {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     HRManager hr = new HRManager();
     
     while (true) {
         System.out.println("\n===== HR Recruitment Tool =====");
         System.out.println("--- Job Postings ---");
         System.out.println("1. Post a New Job");
         System.out.println("2. View All Jobs");
         System.out.println("3. Close a Job");
         System.out.println("--- Applicants ---");
         System.out.println("4. Register Applicant");
         System.out.println("5. View All Applicants");
         System.out.println("6. Update Applicant Status");
         System.out.println("7. Auto-Shortlist by Role & Experience");
         System.out.println("8. Filter Applicants by Status");
         System.out.println("9. HR Summary Report");
         System.out.println("0. Exit");
         System.out.print("Choose: ");

         int choice = sc.nextInt(); sc.nextLine();

         switch (choice) {
             case 1:
                 System.out.print("Job Title: ");    String t = sc.nextLine();
                 System.out.print("Department: ");  String d = sc.nextLine();
                 System.out.print("Min Years Exp: "); int m = sc.nextInt(); sc.nextLine();
                 hr.addJobPosting(t, d, m); break;
             case 2: hr.viewJobs(); break;
             case 3:
                 System.out.print("Job ID to close: ");
                 hr.closeJob(sc.nextInt()); sc.nextLine(); break;
             case 4:
                 System.out.print("Name: ");    String n = sc.nextLine();
                 System.out.print("Email: ");   String e = sc.nextLine();
                 System.out.print("Role: ");    String r = sc.nextLine();
                 System.out.print("Years Exp: "); int y = sc.nextInt(); sc.nextLine();
                 hr.addApplicant(n, e, r, y); break;
             case 5: hr.viewApplicants(); break;
             case 6:
                 System.out.print("Applicant ID: "); int id = sc.nextInt(); sc.nextLine();
                 System.out.println("Statuses: Applied / Shortlisted / Interviewed / Hired / Rejected");
                 System.out.print("New Status: "); String st = sc.nextLine();
                 hr.updateStatus(id, st); break;
             case 7:
                 System.out.print("Role: "); String sr = sc.nextLine();
                 System.out.print("Min Exp: "); int se = sc.nextInt(); sc.nextLine();
                 hr.autoShortlist(sr, se); break;
             case 8:
                 System.out.print("Status to filter: ");
                 hr.filterByStatus(sc.nextLine()); break;
             case 9: hr.report(); break;
             case 0:
                 System.out.println("Goodbye!"); sc.close(); return;
             default: System.out.println("Invalid option.");
         }
     }
 }
}
