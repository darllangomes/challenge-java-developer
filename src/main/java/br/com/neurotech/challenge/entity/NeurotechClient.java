package br.com.neurotech.challenge.entity;

import br.com.neurotech.challenge.DTOS.NeuroTechClientDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(of="id")
@Entity(name="clients")
@Table(name="clients")
@AllArgsConstructor
@NoArgsConstructor
public class NeurotechClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer age;
	private Double income;

	public NeurotechClient(NeuroTechClientDTO data){
		this.age = data.age();
		this.income = data.income();
		this.name = data.name();
	}

}