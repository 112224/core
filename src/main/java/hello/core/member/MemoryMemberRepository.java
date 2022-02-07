package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    // 동시성 이슈가 있을 수 있기 때문에 ConcurrentHashMap 을 사용하는 것이 맞지만, 일단은 그냥 HashMap 으로 진행
    private static Map<Long, Member> store = new HashMap<>();
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
