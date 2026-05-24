package Recruitment;

//JobPosting.java — Represents an open job position
public class JobPosting {
 private int    jobId;
 private String title;
 private String department;
 private int    minExperience;
 private boolean isOpen;

 public JobPosting(int jobId, String title,
                   String dept, int minExp) {
     this.jobId         = jobId;
     this.title         = title;
     this.department    = dept;
     this.minExperience = minExp;
     this.isOpen        = true;
 }

 public int     getJobId()        { return jobId; }
 public String  getTitle()        { return title; }
 public String  getDepartment()   { return department; }
 public int     getMinExperience(){ return minExperience; }
 public boolean isOpen()         { return isOpen; }
 public void    close()          { isOpen = false; }

 public void display() {
     System.out.printf("%-4d %-20s %-15s %-8d %s%n",
         jobId, title, department, minExperience,
         isOpen ? "Open" : "Closed");
 }
}

