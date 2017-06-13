package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlunoLivroPK implements Serializable {

	@Column
	private Integer livroCodigo;
	
	@Column
	private Integer ra;
	
	public AlunoLivroPK() {
	}
	
	public AlunoLivroPK(Integer livroCodigo, Integer ra) {
		this.livroCodigo = livroCodigo;
		this.ra = ra;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof AlunoLivroPK){
			
			AlunoLivroPK alunoLivroPK = (AlunoLivroPK) obj;
			
			return alunoLivroPK.getRa().equals(ra) && alunoLivroPK.getLivroCodigo().equals(livroCodigo);
			
		}
		
		return false;
		
	}
	
	@Override
	public int hashCode() {
		return ra.hashCode() + livroCodigo.hashCode() ;
	}

	public Integer getLivroCodigo() {
		return livroCodigo;
	}

	public void setLivroCodigo(Integer livroCodigo) {
		this.livroCodigo = livroCodigo;
	}

	public Integer getRa() {
		return ra;
	}

	public void setRa(Integer ra) {
		this.ra = ra;
	}
	
}
