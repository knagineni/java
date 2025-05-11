public class Car {
  private final String brand;
  private final String fuel;
  private final int horsepower;
  ...
}

Car car = new Car("Ford", "electric", 80);

We know that the List API exposes a method named contains(Object o). This method returns true if the given Object is present in the given List. So, we can easily write a Predicate, as follows:

Predicate<Car> predicate = cars::contains;

System.out.println(predicate.test(car)); // true

System.out.println(
  cars.stream().anyMatch(p -> p.equals(car))
); // true

Alternatively, we can rely on BiPredicate. This is a functional interface representing a two-arity specialization of the well-known Predicate. Its test(Object o1, Object o2) method gets two arguments, so it is a perfect fit for our case:

BiPredicate<List<Car>, Car> biPredicate = List::contains;

System.out.println(biPredicate.test(cars, car)); // true