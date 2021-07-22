package ProjetoSpring.Controller.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table

public class Aluno {
	
	
	private String nome;
	@Id
	@NotEmpty(message = "CPF não pode ser vazio!")
	private String cpf;
	private Integer idade;
	
	@ManyToOne	
	@JoinColumn(name="codigocurso")
	private Curso curso;

}




