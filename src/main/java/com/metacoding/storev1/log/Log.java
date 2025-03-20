package com.metacoding.storev1.log;

import com.metacoding.storev1.store.Store;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // JPA가 Object Mapping 시 사용
@Table(name = "log_tb")
@Entity // 설정 파일에서 테이블을 생성해줌
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer storeId; // 상품 ID (FK)
    private Integer qty; // 구매 수량
    private Integer totalPrice; // qty * price
    private String buyer; // 구매자 이름
}
