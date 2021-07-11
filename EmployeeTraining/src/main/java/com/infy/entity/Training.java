package com.infy.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.infy.Enum.Status;

@Entity
public class Training {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tId;
    private Integer empId;
 
    private String course;
    private String code;
    private Integer score;
    private Integer hoursSpent;
    private Date dateCompleted;
    
    private Status status;
    
	public Training(Integer tId, Integer empId, String course, String code, Integer score, Integer hoursSpent,
			Date dateCompleted, Status status) {
		super();
		this.tId = tId;
		this.empId = empId;
		this.course = course;
		this.code = code;
		this.score = score;
		this.hoursSpent = hoursSpent;
		this.dateCompleted = dateCompleted;
		this.status = status;
	}

	public Training() {

	}

	public Integer gettId() {
		return tId;
	}

	public void settId(Integer tId) {
		this.tId = tId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getHoursSpent() {
		return hoursSpent;
	}

	public void setHoursSpent(Integer hoursSpent) {
		this.hoursSpent = hoursSpent;
	}

	public Date getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Training[tId=" + tId + ", empId=" + empId + ", course=" + course + ", code=" + code + ", score="
				+ score + ", hoursSpent=" + hoursSpent + ", dateCompleted=" + dateCompleted + ", status=" + status
				+ "]";
	}
	
    
}
