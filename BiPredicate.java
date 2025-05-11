public class Car {
  private final String brand;
  private final String fuel;
  private final int horsepower;
  ...
}

Car car = new Car("Ford", "electric", 80);

Predicate<Car> predicate = cars::contains;

System.out.println(predicate.test(car)); // true

System.out.println(
  cars.stream().anyMatch(p -> p.equals(car))
); // true

BiPredicate<List<Car>, Car> biPredicate = List::contains;

System.out.println(biPredicate.test(cars, car)); // true
