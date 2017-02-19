import java.text.DecimalFormat;
import java.util.*;

public class BusquedaKnn {
    public static void main (String[] args) {

       Scanner entrada = new Scanner(System.in);
        DecimalFormat formateador = new DecimalFormat("#.###");

        System.out.println ("Dime el valor de n");
        int n = entrada.nextInt();
        System.out.println ("Dime el valor de d");
        int d = entrada.nextInt();

		/*int n =10;
		int d =10;*/
        int g =0;
        double suma=0.0;

        double m[] = new double[d];
        double q[] = new double[d];
        double guardar[] = new double[d];

        for (int i = 0; i<n; i++){
            //geneador de m
            for (int j = 0; j<m.length; j++){
                m[j] = Math.random()*(1-0);

                System.out.println ("m"+ i +": " +  formateador.format(m[j]));
            }

            //generador de q
            System.out.println ("******************");
            q[i] = Math.random()*(1-0);
            System.out.println ("q"+ i +": " +  formateador.format(q[i]));

            System.out.println ("******************");
        }

        g=n;
        if(d > n){
            g=d;
        }
        for (int l = 0; l<guardar.length; l++){
            double val1 = 0;
            if(m.length > l){
                val1=m[l];
            }
            double val2=0;
            if(q.length>l){
                val2=q[l];
            }

            suma = suma + Math.pow(val2-val1, 2);

            guardar[l]=Math.sqrt(suma);

            System.out.println ("L"+l+ ": "+formateador.format(guardar[l]));
        }
        System.out.println ("**********ordenados********");
        double aux;
        for (int k=0; k<guardar.length-1; k++)
        {
            for (int j=0; j<guardar.length-1; j++)
            {
                if(guardar[j+1]<guardar[j])
                {
                    aux=guardar[j+1];
                    guardar[j+1]=guardar[j];
                    guardar[j]=aux;
                }
            }
        }
        for (int h = 0; h<guardar.length; h++)
        {
            System.out.println(formateador.format(guardar[h]));
        }
        System.out.println ("**********busqueda********");

        System.out.println ("Qué número deseas buscar?");
        double numero=entrada.nextDouble();

        int pos=-1;

        for (int r = 0; r<guardar.length; r++)
        {
            if(numero == guardar[r])
            {
                pos = r;
            }
            //	System.out.println (r);
        }
        if(numero == guardar[pos])
        {
            System.out.println ("El numero esta en la posision: " + (pos+1));
        }
        else{
            System.out.println ("El numero no esta esta en la posision: " + (pos+1));
        }


    }//main
}
