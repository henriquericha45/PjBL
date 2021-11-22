import java.io.*;
import java.util.*;

public class DAO {

	String fileName = "PjBl.csv";
	String SEPARADOR = ",";

	FileReader reader;
	BufferedReader buffer;

	public double[][] getFile() throws IOException {

		FileReader arquivo = new FileReader(fileName);
		BufferedReader br = new BufferedReader(arquivo);
		br.readLine();

		ArrayList<Produto> lista = new ArrayList<Produto>();
		String linha;
		while ((linha = br.readLine()) != null) {
			String[] tokens = linha.split(SEPARADOR);

			if (tokens[0].equals("Filme")) {
				Filme filme = new Filme("Filme", tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]));
				lista.add(filme);
			}
			if (tokens[0].equals("Serie")) {
				Serie serie = new Serie("Serie", tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]),
						Integer.parseInt(tokens[5]));
				lista.add(serie);
			}
		}
		System.out.println("Dados recolhidos!");
		return lista;
	}
}