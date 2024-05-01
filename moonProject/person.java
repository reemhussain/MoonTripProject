public class person {
  protected String name;
  protected String pass;
  protected String medical;
  protected String mental;

  person(){}
  
  person(String name, String pass, String medical, String mental){
    this.medical = medical;
    this.mental = mental;
    this.name = name;
    this.pass = pass;
  }

  public void setMedical(String medical) {
    this.medical = medical;
  }

  public void setMental(String mental) {
    this.mental = mental;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public String getMedical() {
    return medical;
  }

  public String getMental() {
    return mental;
  }

  public String getName() {
    return name;
  }
  
  public String getPass() {
    return pass;
  }
  @Override
  public String toString() {
    return "this person class";
  }
  public void getDetail(){
    System.out.println(this);
  }
}
