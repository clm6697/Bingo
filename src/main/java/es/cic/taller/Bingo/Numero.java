package es.cic.taller.Bingo;


public class Numero {
	
	private int mNumero;
	private boolean marcado;
	
	public Numero(int numero) {
		mNumero= numero;
	}
	
	public int getNumero() {
		return mNumero;
	}
	
	public boolean isMarcado() {
		return marcado;
	}

	public void setMarcado(boolean marcado) {
		this.marcado = marcado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mNumero;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Numero other = (Numero) obj;
		if (mNumero != other.mNumero)
			return false;
		return true;
	}
	
	
	public String getNombreFichero() {
		return mNumero + ".png";
	}

}
