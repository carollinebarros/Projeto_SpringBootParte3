package ProjetoSpring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetoSpring.Controller.model.Curso;
import ProjetoSpring.Controller.model.Repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class ControllerCurso {

	@Autowired
	private CursoRepository cursoRepository;

	@PostMapping("/publicar")
	public Curso publicar(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}

	@GetMapping("/visualizar")
	public List<Curso> visualizar() {
		return cursoRepository.findAll();
	}

	@GetMapping("/procurar/{codigocurso}")
	public Optional<Curso> procurar(@PathVariable Integer codigocurso) {
		return cursoRepository.findById(codigocurso);
	}

	@PutMapping("/atualizar/{codigocurso}")
	public String atualizar(@PathVariable("codigocurso") Integer codigocurso, @RequestBody Curso newCurso) {
		Optional<Curso> oldCurso = this.cursoRepository.findById(codigocurso);
		if (oldCurso.isPresent()) {
			Curso curso = oldCurso.get();
			curso.setCodigocurso(newCurso.getCodigocurso());
			curso.setNomecurso(newCurso.getNomecurso());
			cursoRepository.save(curso);
			return "Curso alterado com sucesso!";
		} else {
			return "Curso não cadastrado!";
		}
	}

	@DeleteMapping("/remover/{codigocurso}")
	public void remover(@PathVariable Integer codigocurso) {
		cursoRepository.deleteById(codigocurso);
	}
}
