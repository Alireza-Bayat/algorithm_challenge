package leet.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimplifyPathTest {

    private SimplifyPath simplifyPath;

    @Before
    public void prepare() {
        simplifyPath = new SimplifyPath();
    }

    @Test
    public void simplifyPathToCanonical() {
        Assert.assertEquals("/.../b/d", simplifyPath.simplifyPath("/.../a/../b/c/../d/./"));
        Assert.assertEquals("/home", simplifyPath.simplifyPath("/home/"));
        Assert.assertEquals("/home/foo", simplifyPath.simplifyPath("/home//foo/"));
        Assert.assertEquals("/home/user/Pictures", simplifyPath.simplifyPath("/home/user/Documents/../Pictures"));
        Assert.assertEquals("/", simplifyPath.simplifyPath("/../"));
        Assert.assertEquals("/c", simplifyPath.simplifyPath("/a/./b/../../c/"));
    }

}