package classes;

public class Cidade
{
	int codCidade;
	String nome;
	String cordX;
	String cordY;

	public Cidade(int cod, String nomeCidade, String coordenadaX, String coordenadaY)
	{
		this.codCidade = cod;
		this.nome = nomeCidade;
		this.cordX = coordenadaX;
		this.cordY = coordenadaY;
	}

	public String toString()
	{
		String retorno;

		retorno = "Código: " + this.codCidade + ", nome: " + this.nomeCidade + ", coordenadaX: " + this.cordX + ", coordenadaY: " + this.cordY;

		return retorno;
    }
}