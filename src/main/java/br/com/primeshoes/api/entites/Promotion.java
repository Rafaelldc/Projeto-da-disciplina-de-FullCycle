package br.com.primeshoes.api.entites;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "promotions")
public class Promotion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private float discountPercentage;
	private Date startDate;
	private Date endDate;
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name = "product_variation_id")
	private ProductVariation productVariation;
	
	public Promotion() {}
		
	public Promotion(long id, String name, float discountPercentage, Date startDate, Date endDate, boolean isActive) {
		this.id = id;
		this.name = name;
		this.discountPercentage = discountPercentage;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isActive = isActive;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}