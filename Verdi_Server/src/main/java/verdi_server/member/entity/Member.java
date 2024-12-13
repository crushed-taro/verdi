package verdi_server.member.entity;

import jakarta.persistence.*;
import org.springframework.core.ReactiveAdapterRegistry;

import java.util.List;

@Entity
@Table(name = "tbl_member")
public class Member {

    @Id
    @Column(name = "member_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberCode;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "authority_code")
    private String authorityCode;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "mobile_number")
    private int mobileNumber;

    @Column(name = "birth")
    private String birth;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "gender")
    private String getder;

    @OneToMany
    @JoinColumn(name = "member_code")
    private List<MemberRole> memberRole;

    public Member(int memberCode, String memberId, String authorityCode, String email, String password, String name, String nickname, int mobileNumber, String birth, String profilePhoto, String getder, List<MemberRole> memberRole) {
        this.memberCode = memberCode;
        this.memberId = memberId;
        this.authorityCode = authorityCode;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.mobileNumber = mobileNumber;
        this.birth = birth;
        this.profilePhoto = profilePhoto;
        this.getder = getder;
        this.memberRole = memberRole;
    }

    public Member() {

    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(String authorityCode) {
        this.authorityCode = authorityCode;
    }

    public List<MemberRole> getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(List<MemberRole> memberRole) {
        this.memberRole = memberRole;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getGetder() {
        return getder;
    }

    public void setGetder(String getder) {
        this.getder = getder;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberCode=" + memberCode +
                ", memberId='" + memberId + '\'' +
                ", authorityCode='" + authorityCode + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", birth='" + birth + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", getder='" + getder + '\'' +
                ", memberRole=" + memberRole +
                '}';
    }
}
