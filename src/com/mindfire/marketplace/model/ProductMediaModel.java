package com.mindfire.marketplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productmedias")
public class ProductMediaModel {
	
	@Id
	@Column(name = "p_mediacode")
	private String mediaCode;
	
	@Column(name = "p_productcode")
	private String productCode;
	
	@Column(name = "p_mediatype")
	private String mediaType;
	
	@Column(name = "p_mediaurl")
	private String mediaURL;
	
	
	public String getMediaCode() {
		return mediaCode;
	}
	public void setMediaCode(String mediaCode) {
		this.mediaCode = mediaCode;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getMediaURL() {
		return mediaURL;
	}
	public void setMediaURL(String mediaURL) {
		this.mediaURL = mediaURL;
	}
	public String getMediaType() {
		return mediaType;
	}
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
	
}
