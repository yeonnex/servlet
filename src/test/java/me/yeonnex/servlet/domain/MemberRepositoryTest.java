package me.yeonnex.servlet.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void after() {
        memberRepository.clear();
    }

    @Test
    @DisplayName("회원을 저장한다")
    void save() {
        String name = "seoyeon";
        Member member = new Member(name, 24);
        Member savedMember = memberRepository.save(member);
        assertThat(name).isEqualTo(savedMember.getUsername());
        assertThat(savedMember.getId()).isNotNull();
    }

    @Test
    @DisplayName("모든 회원을 조회한다")
    void findAll() {
        Member member1 = new Member("tester1", 24);
        memberRepository.save(member1);
        Member member2 = new Member("tester2", 25);
        memberRepository.save(member2);

        List<Member> all = memberRepository.findAll();
        assertThat(all.size()).isEqualTo(2);
    }
}