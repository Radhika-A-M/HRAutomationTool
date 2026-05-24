package Recruitment;

import java.util.*;

//HRManager.java — Core logic for the HR system
public class HRManager {
 private ArrayList<Applicant>  applicants = new ArrayList<>();
 private ArrayList<JobPosting> jobs       = new ArrayList<>();
 private int nextApplicantId = 1;
 private int nextJobId       = 1;

 // ── JOB POSTINGS ──────────────────────────────────────────────

 public void addJobPosting(String title, String dept, int minExp) {
     jobs.add(new JobPosting(nextJobId++, title, dept, minExp));
     System.out.println("✔ Job posted.");
 }

 public void viewJobs() {
     if (jobs.isEmpty()) { System.out.println("No jobs posted."); return; }
     System.out.printf("%-4s %-20s %-15s %-8s %s%n",
         "ID", "Title", "Department", "MinExp", "Status");
     System.out.println("-".repeat(60));
     for (JobPosting j : jobs) j.display();
 }

 public void closeJob(int jobId) {
     for (JobPosting j : jobs) {
         if (j.getJobId() == jobId) { j.close(); System.out.println("✔ Job closed."); return; }
     }
     System.out.println("Job ID not found.");
 }

 // ── APPLICANTS ────────────────────────────────────────────────

 public void addApplicant(String name, String email,
                           String role, int exp) {
     applicants.add(new Applicant(nextApplicantId++, name, email, role, exp));
     System.out.println("✔ Applicant registered.");
 }

 public void viewApplicants() {
     if (applicants.isEmpty()) { System.out.println("No applicants."); return; }
     System.out.printf("%-4s %-18s %-25s %-15s %-5s %-12s%n",
         "ID", "Name", "Email", "Role", "Exp", "Status");
     System.out.println("-".repeat(80));
     for (Applicant a : applicants) a.display();
 }

 // Update pipeline status
 public void updateStatus(int id, String status) {
     for (Applicant a : applicants) {
         if (a.getId() == id) {
             a.setStatus(status);
             System.out.println("✔ Status updated to: " + status);
             return;
         }
     }
     System.out.println("Applicant ID not found.");
 }

 // Auto-shortlist: experience >= required for the role
 public void autoShortlist(String role, int minExp) {
     int count = 0;
     for (Applicant a : applicants) {
         if (a.getAppliedRole().equalsIgnoreCase(role)
                 && a.getExperience() >= minExp
                 && a.getStatus().equals("Applied")) {
             a.setStatus("Shortlisted");
             count++;
         }
     }
     System.out.println("✔ Shortlisted " + count + " applicant(s).");
 }

 // Filter by status
 public void filterByStatus(String status) {
     boolean found = false;
     for (Applicant a : applicants) {
         if (a.getStatus().equalsIgnoreCase(status)) {
             a.display(); found = true;
         }
     }
     if (!found) System.out.println("No applicants with status: " + status);
 }

 // Summary report
 public void report() {
     long hired    = applicants.stream().filter(a -> a.getStatus().equals("Hired")).count();
     long rejected = applicants.stream().filter(a -> a.getStatus().equals("Rejected")).count();
     long shortlist = applicants.stream().filter(a -> a.getStatus().equals("Shortlisted")).count();
     System.out.println("── HR Report ──────────────────");
     System.out.println("Total applicants : " + applicants.size());
     System.out.println("Shortlisted      : " + shortlist);
     System.out.println("Hired            : " + hired);
     System.out.println("Rejected         : " + rejected);
     System.out.println("Open jobs        : " + jobs.stream().filter(JobPosting::isOpen).count());
 }
}
