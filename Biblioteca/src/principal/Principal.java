package principal;

import java.util.List;

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
		estanteA1.setDescricao("Estante A1");
		
		estanteDao.gravar(estanteA1);
		
		Estante estanteA2 = new Estante();
		estanteA2.setDescricao("Estante A2");
		
		estanteDao.gravar(estanteA2);
		
		estanteDao.commit();
		
		// ----------------------------------------------------------------------------------------------
		
		LivroDAO livroDao = new LivroDAO();
		
		Livro livroDorianGray = new Livro();
		livroDorianGray.setNome("O Retrato de Dorian Gray");
		livroDorianGray.setEstante(estanteA1);
		
		livroDao.gravar(livroDorianGray);
		
		Livro livroGulliver = new Livro();
		livroGulliver.setNome("As Viagens de Gulliver");
		livroGulliver.setEstante(estanteA2);
		
		livroDao.gravar(livroGulliver);
		
		livroDao.commit();
						
		// ----------------------------------------------------------------------------------------------
		
		AlunoDAO alunoDao = new AlunoDAO();
		
		Aluno alunoBruno = new Aluno();
		alunoBruno.setNome("Bruno Thiago da Silva");
		alunoBruno.setRa(140102150);
		
		alunoDao.gravar(alunoBruno);
		
		Aluno alunoVitor = new Aluno();
		alunoVitor.setNome("Vitor Leandro");
		alunoVitor.setRa(140102151);
		
		alunoDao.gravar(alunoVitor);
		
		alunoDao.commit();
		
		// ----------------------------------------------------------------------------------------------
		
		AlunoLivroDAO alunoLivroDao = new AlunoLivroDAO();
		
		AlunoLivroPK alunoLivroPK = new AlunoLivroPK();
		AlunoLivro novoEmprestimo = new AlunoLivro();
		
		alunoLivroPK.setLivroCodigo(livroDorianGray.getCodigo());
		alunoLivroPK.setRa(alunoBruno.getRa());
		
		novoEmprestimo.setAlunoLivroPK(alunoLivroPK);
		
		alunoLivroDao.gravar(novoEmprestimo);
		
		alunoLivroDao.commit();
		
		// ----------------------------------------------------------------------------------------------
		
		List<AlunoLivro> listaLivrosAlunos = alunoLivroDao.find();
		
		System.out.println("\n**** LIVROS EMPRESTADOS ****");
		
		for (AlunoLivro emprestimo : listaLivrosAlunos) {

			System.out.println("\nAluno: " + emprestimo.getAluno().getNome());
			System.out.println("Livro Emprestado: " + emprestimo.getLivro().getNome());
			
		}
		
		System.out.println("\n******************************");
		
		AlunoLivro al = alunoLivroDao.find(new AlunoLivroPK(13, 140102939));
		
		System.out.println("\nAluno: " + al.getAluno().getNome());
		System.out.println("Livro Emprestado: " + al.getLivro().getNome());
				
		JPAUtil.closeEntityManager();
				
	}
	
}
