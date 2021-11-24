import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
					matrix[i][j] = Double.parseDouble(values[i]);
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

	public static void main(String[] args) {
		String path = "matrix4X4.txt";

		double[][] matrix = getFile(path, 4, 4);

		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				System.out.println(matrix[j][i]);
			}
		}
	}
}