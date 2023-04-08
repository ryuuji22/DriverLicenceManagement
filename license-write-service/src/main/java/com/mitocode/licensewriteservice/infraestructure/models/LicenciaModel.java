package com.mitocode.licensewriteservice.infraestructure.models;

import java.time.LocalDate;
import java.util.Collection;

import com.mitocode.licensewriteservice.domain.enums.EstadoType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "LICENCIAS", schema = "public")
@Getter
@Setter
@NoArgsConstructor
public class LicenciaModel extends BaseEntityModel{
	
	@Column(name = "rut", nullable = false)
    private Integer rut;

    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDate fechaSolicitud;
    
    @Column(name = "fecha_validez_desde", nullable = false)
    private LocalDate fechaValidezDesde;
    
    @Column(name = "fecha_validez_hasta", nullable = false)
    private LocalDate fechaValidezHasta;
    
    @Column(name = "estado", nullable = false)
	@Enumerated(EnumType.STRING)
	private EstadoType estado;

    @ManyToOne
    @JoinColumn(name = "solicitante_id", referencedColumnName = "id")
    private SolicitanteModel solicitante;
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy="licencia", cascade={CascadeType.ALL})
	private Collection<LicenciaCategoriaModel> licenciaCategorias;
    

}
