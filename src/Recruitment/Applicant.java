package Recruitment;

//Applicant.java — Represents a job applicant
public class Applicant {
 private int    id;
 private String name;
 private String email;
 private String appliedRole;
 private int    experienceYears;
 private String status; // Applied, Shortlisted, Interviewed, Hired, Rejected

 public Applicant(int id, String name, String email,
                  String role, int exp) {
     this.id              = id;
     this.name            = name;
     this.email           = email;
     this.appliedRole     = role;
     this.experienceYears = exp;
     this.status          = "Applied"; // default status
 }

 // Getters
 public int    getId()             { return id; }
 public String getName()           { return name; }
 public String getEmail()          { return email; }
 public String getAppliedRole()    { return appliedRole; }
 public int    getExperience()      { return experienceYears; }
 public String getStatus()         { return status; }

 // Setters
 public void setStatus(String s)  { this.status = s; }

 public void display() {
     System.out.printf("%-4d %-18s %-25s %-15s %-5d %-12s%n",
         id, name, email, appliedRole, experienceYears, status);
 }
}
