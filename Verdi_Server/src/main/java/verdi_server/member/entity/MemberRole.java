package verdi_server.member.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_member_role")
@IdClass(MemberRolePk.class)
public class MemberRole {

    @Id
    @Column(name = "member_code")
    private int memberCode;

    @Id
    @Column(name = "authority_code")
    private int authorityCode;

    @ManyToOne
    @JoinColumn(name = "authority_code", insertable = false, updatable = false)
    private Authority authority;

    public MemberRole(int memberCode, int authorityCode, Authority authority) {
        this.memberCode = memberCode;
        this.authorityCode = authorityCode;
        this.authority = authority;
    }

    public MemberRole(int memberCode, int authorityCode) {
        this.memberCode = memberCode;
        this.authorityCode = authorityCode;
    }

    public MemberRole() {
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public int getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(int authorityCode) {
        this.authorityCode = authorityCode;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "MemberRole{" +
                "memberCode=" + memberCode +
                ", authorityCode=" + authorityCode +
                ", authority=" + authority +
                '}';
    }
}
