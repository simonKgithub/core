package hello.core;

import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        // 0.외부에서 객체 생성
        AppConfig appConfig = new AppConfig();
        // 1.외부 객체에서 구현체 생성 및 주입
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        // 0.멤버생성
        Member member = new Member(memberId, "memberA", Grade.VIP);

        // 1.멤버 회원 등록
        memberService.join(member);

        // 2.주문
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        // 3.결과
        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
