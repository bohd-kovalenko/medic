package com.demo.warmedicapp.services;

import com.demo.warmedicapp.payload.requests.BlankRequest;
import com.demo.warmedicapp.payload.responses.BlankResponse;

public interface BlankService {
    BlankResponse getBlankResponsesBySoldierId(Integer id);

    void addBlankResponseBySoldierId(Integer id, BlankRequest blankRequest);
}
