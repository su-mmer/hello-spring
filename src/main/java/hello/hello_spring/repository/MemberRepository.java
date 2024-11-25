package hello.hello_spring.repository;
import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findByID(Long id); // Null 반환되면 Optional 로 감싸서..

    Optional<Member> findByName(String name);

    List<Member> findAll();
}
