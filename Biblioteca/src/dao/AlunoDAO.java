package dao;

import dao.generic.GenericJPADAO;
import entity.Aluno;

public class AlunoDAO extends GenericJPADAO<Aluno, Integer> {

	@Override
	public Class<Aluno> getEntityClass() {
		return Aluno.class;
	}
	
}
