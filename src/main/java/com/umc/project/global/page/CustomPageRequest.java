package com.umc.project.global.page;

import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

public class CustomPageRequest extends AbstractPageRequest {
    private static final long serialVersionUID = -4541509938956089562L;
    private final Sort sort;

    protected CustomPageRequest(int pageNumber, int pageSize, Sort sort) {

        super(pageNumber - 1, pageSize);

        Assert.notNull(sort, "Sort must not be null");

        this.sort = sort;
    }

    public static CustomPageRequest of(Pageable pageable){
        return of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getSort());
    }

    public static CustomPageRequest of(int pageNumber, int pageSize) {
        return of(pageNumber, pageSize, Sort.unsorted());
    }

    public static CustomPageRequest of(int pageNumber, int pageSize, Sort sort) {
        return new CustomPageRequest(pageNumber, pageSize, sort);
    }

    public static CustomPageRequest of(int pageNumber, int pageSize, Direction direction, String... properties) {
        return of(pageNumber, pageSize, Sort.by(direction, properties));
    }

    public static CustomPageRequest ofSize(int pageSize) {
        return CustomPageRequest.of(0, pageSize);
    }

    public Sort getSort() {
        return sort;
    }

    @Override
    public CustomPageRequest next() {
        return new CustomPageRequest(getPageNumber() + 1, getPageSize(), getSort());
    }

    @Override
    public CustomPageRequest previous() {
        return getPageNumber() == 0 ? this : new CustomPageRequest(getPageNumber() - 1, getPageSize(), getSort());
    }

    @Override
    public CustomPageRequest first() {
        return new CustomPageRequest(0, getPageSize(), getSort());
    }

    @Override
    public boolean equals(@Nullable Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CustomPageRequest that)) {
            return false;
        }

        return super.equals(that) && sort.equals(that.sort);
    }

    @Override
    public CustomPageRequest withPage(int pageNumber) {
        return new CustomPageRequest(pageNumber, getPageSize(), getSort());
    }

    public CustomPageRequest withSort(Direction direction, String... properties) {
        return new CustomPageRequest(getPageNumber(), getPageSize(), Sort.by(direction, properties));
    }

    public CustomPageRequest withSort(Sort sort) {
        return new CustomPageRequest(getPageNumber(), getPageSize(), sort);
    }

    @Override
    public int hashCode() {
        return 31 * super.hashCode() + sort.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Page request [number: %d, size %d, sort: %s]", getPageNumber(), getPageSize(), sort);
    }
}
