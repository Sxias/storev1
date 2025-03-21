package com.metacoding.storev1.log;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LogService {

    private LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public List<LogResponse.ListPage> 구매목록() {
        return logRepository.findAllJoinStore();
    }

}
