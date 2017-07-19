package es.cic.taller.Bingo;


public class Numero {
	
	private int mNumero;
	
	
	public Numero(int Numero) {
		mNumero= Numero;
	}
	public int getNumero() {
		return mNumero;
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

}
