package com.blackbyte.api;


public class Client {
	private Settings settings;
	private Company company;
	private Project project;
	private Goal goal;
	private Task task;
	private Comment comment;
	private File file;
	private User user;
	
	public Client(Settings settings) {
		this.settings = settings;
		company = new Company(settings);
		project = new Project(settings);
		goal = new Goal(settings);
		task = new Task(settings);
		comment = new Comment(settings);
		user = new User(settings);
		file = new File(settings);
	}
	
	public Settings getSettings() {
		return settings;
	}
	
	public void setSettings(Settings settings) {
		this.settings = settings;
	}
	
	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	public Goal getGoal() {
		return goal;
	}
	
	public void setGoal(Goal goal) {
		this.goal = goal;
	}
	
	public Task getTask() {
		return task;
	}
	
	public void setTask(Task task) {
		this.task = task;
	}
	
	public Comment getComment() {
		return comment;
	}
	
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	public File getFile() {
		return file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

}
