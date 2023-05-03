package listadt;

/**
 * This interface represents a mutable list. Contains method to return its immutable counterpart.
 *
 * @param <T> the type of elements in this list
 */
public interface MutableListADT<T> extends ListADT<T> {

  /**
   * Return immutable counterpart of this list.
   *
   * @return immutable list
   */
  ImmutableListADT<T> getImmutableList();

}
