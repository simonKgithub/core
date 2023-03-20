package hello.core;

import hello.core.member.*;

public class MemberApp {
    public static void main(String[] args) {
        // 0.외부 객체 생성
        AppConfig appConfig = new AppConfig();
        // 1.외부에서 구현체 생성 후 반환
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
