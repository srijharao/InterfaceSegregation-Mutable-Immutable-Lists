import listadt.ImmutableListADT;
import listadt.ImmutableListADTImpl;
import listadt.ListADT;
import listadt.ListADTImpl;
import listadt.MutableListADT;
import listadt.MutableListADTImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for ImmutableListADT and MutableListADT.
 */
public class MutableImmutableTest {

  private MutableListADT<String> list;
  private ImmutableListADT<String> listImmutable;

  @Test
  public void testImmutableMap() {
    ImmutableListADT<String> list = new ImmutableListADTImpl<>();
    list = (ImmutableListADT<String>) list.map(String::toUpperCase);
    assertEquals("[]", list.toString());
    assertEquals(0, list.getSize());
  }

  @Test
  public void testImmutableReturnsImmutableList() {
    ListADT<String> listADTList = new ListADTImpl<>();
    listADTList.add(0, "First");
    listADTList.add(1, "Second");
    listADTList.add(2, "Third");
    list = new MutableListADTImpl<>(listADTList);
    String stringList = "This is a immutable string";
    String[] words = stringList.split("\\s+");
    for (String word : words) {
      list.addBack(word);
    }
    listImmutable = list.getImmutableList();
    MutableListADT<String> returnedWords = listImmutable.getMutableList();
    assertEquals(listImmutable.getSize(), returnedWords.getSize());
    assertEquals(listImmutable.toString(),
        "((First Second Third This is a immutable string))");
  }

  @Test
  public void testMutableReturnsMutableList() {
    ListADT<String> listADTList = new ListADTImpl<>();
    listADTList.add(0, "First");
    listADTList.add(1, "Second");
    listADTList.add(2, "Third");
    list = new MutableListADTImpl<>(listADTList);
    String sentence = "This is a mutable string";
    String[] words = sentence.split("\\s+");
    for (String w : words) {
      list.addBack(w);
    }
    ListADT<Integer> listSize = (ListADT<Integer>) list.map(s -> s.length());
    assertEquals(list.getSize(), listSize.getSize());
    listSize.addBack(10);
    assertEquals(list.getSize() + 1, listSize.getSize());
    assertEquals("((5 6 5 4 2 1 7 6 10))", listSize.toString());
  }

  @Test
  public void testCreateImmutableUsingMutable() {
    ListADT<String> listADTList = new ListADTImpl<>();
    listADTList.add(0, "First");
    listADTList.add(1, "Second");
    listADTList.add(2, "Third");
    list = new MutableListADTImpl<>(listADTList);
    list.addBack("back");
    assertEquals("((First Second Third back))", list.toString());
    list.add(1, "list is mutable");
    assertEquals("((First list is mutable Second Third back))", list.toString());
    listImmutable = list.getImmutableList();
    assertEquals("((First list is mutable Second Third back))", listImmutable.toString());
    list.addBack("list is now immutable");
    assertEquals(1, listImmutable.getSize());
    assertEquals("((First list is mutable Second Third back list is now immutable))",
        list.toString());
    assertEquals("((First list is mutable Second Third back list is now immutable))",
        listImmutable.toString());
    list = listImmutable.getMutableList();
    list.addFront("Front");
    assertEquals("((Front (First list is mutable Second Third back list is now immutable)))",
        list.toString());
    assertEquals("(Front (First list is mutable Second Third back list is now immutable))",
        listImmutable.toString());
  }


}