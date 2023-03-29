
enum Season {
  //1. define enum object at the beginning
  SPRING("Spring", "Spring 1"),
  SUMMER("Summer", "Summer 1"),
  AUTUMN("Autumn", "Autumn 1"),
  WINTER("Winter", "Winter 1");
  
  private final String seasonName;
  private final String seasonDesp;
  
  private Season(String s, String d) {
    this.seasonName = s;
    this.seasonDesp = d;
  }
  
  String getSeasonName() {
    return seasonName;
  }
  
  String getSeasonDesp() {
    return searconDesp;
  }
}

// usage
Season.SPRING.getClass();
Season.SPRING.getClass().getSuperClass(); // Super class: Enum class, cannot extend other super class

