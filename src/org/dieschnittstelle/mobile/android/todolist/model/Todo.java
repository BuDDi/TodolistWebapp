package org.dieschnittstelle.mobile.android.todolist.model;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.dieschnittstelle.mobile.android.todolist.model.remote.JsonDateSerializer;

public class Todo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6410064189686738560L;

	public static enum Priority {
		Low, Normal, High;

		public static Priority getForOrdinal(byte ordinal) {
			return getForOrdinal((long) ordinal);
		}

		public static Priority getForOrdinal(short ordinal) {
			return getForOrdinal((long) ordinal);
		}

		public static Priority getForOrdinal(int ordinal) {
			return getForOrdinal((long) ordinal);
		}

		public static Priority getForOrdinal(long ordinal) {
			Priority[] values = values();
			for (Priority prio : values) {
				if (prio.ordinal() == ordinal) {
					return prio;
				}
			}
			throw new IllegalArgumentException("Priority for ordinal number "
					+ ordinal + " could not be found!");
		}

	};

	private long id;

	private String userId;

	private String name;

	private String description;

	private boolean done;

	private Priority priority;

	private Date date;

	public Todo() {
		super();
	}

	public Todo(long id, String userId, String name, String description,
			boolean done, Priority priority, Date date) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.done = done;
		this.priority = priority;
		this.date = date;
	}

	public Todo(String userId, String name, String description, boolean done,
			Priority priority, Date date) {
		super();
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.done = done;
		this.priority = priority;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Todo)) {
			return false;
		}
		Todo otherTodo = (Todo) o;
		return this.id == otherTodo.id && this.userId.equals(otherTodo.userId);
	}

	public Todo updateFrom(Todo item) {
		setUserId(item.userId);
		setName(item.name);
		setDescription(item.description);
		setDone(item.done);
		setDate(item.date);
		setPriority(item.priority);
		return this;
	}

	@Override
	public String toString() {
		return "{Todo id:" + this.id + " userId:" + this.userId + " name:\""
				+ this.name + "\" \"" + this.description + "\" done:" + this.done
				+ " prio:\"" + this.priority + "\"}";
	}
}
