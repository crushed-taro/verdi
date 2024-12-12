package verdi_server.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import verdi_server.member.entity.MemberRole;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Integer> {
}
