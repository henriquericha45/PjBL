import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DAO {


	public static double[][] getFile(String path, int numLinhas, int numColunas) {

		String line = "";
		String SEPARADOR = ",";
		double[][] matrix = new double[numLinhas][numColunas];
		int j = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));

			while ((line = br.readLine()) != null) {
				String[] values = line.split(SEPARADOR);
				
				for(int i=0; i<values.length; i++){
					matrix[j][i] = Double.parseDouble(values[i]);
				}
				j++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		

		return matrix;
	}

	public static void generateFile(double[][] matrix) throws IOException{


		
		FileWriter writer = new FileWriter("matrixC.txt");

		

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				writer.append(String.valueOf(matrix[i][j])+",");
				
			}
			writer.append("\n");
		}
		writer.close();

		
	}
}