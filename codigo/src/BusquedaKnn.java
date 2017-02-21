
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.*;

public class BusquedaKnn {

    String linea = null;

    public String []cargarNumeros()
    {
        File archivo1 = new File("Numeros.txt");
        FileReader fr1 = null;
        BufferedReader bfr1= null;
        String numerosCargados[] = new String [1000];

        try
        {
            fr1 = new FileReader(archivo1);
            bfr1 = new BufferedReader(fr1);

            int conta=0; //sirve para contar las lineas del archivo
            while ((linea = bfr1.readLine())!=null)
            {
                numerosCargados[conta] = linea.toUpperCase();
                conta++;
            }

        }//llave try
        catch(NullPointerException npe)
        {
            npe.getMessage();
        }
        catch (IOException ioe)
        {
            System.out.println ("No existe ese archivo");
        }
        finally
        {
            try
            {
                if( fr1!=null )
                {
                    fr1.close();
                    bfr1.close();
                }
            }
            catch (IOException ioe2)
            {
                System.out.println ("No existe el archivo");
            }
        }//finally
        return numerosCargados;
    }//metodo cargar numeros

    ////////////////////////////////////////////////////////////////////////////////
    public void verificarArchivo()
    {
        BusquedaKnn bu= new BusquedaKnn();
        int contaNumeros = 0;

        for (int i = 0; i<bu.cargarNumeros().length; i++)
        {
            if(bu.cargarNumeros()[i]!=null)
            {
                contaNumeros++;
            }
        }
        if(contaNumeros==0)
        {
            System.out.println ("Se han cargado "+contaNumeros+" numeros");
            System.out.println ("Verifica el archivo, esta vacio o no existe!!!");
        }
        else
        {
            System.out.println ("Se han cargado "+contaNumeros+" numeros");
        }
    }//metodo Verificar Archivo

    ////////////////////////////////////////////////////////////////////////////////
    public void borrarArchivo()
    {
        Scanner entrada = new Scanner(System.in);

        FileWriter archivo1 = null;
        PrintWriter pw1 = null;

        System.out.println ("¿Estas seguro de querer borrar el archivo? S/N");
        String res = entrada.next();
        res.toLowerCase();
        if(res.equals("s"))
        {
            try
            {
                archivo1 = new FileWriter("Numeros.txt",false);
            }
            catch(FileNotFoundException fnfe)
            {
                fnfe.getMessage();
            }
            catch(IOException ioe)
            {
                ioe.getMessage();
            }
            finally
            {
                try
                {
                    archivo1.close();
                }
                catch(Exception ex)
                {
                    ex.getMessage();
                }

            } //finally
            System.out.println ("!!!!!!HAS BORRADO LOS ARCHIVOS!!!!!!");
        }
        else
        {
            System.out.println ("No lo has Borrado!!!");
        }
    } //metodo borrar Archivo

    ////////////////////////////////////////////////////////////////////////////////
    public void llenarArchivo()
    {
        Scanner entrada = new Scanner(System.in);
        DecimalFormat formateador = new DecimalFormat("#.###");

        FileWriter archivo1 = null;
        PrintWriter pw1 = null;
        BufferedReader bfr1=null;
        int n;
        int d;

        try
        {
            archivo1 = new FileWriter("Numeros.txt",true);
            pw1 = new PrintWriter(archivo1);

            System.out.println ("\nDime el valor de descriptores n");
            n = entrada.nextInt();
            System.out.println ("Dime el valor de dimensiones d");
            d = entrada.nextInt();

            double m[] = new double[d];
            double q[] = new double[d];

            for (int k = 0; k<n; k++){
                for (int i = 0; i<m.length; i++){
                    m[i] = Math.random()*(1-0);
                    //System.out.println ("m"+ k +": " +  formateador.format(m[i]));
                    pw1.println(formateador.format(m[i]));
                }
            }
            for (int j = 0; j<q.length; j++){
                q[j] = Math.random()*(1-0);
                //System.out.println ("q"+ j +": " +  formateador.format(q[j]));
                pw1.println(formateador.format(q[j]));
            }

        }//try
        catch(IOException ioe)
        {
            System.out.println ("IOException");
        }
        finally
        {
            try
            {
                pw1.close();
                archivo1.close();
            }
            catch(Exception ioe)
            {
                System.out.println (ioe.getMessage());
            }
        }
    }//metodo Llenar archivo

    ///////////////////////////////////////////////////////////////////////////////
    public double distanciaEuclidiana(double[]m, double[]q){

        double suma=0.0;

        for (int i=0; i<Math.min(m.length, q.length); i++){
            suma += Math.pow(m[i] - q[i], 2);
        }//for

        return Math.sqrt(suma);

    }//metodo distancia euclideana

}//clase BusquedaKnn

class PruebaBusquedaKnn {

    public static void main (String[] args) {
        Scanner entrada = new Scanner(System.in);
        DecimalFormat formateador = new DecimalFormat("#.###");

        int opcion = 0;
        int opcion2=0;
        do
        {
            System.out.println ("\n************");
            System.out.println ("\nSelecciona una opcion");
            System.out.println ("1) Llenar Archivo con Numeros");
            System.out.println ("2) Verificar archivo de numeros");
            System.out.println ("3) Distancia Euclideana");
            System.out.println ("4) Salir");
            opcion = entrada.nextInt();

            switch (opcion)
            {
                case 1: BusquedaKnn bu= new BusquedaKnn();
                    bu.borrarArchivo();
                    bu.llenarArchivo();
                    break;

                case 2: BusquedaKnn bu2= new BusquedaKnn();
                    bu2.cargarNumeros();
                    bu2.verificarArchivo();
                    break;

                case 3: BusquedaKnn bu3= new BusquedaKnn();

                    //	double distancia=bu3.distanciaEuclidiana(bu3.llenarArchivo(m),bu3.llenarArchivo(q));
                    //System.out.println ("l = " + formateador.format(distancia));

                    do{
                        System.out.println ("\nSelecciona una opcion");
                        System.out.println ("1) Ordenamiento");
                        System.out.println ("2) Busqueda");
                        System.out.println ("3) Salir");
                        opcion2 = entrada.nextInt();
                        switch(opcion2){
                            case 1: BusquedaKnn b1 = new BusquedaKnn();
                                break;
                            case 2: BusquedaKnn b2 = new BusquedaKnn();
                                break;
                            case 3:	System.out.println ("salir.........."); break;
                            default :System.out.println ("Opcion NO valida"); break;
                        }//while
                    }
                    while (opcion!=3) ;


    			/*case 4:	 BusquedaKnn bu4= new BusquedaKnn();
							bu4.borrarArchivo(); break;
						*/
                case 4:	System.out.println ("TE HAS SALIDO.........."); break;
                default :System.out.println ("Opcion NO valida"); break;
            }//switch


        }//do
        while (opcion!=4) ;
    }//main

}//clase principal
