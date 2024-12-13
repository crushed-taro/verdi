package verdi_server.member.entity;

import java.io.Serializable;

public class MemberRolePk implements Serializable {

    private int memberCode;
    private int authorityCode;

    public MemberRolePk() {
    }

    public MemberRolePk(int memberCode, int authorityCode) {
        this.memberCode = memberCode;
        this.authorityCode = authorityCode;
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

    @Override
    public String toString() {
        return "MemberRolePk{" +
                "memberCode=" + memberCode +
                ", authorityCode=" + authorityCode +
                '}';
    }
}
