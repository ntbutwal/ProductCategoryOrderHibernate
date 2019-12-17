package com.hibernate.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "date")
	private Date orderDate;

	@Column(name = "status")
	private String status;

	@Column(name = "shipping_address")
	private String shippingAddress;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "ordered_products", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = {
			@JoinColumn(name = "product_id") })
	private List<ProductEntity> productent;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<ProductEntity> getProductent() {
		return productent;
	}

	public void setProductent(List<ProductEntity> productent) {
		this.productent = productent;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", orderDate=" + orderDate + ", status=" + status + ", shippingAddress="
				+ shippingAddress + ", productent=" + productent + "]";
	}

}
