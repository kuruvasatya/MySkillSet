package com.learning.dto;

import lombok.Data;
import java.util.*;

@Data
public class RevisionResponse {
    @Data
    public class RevisionDetails {
        private int revId;
        private Boolean isDatabaseSensitive;
        private String attestedBy;
        private Date attestedDate;
    }
    private int id;
    private List<RevisionDetails> revisionDetailsList;
}
