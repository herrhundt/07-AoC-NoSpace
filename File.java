public class File
{
    String name ; 
    int size; 

    /**
     * Konstruktor für Objekte der Klasse File
     */
    public File(String pName, int pSize)
    {
        name = pName; 
        size = pSize; 
    }

    public String getName(){return name;}
    public int getSize(){ return size; }
}
