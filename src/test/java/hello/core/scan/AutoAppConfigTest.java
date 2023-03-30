package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    public void basicScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberRepository memberRepository = ac.getBean(MemberRepository.class);

        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }
}
