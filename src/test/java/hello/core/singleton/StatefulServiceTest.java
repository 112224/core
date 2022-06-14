package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);


//        사용자 A의 10000원 주문
        statefulService1.order("userA", 10000);
//        사용자 B의 20000원
        statefulService2.order("userB", 20000);

//        ThreadA: 사용자A 주문금액 조회
//        멀티쓰레딩 상황을 가정하여 A의 주문금액 조회 이전에 새로운 주문이 만들어진 상황 가분
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);


//        해당 문제를 해결하려면
//        //        사용자 A의 10000원 주문
//        int userAPrice = statefulService1.order("userA", 10000);
//        //        사용자 B의 20000원
//        int userBPrice = statefulService2.order("userB", 20000);

    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}