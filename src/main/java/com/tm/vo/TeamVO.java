package com.tm.vo;

/**
 *
 */
public class TeamVO {
    private Integer id;
    private String firstName;
    private String lastName;

    public String getEvaluationStatus() {
        return evaluationStatus;
    }

    public void setEvaluationStatus(String evaluationStatus) {
        this.evaluationStatus = evaluationStatus;
    }

    private String evaluationStatus;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    private String designation;
    private Integer supervisorId;

    public TeamVO (Integer id, String firstName, String lastName, String designation, Integer supervisorId,
                   String evaluationStatus) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setDesignation(designation);
        this.setSupervisorId(supervisorId);
        this.setEvaluationStatus(evaluationStatus);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }
}
