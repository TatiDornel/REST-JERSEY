package br.com.dornel.easysystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "SYSTEM")
public class System  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@GenericGenerator(name="generator_system", strategy="native", parameters=@Parameter(name="sequence", value="system_id_seq"))
	@Id
//	@SequenceGenerator(name="system_id_seq",
//             sequenceName="system_id_seq")
//	@GenericGenerator(name="generator_system",  parameters=@Parameter(name="sequence", value="system_id_seq"), strategy = "sequence")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="generator_system")
	private Long id;
	
	@Column(name="NAME", nullable = false, length = 100, unique= true)
	private String name;
	
	@Column(name="DESCRIPTION", nullable = false, length = 55, unique= true)
	private String description;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
