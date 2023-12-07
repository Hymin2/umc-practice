package com.umc.project.global.page.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PageDTO<T> {
    List<T> results;
    Integer listSize;
    Integer totalPage;
    Long totalElements;
    Boolean isFirst;
    Boolean isLast;

    public static <T> PageDTO<T> of(Page page, List<T> results){
        return PageDTO.<T>builder()
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .listSize(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPage(page.getTotalPages())
                .results(results)
                .build();
    }
}
