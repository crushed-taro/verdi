package verdi_server.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import verdi_server.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
