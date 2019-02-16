package com.arahansa.springbootlevel1magicuser.service;

import com.arahansa.springbootlevel1magicuser.domain.Member;
import com.arahansa.springbootlevel1magicuser.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberRepository repository;

    public List<Member> findAll() {
        return repository.findAll();
    }

    public Member save(Member member) {
        return repository.save(member);
    }
}
