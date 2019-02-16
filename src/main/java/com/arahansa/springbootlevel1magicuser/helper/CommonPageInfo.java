package com.arahansa.springbootlevel1magicuser.helper;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.Arrays;
import java.util.List;

@Data
public class CommonPageInfo<T> {
    private int numArticlePerPage = 20; // 페이지당 아티클 갯수였는데 쓸 일이 없어졌다.
    private int numPages = 10; // 페이지 갯수
    private List<?> content;
    // 페이징
    private int numTotalPage; // 총 페이지 수
    private int beginPage; // 페이지 하단의 링크에 쓰일 시작 페이지
    private int endPage; // 페이지 하단의 링크에 쓰일 끝페이지
    private int currentPage; //현재 페이지
    private int[] pages;
    private boolean previous;
    private boolean next;

    public CommonPageInfo(Page<T> pageBoard) {
        this.numTotalPage = pageBoard.getTotalPages();
        this.beginPage = pageBoard.getNumber() / numPages * numPages + 1;
        this.endPage = (beginPage + numPages - 1) > numTotalPage ? numTotalPage : beginPage + numPages - 1;
        this.content = pageBoard.getContent();
        this.previous = beginPage > numPages;
        this.next = endPage < numTotalPage;
        this.pages = new int[endPage - beginPage + 1];
        for (int i = 0, j = beginPage; i < pages.length; i++, j++) {
            pages[i] = j;
        }
        this.currentPage = pageBoard.getNumber() + 1;
    }

    @Override
    public String toString() {
        return "CommonPageInfo{" +
                "content=" + content +
                ", numTotalPage=" + numTotalPage +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", pages=" + Arrays.toString(pages) +
                ", previous=" + previous +
                ", next=" + next +
                '}';
    }
}