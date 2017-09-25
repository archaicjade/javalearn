package com.yiche.entity;

public class InvokeConfig {
	
	
	public InvokeConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String ID;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getAssemblyPath() {
		return AssemblyPath;
	}

	public void setAssemblyPath(String assemblyPath) {
		AssemblyPath = assemblyPath;
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public String getMethodName() {
		return MethodName;
	}

	public void setMethodName(String methodName) {
		MethodName = methodName;
	}

	private String AssemblyPath;
	private String ClassName;
	private String MethodName;
}
