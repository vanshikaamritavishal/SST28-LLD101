package com.example.tickets;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public final class IncidentTicket {

    private final String id;
    private final String reporterEmail;
    private final String title;

    private final String description;
    private final Priority priority;
    private final List<String> tags;
    private final String assigneeEmail;
    private final boolean customerVisible;
    private final Integer slaMinutes;
    private final String source;

    public enum Priority {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    private IncidentTicket(Builder builder) {
        this.id = builder.id;
        this.reporterEmail = builder.reporterEmail;
        this.title = builder.title;
        this.description = builder.description;
        this.priority = builder.priority;
        this.assigneeEmail = builder.assigneeEmail;
        this.customerVisible = builder.customerVisible;
        this.slaMinutes = builder.slaMinutes;
        this.source = builder.source;
        this.tags = builder.tags == null
                ? Collections.emptyList()
                : Collections.unmodifiableList(new ArrayList<>(builder.tags));
    }

    public String getId() {
        return id;
    }

    public String getReporterEmail() {
        return reporterEmail;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getAssigneeEmail() {
        return assigneeEmail;
    }

    public boolean isCustomerVisible() {
        return customerVisible;
    }

    public Integer getSlaMinutes() {
        return slaMinutes;
    }

    public String getSource() {
        return source;
    }

    public Builder toBuilder() {
        Builder b = new Builder();
        b.id = this.id;
        b.reporterEmail = this.reporterEmail;
        b.title = this.title;
        b.description = this.description;
        b.priority = this.priority;
        b.assigneeEmail = this.assigneeEmail;
        b.customerVisible = this.customerVisible;
        b.slaMinutes = this.slaMinutes;
        b.source = this.source;
        if (this.tags != null && !this.tags.isEmpty()) {
            b.tags = new ArrayList<>(this.tags);
        }
        return b;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String id;
        private String reporterEmail;
        private String title;

        private String description;
        private Priority priority;
        private List<String> tags;
        private String assigneeEmail;
        private boolean customerVisible;
        private Integer slaMinutes;
        private String source;

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder reporterEmail(String reporterEmail) {
            this.reporterEmail = reporterEmail;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder priority(Priority priority) {
            this.priority = priority;
            return this;
        }

        public Builder tags(List<String> tags) {
            if (tags == null) {
                this.tags = null;
            } else {
                this.tags = new ArrayList<>(tags);
            }
            return this;
        }

        public Builder assigneeEmail(String assigneeEmail) {
            this.assigneeEmail = assigneeEmail;
            return this;
        }

        public Builder customerVisible(boolean customerVisible) {
            this.customerVisible = customerVisible;
            return this;
        }

        public Builder slaMinutes(Integer slaMinutes) {
            this.slaMinutes = slaMinutes;
            return this;
        }

        public Builder source(String source) {
            this.source = source;
            return this;
        }

        public IncidentTicket build() {
            Validation.requireValidId(id);
            Validation.requireValidEmail(reporterEmail, "reporterEmail");
            Validation.requireNonEmpty(title, "title");
            Validation.requireMaxLength(title, 80, "title");

            if (assigneeEmail != null) {
                Validation.requireValidEmail(assigneeEmail, "assigneeEmail");
            }
            if (priority != null) {
                Validation.requirePriority(priority.name());
            }
            if (slaMinutes != null) {
                Validation.requireRange(slaMinutes, 5, 7200, "slaMinutes");
            }

            return new IncidentTicket(this);
        }
    }
}
