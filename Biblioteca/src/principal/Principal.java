package principal;

import java.util.List;

import javax.persistence.Query;

import dao.AlunoDAO;
import dao.AlunoLivroDAO;
import dao.EstanteDAO;
import dao.LivroDAO;
import dao.generic.JPAUtil;
import entity.Aluno;
import entity.AlunoLivro;
import entity.AlunoLivroPK;
import entity.Estante;
import entity.Livro;

public class Principal {

	public static void main(String[] args) {
		
		JPAUtil.beginTrasaction();
		
		EstanteDAO estanteDao = new EstanteDAO();
		
		Estante estanteA1 = new Estante();
		estanteA1.setDescricao("Estante A3");
		
		estanteDao.gravar(estanteA1);
		
		Estante estanteA2 = new Estante();
		estanteA2.setDescricao("Estante A4");
		
		estanteDao.gravar(estanteA2);
				
		// ----------------------------------------------------------------------------------------------
		
		LivroDAO livroDao = new LivroDAO();
		
		Livro livro1 = new Livro();
		livro1.setNome("Acabou tudo");
		livro1.setEstante(estanteA1);
		
		livroDao.gravar(livro1);
		
		Livro livroGulliver = new Livro();
		livroGulliver.setNome("Começou agora");
		livroGulliver.setEstante(estanteA2);
		
		livroDao.gravar(livroGulliver);
								
		// ----------------------------------------------------------------------------------------------
		
		AlunoDAO alunoDao = new AlunoDAO();
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Fulano de Tal");
		aluno1.setRa(140102102);
		
		alunoDao.save(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Fulana de Tal");
		aluno2.setRa(140102103);
		
		alunoDao.save(aluno2);
				
		// ----------------------------------------------------------------------------------------------
		
		AlunoLivroDAO alunoLivroDao = new AlunoLivroDAO();
		
		AlunoLivroPK alunoLivroPK = new AlunoLivroPK();
		AlunoLivro novoEmprestimo = new AlunoLivro();
		
		alunoLivroPK.setLivroCodigo(livro1.getCodigo());
		alunoLivroPK.setRa(aluno1.getRa());
		
		novoEmprestimo.setAlunoLivroPK(alunoLivroPK);
		
		alunoLivroDao.gravar(novoEmprestimo);
		
		JPAUtil.commit(); // transação fechada neste momento
		
		// ----------------------------------------------------------------------------------------------
		
		System.out.println("\n**** LIVROS EMPRESTADOS ****\n");
		
		Query query = JPAUtil.getEntityManager().createNamedQuery("buscarEmprestimos");
		
		List<AlunoLivro> listaLivrosAlunos = query.getResultList();
		
		for (AlunoLivro emprestimo : listaLivrosAlunos) {

			System.out.println("\nAluno: " + emprestimo.getAluno().getNome());
			System.out.println("Livro Emprestado: " + emprestimo.getLivro().getNome());
			
		}
				
		JPAUtil.closeEntityManager();
				
	}
	
}
