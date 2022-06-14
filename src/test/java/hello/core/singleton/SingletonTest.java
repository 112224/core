package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
//        1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
//        2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

//        참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
//        서로 다른 참조값을 가지고 있음을 확인. -> 새로운 객체가 만들어짐

//        메모리 낭비가 심한 상황. 이를 해결하기 위한 패턴이 singleton pattern으로
//        하나의 객체를 생성하여, 공유하는 것으로 해당 방식의 문제점을 해결(객체는 한 번 생성)
        assertThat(memberService1).isNotSameAs(memberService2);

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 테스트")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
//        SameAs : == 비교로 참조값을 비교하는 것
//        Equal : equals 메소드 overriding
        assertThat(singletonService1).isSameAs(singletonService2);

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤객체")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//        1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
//        2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

//        참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
//        서로 다른 참조값을 가지고 있음을 확인. -> 새로운 객체가 만들어짐

//        메모리 낭비가 심한 상황. 이를 해결하기 위한 패턴이 singleton pattern으로
//        하나의 객체를 생성하여, 공유하는 것으로 해당 방식의 문제점을 해결(객체는 한 번 생성)
        assertThat(memberService1).isSameAs(memberService2);
    }
}
