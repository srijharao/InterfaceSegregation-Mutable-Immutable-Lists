package listadt;

/**
 * This interface represents an immutable list.
 *
 * @param <T> the type of elements in this list
 */
public interface ImmutableListADT<T> extends CommonListADT<T> {

  /**
   * Return mutable counterpart of this list.
   *
   * @return mutable list
   */
  MutableListADT<T> getMutableList();

}
