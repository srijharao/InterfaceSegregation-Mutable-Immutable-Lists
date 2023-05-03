package listadt;

import java.util.function.Function;

/**
 * Implementation of MutableListADT. contains methods to return immutable counterpart and perform
 * mutable list operations.
 *
 * @param <T> object generic
 */
public class MutableListADTImpl<T> implements MutableListADT<T> {

  private final ListADT<T> tListADT;

  public MutableListADTImpl(ListADT<T> tListADT) {
    this.tListADT = tListADT;
  }

  /**
   * A general purpose map higher order function on this list, that returns the corresponding list
   * of type R.
   *
   * @param converter the function that converts T into R
   * @return the resulting list that is identical in structure to this list, but has data of type R
   */
  @Override
  public <R> MutableListADTImpl<R> map(Function<T, R> converter) {
    return new MutableListADTImpl((ListADT<R>) tListADT.map(converter));
  }

  /**
   * Return the number of objects currently in this list.
   *
   * @return the size of the list
   */
  @Override
  public int getSize() {
    return tListADT.getSize();
  }

  /**
   * Get the (index)th object in this list.
   *
   * @param index the index of the object to be returned
   * @return the object at the given index
   * @throws IllegalArgumentException if an invalid index is passed
   */
  @Override
  public T get(int index) throws IllegalArgumentException {
    return tListADT.get(index);
  }

  /**
   * Return immutable counterpart of this list.
   *
   * @return immutable list
   */
  @Override
  public ImmutableListADT<T> getImmutableList() {
    return ImmutableListADTImpl.ImmutableBuilder.build(tListADT);
  }

  @Override
  public void addFront(T b) {
    tListADT.addFront(b);
  }

  @Override
  public void addBack(T b) {
    tListADT.addBack(b);
  }

  @Override
  public void add(int index, T b) {
    tListADT.add(index, b);
  }

  @Override
  public void remove(T b) {
    tListADT.remove(b);
  }

  @Override
  public String toString() {
    return "(" + tListADT.toString() + ")";
  }
}
