public class Coordenador{

    public static void main(String[] args) {

        /*
        carrega as matrizes A e B (a partir dos dados dos arquivos 
        previamente gerados)
        */

        String pathA = "matrixA.txt";
        String pathB = "matrixB.txt";
        
        
        int m = 4;
        int n = 4;
        int k = 4;

        int n_calc = 1;
        
        double[][] matrixA = DAO.getFile(pathA, m, k);
        double[][] matrixB = DAO.getFile(pathB, k, n);


      


        /*
        aloca espaço em memória para armazenar a matriz C
        */

        double[][] matrixC = new double[m][n];

        /*
        faz a divisão do trabalho de cálculo da matriz C, determinando os 
        intervalos da matriz C que cada Calculador deverá resolver, de 
        forma que cada Calculador calcule aproximadamente a mesma 
        quantidade de elementos da matriz C
         */
         
        /*
        envia mensagem para cada Calculador contendo a matriz A, a matriz 
        B e os índices que determinam o intervalo a ser calculado (linha 
        inicial, linha final, coluna inicial e coluna final)
        */
        
        
        int anterior = 0;
        int sobra =  (m * n) % n_calc; //0
        int limite = ( m * n - sobra ) / n_calc - 1; //3

        for (int i = 0 ; i < n_calc; i++) {
            
            //System.out.println(i);
            //System.out.println("Limite: " + limite);
            //System.out.println("Sobra: " + sobra);
            //System.out.println("Anterior: " + anterior);
            
            
            
            if(sobra==0) {
                //System.out.println("Final: " + (int)(limite+anterior));

                Calculo calc = new Calculo(matrixA, matrixB, anterior, limite+anterior);

                Trabalhador trab = new Trabalhador(calc, 1000 * (i+1) );
                trab.start();

                anterior = anterior + limite + 1;
                
            } else {
                //System.out.println("Final: " + (int)(limite+anterior+1));

                Calculo calc = new Calculo(matrixA, matrixB, anterior, limite+anterior+1);

                Trabalhador trab = new Trabalhador(calc, 1000 * (i+1) );
                trab.start();

                anterior = anterior + limite + 2;

                sobra--;
            }

            
            
            
        }



        /*
        aguarda as mensagens com a resposta (parte calculada da matriz C)
        de cada Calculador, fazendo o preenchimento da matriz C
         */



         /*
         gera o arquivo correspondente à matriz C
          */

    }




}