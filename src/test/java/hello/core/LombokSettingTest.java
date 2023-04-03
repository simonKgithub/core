package hello.core;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Getter
@Setter
public class LombokSettingTest {

    String name;

    @Test
    public void lombokTest() {
        LombokSettingTest test = new LombokSettingTest();
        test.setName("테스트");
        String str = test.getName();
        assertThat(str).isEqualTo("테스트");
    }
}
