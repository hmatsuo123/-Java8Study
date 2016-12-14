package ch03.ex18;

public interface FunctionCallable<T, R> {

	R call(T t) throws Exception;
}
