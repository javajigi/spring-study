package com.blogcode.repository;

import com.blogcode.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jojoldu@gmail.com on 2017. 2. 14.
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

public interface MemberRepository extends CrudRepository<Member, Long> {
}
