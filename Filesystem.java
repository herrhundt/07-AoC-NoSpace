
public class Filesystem
{
    Folder root = new Folder("/",null); 
    
    Folder actual;  
    
    public Filesystem()
    {
       actual = root;  
    }
    
    public void findDirectories() //less size than 100 000
    { 
        System.out.println(root.findDirectories()); 
    }
    
    public void setRoot(){actual = root; }
    public Folder getRoot(){return root;}
    
    public void cd(String dirName)
    {
        if(dirName.contains("/")) 
        {
            actual = root;
            System.out.println("return to root-folder!"); 
        }
        else if(dirName.contains(".."))//moves out one level: it finds the directory that contains the current directory, then makes that directory the current directory.
        {
           System.out.println(".. found");
           actual = actual.getParent(); 
        }
        else {
            actual = actual.changeDirectory(dirName); 
            }
    }
    public void addFile(String pName, int pSize)
    {
        actual.addFile(pName, pSize);
    }
    
    public void addFolder(String dirName)
    {
        actual.addFolder(dirName, actual);
    }
    
}
