package file;
import java.io.*;
import java.util.*;
public class model {
	String path = "C:\\Users\\ELCOT\\filemanager";
	String filename;
	String symbol = "\\";
	Scanner sc = new Scanner(System.in);
	public void createfolder( ) {
		String foldername;
		System.out.println("Enter the folder name to be created");
		foldername = sc.nextLine();
		File folder=new File(path+foldername);
		boolean present = folder.exists();
		System.out.println("Folder present"+present);
		if(present == false) {
			folder.mkdir();
			present= folder.exists();
		System.out.println("Folder present"+present);
		                     }
	                           }
	public void createsubfolder() {
		String foldername;
		System.out.println("Enter the FOLDERNAME where you want me to create a sub folder");
			foldername = sc.nextLine();
		System.out.println("Enter the SUBFOLDER name you want to create");
		String subfolder;
			subfolder = sc.nextLine();
		File folder=new File(path+foldername+symbol+subfolder);
		boolean present = folder.exists();
		System.out.println("Folder present"+present);
		if(present == false) {
			folder.mkdirs();
			present= folder.exists();
		System.out.println("Folder present"+present);
		                     }
		
	}
	public void createfileinsidefolder() {
		System.out.println("Enter the FOLDERNAME in which you want to CREATE THE FILE");
		String foldername;
			foldername = sc.nextLine();
		System.out.println("Enter the File Name with its type eg file.txt");
			filename = sc.nextLine();
		File file = new File(path+foldername+symbol+filename);
		boolean present = file.exists();
		System.out.println("Folder Present"+"--->"+present);
		if(present == false) {
		try {
			boolean created =file.createNewFile();
			System.out.println("File Created"+"----->"+created);
		}catch(IOException e) {
			e.printStackTrace();
		}
		}
		
	}
	public void rename() throws IOException {
		System.out.println("Enter the File Name You want to RENAME");
			filename = sc.nextLine();
		File file = new File(path+symbol+filename);
		file.createNewFile();
		String s;
		System.out.println("Enter Newname of the File");
			s = sc.nextLine();
		File newname = new File(path+symbol+s);
		//oldname.renameto(new name)
		boolean succesfull = file.renameTo(newname);
		System.out.println("Rename Completed"+"------->---->"+succesfull);
	}
	public void nameoffile() {
		// name of the object example file newname
		//obj name.getname()
		File file = new File("c:\\users\\ELCOT\\filemanager\\term.txt");
		System.out.println("filename"+file.getName());
	}
	public void fileprop() {
		System.out.println("Enter the FileName");
					filename =sc.nextLine();
		File file = new File(path+symbol+filename);
		System.out.println("File is Executable"+"---->"+file.canExecute());
		System.out.println("File is Readable"+"----->"+file.canRead());
		System.out.println("File is Writable"+"------>"+file.canWrite());
	}
	// name alone
	public void listall() {
		 File file = new File (path);
		 String[]listof = file.list();
		 for(String s:listof )
			 System.out.println(s);
	}
	// with location
	public void listfilefol() {
		File file = new File (path);
		 File []listof = file.listFiles();
		 Arrays.sort(listof);
		 for(File s:listof )
			 System.out.println(s);
		 //for printing file alone
		/* for(File s:listof )
			 if(s.isFile())
			 System.out.println(s);*/
		 // for printing folder
		 for(File s:listof )
			 if(s.isDirectory())
			 System.out.println(s);
	}
	public void checkExten() {
		File file = new File(path);
		File[] filefolder= file.listFiles();
		for(File f : filefolder) {
			if(f.isFile()) {//to get file alone and to avoid folder
			String s = f.getName();
			// s is file name t is extension name
			int lastdot = s.lastIndexOf(".");
			// to get all extension alone with 
			String t=s.substring(lastdot+1);
			if(t.equals("txt"))
			System.out.println(s);
			}
		}
	}
	public void listbysize() {
		// f.length()>size in bytes
		File file = new File(path);
		File[] filefolder=file.listFiles();
		for(File f: filefolder) {
			if(f.length()<50000)
				System.out.println(f.getName());
		}
	}
	// write by file writer
	/*public void write() throws IOException {
		File file = new File("c:\\users\\ELCOT\\filemanager\\rio.txt");
		file.createNewFile();
		FileWriter write = new FileWriter(file);
		write.write("hio");
		write.flush();
		write.close();
	}
	// read by file reader 
		public void read() throws IOException {
			File file = new File("c:\\users\\ELCOT\\filemanager\\rio.txt");
			file.createNewFile();
			 FileReader f2 = new FileReader(file);
			    int x = f2.read();
			    while(x != -1){
			        System.out.println((char)x);
			        x = f2.read();
			    }
			    f2.close();
		}*/
		public void createfile() {
			System.out.println("Enter the File name with its Type eg file.txt");
				filename = sc.nextLine();
			File file = new File(path+symbol+filename);
			boolean present = file.exists();
			System.out.println("FILE Already Present"+"--->"+present);
			if(present == false) {
			try {
				boolean created =file.createNewFile();
				System.out.println("File Created"+"--->"+created);
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			}
		}
	public void searchfiler() {
		System.out.println("Enter the Filename you want to SEARCH with its format eg text.txt");
			filename = sc.nextLine();
		File file = new File(path);
		File[] filefolder=file.listFiles();
		int i=0;
		boolean check = true;
		for(File f: filefolder) {
			String s = filefolder[i].getName();
			//System.out.println(s);
			 check = s.equalsIgnoreCase(filename);
			if(check == true ) {
				System.out.println("FOUND"+"    "+f.getName());
				break;
			}
				i++;
			
		}
		if(check == false)
			System.out.println("File Not Found");
	}
	public void delete() {
		System.out.println("Enter the Filename you want to Delete");
			filename = sc.nextLine();
		File file = new File(path+symbol+filename);
		System.out.println(file.getName());
    if (file.delete()) {
        System.out.println("File Deleted Successfully");
    }
    else {
        System.out.println("Failed to Delete the File");
    }
		
	}
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("========================================================");
		System.out.println("WELCOME TO YOUR FILE MANAGER");
		System.out.println("DEVELOPER NAME =======> DARWIN S");
		System.out.println("========================================================");

	}
	public void tocreatenewpath() {
		// TODO Auto-generated method stub
		System.out.println("Enter the PATH like----->C:\\Users\\ELCOT\\");
			path = sc.nextLine();
			File folder=new File(path);
			boolean present = folder.exists();
			System.out.println("PATH already exists"+present);
			if(present == false) {
				folder.mkdir();
				present= folder.exists();
			System.out.println("PATH created"+present);
			                     }

	}



}
