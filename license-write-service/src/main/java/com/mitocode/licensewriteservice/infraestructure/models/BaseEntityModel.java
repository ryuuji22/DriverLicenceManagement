package com.mitocode.licensewriteservice.infraestructure.models;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntityModel {

	@Id
	private String id;

	private Boolean enabled;

	@CreatedDate
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@PrePersist
	public void prePersist() {
		this.createdAt = new Date(System.currentTimeMillis());
		this.id = UUID.randomUUID().toString();
		this.enabled = Boolean.TRUE;
	}

}
