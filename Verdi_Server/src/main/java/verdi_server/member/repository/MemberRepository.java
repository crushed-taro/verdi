package verdi_server.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import verdi_server.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Member findByMemberId(String memberId);

    // JPQL과 @Query활용
    @Query("SELECT MAX(m.memberCode) FROM Member m")
    int maxMemberCode();

    Member findByEmail(String memberEmail);
}
