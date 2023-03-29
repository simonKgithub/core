package hello.core.order;

import hello.core.discout.DiscountPolicy;
import hello.core.discout.FixDiscountPolicy;
import hello.core.discout.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 1. 회원 조회
        Member member = memberRepository.findById(memberId);
        // 2. 할인 적용
        int discountPrice = discountPolicy.discount(member, itemPrice);
        // 3. 할인된 주문 결과 리턴
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}