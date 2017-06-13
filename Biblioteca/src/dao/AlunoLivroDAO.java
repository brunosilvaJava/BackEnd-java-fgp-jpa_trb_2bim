package dao;

import dao.generic.GenericJPADAO;
import entity.AlunoLivro;
import entity.AlunoLivroPK;

public class AlunoLivroDAO extends GenericJPADAO<AlunoLivro, AlunoLivroPK> {

	@Override
	public Class<AlunoLivro> getEntityClass() {
		return AlunoLivro.class;
	}

}
