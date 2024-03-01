package com.empbulletin.bootcampersbulletin.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Interviews")
public class Interviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interviews_id;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employee employee;

    @Column(name = "unix")
    private Float unix;
    @Column(name = "sequel")
    private Float  sequel;
    @Column(name = "java")
    private Float  java;
    @Column(name = "testing")
    private Float testing;
    @Column(name = "python")
    private Float python;
    @Column(name = "aiml")
    private Float aiml;
    @Column(name = "azure")
    private Float azure;
    @Column(name = "git")
    private Float git;
    @Column(name = "jenkins")
    private Float jenkins;
    @Column(name = "devops")
    private Float devops;

    public Interviews() {
    }

    public Interviews(Long interviews_id, Employee employee, Float unix, Float sequel, Float java, Float testing, Float python, Float aiml, Float azure, Float git, Float jenkins, Float devops) {
        this.interviews_id = interviews_id;
        this.employee = employee;
        this.unix = unix;
        this.sequel = sequel;
        this.java = java;
        this.testing = testing;
        this.python = python;
        this.aiml = aiml;
        this.azure = azure;
        this.git = git;
        this.jenkins = jenkins;
        this.devops = devops;
    }
    // Additional fields
    @Transient
    private Float average_interviews;

    @Transient
    private String interviews_rating;

    // Calculate average_marks
    @PostLoad
    public void calculateAverageInterviews() {
        float totalInterviews = unix + sequel + java + testing + python + aiml + azure + git + jenkins + devops;
        average_interviews = totalInterviews / 10;
        calculateInterviewsRating();
    }

    // Calculate marks_rating based on average_marks
    private void calculateInterviewsRating() {
        if (average_interviews >= 9.0) {
            interviews_rating = "Excellent";
        } else if (average_interviews >= 7.0) {
            interviews_rating = "Good";
        } else if (average_interviews >= 5.0) {
            interviews_rating = "Average";
        } else {
            interviews_rating = "Poor";
        }
    }


    @Override
    public String toString() {
        return "Interviews{" +
                "interviews_id=" + interviews_id +
                ", employee=" + employee +
                ", unix=" + unix +
                ", sequel=" + sequel +
                ", java=" + java +
                ", testing=" + testing +
                ", python=" + python +
                ", aiml=" + aiml +
                ", azure=" + azure +
                ", git=" + git +
                ", jenkins=" + jenkins +
                ", devops=" + devops +
                '}';
    }

}
