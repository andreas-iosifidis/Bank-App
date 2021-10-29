
package bankapp;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;




public class Account {
     private int ID;
     private int password;
     File file;
     String filename;
    private String IDtoString;
    private String PasswordtoString;
    private int money;
    static final int poso=100;
    static final int poso1=200;
    static final int poso2=300;
    static final int poso3=400; 
    FileWriter filewriter;
    boolean logged;
   
public Account(int Identity,int pass) {
    this.ID=Identity;
    this.password=pass;
    
    filename=String.valueOf(ID)+".txt";
        }

public void copyAccount(Account account2){
this.setAccountID(account2.getAccountID());
this.SetPassword(account2.getPassword());
this.setMoney(account2.getMoney());
this.logged=account2.logged;
}
public void setAccountID(int id){this.ID=id;}

public int getAccountID(){return ID;}
public int getPassword(){return password;}

public void setMoney(int Money){
    this.money=Money;
}

public void SetPassword(int Password){this.password=Password;}
public int getMoney(){return money;}

public String GetIDtoString(){return IDtoString=String.valueOf(ID);}
public String GetPasswordtoString(){return PasswordtoString=String.valueOf(password);}




    
public String accountBalance(){
            
    return Integer.toString(money);

            }


public static boolean isON(Account account){
    
    return account.logged;}

public  void saveToFile(Account account,String s) throws IOException{ 
    file=new File(filename);
    
    
    FileOutputStream a=new FileOutputStream(file,true);
    a.write(s.getBytes());
   a.close();
   
    
    
    if(file.exists()){
    
    file.canWrite();file.setExecutable(true);file.setReadable(true);file.setWritable(true);
   
    }
   
    }


}

