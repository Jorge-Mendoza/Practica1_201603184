
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorgi
 */
public class Snake {
    
    static Scanner lector=new Scanner(System.in);
    static String [][]matrix=new String[35][70];
    static String[]jugadores=new String[10];
    static String [][]aux=new String[35][70];
    
    public static void main(String[] args) {
        menu();
        
        
    }
    public static  void menu(){
        System.out.println("\033[31m--------------------------------");
        System.out.println("\033[32m*******Bienvenido a Snake*******");
        System.out.println("\033[31m--------------------------------");
        System.out.println("\033[36m*******       Menú       *******");
        System.out.println("\033[34m------ [1] Iniciar Juego -------");
        System.out.println("\033[34m-----[2] Regresar al juego-----");
        System.out.println("\033[34m-------- [3] Historial ---------");
        System.out.println("\033[34m------     [4] Salir      ------");
        System.out.println("\033[34m******* Elije una opción *******");
        System.out.println("\033[31m--------------------------------");
        String opcion;
        
        opcion=lector.next();
        
        
        switch(opcion){
            case "1":
                agregar();
                snake();
                juego();
            break;
            case "2":
                regresar();
            break;
            case "3":
                historial();
            break;
            case "4":
                System.exit(0);
            default:
               
                System.out.println("Has ingresado un dato erróneo, ingresa el numero de opcion que prefieras");
                menu();
            break;
        }
    }
    static int contador=0;
    static String nombre;
    static  String fecha;
    public static void agregar(){
     
       System.out.println("\033[31m--------------------------------");
       System.out.println("\033[32m*******Ingresa tu Nombre *******");
       System.out.println("\033[31m--------------------------------");
       nombre=lector.next();
       System.out.println("\033[31m--------------------------------");
       System.out.println("\033[32m**Ingresa fecha de nacimiento **");
       System.out.println("\033[32m**********dd/mm/aaaa ***********");
       System.out.println("\033[31m--------------------------------");
       fecha=lector.next();
       jugadores[contador]=nombre+" ........ "+fecha;
       contador++;
       System.out.println("Empieza el juego....");   
    }
    public static void snake(){
       
        for (int i=0; i<35;i++)
		{
			for (int j=0; j<70;j++)
			{
				if ((i==0)||(i==34)||(j==69)||(j==0)){
					creaPared(i,j);
                                       
                                } 
                                if((i==12&&j==35)){
                                    
                                    System.out.print (matrix[i][j]="@");
                                    
                                }
                                 if(matrix[i][j]==null){
                                    creaItems(i,j);
                                    
                                }
//                                
                                
                         aux[i][j]=matrix[i][j];      
//                               
			}
			System.out.println (" ");
		}
        
        
        
    }  
    public static void juego(){
       System.out.println ();
        
       System.out.println("\033[31m--------------------------------");
       System.out.println("\033[32m******Haz algún movimiento*******");
       System.out.println("\033[31m--------------------------------");
       String eleccion=lector.next();
       
        for (int i=0; i<35;i++)
		{
			for (int j=0; j<70;j++)
			{
                         
                         if(aux[i][j].equalsIgnoreCase("@")){
                           //System.out.print ("aquí"+i+","+j);  
                           movimientos(i,j,eleccion);
                         }   
                        }
                        //System.out.println (" ");
                }
        juego();
    }
    static int score=10;
    public static void movimientos(int i,int j,String eleccion){
        int posX=i;
        int posY=j;
        switch(eleccion){
            case "w":
                posX--;
                for (int k=0; k<35;k++)
		{
			for (int f=0; f<70;f++)
			{
                          
                         if(aux[posX][posY].equalsIgnoreCase("#")){
                           posX++;
                           System.out.println("Has topado en un muro");
                           System.out.println ("aquí"+i+","+j);  
                           
                         } 
                         if(aux[posX][posY].equalsIgnoreCase(" ")){
                             aux[posX][posY]="@";
                             aux[i][j]=" ";
                            // System.out.println ("aquí"+i+","+j);  
                         }
                         if(aux[posX][posY].equalsIgnoreCase("%")){
                             aux[posX][posY]="@";
                             score=score+10;
                             
                             aux[i][j]=" ";
                             //System.out.println ("aquí"+i+","+j);  
                         }
                          if(aux[posX][posY].equalsIgnoreCase("$")){
                             aux[posX][posY]="@";
                             score=score-10;
                             aux[i][j]=" ";
                             //System.out.println ("aquí"+i+","+j);  
                         }
                        }
                        //System.out.println (" ");
                }
                imprimeTablero();
                if(score==100){
                    System.out.println("\033[32m Felicidades has ganado la partida");
                    System.out.println("\033[32m Juega de nuevo, y regresa pronto");
                    menu();
                }
                if (score<=0){
                    System.out.println("\033[36m Has perdido el juego");
                    System.out.println("\033[36m Juega de nuevo, y regresa pronto");
                    menu();
                }
            break;
            case "s":
                    posX++;
                    
                for (int k=0; k<35;k++)
		{
			for (int f=0; f<70;f++)
			{
                          
                         if(aux[posX][posY].equalsIgnoreCase("#")){
                           posX--;
                           System.out.println("Has topado en un muro");
                           System.out.println ("aquí"+i+","+j);  
                           
                         } 
                         if(aux[posX][posY].equalsIgnoreCase(" ")){
                             aux[posX][posY]="@";
                             aux[i][j]=" ";
                            // System.out.println ("aquí"+i+","+j);  
                         }
                         if(aux[posX][posY].equalsIgnoreCase("%")){
                             aux[posX][posY]="@";
                             score=score+10;
                             jugadores[contador]=jugadores[contador]+"..... "+score;
                             aux[i][j]=" ";
                             //System.out.println ("aquí"+i+","+j);  
                         }
                          if(aux[posX][posY].equalsIgnoreCase("$")){
                             aux[posX][posY]="@";
                             score=score-10;
                             aux[i][j]=" ";
                             //System.out.println ("aquí"+i+","+j);  
                         }
                        }
                        //System.out.println (" ");
                }
                imprimeTablero();
                if(score==100){
                    System.out.println("\033[32m Felicidades has ganado la partida");
                    System.out.println("\033[32m Juega de nuevo, y regresa pronto");
                    menu();
                }
                if (score<=0){
                    System.out.println("\033[36m Has perdido el juego");
                    System.out.println("\033[36m Juega de nuevo, y regresa pronto");
                    menu();
                }
            break;
            case "a":
                posY--;
                
                for (int k=0; k<35;k++)
		{
			for (int f=0; f<70;f++)
			{
                          
                         if(aux[posX][posY].equalsIgnoreCase("#")){
                           posY++;
                           System.out.println("Has topado en un muro");
                           System.out.println ("aquí"+i+","+j);  
                           
                         } 
                         if(aux[posX][posY].equalsIgnoreCase(" ")){
                             aux[posX][posY]="@";
                             aux[i][j]=" ";
                            // System.out.println ("aquí"+i+","+j);  
                         }
                         if(aux[posX][posY].equalsIgnoreCase("%")){
                             aux[posX][posY]="@";
                             score=score+10;
                             aux[i][j]=" ";
                             //System.out.println ("aquí"+i+","+j);  
                         }
                          if(aux[posX][posY].equalsIgnoreCase("$")){
                             aux[posX][posY]="@";
                             score=score-10;
                             aux[i][j]=" ";
                             //System.out.println ("aquí"+i+","+j);  
                         }
                        }
                        //System.out.println (" ");
                }
                imprimeTablero();
                if(score==100){
                    System.out.println("\033[32m Felicidades has ganado la partida");
                    System.out.println("\033[32m Juega de nuevo, y regresa pronto");
                    menu();
                }
                if (score<=0){
                    System.out.println("\033[36m Has perdido el juego");
                    System.out.println("\033[36m Juega de nuevo, y regresa pronto");
                    menu();
                }
            break;
            case "d":
                posY++;
                
                for (int k=0; k<35;k++)
		{
			for (int f=0; f<70;f++)
			{
                          
                         if(aux[posX][posY].equalsIgnoreCase("#")){
                           posY--;
                           System.out.println("Has topado en un muro");
                           System.out.println ("aquí"+i+","+j);  
                           
                         }  
                         if(aux[posX][posY].equalsIgnoreCase(" ")){
                             aux[posX][posY]="@";
                             aux[i][j]=" ";
                            // System.out.println ("aquí"+i+","+j);  
                         }
                         if(aux[posX][posY].equalsIgnoreCase("%")){
                             aux[posX][posY]="@";
                             score=score+10;
                             
                             aux[i][j]=" ";
                             //System.out.println ("aquí"+i+","+j);  
                         }
                          if(aux[posX][posY].equalsIgnoreCase("$")){
                             aux[posX][posY]="@";
                             score=score-10;
                             aux[i][j]=" ";
                             //System.out.println ("aquí"+i+","+j);  
                         }
                        }
                        //System.out.println (" ");
                } 
                imprimeTablero();
                if(score==100){
                    System.out.println("\033[32m Felicidades has ganado la partida");
                    System.out.println("\033[32m Juega de nuevo, y regresa pronto");
                    menu();
                }
                if (score<=0){
                    System.out.println("\033[36m Has perdido el juego");
                    System.out.println("\033[36m Juega de nuevo, y regresa pronto");
                    menu();
                }
            break;
            case "m":
                menu();
            break;
            default:
                System.out.println("Has ingresado una tecla errónea, intenta de nuevo");
                juego();
            break;
        }
      
        
        
    }
    public static void imprimeTablero(){
        System.out.println ();
        for (int i=0; i<35;i++)  
		{
			for (int j=0; j<70;j++)
			{
                         
                         
                           System.out.print (aux[i][j]);  
                           
                         
                        }
                        System.out.println (" ");
                }
        System.out.println("....."+nombre+".... Tu score: "+score);
        
    }
    public static void creaItems(int i,int j){
        int fruto=(int)Math.floor(Math.random()*(3-0+1)+(0));

        switch(fruto){
            case 0:
                System.out.print (matrix[i][j]="#");
            break;
            case 1:
                System.out.print (matrix[i][j]="%");
            break;
            case 2:
                System.out.print (matrix[i][j]="$");
            break;
            case 3:
                System.out.print (matrix[i][j]=" ");
            break;
        }
    }
   
    public static void creaPared(int i,int j){
        System.out.print (matrix[i][j]="#");
    }
    public static void historial(){ 
        System.out.println("\033[31m--------------------------------");
        System.out.println("\033[32m    *******Historial*******     ");
        System.out.println("\033[31m--------------------------------");
        for(int i=0;i<jugadores.length;i++){
            System.out.println(jugadores[i]);
        }
        menu();
    }
       
   
    public static void regresar(){
        imprimeTablero();
        juego();
    }
    public Snake(){
        
    }
    
}
