public class Standard implements Car {
  public String name;
  public String type;

  public Standard(String name, String type){
    this.name = name;
    this.type = type;
  }

  @Override
  public String getDescription(){
    return name + " " + type;
  }

  @Override
  public int getCost(){
    return 270;
  }
}
