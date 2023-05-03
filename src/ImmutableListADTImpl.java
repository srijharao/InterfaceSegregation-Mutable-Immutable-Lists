package listadt;

import java.util.function.Function;

/**
 * This is an implementation for an Immutable list.
 */

public class ImmutableListADTImpl<T> implements ImmutableListADT<T> {

  private final ListADT<T> tListADT;

  /**
   * Construct an ImmutableListADT object.
   */
  public ImmutableListADTImpl() {
    tListADT = new ListADTImpl<>();
  }

  @Override
  public <R> ImmutableListADTImpl<R> map(Function<T, R> converter) {
    return ImmutableBuilder.build((ListADT) tListADT.map(converter));
  }

  @Override
  public int getSize() {
    return tListADT.getSize();
  }

  @Override
  public T get(int index) throws IllegalArgumentException {
    return tListADT.get(index);
  }

  @Override
  public MutableListADT<T> getMutableList() {
    return new MutableListADTImpl<>(tListADT);
  }

  private void addBack(T b) {
    tListADT.addBack(b);
  }

  @Override
  public String toString() {
    return this.tListADT.toString();
  }

  /**
   * A builder class to build final Immutable list.
   *
   * @param <T> the type of elements in this list
   */

  public static class ImmutableBuilder<T> {

    /**
     * Build method to build the final immutable list.
     *
     * @param listADT ListADT used to build immutable list
     * @return a final immutable list
     */
    public static ImmutableListADTImpl build(ListADT listADT) {
      ImmutableListADTImpl immutableListADT = new ImmutableListADTImpl<>();
      immutableListADT.addBack(listADT);
      return immutableListADT;
    }

  }
}
