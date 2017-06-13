package dao.generic;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericJPADAO<ENTIDADE, CHAVE> implements GenericDAO<ENTIDADE, CHAVE> {
	
	public abstract Class<ENTIDADE> getEntityClass();
	
	@Override
	public void gravar(ENTIDADE entity) {
		JPAUtil.getEntityManager().persist(entity); // inclui
	}
	
	@Override
	public void save(ENTIDADE entity) {
		JPAUtil.getEntityManager().merge(entity); // inclui ou altera
	}

	@Override
	public void delete(ENTIDADE entity) {
		JPAUtil.getEntityManager().remove(entity);
	}

	@Override
	public ENTIDADE find(CHAVE id) {
		return JPAUtil.getEntityManager().find(getEntityClass(), id);
	}

	@Override
	public List<ENTIDADE> find() {
		CriteriaQuery<ENTIDADE> cq = JPAUtil.getEntityManager().getCriteriaBuilder().createQuery(getEntityClass());
		cq.from(getEntityClass());
		return JPAUtil.getEntityManager().createQuery(cq).getResultList();
	}

	@Override
	public void beginTransaction() {
		JPAUtil.beginTrasaction();
	}

	@Override
	public void commit() {
		JPAUtil.commit();
	}

	@Override
	public void rollBack() {
		JPAUtil.rollBack();
	}

	@Override
	public void close() {
		JPAUtil.closeEntityManager();	
	}
	
}
