package ProjetoSpring.Controller.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Curso {

	@Id
	private Integer codigocurso;
	private String nomecurso;

	@JsonIgnore
	@OneToMany(mappedBy = "curso")
	private List<Aluno> alunos;
}
