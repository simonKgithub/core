package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
        this.orderService = appConfig.orderService();
    }

    @Test
    public void createOrder(){
        //primitive(기본)타입 long을 쓰게된다면, null을 넣을 수 없어서 생성초기부터 wrapper 타입을 작성한 것이다.
        Long memberId = 1L;

        // 0.멤버생성
        Member member = new Member(memberId, "memberA", Grade.VIP);

        // 1.멤버 회원 등록
        memberService.join(member);

        // 2.주문
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // 3.결과
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
