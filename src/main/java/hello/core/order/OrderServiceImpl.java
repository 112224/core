package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier
@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    /*
     * 인터페이스에만 의존하는 상황이 아니라 그의 구현체에 까지 의존하고 있는 상황으로
     * 클라이언트의 소스코드 변경이 불가피한 상황 => OCP, DIP 위반
     * discountPolicy = this. ~
     * 형태로 추후에 변경 가능할 것이라 예상(의존성 주입)*/
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
    //test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
