package com.ravi.Hiberanate_OES.Entities;

// imported packages
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

	@Entity
	public class Options {

		// add required field/variables which you want to add for table structure 
		// and make sure it should be in private
				
		@Id
		private int optionNumber;
		private String correctOpt;
		private String wrongOpt;
		
		@ManyToOne
		@JoinColumn(name="qId")
		private Questions questions;
		
		//Apply setters and getters
		
		public Questions getQuestions() {
			return questions;
		}
		public void setQuestions(Questions questions) {
			this.questions = questions;
		}
		public int getOptionNumber() {
			return optionNumber;
		}
		public void setOptionNumber(int optionNumber) {
			this.optionNumber = optionNumber;
		}
		
		public String getCorrectOpt() {
			return correctOpt;
		}
		public void setCorrectOpt(String correctOpt) {
			this.correctOpt = correctOpt;
		}
		public String getWrongOpt() {
			return wrongOpt;
		}
		public void setWrongOpt(String wrongOpt) {
			this.wrongOpt = wrongOpt;
		}
		@Override
		public String toString() {
		    return "Options [optionNumber=" + optionNumber + 
		           ", correctOpt=" + correctOpt + ", wrongOpt=" + wrongOpt + "]";
		}
}
