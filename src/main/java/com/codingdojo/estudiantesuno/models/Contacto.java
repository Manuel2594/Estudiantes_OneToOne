package com.codingdojo.estudiantesuno.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Contactos")
public class Contacto {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) // Primarikey
		private Long id;
		@Size(min = 5, max = 20)
		private String direccion;
		@Size(min = 5, max = 20)
		private String ciudad;
		@Size(min = 5, max = 20)
		private String estado;
		@Column(updatable = false)
		@DateTimeFormat(pattern = "dd-MM-yyyy")
		private Date createdAt;
		@DateTimeFormat(pattern = "dd-MM-yyyy")
		private Date updatedAt;

		@OneToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "estudiante_id")
		private Estudiante estudiante;

		
//Contructor
		public Contacto() {
		}
		
//GETTER AND SETTER
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public String getCiudad() {
			return ciudad;
		}
		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}
		public String getEstado() {
			return estado;
		}
		public void setEstado(String estado) {
			this.estado = estado;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		public Estudiante getEstudiante() {
			return estudiante;
		}
		public void setEstudiante(Estudiante estudiante) {
			this.estudiante = estudiante;
		}
		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
	}