package org.apache.zookeeper.version;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class InfoTest {

    @Test
    public void testWithProjectPropertiesGetValuesAreLoaded() {
        assertEquals("foo", Info.VERSION);
        assertEquals(1, Info.MAJOR);
        assertEquals(2, Info.MINOR);
        assertEquals(3, Info.MICRO);
        assertEquals("bar", Info.QUALIFIER);
        assertEquals(-1, Info.REVISION);
        assertEquals("abcde", Info.REVISION_HASH);
        assertEquals("2021-11-03 12:42", Info.BUILD_DATE);
    }
}
