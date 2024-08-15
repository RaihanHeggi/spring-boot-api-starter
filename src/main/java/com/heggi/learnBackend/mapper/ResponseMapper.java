package com.heggi.learnBackend.mapper;

import com.heggi.learnBackend.dto.BaseResponseDto;
import com.heggi.learnBackend.entity.BaseResponse;

public class ResponseMapper {
    
    public BaseResponseDto  mapToResponseDto(BaseResponse BaseResponse){
        return new BaseResponseDto<>(
            BaseResponse.getStatus(),
            BaseResponse.getDetail(),
            BaseResponse.getData()
        );
    }

    public BaseResponse  mapToResponse(BaseResponseDto BaseResponseDto){
        return new BaseResponse<>(
            BaseResponseDto.getStatus(),
            BaseResponseDto.getDetail(),
            BaseResponseDto.getData()
        );
    }

}
