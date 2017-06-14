package entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="aluno_livro")
@NamedQuery(name="buscarEmprestimos", query="select al from AlunoLivro al")
public class AlunoLivro {
	
	@EmbeddedId
	private AlunoLivroPK alunoLivroPK;
	
	@JoinColumn(name="ra", referencedColumnName="ra", insertable=false, updatable=false)
	@ManyToOne
	private Aluno aluno;
	
	@JoinColumn(name="livroCodigo", referencedColumnName="codigo", insertable=false, updatable=false)
	@ManyToOne
	private Livro livro;
	
	public AlunoLivro() {
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public AlunoLivroPK getAlunoLivroPK() {
		return alunoLivroPK;
	}

	public void setAlunoLivroPK(AlunoLivroPK alunoLivroPK) {
		this.alunoLivroPK = alunoLivroPK;
	}
	
}
