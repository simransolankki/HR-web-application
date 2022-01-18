package com.thinking.machines.hr.beans;
import java.io.*;
public class DesignationBean implements Serializable
{
private int code;
private String title;
public DesignationBean()
{
this.code=0;
this.title="";
}
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setTitle(java.lang.String title)
{
this.title=title;
}
public java.lang.String getTitle()
{
return this.title;
}
}