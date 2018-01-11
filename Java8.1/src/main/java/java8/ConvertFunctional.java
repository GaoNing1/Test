package java8;
@FunctionalInterface
public interface ConvertFunctional<F, T> {
T convert (F f);
}
