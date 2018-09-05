package seedu.addressbook.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class UtilsTest {


    @Test
    public void elementsAreUnique() throws Exception {
        // empty list
        assertAreUnique();

        // only one object
        assertAreUnique((Object) null);
        assertAreUnique(1);
        assertAreUnique("");
        assertAreUnique("abc");

        // all objects unique
        assertAreUnique("abc", "ab", "a");
        assertAreUnique(1, 2);

        // some identical objects
        assertNotUnique("abc", "abc");
        assertNotUnique("abc", "", "abc", "ABC");
        assertNotUnique("", "abc", "a", "abc");
        assertNotUnique(1, Integer.valueOf(1));
        assertNotUnique(null, 1, Integer.valueOf(1));
        assertNotUnique(null, null);
        assertNotUnique(null, "a", "b", null);
    }

    @Test
    public void test_isAnyNull() throws Exception{
        // empty list
        assertFalse(Utils.isAnyNull());

        // only one null object
        assertTrue(Utils.isAnyNull((Object) null));
        assertTrue(Utils.isAnyNull("a", "b", null));
        assertTrue(Utils.isAnyNull(null, "a", "b"));
        assertTrue(Utils.isAnyNull( "a", null, "b"));

        // more than one null objects
        assertTrue(Utils.isAnyNull(null, null, "b"));
        assertTrue(Utils.isAnyNull(null, "a", null, "b"));
        assertTrue(Utils.isAnyNull("a", null, "b", null));

        // no null objects
        assertFalse(Utils.isAnyNull("a", "b"));
        //
    }

    private void assertAreUnique(Object... objects) {
        assertTrue(Utils.elementsAreUnique(Arrays.asList(objects)));
    }

    private void assertNotUnique(Object... objects) {
        assertFalse(Utils.elementsAreUnique(Arrays.asList(objects)));
    }
}
