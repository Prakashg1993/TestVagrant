package pojo;

import java.util.List;

public class weatherReport {
	
private coord coord;
private List<weather> weather;
private String base;
private main main;
private String visibility;
private wind wind;
private clouds clouds;
private String dt;
private sys sys;
private String timezone;
private String id;
private String name;
private String cod;


public pojo.coord getCoord() {
	return coord;
}
public void setCoord(pojo.coord coord) {
	this.coord = coord;
}
public List<pojo.weather> getWeather() {
	return weather;
}
public void setWeather(List<pojo.weather> weather) {
	this.weather = weather;
}
public String getBase() {
	return base;
}
public void setBase(String base) {
	this.base = base;
}
public pojo.main getMain() {
	return main;
}
public void setMain(pojo.main main) {
	this.main = main;
}
public String getVisibility() {
	return visibility;
}
public void setVisibility(String visibility) {
	this.visibility = visibility;
}
public pojo.wind getWind() {
	return wind;
}
public void setWind(pojo.wind wind) {
	this.wind = wind;
}
public pojo.clouds getClouds() {
	return clouds;
}
public void setClouds(pojo.clouds clouds) {
	this.clouds = clouds;
}
public String getDt() {
	return dt;
}
public void setDt(String dt) {
	this.dt = dt;
}
public pojo.sys getSys() {
	return sys;
}
public void setSys(pojo.sys sys) {
	this.sys = sys;
}
public String getTimezone() {
	return timezone;
}
public void setTimezone(String timezone) {
	this.timezone = timezone;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCod() {
	return cod;
}
public void setCod(String cod) {
	this.cod = cod;
}




}
