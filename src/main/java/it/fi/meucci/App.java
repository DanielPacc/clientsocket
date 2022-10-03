package it.fi.meucci;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        client cliente = new client();
        cliente.connect();
        cliente.comunica();
    }
}
