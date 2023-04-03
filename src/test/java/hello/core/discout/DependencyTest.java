package hello.core.discout;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DependencyTest {

    @Autowired
    private DiscountPolicy discountPolicy;

//    @Test
//    public void dependencyTest(){
//        System.out.println(discountPolicy.getClass());
//    }
}
