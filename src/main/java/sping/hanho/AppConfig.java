package sping.hanho;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sping.hanho.discount.DiscountPolicy;
import sping.hanho.discount.RateDiscountPolicy;
import sping.hanho.member.MemberRepository;
import sping.hanho.member.MemberService;
import sping.hanho.member.MemberServiceImpl;
import sping.hanho.member.MemoryMemberRepository;
import sping.hanho.order.OrderService;
import sping.hanho.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {

        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {

        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {

        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {

        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
