package com.lowcostairline.beans.crew;

import com.lowcostairline.beans.Entity;

import java.io.Serializable;
import java.util.Objects;


/**
 * aircraft - a class that implements basic
 * characteristics of all types of aircraft crew.
 * It can be extended, if you want to create:
 * <ul>
 *     <li>pilot</li>
 *     <li>steward</li>
 *     <li>Stewardess</li>
 * </ul>
 * @author Marta Gulida
 * @version 1.0
 */

public class AircraftCrew extends Entity implements Serializable {
    /** Field name for name of the aircraft crew member */
    private String name;

    /** Field surname for surname of the aircraft crew member*/
    private String lastName;

    /** Field work experience, which show how many years a person has been working */
    private int workExperience;

    private String jobDescription;

    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AircraftCrew that = (AircraftCrew) o;
        return workExperience == that.workExperience &&
                Double.compare(that.salary, salary) == 0 &&
                Objects.equals(name, that.name) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(jobDescription, that.jobDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, lastName, workExperience, jobDescription, salary);
    }
}
