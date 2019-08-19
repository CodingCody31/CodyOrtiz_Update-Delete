package com.codyortiz.mvc.models;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Size(min = 5, max = 200)
	    private String title;
	    @Size(min = 5, max = 200)
	    private String description;
	    @Size(min = 3, max = 40)
	    private String language;
	    @Min(100)
	    private Integer numberOfPages;
	    // This will not allow the createdAt column to be updated after creation
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Calendar createdAt;
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Calendar updatedAt;
	    

	    public Book() {
			super();
		}
	    
	    
		public Book (Long id, String title, String description, String language, Integer numberOfPages) {
			this.id = id;
			this.title = title;
			this.description = description;
			this.language = language;
			this.numberOfPages = numberOfPages;
		}
		public Book (String title, String description, String language, Integer numberOfPages) {
			
			this.title = title;
			this.description = description;
			this.language = language;
			this.numberOfPages = numberOfPages;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		public String getLanguage() {
			return language;
		}


		public void setLanguage(String language) {
			this.language = language;
		}


		public Integer getNumberOfPages() {
			return numberOfPages;
		}


		public void setNumberOfPages(Integer numberOfPages) {
			this.numberOfPages = numberOfPages;
		}


		public Calendar getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(Calendar createdAt) {
			this.createdAt = createdAt;
		}


		public Calendar getUpdatedAt() {
			return updatedAt;
		}


		public void setUpdatedAt(Calendar updatedAt) {
			this.updatedAt = updatedAt;
		}


		// other getters and setters removed for brevity
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = Calendar.getInstance();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = Calendar.getInstance();
	    }

}
