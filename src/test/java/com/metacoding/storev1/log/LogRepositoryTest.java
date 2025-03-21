package com.metacoding.storev1.log;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.metacoding.storev1.log.LogResponse.ListPage;

@DataJpaTest // em IoC 등록
@Import(LogRepository.class)
public class LogRepositoryTest {

    @Autowired // DI Annotation
    private LogRepository logRepository;

    @Test
    public void findAllWithStore_test() { // test 용 함수는 언더바로 구분 : Convention + 매개변수에는 아무것도 넣을 수 없음
        List<LogResponse.ListPage> logList = logRepository.findAllJoinStore();
        for (ListPage listPage : logList) {
            System.out.println(listPage);
        }
    }

}
