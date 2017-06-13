package dao;

import dao.generic.GenericJPADAO;
import entity.Estante;

public class EstanteDAO extends GenericJPADAO<Estante, Integer> {
	
	@Override
	public Class<Estante> getEntityClass() {
		return Estante.class;
	}

}
