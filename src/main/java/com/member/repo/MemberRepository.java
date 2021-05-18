package com.member.repo;



import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.member.entity.Member;

@Repository
public interface MemberRepository extends MongoRepository<Member,String> {
	
	Member findMemberBymemberid(String memberid);
	//Optional<Member> findMemberByid(ObjectId id);

}
