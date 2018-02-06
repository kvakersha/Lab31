import java.util.ArrayList;
import java.util.Random;


class Transposing extends Thread
{

    private static ArrayList<ArrayList<Double>> matrix1;//исходная матрица
    private static ArrayList<ArrayList<Double>> matrix2;//получившаяся матрица
    int row;//строка
    int column;//столбец

    Transposing(ArrayList<ArrayList<Double>> matrix1, ArrayList<ArrayList<Double>> matrix2,int row){
        this.matrix1=matrix1;
        this.matrix2 = matrix2;
        this.row = row;
    }
    @Override

    public void run(){
        for (int j = 0; j < matrix1.size(); j++)
            matrix2.get(j).set(row,matrix1.get(row).get(j));
    }
}


class Matr {

    private ArrayList<ArrayList<Double>> matrix = new ArrayList<ArrayList<Double>>();
    private ArrayList<ArrayList<Double>> result = new ArrayList<ArrayList<Double>>();
    ArrayList<Transposing> threads;


    public Matr(ArrayList<ArrayList<Double>> matrix) {
        this.matrix = matrix;
        int a = matrix.size();
        Random r = new Random();
        r.nextDouble();
        for (int i = 0; i < a; i++) {
            ArrayList<Double> temp2 = new ArrayList<Double>(); // added ()
            for (int j = 0; j < a; j++)
                temp2.add(0d);
            result.add(temp2);
        }
    }

    ArrayList<ArrayList<Double>> getResult(){ return result;}


    public void start(){
        threads=new ArrayList<Transposing>();
        for(int i=0;i<matrix.size();i++){
            threads.add(new Transposing(matrix,result,i));	//Создание потока

            threads.get(i).start();
            try{
                threads.get(i).join();
            }catch(InterruptedException e){
                System.out.println("er");
            }//Запуск потока
        }
    }

}




public class TransposeMatrix {
    public static void main(String[] args){    }
}
