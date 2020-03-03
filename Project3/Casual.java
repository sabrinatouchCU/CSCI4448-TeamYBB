import java.util.Random;
import java.util.ArrayList;

public class Casual extends Customer {
  private int days;
  private int capacity = 0;
  private ArrayList<Car> carList = new ArrayList<Car>();

  public Casual(String name, String type){
    super(name, type);
  }

  @Override
  public int getNumCars(){
    return 1;
  }

  @Override
  public String getName(){
    return name;
  }

  @Override
  public void generateDays(){
    Random rand = new Random();
    int random_number = rand.nextInt(4) + 1;
    this.days = random_number;
  }

  @Override
  public int getDays(){
    return this.days;
  }

  @Override
  public void decrement(){
    this.days = this.days - 1;
  }

  @Override
  public void makeRental(int number){
    this.capacity += number;
  }

  @Override
  public int getCapacity(){
    return this.capacity;
  }

  @Override
  public void resetCapacity(){
    this.capacity = 0;
  }

  @Override
  public void addList(Car car){
    this.carList.add(car);
  }

  @Override
  public void resetList(){
    for(int i = 0; i < this.carList.size(); i++){
      this.carList.remove(i);
    }
  }

  @Override
  public ArrayList<Car> getCarList(){
    return this.carList;
  }

}
