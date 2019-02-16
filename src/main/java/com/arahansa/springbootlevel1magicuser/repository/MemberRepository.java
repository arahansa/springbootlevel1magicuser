package com.arahansa.springbootlevel1magicuser.repository;

import com.arahansa.springbootlevel1magicuser.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
