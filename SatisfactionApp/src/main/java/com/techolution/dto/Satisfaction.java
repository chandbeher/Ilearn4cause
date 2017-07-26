package com.techolution.dto;

import java.io.Serializable;
import java.util.Map;

public class Satisfaction implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Map<Object, Integer> satisfactionPerUnit;
	private String totalTimeConsumed;
	private String totalSatisfaction;
	private String message;
	
	public Satisfaction() {
	}
	public Map<Object, Integer> getSatisfactionPerUnit() {
		return satisfactionPerUnit;
	}
	public void setSatisfactionPerUnit(Map<Object, Integer> satisfactionPerUnit) {
		this.satisfactionPerUnit = satisfactionPerUnit;
	}
	public String getTotalTimeConsumed() {
		return totalTimeConsumed;
	}
	public void setTotalTimeConsumed(String totalTimeConsumed) {
		this.totalTimeConsumed = totalTimeConsumed;
	}
	public String getTotalSatisfaction() {
		return totalSatisfaction;
	}
	public void setTotalSatisfaction(String totalSatisfaction) {
		this.totalSatisfaction = totalSatisfaction;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
