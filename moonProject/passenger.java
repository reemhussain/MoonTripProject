import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class passenger extends person {
  
  private boolean logged;
  private Scanner input;
  
  passenger(){}

  passenger(String name, String pass, String medical, String mental){
    super(name, pass, medical, mental);
    logged = false;
    input = null;
  }

  public boolean acceptance(){
    if(medical.equalsIgnoreCase("ok") && mental.equalsIgnoreCase("ok") && logged)
    {
      System.out.println("you can go!");
      return true;
    }
    System.out.println("sorry you can not go!");
    return false;
  }
  
  public void login(String name, String pass){
    String health = "";
    String mental = "";
    if(!name.isEmpty() && !pass.isEmpty()){
      
      try {
        input = new Scanner(new File("data.txt"));
        while(input.hasNextLine()){
          String[] tmp  = input.nextLine().split("-");
          if(tmp[0].equals(name) && tmp[1].equals(pass)){
            logged = true;

            System.out.println("Welcome " + tmp[0]);
            this.name = tmp[0];
            this.pass = tmp[1];
            this.medical = tmp[2];
            this.mental = tmp[3];
            return;
          }
        }
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }
    }   else {

      logged = false;
      System.out.println("invalid input");
    }
  }

  public void createAccount(String name, String pass, String medical, String mental) {
    if(!name.isEmpty() && !pass.isEmpty() && !medical.isEmpty() && !mental.isEmpty()){
      
      try {
        FileWriter fileWriter = new FileWriter("data.txt",true);
        fileWriter.write(String.format("%s-%s-%s-%s\n", name,pass,medical,mental));
        fileWriter.close();
        System.out.println("done");
        logged = true;
        this.name = name;
        this.pass = pass;
        this.medical = medical;
        this.mental = mental;
        return;
      } catch (IOException e) {
        e.printStackTrace();
      }
    }else {

      System.out.println("invalid input");
      logged = false;
    }
  }

  public boolean getLogged() {
    return logged;
  }

  @Override
  public String toString() {
    return "this passenger class";
  }
  
  public void getDetail(){
    System.out.println(this);
  }
}
