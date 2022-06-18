package springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//JPA Auditing으로 생성시간/수정시간 자동화하기
//BaseTimeEntity는 모든 entity의 상위 클래스가 되어 entity들의 createdDate,modifiredDate를 자동으로 관리하는 역할
@Getter
@MappedSuperclass  //JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 필드들(createdDate,modifiedDate)도 칼럼으로 인식하도록
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity에 Auditing 기능을 포함시킴.
public abstract class BaseTimeEntity {

    @CreatedDate  //Entity가 생성되어 저장될 때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate //조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.
    private LocalDateTime modifiedDate;

}
