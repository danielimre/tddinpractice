package com.company.todos.domain;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.google.common.base.Objects;

/**
 * Represents a TODO entry.
 *
 * @author Mate Szvoboda
 *
 */
@Entity
public class Todo {
    private Long id;
    private String userName;
    private String title;
    private boolean completed;

    /**
     * Constructs an empty todo.
     */
    public Todo() {
    }

    /**
     * Creates a todo from a builder.
     *
     * @param builder the builder to use
     */
    public Todo(TodoBuilder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.title = builder.title;
        this.completed = builder.completed;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).omitNullValues().add("id", id).add("userName", userName).add("title", title).add("completed", completed).toString();
    }

    // Generated code begins here

    @Generated("Eclipse")
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (completed ? 1231 : 1237);
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        return result;
    }

    @Generated("Eclipse")
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Todo)) {
            return false;
        }
        Todo other = (Todo) obj;
        if (completed != other.completed) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
            return false;
        }
        if (userName == null) {
            if (other.userName != null) {
                return false;
            }
        } else if (!userName.equals(other.userName)) {
            return false;
        }
        return true;
    }

    // Generated code ends here

    /**
     * Builder for {@link Todo}.
     * @author Daniel Imre
     *
     */
    public static final class TodoBuilder {
        private Long id;
        private String userName;
        private String title;
        private boolean completed;

        /**
         * Sets the id.
         *
         * @param id the id
         * @return this builder instance
         */
        public TodoBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        /**
         * Binds the todo to a user.
         *
         * @param userName the username
         * @return this builder instance
         */
        public TodoBuilder forUser(String userName) {
            this.userName = userName;
            return this;
        }

        /**
         * Sets the title.
         *
         * @param title the title
         * @return this builder instance
         */
        public TodoBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * Marks the todo as completed.
         *
         * @return this builder instance
         */
        public TodoBuilder completed() {
            this.completed = true;
            return this;
        }

        /**
         * Build a todo based on this builder.
         *
         * @return
         */
        public Todo build() {
            return new Todo(this);
        }
    }
}
