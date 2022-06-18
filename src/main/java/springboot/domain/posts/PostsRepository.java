package springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//DAO라고 불리는 DB Layer 접근자, Repository in JPA
//퍼시스턴스 레이어, DB나 파일같은 외부 I/O 작업을 처리함
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();


}
