import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LengthTest {
    @Test
    public void should_return_10cm_when_give_1dm() throws Exception {
        Length length = new Length(1, "dm");

        assertThat(length.transformToBaseUnit(), is(10));
    }

    @Test
    public void should_return_20cm_when_give_2dm() throws Exception {
        Length length = new Length(2, "dm");

        assertThat(length.transform("cm"), is(20));
    }

    @Test
    public void should_return_1dm_when_give_10dm() throws Exception {
        Length length = new Length(10, "cm");

        assertThat(length.transform("dm"), is(1));
    }

    @Test
    public void should_return_2cm_when_1cm_add_1cm() throws Exception {
        Length length1 = new Length(1, "cm");
        Length length2 = new Length(1, "cm");

        assertThat(length1.add(length2, "cm"), is(2));
    }

    @Test
    public void should_return_12cm_when_1dm_add_2cm() throws Exception {
        Length length1 = new Length(1, "dm");
        Length length2 = new Length(2, "cm");

        assertThat(length1.add(length2, "cm"), is(12));
    }

    @Test
    public void should_return_1cm_when_2cm_minus_1cm() throws Exception {
        Length length1 = new Length(2, "cm");
        Length length2 = new Length(1, "cm");

        assertThat(length1.minus(length2, "cm"), is(1));
    }

    @Test
    public void should_return_1dm_when_12cm_minus_2cm() throws Exception {
        Length length1 = new Length(12, "cm");
        Length length2 = new Length(2, "cm");

        assertThat(length1.minus(length2, "dm"), is(1));
    }
}
