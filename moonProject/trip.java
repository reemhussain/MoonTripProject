public class trip {
 
  private String[] trips = {"1- days = 10 , time = 20:00, prices of flights = 100","2- days = 3 , time = 2:00, prices of flights = 20","3- days = 6 , time = 18:00, prices of flights = 50"};
  private int num; 
  
  trip(){}
  
  trip(int num){ this.num = num; }

  public void viewTrips(){
    System.out.println("Available trips:");

    for (String trip : trips) {
      System.out.println(trip);
    }

  }

  public void selectTrip(int selected, Boolean ok){

    if(0 <= selected &&  selected< trips.length){
      num = selected;
      
      if(ok){
        System.out.println("you selected this trip : " + trips[num]);
      }      
    }
    else
      System.out.println("invalid input");
  }

  @Override
  public String toString() {
    return "this trip class";
  }

  public void getDetail(){
    System.out.println(this);
  }


}
