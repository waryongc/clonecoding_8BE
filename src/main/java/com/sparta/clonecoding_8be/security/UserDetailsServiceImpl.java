package com.sparta.clonecoding_8be.security;


import com.sparta.clonecoding_8be.model.Member;
import com.sparta.clonecoding_8be.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final MemberRepository memberRepository;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username).orElseThrow(
                        () -> new UsernameNotFoundException(username + "이 존재하지 않습니다")
                );
        return new UserDetailsImpl(member);

    }

}
