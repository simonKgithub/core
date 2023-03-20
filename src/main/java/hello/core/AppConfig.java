package hello.core;

import hello.core.discout.DiscountPolicy;
import hello.core.discout.FixDiscountPolicy;
import hello.core.discout.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //MemberService 역할 => 구현체
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    //MemberRepository 역할 => 구현체
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    //OrderService 역할 => 구현체
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }
    //DiscountPolicy 역할 => 구현체
    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}