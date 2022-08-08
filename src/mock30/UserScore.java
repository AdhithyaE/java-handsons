package mock30;

public class UserScore implements Comparable<UserScore>{
	Double completion_Percentage;
	User user;
	Course course;
	public int compareTo(UserScore c) {
		return -(this.getCompletion_Percentage().compareTo(c.getCompletion_Percentage()));
	}
	public Double getCompletion_Percentage() {
		return completion_Percentage;
	}
	public void setCompletion_Percentage(Double completion_Percentage) {
		this.completion_Percentage = completion_Percentage;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public UserScore(Double completion_Percentage, User user, Course course) {
		super();
		this.completion_Percentage = completion_Percentage;
		this.user = user;
		this.course = course;
	}
	public UserScore() {
		super();
	}
	
}
