import java.io.*;
import java.util.*;

public class NoSpace
{
  //static String filename = "input-sample.txt"; //for testing purposes 
  static String filename = "input.txt"; //the original input  
  static String [] input;
  static Filesystem fs = new Filesystem(); 
  
  public static void print()
  {
      fs.setRoot(); 
      fs.getRoot().print("-");
  }
  
  public static void solvePuzzle()
  {
      fs.findDirectories(); 
  }
  
  public static void executeCommands()
  { 
      String command; 
      for(int lineCounter = 0; lineCounter<input.length;lineCounter++)
      {
          command = input[lineCounter];
          if(command.contains("$"))
       {
          if(command.contains("cd"))
          {
            String dir = command.replace("$ cd ",""); 
                fs.cd(dir);   
          }
          
          else if(command.contains("ls"))
          {
              System.out.println("ls gefunden, jetzt kommen files oder folders");  
          }
        } //shell-Kommando
       else 
        {
          if(command.contains("dir"))//folder kommen  
          { 
             String dir = command.replace("dir ",""); 
             fs.addFolder(dir);//add folder   
          }
          else //files kommen 
          {
              String[] fileCommand= command.split(" "); 
              int size = Integer.parseInt(fileCommand[0]); 
              String name = fileCommand[1]; 
              fs.addFile(name, size); 
              
          }
        }
      } 
    }
  
  
    /**
     * Die Methode liest den Input der Textdatei in ein Array ein. 
     */
    public static void readInputIntoArray() throws IOException
    {
    int arraySize =0; 
    try
    {
        arraySize = getInputLength(); 
    }
    catch (IOException e) 
    {
        System.out.println("Es ist ein Fehler beim Einlesen passiert!"); 
        System.exit(1); //Programm beenden
    }
    input = new String[arraySize]; //Erstelle leeres Array mit der Anzahl 
    
    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);      
    String zeile = "";
    
    for(int i=0; i<arraySize;i++)
    {
         input[i] = br.readLine();
    }
      br.close();
      //array should be read correctly  
    }  
    
    /**
     * Methode bestimmt die Länge der Texteingabe 
     */
    public static int getInputLength() throws IOException
    {
     int size = 0;  
     FileReader fr = new FileReader(filename);
     BufferedReader br = new BufferedReader(fr);  
      //Bestimme die Anzahl der Werte! 
     String zeile = "";
     while( (zeile = br.readLine()) != null )
     {
        System.out.println(zeile);
        size++; 
      }
      br.close();
    return size; 
    }    


}
