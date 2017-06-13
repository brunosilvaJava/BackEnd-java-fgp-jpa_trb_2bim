package dao;

import dao.generic.GenericJPADAO;
import entity.Livro;

public class LivroDAO extends GenericJPADAO<Livro, Integer> {
	
	@Override
	public Class<Livro> getEntityClass() {
		return Livro.class;
	}

}
