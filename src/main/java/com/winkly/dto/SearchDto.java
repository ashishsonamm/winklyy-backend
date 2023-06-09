package com.winkly.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.winkly.entity.SearchResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchDto {
    private List<SearchResult> resultList;
}
