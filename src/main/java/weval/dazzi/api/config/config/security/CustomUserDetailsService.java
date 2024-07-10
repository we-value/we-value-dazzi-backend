package weval.dazzi.api.config.config.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import weval.dazzi.domain.entity.member.Member;
import weval.dazzi.domain.entity.member.access.repository.MemberRepository;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        Member member = memberRepository.findByMemberId(Long.valueOf(userId))
                .orElseThrow(() -> new UsernameNotFoundException("Could not found member" + userId));


        return User.builder()
                .username(member.getMemberId().toString())
                .password("")
                .roles("USER")
                .build();
    }
}
