// https://www.baeldung.com/a-guide-to-java-enums
// 尚硅谷java: https://www.youtube.com/watch?v=eVv2CLoaRTw&list=PLmOn9nNkQxJG_AbAUeyAPH3fO0i_APAM9&index=117


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
  
  // other functions
  void show() {
    System.out.println("show");
  }
}

// usage & methods
// Season.SPRING.getClass(); // return Season class
// Season.SPRING.getClass().getSuperClass(); // Super class: Enum class, cannot extend other super class

// Static Season[] values(): Season.values() to iterate all enum type values
// Static Season valueOf(String name): Season.valueOf("SPRING") convert name to enum type; the name must be enum type name 'SPRING', otherwise throw illegalArgumentException

// String toString(): override toString method, default returns constant name e.g., 'SPRING' in the example
// String name(): Season.SPRING.name() return 'SPRING'
// int ordinal(): Season.AUTUMN.ordinal(): return the order of enum AUTUMN


// enum
// 1. enum type can implments an interface; override interface abstract method in the "other functions"
// 2. enum type can implments an interface; override interface abstract method for each enum type object; see the example below

interface Info {
  void show();
}

enum Season implements Info {
  //1. define enum object at the beginning
  SPRING("Spring", "Spring 1") { // call constructor
    @Override
    void show() {
      System.out.println("show1");
    }
  },
  SUMMER("Summer", "Summer 1") {
    void show() {
      System.out.println("show2");
    }
  },
  AUTUMN("Autumn", "Autumn 1") {
    void show() {
      System.out.println("show3");
    }
  },
  WINTER("Winter", "Winter 4") {
    void show() {
      System.out.println("show1");
    }
  };
  
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
  
  // other functions
}


// Singleton use enum: can use enum to create singleton class instance
enum COLOR {
  RED
};

