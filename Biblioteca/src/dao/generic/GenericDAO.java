package dao.generic;

import java.util.List;

public interface GenericDAO<ENTIDADE, CHAVE> {

	public void gravar(ENTIDADE entity);
	public void save(ENTIDADE entity);
	public void delete(ENTIDADE entity);
	public ENTIDADE find (CHAVE id);
	public List<ENTIDADE> find();
	public void beginTransaction();
	public void commit();
	public void rollBack();
	public void close();
}
