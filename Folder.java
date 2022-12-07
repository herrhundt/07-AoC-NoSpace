import java.util.*;

public class Folder
{
    String name;
    Folder parent; 
    
    ArrayList<File> files = new ArrayList<File>();
    ArrayList<Folder> subfolders = new ArrayList<Folder>(); 
    static int folderSum =0; 
    
    /**
     * Konstruktor für Objekte der Klasse Folder
     */
    public Folder(String pName, Folder pParent)
    {
       name = pName; 
       parent = pParent;
    }
    
    public Folder getParent(){return parent;}
    
    public Folder changeDirectory(String pName) 
    {
       Folder lookUp = containsFolder(pName); 
       if(lookUp!=null)  return lookUp; 
       System.out.println("Directory "+pName+" not found!");
       return null; 
      
    }
    
    public int findDirectories()
    { 
       System.out.println(getName()+" has size "+getSize());
       if(getSize()<100000)
       {
           System.out.println(getName());
           folderSum+=getSize();
        } 
        for (Folder f: subfolders)
       { 
        f.findDirectories(); 
       } 
       return folderSum; 
    }
    
    public void print(String pSpace)
    {
        System.out.println(pSpace + name+" (dir)"); 
        pSpace = " " + pSpace ; 

       for (Folder f: subfolders)
       {
          f.print(pSpace); 
       }
       
       Iterator<File> iterfiles = files.iterator(); 
        File actual; 
       while(iterfiles.hasNext())
       {
           actual = iterfiles.next(); 
           System.out.println(pSpace+actual.getName()+" (file, size="+ actual.getSize()+")"); 
        }
    }
    
    public void addFile(String pName, int pSize)
    {
       files.add(new File(pName, pSize)); 
    }
    
    public void addFolder(String pName, Folder pFolder)
    {
        subfolders.add(new Folder(pName,pFolder));
    }
    
    public Folder containsFolder(String pName)
    {
        Iterator<Folder> iter = subfolders.iterator();
        Folder actual; 
        while(iter.hasNext())
        {
            actual = iter.next(); 
            if(actual.getName().equals(pName)) return actual;  
        }
        return null; //no subfolder there
    }

    public String getName()
    {
        return this.name; 
    }  
    
    
    public int getSize()
    {
       int size =0;
       File actual; 
       Iterator<File> iterfiles = files.iterator(); 
       while(iterfiles.hasNext())
       {
           actual = iterfiles.next(); 
           size+=actual.getSize(); 
        }
       for (Folder f: subfolders)
       {
           size += f.getSize(); 
        }
        return size;
    }
}
