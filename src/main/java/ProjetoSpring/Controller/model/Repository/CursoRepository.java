package ProjetoSpring.Controller.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetoSpring.Controller.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
